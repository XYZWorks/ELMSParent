package bl.userbl;

import java.rmi.RemoteException;

import net.RMIManage;
import ds.accountdataservice.AccountDataService;
import po.account.AccountPO;
import test.java.other.VOPOchange;
import util.AccountType;
import util.DataServiceType;
import util.ResultMessage;
import vo.account.AccountVO;

/**
 * 
 * @author czq
 *
 */

public class UserMes {
	AccountDataService accountds;
	
	public UserMes() {
		accountds = (AccountDataService)RMIManage.getDataService(DataServiceType.AccountDataService);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return re;
	}

	public AccountVO getMes(String ID) {
		AccountVO vo = null ;
		AccountPO po = null;
		try {
			po = accountds.getMes(ID);
			
			vo = (AccountVO) VOPOchange.POtoVO(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

}
