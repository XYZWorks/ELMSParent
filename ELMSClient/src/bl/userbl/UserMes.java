package bl.userbl;

import java.rmi.RemoteException;

import po.account.AccountPO;
import test.java.other.VOPOchange;
import util.ResultMessage;
import vo.account.AccountVO;
import ds.accountdataservice.AccountDataService;

/**
 * 
 * @author czq
 *
 */

public class UserMes {
	AccountDataService accountds;
	
	public UserMes(AccountDataService accountDataService) {
		this.accountds = accountDataService;
	}
	
	public AccountVO login(AccountVO vo) {
		try {
			AccountPO temp = accountds.check(vo.ID, vo.password);
			if(temp == null){
				return null;
			}else{
				return (AccountVO)VOPOchange.POtoVO(temp);
			}
			
			
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}

	}

	public ResultMessage modify(AccountVO vo) {
		
		AccountPO po = (AccountPO) VOPOchange.VOtoPO(vo);
		ResultMessage re = null;
		try {
			re =  accountds.modify(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			
		}
		return re;
	}

	public AccountVO getMes(String ID) {
		AccountVO vo = null ;
		AccountPO po = null;
		try {
			po = accountds.getMes(ID);
			if( po == null){
				return null;
			}
			vo = (AccountVO) VOPOchange.POtoVO(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vo;
	}

}
