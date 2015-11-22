package data.transportdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.DocPO;
import po.transport.ArriveYYDocPO;
import po.transport.ArriveZZDocPO;
import po.transport.LoadDocPO;
import po.transport.SendGoodDocPO;
import po.transport.TransferDocPO;
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
			return new LoadDocPO(findMes.get(0), DocType.valueOf(findMes.get(1)), MyDate.getDate(findMes.get(2)), DocState.valueOf(findMes.get(3)), findMes.get(4), findMes.get(5), findMes.get(6), findMes.get(7), findMes.get(8), findMes.get(9));
		}
	}

	public ResultMessage addLoadDocPO(LoadDocPO po) throws RemoteException {
		return addToSQL(loadDocTable, po.getID() , po.getType().name() , MyDate.toString(po.getDate()) , po.getState().name() , po.getYYID() , po.getLoadDocID(), po.getArriveCity() ,po.getCarID(), po.getSupervisor() , po.getEscort());
	}

	public SendGoodDocPO getSendGoodDocPO(String id) throws RemoteException {
		findMes = findFromSQL(sendGoodDocTable, id);
		if(findMes==null){
			return null;
		}else{
			return new SendGoodDocPO(findMes.get(0), DocType.valueOf(findMes.get(1)), MyDate.getDate(findMes.get(2)), DocState.valueOf(findMes.get(3)), findMes.get(4), findMes.get(5));
		}
	}

	public ResultMessage addSendGoodDocPO(SendGoodDocPO po)
			throws RemoteException {
		return addToSQL(sendGoodDocTable, po.getID() , po.getType().name() , MyDate.toString(po.getDate()) , po.getState().name() , po.getSendMan() , po.getOrderBarCode());
	}

	public TransferDocPO getTransferDocPO(String id) throws RemoteException {
		findMes = findFromSQL(transferDocTable, id);
		if(findMes==null){
			return null;
		}else{
			return new TransferDocPO(findMes.get(0), DocType.valueOf(findMes.get(1)), MyDate.getDate(findMes.get(2)), DocState.valueOf(findMes.get(3)), findMes.get(4), findMes.get(5) ,  Integer.parseInt(findMes.get(6)) , findMes.get(7) , helper.tranFromStringToArray(findMes.get(8)));
		}
	}

	public ResultMessage addTransferDocPO(TransferDocPO po)
			throws RemoteException {
		return addToSQL(transferDocTable, po.getID() , po.getType().name() , MyDate.toString(po.getDate()) , po.getState().name() , po.getTransferWayID() , po.getSendCity() , String.valueOf(po.getContainerNum()) , po.getLoadManName() , helper.tranFromArrayToString(po.getOrderBarCode()));
	}

	public ArriveZZDocPO getArriveZZDocPO(String id) throws RemoteException {
		findMes = findFromSQL(arriveZZDocTable, id);
		if(findMes==null){
			return null;
		}else{
			return new ArriveZZDocPO(findMes.get(0), DocType.valueOf(findMes.get(1)), MyDate.getDate(findMes.get(2)), DocState.valueOf(findMes.get(3)), findMes.get(4), findMes.get(5) , GoodsState.valueOf(findMes.get(6)) );
		}
	}

	public ResultMessage addArriveZZDocPO(ArriveZZDocPO po)
			throws RemoteException {
		return addToSQL(arriveZZDocTable, po.getID() , po.getType().name() , MyDate.toString(po.getDate()) , po.getState().name() , po.getZZID() , po.getSendCity() , po.getGoodState().name());
	}

	public ArriveYYDocPO getArriveYYDocPO(String id) throws RemoteException {
		findMes = findFromSQL(arriveYYDocTable, id);
		if(findMes==null){
			return null;
		}else{
			return new ArriveYYDocPO(findMes.get(0), DocType.valueOf(findMes.get(1)), MyDate.getDate(findMes.get(2)), DocState.valueOf(findMes.get(3)), findMes.get(4), findMes.get(5) , GoodsState.valueOf(findMes.get(6)) );
		}
	}

	public ResultMessage addArriveYYDocPO(ArriveYYDocPO po)
			throws RemoteException {
		
		return addToSQL(arriveYYDocTable, po.getID() , po.getType().name() , MyDate.toString(po.getDate()) , po.getState().name() , po.getZZID() , po.getSendCity() , po.getGoodState().name());
	}

	public ArrayList<? extends DocPO> getDocLists(DocType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage changeDocsState(ArrayList<String> docsID,
			DocType type, DocState state) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage changeOneDocState(String docID,
			DocType type, DocState state) {
		// TODO Auto-generated method stub
		return null;
	}

}
