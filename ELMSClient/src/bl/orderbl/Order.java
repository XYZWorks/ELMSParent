package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import bl.storebl.StoreController;
import bl.transportbl.TransportController;
import util.DataServiceType;
import util.MyDate;
import util.ResultMessage;
import vo.DocVO;
import vo.order.OrderSimpleInfoVO;
import vo.order.OrderVO;
import vo.order.ReceiveVO;
import blservice.strategyblservice.StrategyblService;
import ds.orderdataservice.OrderDataService;
import net.RMIManage;
import po.order.OrderPO;
import test.java.other.VOPOchange;

/**
 * @author ymc
 * @version 创建时间：2015年10月27日 下午7:48:05
 *
 */
public class Order {
	OrderDataService orderData;
	StrategyblService strategybl;
	TransportController transportController;
	StoreController storeController;
	
	public Order() {
		orderData = (OrderDataService) RMIManage.getDataService(DataServiceType.OrderDataService);
		try {
			orderData.initial();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ResultMessage add(OrderVO vo) {
		OrderPO po = (OrderPO) VOPOchange.VOtoPO(vo);
		try {
			return orderData.add(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
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

		transportController = new TransportController();
		ArrayList<String> poStrings = new ArrayList<String>();
		try {
			poStrings = orderData.getSingleOrderDocs(orderBarCode);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (String poString : poStrings) {
			if (poString.startsWith("ZCD") || poString.startsWith("DDD") || poString.startsWith("ZZD")
					|| poString.startsWith("JSD") || poString.startsWith("PSD"))
				transportController.getByID(poString);
			else if(poString.startsWith("RKD")||poString.startsWith("CKD"))
				storeController.getByID(poString);
		}

		return null;
	}

	public OrderVO getFullInfo(String orderBarCode) {
		try {
			orderData.getSingleOrderPO(orderBarCode);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage receiveInfo(ArrayList<ReceiveVO> vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addDocToList(DocVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
