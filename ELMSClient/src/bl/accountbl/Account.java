package bl.accountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import po.account.AccountPO;
import util.ResultMessage;
import vo.account.AccountVO;
import ds.accountdataservice.AccountDataService;

/**
 * @author ymc
 * @version 创建时间：2015年10月27日 下午7:44:11
 *
 */
public class Account {

	private AccountDataService accountData;
	private ResultMessage result = null;

	public Account(AccountDataService accountDataService) {
		this.accountData = accountDataService;
	}

	public ResultMessage add(AccountVO vo) throws RemoteException {
		AccountPO po = null;
		result = null;

		po = (AccountPO) VOPOchange.VOtoPO(vo);
		result = accountData.add(po);
		
		return result;
	}

	public ResultMessage delete(String ID) throws RemoteException {
		result = null;
		result = accountData.delete(ID);
		return result;
	}

	public AccountVO find(String ID) throws RemoteException {
		AccountPO po = null;
		po = accountData.find(ID);
		if (po != null) {
			AccountVO vo = (AccountVO) VOPOchange.POtoVO(po);
			return vo;
		}
		return null;
	}

	public ResultMessage modify(AccountVO vo) throws RemoteException {
		AccountPO po = (AccountPO) VOPOchange.VOtoPO(vo);
		ResultMessage result = null;
		result = accountData.modify(po);
		return result;
	}

	public ArrayList<AccountVO> show() throws RemoteException {
		ArrayList<AccountVO> vos = null;
		ArrayList<AccountPO> pos = accountData.show();

		if (pos == null) {
			return null;
		}

		vos = new ArrayList<AccountVO>(pos.size());
		for (AccountPO accountPO : pos) {
			vos.add((AccountVO) VOPOchange.POtoVO(accountPO));
		}

		return vos;

	}

}
