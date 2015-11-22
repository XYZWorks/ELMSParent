package data.orderdata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import po.DocPO;
import po.order.OrderPO;
import po.order.ReceivePO;
import util.DocType;
import util.MyDate;
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
	
	private final String orderTable = "order";

	public OrderDataImpl() throws RemoteException {}
	
	public void initial() throws RemoteException {
		initialFromSQL(orderTable);
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
			e.printStackTrace();
			return null;
		}
		
		return pos;
	}

	public ResultMessage add(OrderPO po) throws RemoteException {
		return addToSQL(orderTable, po.getOrderBarCode() , DocType.getName(po.getType()) , MyDate.toString(po.getDate()) , po.getState().name() , po.getSenderName() , po.getSenderPhone() , po.getSenderAddress() , po.getReceiverName() , po.getReceiverPhone() , po.getReceiverCompany() , po.getReceiverAddress() , String.valueOf(po.getGoodNum()) ,po.getGoodName() , String.valueOf(po.getGoodWeight()) , String.valueOf(po.getGoodLong()) , String.valueOf(po.getGoodWidth()) , String.valueOf(po.getGoodHeight()) , po.getGoodPack() , po.getOrderForm() , String.valueOf(po.getOrderEestiTime()) ,String.valueOf(po.getOrderCost()) , po.getLoadDoc() , po.getArriveZZDoc() , po.getTransferDoc() , po.getArriveYYDoc() , po.getSendGoodDoc() , po.getRealReceiver() , MyDate.toString(po.getOrderReceiveDate())) ;
	}

	public ResultMessage del(String orderBarCode) throws RemoteException {
		return delFromSQL(orderTable, orderBarCode);
	}

	public ResultMessage addDocToList(DocPO po, ArrayList<String> orderBarCodes)
			throws RemoteException {
		try {
			String type = po.getType().name();
			int affectNum = 0;
			for (String temp : orderBarCodes) {
				sql = "MODIFY `" + orderTable + "` SET " + type + "` = ?" + "WHERE orderBarCode ="
						+ temp;
				preState.setString(1, po.getID());
				preState = conn.prepareStatement(sql);
				affectNum = preState.executeUpdate();
			}
			if(affectNum == 0){
				return ResultMessage.NOT_EXIST;
			}else{
				return ResultMessage.SUCCESS;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ResultMessage.FAIL;
	}

	public OrderPO getSingleOrderPO(String orderBarCode) throws RemoteException {
		findMes = findFromSQL(orderTable, orderBarCode);
		if(findMes == null){
			return null;
		}else{
			return new OrderPO(findMes.get(1), MyDate.getDate(findMes
					.get(2)), findMes.get(3),
					findMes.get(4), findMes.get(5),
					findMes.get(6), findMes.get(7),
					findMes.get(8), findMes.get(9),
					findMes.get(10), Integer.parseInt(findMes.get(11)),
					findMes.get(12),
					Integer.parseInt(findMes.get(13)),
					Integer.parseInt(findMes.get(14)),
					Integer.parseInt(findMes.get(15)),
					Integer.parseInt(findMes.get(16)),
					findMes.get(17), findMes.get(18),
					Integer.parseInt(findMes.get(19)),
					Integer.parseInt(findMes.get(20)),
					findMes.get(21), findMes.get(22),
					findMes.get(23), findMes.get(24),
					findMes.get(25), findMes.get(26),
					MyDate.getDate(findMes.get(27)));
		}
		
	}
	
	
	//改成 String ，返回的应该是单据的ID，然后去查找   edit by czq
	public ArrayList<String> getSingleOrderDocs(String orderBarCode )
			throws RemoteException {
		ArrayList<String> docpos ;
		findMes = findFromSQL(orderTable, orderBarCode);
		if(findMes == null){
			return null; 
		}else{
			docpos = new ArrayList<String>(5);
			docpos.add(findMes.get(20));
			docpos.add(findMes.get(21));
			docpos.add(findMes.get(22));
			docpos.add(findMes.get(23));
			docpos.add(findMes.get(24));
			return docpos;
		}
	}

	public ResultMessage receiveInfo(ReceivePO PO ,String orderBarCode) throws RemoteException {
		int affectRows = 0;
		try {
			sql = "UPDATE " + orderTable + "SET `senderAddress`= ? , `receiverName`= ? ,`receiverPhone`= ? ,`receiverCompany`= ? ,`receiverAddress`= ?  WHERE orderBarCode = "
					+ orderBarCode;
			preState = conn.prepareStatement(sql);
			affectRows = preState.executeUpdate();
			if(affectRows == 0){
				return ResultMessage.NOT_EXIST;
			}else{
				return ResultMessage.SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return ResultMessage.FAIL;
	}

	

}
