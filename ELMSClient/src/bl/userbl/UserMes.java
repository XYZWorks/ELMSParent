package bl.userbl;

import java.rmi.RemoteException;

import bl.VOPOchange;
import po.account.AccountPO;
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

	public AccountVO login(AccountVO vo) throws RemoteException {
		AccountPO temp = accountds.check(vo.ID, vo.password);
		if (temp == null) {
			return null;
		} else {
			return (AccountVO) VOPOchange.POtoVO(temp);
		}

	}

	public ResultMessage modify(AccountVO vo) throws RemoteException {

		AccountPO po = (AccountPO) VOPOchange.VOtoPO(vo);
		return accountds.modify(po);
	}

	public AccountVO getMes(String ID) throws RemoteException {
		AccountVO vo = null;
		AccountPO po = null;
		po = accountds.getMes(ID);
		if (po == null) {
			return null;
		}
		vo = (AccountVO) VOPOchange.POtoVO(po);
		return vo;
	}

}
