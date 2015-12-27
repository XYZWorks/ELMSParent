package bl.orderbl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import net.RMIManage;
import util.City;
import util.DataServiceType;
import util.DocState;
import util.DocType;
import util.MyDate;
import util.ResultMessage;
import vo.DocVO;
import vo.order.OrderSimpleInfoVO;
import vo.order.OrderVO;
import vo.order.PreReceiveVO;
import vo.order.ReceiveVO;
import bl.BusinessController;
import bl.transportbl.TransportController;
import blservice.orderblservice.Orderblservice;
import ds.orderdataservice.OrderDataService;
import exception.ExceptionHandler;

/**
 * 订单controller类
 * 
 * @author czq
 * @version 2015年11月15日 上午9:22:18
 */
public class OrderController extends BusinessController implements
		Orderblservice {

	private TransportController transportController;
	private OrderDataService orderData;
	private Order order;

	public OrderController() {
		orderData = (OrderDataService) RMIManage
				.getDataService(DataServiceType.OrderDataService);
		order = new Order(orderData);
		myType = DataServiceType.OrderDataService;
	}

	@Override
	public ResultMessage add(OrderVO vo) {
		try {
			return order.add(vo);
		} catch (RemoteException  | NullPointerException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return add(vo);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage checkBarCode(String orderBarCode) {
		try {
			return order.checkBarCode(orderBarCode);
		} catch (RemoteException  | NullPointerException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return checkBarCode(orderBarCode);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<OrderVO> getOrderVO(MyDate date) {
		try {
			return order.getOrderVO(date);
		} catch (RemoteException  | NullPointerException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return getOrderVO(date);
			}
		}
		return null;
	}

	@Override
	public ResultMessage del(String orderBarCode) {
		try {
			return order.del(orderBarCode);
		} catch (RemoteException  | NullPointerException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return del(orderBarCode);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<OrderSimpleInfoVO> getSimpleInfo(String orderBarCode) {
		try {
			return order.getSimpleInfo(orderBarCode);
		} catch (RemoteException  | NullPointerException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return getSimpleInfo(orderBarCode);
			}
		}
		return null;
	}

	@Override
	public OrderVO getFullInfo(String orderBarCode) {
		try {
			return order.getFullInfo(orderBarCode);
		} catch (RemoteException  | NullPointerException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return getFullInfo(orderBarCode);
			}
		}
		return null;
	}

	@Override
	public ResultMessage receiveInfo(ReceiveVO vo) {
		try {
			return order.receiveInfo(vo);
		} catch (RemoteException  | NullPointerException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return receiveInfo(vo);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage addDocToList(DocVO vo, ArrayList<String> orderBarCodes) {
		try {
			return order.addDocToList(vo, orderBarCodes);
		} catch (RemoteException  | NullPointerException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return addDocToList(vo, orderBarCodes);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<DocVO> getDocLists(DocType type) {

		try {
			return order.getDocLists();
		} catch (RemoteException  | NullPointerException e1 ){
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return getDocLists(type);
			}
		}
		return null;
	}

	@Override
	public ResultMessage changeDocsState(ArrayList<String> docsID,
			DocType type, DocState state) {
		try {
			return order.changeDocsState(docsID, type, state);
		} catch (RemoteException  | NullPointerException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return changeDocsState(docsID, type, state);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage changeOneDocState(String docID, DocType type,
			DocState state) {
		try {
			return order.changeOneDocState(docID, type, state);
		} catch (RemoteException  | NullPointerException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return changeOneDocState(docID, type, state);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<PreReceiveVO> getPreReceive() {
		try {
			return order.getPreReceive(transportController
					.getDaySendDocs(MyDate.getNowTime()));
		} catch (RemoteException  | NullPointerException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return getPreReceive();
			}
		}
		return null;
	}

	@Override
	public DocVO getByID(String ID, DocType type) {
		return getFullInfo(ID);
	}

	@Override
	public double getEstiDate(City one, City two) {
		return order.getEstiDate(one, two);
	}

	@Override
	public ResultMessage setEstiDate(double day, City one, City two) {

		return order.setEstiDate(day, one, two);
	}

	@Override
	public int getDayDocCount(DocType type) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void reinitDataService(Remote dataService) {
		orderData = (OrderDataService) dataService;
		order = new Order(orderData);
	}

}
