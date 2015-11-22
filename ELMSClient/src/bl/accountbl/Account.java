package bl.accountbl;

import java.rmi.RemoteException;

import po.AccountPO;
import test.java.other.VOPOchange;
import util.DataServiceType;
import util.ResultMessage;
import vo.AccountVO;
import ds.accountdataservice.AccountDataService;
import net.RMIManage;

/**
 * @author ymc
 * @version 创建时间：2015年10月27日 下午7:44:11
 *
 */
public class Account {

	AccountDataService accountData;


	public Account() {
		accountData = (AccountDataService) new RMIManage().getDataService(DataServiceType.AccountDataService);
		try {
			accountData.initial();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultMessage add(AccountVO vo) {
		AccountPO po = null;
		ResultMessage result = null;
		
		po = (AccountPO) VOPOchange.VOtoPO(vo);
		
		try {
			result = accountData.add(po);
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
		AccountPO po = null;
		try {
			po = accountData.find(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AccountVO vo = (AccountVO) VOPOchange.POtoVO(po);
		return vo;
	}

	public ResultMessage modify(AccountVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
