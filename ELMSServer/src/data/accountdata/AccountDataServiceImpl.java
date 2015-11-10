package data.accountdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.AccountPO;
import util.ResultMessage;
//import data.dataioutility.DataIOUtility;
import ds.accountdataservice.AccountDataService;
 /** * @author czq @version 创建时间：2015年10月27日 下午11:08:02 * 简单说明 */
public class AccountDataServiceImpl extends UnicastRemoteObject implements AccountDataService {
	
	private String path = "account";

//	private DataIOUtility d;

	public AccountDataServiceImpl() throws RemoteException {
		super();
//		d = new DataIOUtility(path);
	}
	
	
	
	public ResultMessage add(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	

	public ResultMessage initial() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public AccountPO find(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage delete(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage modify(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage check(String ID, String password)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public AccountPO getMes(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
