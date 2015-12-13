package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.storebl.StoreController;
import bl.transportbl.TransportController;
import blservice.strategyblservice.StrategyblService;
import ds.orderdataservice.OrderDataService;
import net.RMIManage;
import po.DocPO;
import po.order.OrderPO;
import po.order.ReceivePO;
import test.java.other.VOPOchange;
import util.DataServiceType;
import util.DocType;
import util.MyDate;
import util.ResultMessage;
import vo.DocVO;
import vo.order.OrderSimpleInfoVO;
import vo.order.OrderVO;
import vo.order.PreReceiveVO;
import vo.order.ReceiveVO;
import vo.store.InStoreDocVO;
import vo.store.OutStoreDocVO;
import vo.transport.ArriveYYDocVO;
import vo.transport.ArriveZZDocVO;
import vo.transport.LoadDocVO;
import vo.transport.SendGoodDocVO;
import vo.transport.TransferDocVO;

/**
 * @author ymc
 * @version 创建时间：2015年10月27日 下午7:48:05
 *
 */
public class Order {
	private OrderDataService orderData;
	private StrategyblService strategybl;
	private TransportController transportController;
	private StoreController storeController;
	
	public Order(OrderDataService orderData) {
		this.orderData = orderData;
	}

	public ResultMessage add(OrderVO vo) {
		OrderPO po = (OrderPO) VOPOchange.VOtoPO(vo);
		try {
			return orderData.add(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	public ResultMessage checkBarCode(String orderBarCode) {
		OrderPO po = null;
		try {
			po = orderData.getSingleOrderPO(orderBarCode);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po == null)
			return ResultMessage.NOT_EXIST;
		else
			return ResultMessage.SUCCESS;
	}

	public ArrayList<OrderVO> getOrderVO(MyDate date) {

		ArrayList<OrderPO> pos = new ArrayList<OrderPO>();

		try {
			pos = orderData.getDayOrderPO(date);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<OrderVO> vos = new ArrayList<OrderVO>(pos.size());

		for (OrderPO po : pos) {
			vos.add((OrderVO) VOPOchange.POtoVO(po));
		}

		return vos;
	}

	public ResultMessage del(String orderBarCode) {

		try {
			return orderData.del(orderBarCode);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	public ArrayList<OrderSimpleInfoVO> getSimpleInfo(String orderBarCode) {
		
		ArrayList<String> poStrings = new ArrayList<String>();
		ArrayList<OrderSimpleInfoVO> orderSimpleInfoVOs = null;
		
		transportController = new TransportController();
		storeController = new StoreController();
		
		try {
			poStrings = orderData.getSingleOrderDocs(orderBarCode);
			if(poStrings == null ){
				return null;
			}
			orderSimpleInfoVOs = new ArrayList<OrderSimpleInfoVO>(poStrings.size());
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		String time = "";
		String place = "";
		DocType type=null;
		for (String poString : poStrings) {
			String tmp = poString.substring(0, 3);
			switch (tmp) {
			//装车单
			case "ZCD":
				LoadDocVO vol = (LoadDocVO) transportController.getByID(poString);
				place = vol.arriveCity.toString();
				time = MyDate.toString(vol.date);
				type=DocType.loadDoc;
				break;
			//接受单
			case "JSD":
				ArriveYYDocVO voy = (ArriveYYDocVO) transportController.getByID(poString);
				place = voy.sendCity.toString();
				time = MyDate.toString(voy.date);
				type=DocType.arriveYYDoc;
				break;
			//到达单
			case "DDD":
				ArriveZZDocVO voz = (ArriveZZDocVO) transportController.getByID(poString);
				place = voz.sendCity.toString();
				time = MyDate.toString(voz.date);
				type=DocType.arriveZZDoc;
				break;
			//中转单
			case "ZZD":
				TransferDocVO vot = (TransferDocVO) transportController.getByID(poString);
				place = vot.sendCity.toString();
				time =MyDate.toString(vot.date);
				type=DocType.transferDoc;
				break;
			//派送单 
			case "PSD":
				SendGoodDocVO vop = (SendGoodDocVO) transportController.getByID(poString);
				//传入派送员姓名
				place = vop.sendMan.toString();
				time = MyDate.toString(vop.date);
				type=DocType.sendGoodDoc;
				break;
			//入库单
			case "RKD":
				InStoreDocVO vor = (InStoreDocVO) storeController.getByID(poString);
				place = vor.loc.toString();
				time = MyDate.toString(vor.date);
				type=DocType.loadDoc;
				break;
			//出库单
			case "CKD":
				OutStoreDocVO voc = (OutStoreDocVO) storeController.getByID(poString);
				place = voc.loc.toString();
				time = MyDate.toString(voc.date);
				type=DocType.outStoreDoc;
				break;
			default:
				break;
			}
			orderSimpleInfoVOs.add(new OrderSimpleInfoVO(orderBarCode, place, time,type));
			
		
		
			
		}

		return orderSimpleInfoVOs;
	}

	public OrderVO getFullInfo(String orderBarCode) {
		OrderPO po = null;
		try {
			po = orderData.getSingleOrderPO(orderBarCode);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			OrderVO vo = (OrderVO) VOPOchange.POtoVO(po);
			return vo;
		}
		catch(NullPointerException e){
			return null;
		}
	}

	public ResultMessage receiveInfo(ReceiveVO vo) {
		String orderBarCode = vo.orderBarCode;
		ReceivePO po = (ReceivePO) VOPOchange.VOtoPO(vo);
		try {
			return orderData.receiveInfo(po, orderBarCode);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	public ResultMessage addDocToList(DocVO vo,ArrayList<String> orderBarCodes) {
		DocPO po = (DocPO) VOPOchange.VOtoPO(vo);
		try {
			return orderData.addDocToList(po, orderBarCodes);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	public ArrayList<PreReceiveVO> getPreReceive(ArrayList<SendGoodDocVO> daySendDocs) {
		ArrayList<String> barCodes = null;
		ArrayList<PreReceiveVO> pres = null;
		
		if(daySendDocs!= null){
			barCodes = new ArrayList<>(daySendDocs.size());
			pres = new ArrayList<>(daySendDocs.size());
		}
		
		if(barCodes!=null){
			OrderVO tmp = null;
			for(int i = 0;i<barCodes.size();i++){
				tmp = getFullInfo(barCodes.get(i));
//				PreReceiveVO vo = new PreReceiveVO(tmp.ID, tmp.receiver.getAddress(), tmp.receiver.getName());
			}
		}
		return pres;
	}

}
