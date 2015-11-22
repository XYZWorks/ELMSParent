package bl.userbl;

import java.rmi.RemoteException;

import ds.accountdataservice.AccountDataService;
import util.ResultMessage;
import vo.account.AccountVO;

/**
 * 
 * @author czq
 *
 */

public class UserMes {
	AccountDataService accountds;

	public ResultMessage login(AccountVO vo) {
		try {
			return accountds.check(vo.ID, vo.password);

		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}

	}

	public ResultMessage modify(AccountVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public AccountVO getMes() {
		// TODO Auto-generated method stub
		return null;
	}

}
