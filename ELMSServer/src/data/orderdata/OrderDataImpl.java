package data.orderdata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DocState;
import util.DocType;
import util.MyDate;
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
	
	private final String orderTable = "orderTable";

	public OrderDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<OrderPO> getDayOrderPO(MyDate date) throws RemoteException {
		sql = "SELECT * FROM " + orderTable + "WHERE date =" + MyDate.toString(date);
		ArrayList<OrderPO> pos = new ArrayList<OrderPO>(50);
		OrderPO po;
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while(result.next()){
				po = new OrderPO(result.getString(1), MyDate.getDate(result
						.getString(2)), result.getString(3),
						result.getString(4), result.getString(5),
						result.getString(6), result.getString(7),
						result.getString(8), result.getString(9),
						result.getString(10), Integer.parseInt(result.getString(11)),
						result.getString(12),
						Integer.parseInt(result.getString(13)),
						Integer.parseInt(result.getString(14)),
						Integer.parseInt(result.getString(15)),
						Integer.parseInt(result.getString(16)),
						result.getString(17), result.getString(18),
						Integer.parseInt(result.getString(19)),
						Integer.parseInt(result.getString(20)),
						result.getString(21), result.getString(22),
						result.getString(23), result.getString(24),
						result.getString(25), result.getString(26),
						MyDate.getDate(result.getString(27)));
				pos.add(po);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
		
		return pos;
	}

	public ResultMessage add(OrderPO po) throws RemoteException {
		return addToSQL(orderTable, po.getOrderBarCode() , DocType.getName(po.getType()) , MyDate.toString(po.getDate()) , po.getState().name() , po.getSenderName() , po.getSenderPhone() , po.getSenderAddress() , po.getReceiverName() , po.getReceiverPhone() , po.getReceiverCompany() , po.getReceiverAddress() , String.valueOf(po.getGoodNum()) ,po.getGoodName() , String.valueOf(po.getGoodWeight()) , String.valueOf(po.getGoodLong()) , String.valueOf(po.getGoodWidth()) , String.valueOf(po.getGoodHeight()) , po.getGoodPack() , po.getOrderForm() , String.valueOf(po.getOrderEestiTime()) ,String.valueOf(po.getOrderCost()) , po.getLoadDoc() , po.getArriveZZDoc() , po.getTransferDoc() , po.getArriveYYDoc() , po.getSendGoodDoc() , po.getRealReceiver() , MyDate.toString(po.getOrderReceiveDate())) ;
	}

	public ResultMessage del(String orderBarCode) throws RemoteException {
		return delFromSQL(orderBarCode, orderBarCode);
	}

	public ResultMessage addDocToList(DocPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderPO getSingleOrderPO(String orderBarCode) throws RemoteException {
		findMes = 
		return null;
	}

	public ArrayList<DocPO> getSingleOrderDocs(String orderBarCode)
			throws RemoteException {
		
		findMes = findFromSQL(orderTable, orderBarCode);
		return null; 
	}

	public ResultMessage receiveInfo(ReceivePO PO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
