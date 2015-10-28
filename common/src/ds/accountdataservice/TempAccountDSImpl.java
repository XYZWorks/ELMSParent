package ds.accountdataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.AccountPO;
import util.ResultMessage;
//import config.UserfulMethod;
 /** * @author czq @version 创建时间：2015年10月26日 下午1:04:26 * 简单说明 */
public class TempAccountDSImpl implements AccountDataService{

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
//		List<String> docs = UserfulMethod.getDocument("tempAccount.txt");
//		String[] temp;
//		for (String string : docs) {
//			temp = string.split(",");
//			if(ID.equalsIgnoreCase(temp[0]) && password.equalsIgnoreCase(temp[1])){
//				
//				return ResultMessage.SUCCESS;
//			}
//		}
//		
		return ResultMessage.FAIL;
	}

	public AccountPO getMes(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
