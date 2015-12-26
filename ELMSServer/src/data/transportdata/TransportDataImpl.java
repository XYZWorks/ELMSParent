package data.transportdata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import po.DocPO;
import po.transport.ArriveYYDocPO;
import po.transport.ArriveZZDocPO;
import po.transport.LoadDocPO;
import po.transport.PayDocPO;
import po.transport.SendGoodDocPO;
import po.transport.TransferDocPO;
import util.City;
import util.DocState;
import util.DocType;
import util.GoodsState;
import util.MyDate;
import util.ResultMessage;
import dataSuper.DataSuperClass;
import ds.transportdataservice.Transportdataservice;
 /** 
 * 
 * @author czq 
 * @version 2015年11月5日 下午10:04:10 
 */
public class TransportDataImpl extends DataSuperClass implements Transportdataservice {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String loadDocTable = "LoadDoc";
	
	private final String sendGoodDocTable = "SendGoodDoc";
	
	private final String transferDocTable = "TransferDoc";
	
	private final String arriveZZDocTable = "ArriveZZDoc";
	
	private final String arriveYYDocTable = "ArriveYYDoc";
	
	private final String payDocTable = "PayDoc";
	
	public TransportDataImpl() throws RemoteException {}
	
	public void initial() throws RemoteException {
		initialFromSQL(loadDocTable);
		initialFromSQL(sendGoodDocTable);
		initialFromSQL(transferDocTable);
		initialFromSQL(arriveZZDocTable);
		initialFromSQL(arriveYYDocTable);
	}

	public LoadDocPO getLoadDocPO(String id) throws RemoteException {
		findMes = findFromSQL(loadDocTable, id);
		if(findMes==null){
			return null;
		}else{
			return new LoadDocPO(findMes.get(0), DocType.valueOf(findMes.get(1)), MyDate.getDate(findMes.get(2)), DocState.valueOf(findMes.get(3)), findMes.get(4), findMes.get(5), City.valueOf(findMes.get(6)), findMes.get(7), findMes.get(8), findMes.get(9) , helper.tranFromStringToArrayList(findMes.get(10)));
		}
	}

	public ResultMessage addLoadDocPO(LoadDocPO po) throws RemoteException {
		return addToSQL(loadDocTable, po.getID() , po.getType().name() , MyDate.toString(po.getDate()) , po.getState().name() , po.getYYID() , po.getLoadDocID(), po.getArriveCity().name() ,po.getCarID(), po.getSupervisor() , po.getEscort() , helper.tranFromArrayToString(po.getOrderBarCodes()));
	}

	public SendGoodDocPO getSendGoodDocPO(String id) throws RemoteException {
		findMes = findFromSQL(sendGoodDocTable, id);
		if(findMes==null){
			return null;
		}else{
			return new SendGoodDocPO(findMes.get(0), DocType.valueOf(findMes.get(1)), MyDate.getDate(findMes.get(2)), DocState.valueOf(findMes.get(3)), findMes.get(4),findMes.get(5), City.valueOf(findMes.get(6)));
		}
	}

	public ResultMessage addSendGoodDocPO(SendGoodDocPO po)
			throws RemoteException {
		return addToSQL(sendGoodDocTable, po.getID() , po.getType().name() , MyDate.toString(po.getDate()) , po.getState().name() , po.getSendMan() , po.getOrderBarCode() , po.getSendCity().name());
	}

	public TransferDocPO getTransferDocPO(String id) throws RemoteException {
		findMes = findFromSQL(transferDocTable, id);
		if(findMes==null){
			return null;
		}else{
			return new TransferDocPO(findMes.get(0), DocType.valueOf(findMes.get(1)), MyDate.getDate(findMes.get(2)), DocState.valueOf(findMes.get(3)), findMes.get(4), City.valueOf(findMes.get(5) ),  Integer.parseInt(findMes.get(6)) , findMes.get(7) , helper.tranFromStringToArrayList(findMes.get(8)));
		}
	}

	public ResultMessage addTransferDocPO(TransferDocPO po)
			throws RemoteException {
		return addToSQL(transferDocTable, po.getID() , po.getType().name() , MyDate.toString(po.getDate()) , po.getState().name() , po.getTransferWayID() , po.getSendCity().name() , String.valueOf(po.getContainerNum()) , po.getLoadManName() , helper.tranFromArrayToString(po.getOrderBarCode()));
	}

	public ArriveZZDocPO getArriveZZDocPO(String id) throws RemoteException {
		findMes = findFromSQL(arriveZZDocTable, id);
		if(findMes==null){
			return null;
		}else{
			return new ArriveZZDocPO(findMes.get(0), DocType.valueOf(findMes.get(1)), MyDate.getDate(findMes.get(2)), DocState.valueOf(findMes.get(3)), findMes.get(4), City.valueOf(findMes.get(5) ) , GoodsState.valueOf(findMes.get(6)) , helper.tranFromStringToArrayList(findMes.get(7)) );
		}
	}

	public ResultMessage addArriveZZDocPO(ArriveZZDocPO po)
			throws RemoteException {
		return addToSQL(arriveZZDocTable, po.getID() , po.getType().name() , MyDate.toString(po.getDate()) , po.getState().name() , po.getZZID() , po.getSendCity().name() , po.getGoodState().name() , helper.tranFromArrayToString(po.getOrderBarCodes()));
	}

	public ArriveYYDocPO getArriveYYDocPO(String id) throws RemoteException {
		findMes = findFromSQL(arriveYYDocTable, id);
		if(findMes==null){
			return null;
		}else{
			return new ArriveYYDocPO(findMes.get(0), DocType.valueOf(findMes.get(1)), MyDate.getDate(findMes.get(2)), DocState.valueOf(findMes.get(3)), findMes.get(4),City.valueOf(findMes.get(5) ) , GoodsState.valueOf(findMes.get(6)) , helper.tranFromStringToArrayList(findMes.get(7))  );
		}
	}

	public ResultMessage addArriveYYDocPO(ArriveYYDocPO po)
			throws RemoteException {
		return addToSQL(arriveYYDocTable, po.getID() , po.getType().name() , MyDate.toString(po.getDate()) , po.getState().name() , po.getZZID() , po.getSendCity().name() , po.getGoodState().name() ,  helper.tranFromArrayToString(po.getOrderBarCodes()));
	}

	public ArrayList<? extends DocPO> getDocLists(DocType type) throws RemoteException {
		String temptable = "";
		ArrayList<DocPO> pos = new ArrayList<DocPO>();
		switch (type) {
		case loadDoc:
			temptable = loadDocTable;
			break;
		case arriveYYDoc:
			temptable = arriveYYDocTable;
			break;
		case arriveZZDoc:
			temptable = arriveZZDocTable;
			break;
		case transferDoc:
			temptable = transferDocTable;
			break;
		case sendGoodDoc:
			temptable = sendGoodDocTable;
			break;
		default:
			return null;
		}
		try {
			sql = "SELECT * FROM  `" + temptable + "` WHERE state = \"wait\" " ;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			switch (type) {
			case loadDoc:
				while(result.next())
					pos.add(new LoadDocPO(result.getString(1), DocType.valueOf(result.getString(2)), MyDate.getDate(result.getString(3)), DocState.valueOf(result.getString(4)), result.getString(5), result.getString(6),  City.valueOf(result.getString(7)),result.getString(8) , result.getString(9), result.getString(10) , helper.tranFromStringToArrayList(result.getString(11)))  );
				break;
			case arriveYYDoc:
				while(result.next())
					pos.add(new ArriveYYDocPO(result.getString(1), DocType.valueOf(result.getString(2)), MyDate.getDate(result.getString(3)), DocState.valueOf(result.getString(4)), result.getString(5), City.valueOf(result.getString(6)) , GoodsState.valueOf(result.getString(7 )) , helper.tranFromStringToArrayList(result.getString(8))  ) );
				break;
			case arriveZZDoc:
				while(result.next())
					pos.add(new ArriveZZDocPO(result.getString(1), DocType.valueOf(result.getString(2)), MyDate.getDate(result.getString(3)), DocState.valueOf(result.getString(4)), result.getString(5), City.valueOf(result.getString(6)) , GoodsState.valueOf(result.getString(7)) , helper.tranFromStringToArrayList(result.getString(8))  ) );
				break;
			case transferDoc:
				while(result.next())
					pos.add(new TransferDocPO(result.getString(1), DocType.valueOf(result.getString(2)), MyDate.getDate(result.getString(3)), DocState.valueOf(result.getString(4)), result.getString(5), City.valueOf(result.getString(6)) ,  Integer.parseInt(result.getString(7)) , result.getString(8) , helper.tranFromStringToArrayList(result.getString(9)) ));
				break;
			case sendGoodDoc:
				while(result.next())
					pos.add(new SendGoodDocPO(result.getString(1), DocType.valueOf(result.getString(2)), MyDate.getDate(result.getString(3)), DocState.valueOf(result.getString(4)), result.getString(5), result.getString(6)  ,City.valueOf(result.getString(7))) );
					
				break;
			default:
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		if(pos.isEmpty()){
			return null;
		}else{
			return pos;
		}
		
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

	public ResultMessage changeOneDocState(String docID,
			DocType type, DocState state)  throws RemoteException{
		String temptable = "";
		switch (type) {
		case loadDoc:
			temptable = loadDocTable;
			break;
		case arriveYYDoc:
			temptable = arriveYYDocTable;
			break;
		case arriveZZDoc:
			temptable = arriveZZDocTable;
			break;
		case transferDoc:
			temptable = transferDocTable;
			break;
		case sendGoodDoc:
			temptable = sendGoodDocTable;
			break;
		default:
			return null;
		}
		return super.changeOneDocState(docID, temptable, state);
	}

	@Override
	public ResultMessage addPayDoc(PayDocPO po) throws RemoteException {
		return addToSQL(payDocTable	, po.getID() , MyDate.toString(po.getDate()) , po.getYYID() , String.valueOf(po.getMoney()) , po.getCourierName() , helper.tranFromArrayToString(po.getOrders()));
	}

	@Override
	public ArrayList<PayDocPO> getPays() throws RemoteException {
		ArrayList<PayDocPO> pos = new ArrayList<>();
		try {
			sql = "SELECT * FROM  " + payDocTable;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				pos.add(new PayDocPO(result.getString(1), Integer
						.parseInt(result.getString(4)), result.getString(3),
						MyDate.getDate(result.getString(2)), result
								.getString(5), helper
								.tranFromStringToArrayList(result.getString(6))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pos.isEmpty()?null:pos;
	}

	@Override
	public int getDayDocCount(DocType type, MyDate date) throws RemoteException {
		switch (type) {
		case loadDoc:
			return super.getDayDocCount(loadDocTable , date);
		case arriveYYDoc:
			return super.getDayDocCount(arriveYYDocTable, date);
		case arriveZZDoc:
			return super.getDayDocCount(arriveZZDocTable, date);
		case transferDoc:
			return super.getDayDocCount(transferDocTable, date);
		case sendGoodDoc:
			return super.getDayDocCount(sendGoodDocTable, date);
		default:
			System.err.println("单据类型错误，不能获得对应单据");
			return -1;
		}
	}

}
