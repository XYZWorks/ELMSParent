package data.storedata;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import po.store.InStoreDocPO;
import po.store.OutStoreDocPO;
import po.store.StoreCheckPO;
import po.store.StoreMessagePO;
import util.City;
import util.DocState;
import util.DocType;
import util.MyDate;
import util.ResultMessage;
import util.TransferWay;
import dataSuper.DataSuperClass;
import ds.storedataservice.StoreDataService;
 /** 
 * 
 * @author czq 
 * @version 2015年11月5日 下午10:00:00 
 */
public class StoreDataImpl extends DataSuperClass implements StoreDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String instoreDocTable = "InStoreDoc";
	
	private static final String outstoreDocTable = "OutStoreDoc";
	
	private static final String storeCheckTable = "StoreCheck";
	
	private static final String storeMessage = "StoreMessage";
	
	private static final String alarmTable = "alarm";
	

	public StoreDataImpl() throws RemoteException {}
	
	
	
	public void initial() throws RemoteException {
		initialFromSQL(instoreDocTable);
		initialFromSQL(outstoreDocTable);
		initialFromSQL(storeCheckTable);
		initialFromSQL(alarmTable);
		//初始化警戒值，否则设置会找不到该值
		addToSQL(alarmTable, City.NANJING.name() , "0");
		addToSQL(alarmTable, City.BEIJING.name() , "0");
		addToSQL(alarmTable, City.GUANGZHOU.name() , "0");
		addToSQL(alarmTable, City.SHANGHAI.name() , "0");
	}
 
	public StoreMessagePO getStoreMessage() throws RemoteException {
		Object ob = helper.readFromSerFile(storeMessage);
		if(ob == null){
			return null;
		}else{
			return (StoreMessagePO) ob;
		}
	}

	public ResultMessage addIn(InStoreDocPO po) throws RemoteException {
		
		return addToSQL(instoreDocTable, po.getID() , po.getType().name() , MyDate.toString(po.getDate()) , po.getState().name() , helper.tranFromArrayToString(po.getOrders()) , po.getLoc().name() , helper.tranFromArrayToString(po.getLocation()));
	}

	public ResultMessage addOut(OutStoreDocPO po) throws RemoteException {
		return addToSQL(outstoreDocTable, po.getID() , po.getType().name() , MyDate.toString(po.getDate()) , po.getState().name() , helper.tranFromArrayToString(po.getOrderPOs()) , po.getLoc().name() , po.getTransferDoc() , po.getShipWay().name());
		 
	}
	public ArrayList<InStoreDocPO> getIn() throws RemoteException {
		ArrayList<InStoreDocPO> pos = new ArrayList<InStoreDocPO>(40);
		try {
			sql = "SELECT * FROM " + instoreDocTable;
			preState =conn.prepareStatement(sql);
			result = preState.executeQuery();
			while(result.next()){
				pos.add(new InStoreDocPO(result.getString(1), DocType.valueOf(result.getString(2)) ,MyDate.getDate(result.getString(3)),DocState.valueOf(result.getString(4)) ,  helper.tranFromStringToArrayList(result.getString(5)) ,City.valueOf(result.getString(6)) , helper.tranFromStringToArrayList(result.getString(7)))) ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pos.isEmpty() ? null : pos;
	}

	public ArrayList<OutStoreDocPO> getOut() {
		ArrayList<OutStoreDocPO> pos = new ArrayList<OutStoreDocPO>(40);
		try {
			sql = "SELECT * FROM " + outstoreDocTable;
			preState =conn.prepareStatement(sql);
			result = preState.executeQuery();
			while(result.next()){
				pos.add(new OutStoreDocPO(result.getString(1), DocType.valueOf(result.getString(2)) ,MyDate.getDate(result.getString(3)),DocState.valueOf(result.getString(4)), helper.tranFromStringToArrayList(result.getString(5)), City.valueOf(result.getString(6)), result.getString(7) ,TransferWay.valueOf(result.getString(8))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pos.isEmpty() ? null : pos;
	}

	public ResultMessage update(StoreMessagePO po) {
		if(helper.writeToSerFile(po, storeMessage , true)){
			return ResultMessage.SUCCESS;
		}else{
			return ResultMessage.FAIL;
		}
	}


	public ResultMessage storeCheck(StoreCheckPO po) {
		String[] instores = new String[po.getPo().getInStoreDocs().size()];
		String[] outstores = new String[po.getPo().getOutStoreDocs().size()];
		StoreMessagePO storepo = po.getPo();
		for (int i = 0; i < instores.length; i++) {
			instores[i] = storepo.getInStoreDocs().get(i).getID();
		}
		for (int i = 0; i < outstores.length; i++) {
			outstores[i] = storepo.getOutStoreDocs().get(i).getID();
		}
		
		return addToSQL(storeCheckTable, MyDate.toString(po.getTime()) , po.getPo().getLocation().name() , po.getPo().getStoreLoc() , String.valueOf(po.getPo().getNumber()) , helper.tranFromArrayToString(instores) , helper.tranFromArrayToString(outstores));
	}

	public ArrayList<StoreCheckPO> getCheck() {
		ArrayList<StoreCheckPO> pos = new ArrayList<StoreCheckPO>(10);
		try {
			sql = "SELECT *　FROM " + storeCheckTable;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while(result.next()){
				pos.add(new StoreCheckPO(MyDate.getDate(result.getString(1)), new StoreMessagePO(City.valueOf(result.getString(2)), result.getString(3), Integer.parseInt(result.getString(4)), getInstoreDocs(helper.tranFromStringToArray(result.getString(5))), getOutstoreDocs(helper.tranFromStringToArray(result.getString(6))))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return pos.isEmpty()?null:pos;
	}



	public String getAlarmValue(City city) throws RemoteException {
		
		return findFromSQL(alarmTable, city.name()).get(1);
	}
	
	public ResultMessage setAlarmValue(String value, City city)
			throws RemoteException {
		
		return modifyFromSQL(alarmTable, city.name() , value);
	}
	
	private ArrayList<InStoreDocPO> getInstoreDocs(String[] instores){
		ArrayList<InStoreDocPO> pos = new ArrayList<InStoreDocPO>(instores.length);
		for (int i = 0; i < instores.length; i++) {
			findMes = findFromSQL(instoreDocTable, instores[i]);
			if(findMes!= null){
				pos.add(new InStoreDocPO(findMes.get(0), DocType.valueOf(findMes.get(1)) ,MyDate.getDate(findMes.get(2)),DocState.valueOf(findMes.get(3)) ,  helper.tranFromStringToArrayList(findMes.get(4)) ,City.valueOf(findMes.get(5)) , helper.tranFromStringToArrayList(findMes.get(6)))) ;
			}
		}
		return pos;
		
	}
	
	private ArrayList<OutStoreDocPO> getOutstoreDocs(String[] outstores){
		ArrayList<OutStoreDocPO> pos = new ArrayList<OutStoreDocPO>(outstores.length);
		for (int i = 0; i < outstores.length; i++) {
			findMes = findFromSQL(outstoreDocTable, outstores[i]);
			if(findMes!= null){
				pos.add(new OutStoreDocPO(findMes.get(0), DocType.valueOf(findMes.get(1)) ,MyDate.getDate(findMes.get(2)),DocState.valueOf(findMes.get(3)), helper.tranFromStringToArrayList(findMes.get(4)), City.valueOf(findMes.get(5)), findMes.get(6) ,TransferWay.valueOf(findMes.get(7))));
				
			}
		}
		return pos;
	}

	



	

}
