package data.storedata;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.InStoreDocPO;
import po.OutStoreDocPO;
import po.StoreCheckPO;
import po.StoreMessagePO;
import util.ResultMessage;
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
	
	private final String instoreDocTable = "InStoreDoc";
	
	private final String outstoreDocTable = "OutStoreDoc";
	

	public StoreDataImpl() throws RemoteException {}
	
	
	
	public void initial() throws RemoteException {
		initialFromSQL(instoreDocTable);
		initialFromSQL(outstoreDocTable);
		initialFromSQL(storeCheckTable);
	}

	public StoreMessagePO getStoreMessage() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addIn(InStoreDocPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addOut(OutStoreDocPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<InStoreDocPO> getIn() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OutStoreDocPO> getOut() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage update(StoreMessagePO po) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean alarmValue(String value) {
		// TODO Auto-generated method stub
		return false;
	}

	public ResultMessage storeCheck(StoreCheckPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<StoreCheckPO> getCheck() {
		// TODO Auto-generated method stub
		return null;
	}

}
