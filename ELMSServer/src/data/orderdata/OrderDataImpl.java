package data.orderdata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.DocPO;
import po.OrderPO;
import po.ReceivePO;
import util.ResultMessage;
import dataSuper.DataSuperClass;
import ds.orderdataservice.OrderDataService;
 /** 
 * 
 * @author czq 
 * @version 2015年11月5日 下午8:46:19 
 */
public class OrderDataImpl extends DataSuperClass implements OrderDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<OrderPO> getDayOrderPO(Date date) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage add(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage del(String orderBarCode) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addDocToList(DocPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderPO getSingleOrderPO(String orderBarCode) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DocPO> getSingleOrderDocs(String orderBarCode)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage receiveInfo(ReceivePO PO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
