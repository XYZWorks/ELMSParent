package bl.accountbl;

import java.rmi.RemoteException;

import blservice.accountblservice.Accountblservice;
import ds.accountdataservice.AccountDataService;
import po.AccountPO;
import util.ResultMessage;
import vo.AccountVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:44:11 
 *
 */
public class AccountblImpl implements Accountblservice {
	AccountDataService accountData;
	public ResultMessage add(AccountVO vo) {
		AccountPO po;
		ResultMessage result = null;
		if(vo.phoneNum==null||vo.mail==null){
			po=new AccountPO(vo.ID, vo.name, vo.type, vo.password);
		}
		else{
			po=new AccountPO(vo.ID, vo.name, vo.type, vo.password, vo.phoneNum, vo.mail);
		}
		try {
			result=accountData.add(po);
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		return result;
	}

	public ResultMessage delete(AccountVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public AccountVO find(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage modify(AccountVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
