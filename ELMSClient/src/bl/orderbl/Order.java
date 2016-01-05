package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessLogicDataFactory;
import bl.VOPOchange;
import bl.storebl.StoreController;
import bl.strategybl.StrategyController;
import bl.transportbl.TransportController;
import blservice.strategyblservice.StrategyblService;
import ds.orderdataservice.OrderDataService;
import po.DocPO;
import po.order.OrderPO;
import po.order.ReceivePO;
import util.City;
import util.DocState;
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
import vo.strategy.EstiDateVO;
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
		strategybl = new StrategyController();
	}

	public ResultMessage add(OrderVO vo) throws RemoteException {
		OrderPO po = (OrderPO) VOPOchange.VOtoPO(vo);
		return orderData.add(po);
	}

	public ResultMessage checkBarCode(String orderBarCode)
			throws RemoteException {
		OrderPO po = null;
		po = orderData.getSingleOrderPO(orderBarCode);
		if (po == null)
			return ResultMessage.NOT_EXIST;
		else
			return ResultMessage.SUCCESS;
	}

	public ArrayList<OrderVO> getOrderVO(MyDate date) throws RemoteException {

		ArrayList<OrderPO> pos = new ArrayList<OrderPO>();

		pos = orderData.getDayOrderPO(date);
		if (pos == null) {
			return null;
		}
		ArrayList<OrderVO> vos = new ArrayList<OrderVO>(pos.size());

		for (OrderPO po : pos) {
			vos.add((OrderVO) VOPOchange.POtoVO(po));
		}

		return vos;
	}

	public ResultMessage del(String orderBarCode) throws RemoteException {
		OrderVO order = getFullInfo(orderBarCode);
		if(order.transferDocs.getLoadDoc().equalsIgnoreCase("null"))
			return orderData.del(orderBarCode);
		else
			return ResultMessage.FAIL;
	}

	public ArrayList<OrderSimpleInfoVO> getSimpleInfo(String orderBarCode)
			throws RemoteException {

		ArrayList<String> poStrings = new ArrayList<String>();
		ArrayList<OrderSimpleInfoVO> orderSimpleInfoVOs = null;

		transportController = (TransportController) BusinessLogicDataFactory
				.getFactory().getTransportblservice();
		storeController = new StoreController();

		poStrings = orderData.getSingleOrderDocs(orderBarCode);

		if (poStrings == null) {
			return null;
		}
		orderSimpleInfoVOs = new ArrayList<OrderSimpleInfoVO>(poStrings.size());

		String time = "";
		String place = "";
		DocType type = null;
		for (String poString : poStrings) {
			if (poStrings == null || poString.length() < 3) {
				break;
			}
			String tmp = poString.substring(0, 3);
			switch (tmp) {
			// 装车单
			case "ZCD":
				LoadDocVO vol = (LoadDocVO) transportController.getByID(
						poString, DocType.loadDoc);
				place = vol.arriveCity.getName();
				time = MyDate.toString(vol.date);
				type = DocType.loadDoc;
				break;
			// 接受单
			case "JSD":
				ArriveYYDocVO voy = (ArriveYYDocVO) transportController
						.getByID(poString, DocType.arriveYYDoc);
				place = "";
				time = MyDate.toString(voy.date);
				type = DocType.arriveYYDoc;
				break;
			// 到达单
			case "DDD":
				ArriveZZDocVO voz = (ArriveZZDocVO) transportController
						.getByID(poString, DocType.arriveZZDoc);
				place = voz.sendCity.getName();
				time = MyDate.toString(voz.date);
				type = DocType.arriveZZDoc;
				break;
			// 中转单
			case "ZZD":
				TransferDocVO vot = (TransferDocVO) transportController
						.getByID(poString, DocType.transferDoc);
				place = vot.sendCity.getName();
				time = MyDate.toString(vot.date);
				type = DocType.transferDoc;
				break;
			// 派送单
			case "PSD":
				SendGoodDocVO vop = (SendGoodDocVO) transportController
						.getByID(poString, DocType.sendGoodDoc);
				// 传入派送员姓名
				place = vop.sendMan;
				time = MyDate.toString(vop.date);
				type = DocType.sendGoodDoc;
				break;
			// 入库单
			case "RKD":
				InStoreDocVO vor = (InStoreDocVO) storeController.getByID(
						poString, DocType.inStoreDoc);
				place = vor.loc.getName();
				time = MyDate.toString(vor.date);
				type = DocType.inStoreDoc;
				break;
			// 出库单
			case "CKD":
				OutStoreDocVO voc = (OutStoreDocVO) storeController.getByID(
						poString, DocType.outStoreDoc);
				place = voc.loc.getName();
				time = MyDate.toString(voc.date);
				type = DocType.outStoreDoc;
				break;
			default:
				break;
			}
			orderSimpleInfoVOs.add(new OrderSimpleInfoVO(orderBarCode, place,
					time, type));

		}

		return orderSimpleInfoVOs;
	}

	public OrderVO getFullInfo(String orderBarCode) throws RemoteException {
		OrderPO po = null;
		po = orderData.getSingleOrderPO(orderBarCode);

		if (po != null) {
			OrderVO vo = (OrderVO) VOPOchange.POtoVO(po);
			return vo;
		} else {
			return null;
		}
	}

	public ResultMessage receiveInfo(ReceiveVO vo) throws RemoteException {
		String orderBarCode = vo.orderBarCode;
		ReceivePO po = (ReceivePO) VOPOchange.VOtoPO(vo);
		return orderData.receiveInfo(po, orderBarCode);
	}

	public ResultMessage addDocToList(DocVO vo, ArrayList<String> orderBarCodes)
			throws RemoteException {
		DocPO po = (DocPO) VOPOchange.VOtoPO(vo);
		return orderData.addDocToList(po, orderBarCodes);
	}
	
	
	//TODO
	@SuppressWarnings("unused")
	public ArrayList<PreReceiveVO> getPreReceive(
			ArrayList<SendGoodDocVO> daySendDocs) throws RemoteException {
		ArrayList<String> barCodes = null;
		ArrayList<PreReceiveVO> pres = null;

		if (daySendDocs != null) {
			barCodes = new ArrayList<>(daySendDocs.size());
			for (int i = 0; i < daySendDocs.size(); i++) {
				barCodes.add(daySendDocs.get(i).orderBarCode.get(0));
				
			}
			pres = new ArrayList<>(daySendDocs.size());
		}
		
		if (barCodes != null) {
			OrderVO tmp = null;
			for (int i = 0; i < barCodes.size(); i++) {
				tmp = getFullInfo(barCodes.get(i));
				 PreReceiveVO vo = new PreReceiveVO(tmp.ID,
				 tmp.receiver.getAddress(), tmp.receiver.getName() , tmp.otherMes.getRealReceiver() , tmp.otherMes.getOrderReceiveDate());
				 pres.add(vo);
			}
		}

		return pres;
	}

	public double getEstiDate(City one, City two) {
		EstiDateVO vo = strategybl.getEstiDateVO();
		double[] map = new double[6];
		map[0] = vo.dayInBG;
		map[1] = vo.dayInBN;
		map[2] = vo.dayInBS;
		map[3] = vo.dayInNG;
		map[4] = vo.dayInNS;
		map[5] = vo.dayInSG;
		if (twoPlace(City.BEIJING, City.GUANGZHOU, one, two))
			return map[0];
		else if (twoPlace(City.BEIJING, City.NANJING, one, two))
			return map[1];
		else if (twoPlace(City.BEIJING, City.SHANGHAI, one, two))
			return map[2];
		else if (twoPlace(City.NANJING, City.GUANGZHOU, one, two))
			return map[3];
		else if (twoPlace(City.NANJING, City.SHANGHAI, one, two))
			return map[4];
		else if (twoPlace(City.SHANGHAI, City.GUANGZHOU, one, two))
			return map[5];

		return 0;
	}

	private boolean twoPlace(City target1, City target2, City one, City two) {
		if (target1 == one && target2 == two)
			return true;

		if (target1 == two && target2 == one)
			return true;

		return false;
	}

	public ResultMessage setEstiDate(double day, City one, City two) {
		EstiDateVO vo = strategybl.getEstiDateVO();
		if (twoPlace(City.BEIJING, City.GUANGZHOU, one, two))
			vo.dayInBG = (vo.dayInBG + day) / 2;
		else if (twoPlace(City.BEIJING, City.NANJING, one, two))
			vo.dayInBN = (vo.dayInBN + day) / 2;
		else if (twoPlace(City.BEIJING, City.SHANGHAI, one, two))
			vo.dayInBS = (vo.dayInBS + day) / 2;
		else if (twoPlace(City.NANJING, City.GUANGZHOU, one, two))
			vo.dayInNG = (vo.dayInNG + day) / 2;
		else if (twoPlace(City.NANJING, City.SHANGHAI, one, two))
			vo.dayInNS = (vo.dayInNS + day) / 2;
		else if (twoPlace(City.SHANGHAI, City.GUANGZHOU, one, two))
			vo.dayInSG = (vo.dayInSG + day) / 2;
		return strategybl.setEstiDateVO(vo);
	}

	public ResultMessage changeDocsState(ArrayList<String> docsID,
			DocType type, DocState state) throws RemoteException {
		return orderData.changeDocsState(docsID, type, state);
	}

	public ResultMessage changeOneDocState(String docID, DocType type,
			DocState state) throws RemoteException {
		return orderData.changeOneDocState(docID, type, state);

	}

	@SuppressWarnings("unchecked")
	public ArrayList<DocVO> getDocLists() throws RemoteException {
		ArrayList<DocVO> vos = null;
		ArrayList<OrderPO> pos = null;
		pos = (ArrayList<OrderPO>) orderData.getDocLists(DocType.order);
		
		if(pos == null){
			return null;
		}
		
		
		vos = new ArrayList<>(pos.size());
		for (OrderPO orderPO : pos) {
			vos.add((OrderVO) VOPOchange.POtoVO(orderPO));
		}
		return vos.isEmpty() ? null : vos;

	}

}
