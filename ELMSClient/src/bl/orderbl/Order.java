package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import util.DataServiceType;
import util.ResultMessage;
import vo.DocVO;
import vo.order.OrderSimpleInfoVO;
import vo.order.OrderVO;
import vo.order.ReceiveVO;
import blservice.strategyblservice.StrategyblService;
import ds.orderdataservice.OrderDataService;
import net.RMIManage;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:48:05 
 *
 */
public class Order {
	OrderDataService orderData;
	StrategyblService strategybl;
	
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
		return null;
	}

	public ResultMessage checkBarCode(String orderBarCode) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderVO> getOrderVO(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage del(String orderBarCode) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderSimpleInfoVO> getSimpleInfo(String orderBarCode) {
		ArrayList<String> poString = new ArrayList<String>();
		try {
			poString = orderData.getSingleOrderDocs(orderBarCode);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
