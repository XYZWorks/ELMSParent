package data.orderdata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import po.DocPO;
import po.order.GoodMes;
import po.order.OrderPO;
import po.order.OtherOrderMes;
import po.order.PeopleMes;
import po.order.ReceivePO;
import po.order.TransferDocs;
import util.DocState;
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
	
	private static final String orderTable = "myorder";

	public OrderDataImpl() throws RemoteException {}
	
	public void initial() throws RemoteException {
		initialFromSQL(orderTable);
	}

	public ArrayList<OrderPO> getDayOrderPO(MyDate date) throws RemoteException {
		sql = "SELECT * FROM " + orderTable + "WHERE date =" +"\""+ MyDate.toString(date)+"\"";
		ArrayList<OrderPO> pos = new ArrayList<OrderPO>(50);
		OrderPO po;
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				po = new OrderPO(result.getString(1), DocType.valueOf(result
						.getString(2)), MyDate.getDate(result.getString(3)),
						DocState.valueOf(result.getString(4)), new PeopleMes(
								result.getString(5), result.getString(6),
								result.getString(7), result.getString(8)),
						new PeopleMes(result.getString(9),
								result.getString(10), result.getString(11),
								result.getString(12)), new GoodMes(
								Integer.parseInt(result.getString(13)),
								result.getString(14), Integer.parseInt(result
										.getString(15)),
								Integer.parseInt(result.getString(16)),
								Integer.parseInt(result.getString(17)),
								Integer.parseInt(result.getString(18))),
						new OtherOrderMes(result.getString(19), result
								.getString(20) , MyDate.getDate(result.getString(21)), Integer.parseInt(result
								.getString(22)), Double.parseDouble(result
								.getString(23)), result.getString(34), MyDate
								.getDate(result.getString(35))),
						new TransferDocs(result.getString(24), result
								.getString(25), result.getString(26), result
								.getString(27), result.getString(28) , result.getString(29) ,result.getString(30) , result.getString(31) , result.getString(32), helper.tranFromStringToArrayList(result.getString(33))));
				pos.add(po);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return pos;
	}

	public ResultMessage add(OrderPO po) throws RemoteException {
		return addToSQL(orderTable, po.getID(), po.getType().name(),
				MyDate.toString(po.getDate()), po.getState().name(), po
						.getSender().getName(), po.getSender().getPhone(), po
						.getSender().getCompany(), po.getSender().getAddress(),
				po.getReceiver().getName(), po.getReceiver().getPhone(), po
						.getReceiver().getCompany(), po.getReceiver()
						.getAddress(), String.valueOf(po.getGoodMes()
						.getGoodNum()), po.getGoodMes().getGoodName(),
				String.valueOf(po.getGoodMes().getGoodWeight()),
				String.valueOf(po.getGoodMes().getGoodLong()),
				String.valueOf(po.getGoodMes().getGoodWidth()),
				String.valueOf(po.getGoodMes().getGoodHeight()), po
						.getOtherMes().getGoodPack(), po.getOtherMes()
						.getOrderForm(), MyDate.toString(po.getOtherMes().getOrderStartDate()) , String.valueOf(po.getOtherMes()
						.getOrderEestiTime()), String.valueOf(po.getOtherMes()
						.getOrderCost()), po.getTransferDocs().getLoadDoc(), po
						.getTransferDocs().getArriveZZDoc(), po
						.getTransferDocs().getTransferDoc(), po
						.getTransferDocs().getArriveYYDoc(), po
						.getTransferDocs().getSendGoodDoc() , helper.tranFromArrayToString(po.getTransferDocs().getAllDocs()), po.getOtherMes()
						.getRealReceiver(), MyDate.toString(po.getOtherMes()
						.getOrderReceiveDate()));
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
				sql = "MODIFY `" + orderTable + "` SET `" + type + "` = ?" + "WHERE id ="
						+"\""+ temp+"\"";
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
			return  new OrderPO(findMes.get(0), DocType.valueOf(findMes
					.get(0)), MyDate.getDate(findMes.get(2)),
					DocState.valueOf(findMes.get(3)), new PeopleMes(
							findMes.get(4), findMes.get(5),
							findMes.get(6), findMes.get(7)),
					new PeopleMes(findMes.get(8),
							findMes.get(9), findMes.get(10),
							findMes.get(11)), new GoodMes(
							Integer.parseInt(findMes.get(12)),
							findMes.get(13), Integer.parseInt(findMes
									.get(14)),
							Integer.parseInt(findMes.get(15)),
							Integer.parseInt(findMes.get(16)),
							Integer.parseInt(findMes.get(17))),
					new OtherOrderMes(findMes.get(18), findMes
							.get(19), MyDate.getDate(findMes.get(20)) , Integer.parseInt(findMes
							.get(21)), Double.parseDouble(findMes
									.get(22)), findMes.get(33), MyDate
							.getDate(findMes.get(34))),
					new TransferDocs(findMes.get(23), findMes
							.get(24), findMes.get(25), findMes
							.get(26), findMes.get(27) , findMes.get(28) , findMes.get(29) , findMes.get(30) , findMes.get(31), helper.tranFromStringToArrayList(findMes.get(32))));
		}
		
	}
	
	
	//改成 String ，返回的应该是单据的ID，然后去查找   edit by czq
	public ArrayList<String> getSingleOrderDocs(String orderBarCode )
			throws RemoteException {
		ArrayList<String> docpos ;
		findMes = findFromSQL(orderTable, orderBarCode);
		System.err.println(orderBarCode);
		if(findMes == null){
			return null; 
		}else{
			docpos = new ArrayList<String>(10);
			for (int i = 0; i < 10; i++) {
				if(findMes.get(22 + i) != null){
					docpos.add(findMes.get(22 + i));
					System.err.println(findMes.get(22 + i));
				}else{
					break;
				}
			}
			return docpos;
		}
	}

	public ResultMessage receiveInfo(ReceivePO PO ,String orderBarCode) throws RemoteException {
		int affectRows = 0;
		try {
			sql = "UPDATE " + orderTable + " SET `senderAddress`= ? , `receiverName`= ? ,`receiverPhone`= ? ,`receiverCompany`= ? ,`receiverAddress`= ?  WHERE orderBarCode = "
					+"\""+ orderBarCode+"\"";
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

	public ArrayList<? extends DocPO> getDocLists(DocType type)  throws RemoteException{
		sql = "SELECT * FROM " + orderTable + " WHERE state = \"wait\" " ;
		ArrayList<OrderPO> pos = new ArrayList<OrderPO>(50);
		OrderPO po;
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				po = new OrderPO(result.getString(1), DocType.valueOf(result
						.getString(2)), MyDate.getDate(result.getString(3)),
						DocState.valueOf(result.getString(4)), new PeopleMes(
								result.getString(5), result.getString(6),
								result.getString(7), result.getString(8)),
						new PeopleMes(result.getString(9),
								result.getString(10), result.getString(11),
								result.getString(12)), new GoodMes(
								Integer.parseInt(result.getString(13)),
								result.getString(14), Integer.parseInt(result
										.getString(15)),
								Integer.parseInt(result.getString(16)),
								Integer.parseInt(result.getString(17)),
								Integer.parseInt(result.getString(18))),
						new OtherOrderMes(result.getString(19), result
								.getString(20) , MyDate.getDate(result.getString(21)), Integer.parseInt(result
								.getString(22)), Double.parseDouble(result
								.getString(23)), result.getString(34), MyDate
								.getDate(result.getString(35))),
						new TransferDocs(result.getString(24), result
								.getString(25), result.getString(26), result
								.getString(27), result.getString(28) , result.getString(29) ,result.getString(30) , result.getString(31) , result.getString(32), helper.tranFromStringToArrayList(result.getString(33))));
				pos.add(po);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return pos;
	}

	public ResultMessage changeDocsState(ArrayList<String> docsID,
			DocType type, DocState state)  throws RemoteException{
		ResultMessage result;
		for (String string : docsID) {
			result = changeOneDocState(string, type, state);
			if(result != ResultMessage.SUCCESS){
				return ResultMessage.FAIL;
			}
		}
		return ResultMessage.SUCCESS;
	}

	public ResultMessage changeOneDocState (String docID,
			DocType type, DocState state)  throws RemoteException {
		return super.changeOneDocState(docID, orderTable, state);
	}

	@Override
	public int getDayDocCount(DocType type, MyDate date) throws RemoteException {
		return super.getDayDocCount(orderTable,  date);
	}

	

}
