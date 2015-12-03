package bl.accountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.account.AccountPO;
import test.java.other.VOPOchange;
import util.DataServiceType;
import util.ResultMessage;
import vo.account.AccountVO;
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
		accountData = (AccountDataService) RMIManage.getDataService(DataServiceType.AccountDataService);
//		try {
//			accountData.initial();
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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
		ResultMessage result = null;
		try {
			result = accountData.delete(vo.ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public AccountVO find(String ID) {
		AccountPO po = null;
		try {
			po = accountData.find(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(po!=null){
			AccountVO vo = (AccountVO) VOPOchange.POtoVO(po);
			return vo;
		}
		return null;
	}

	public ResultMessage modify(AccountVO vo) {
		AccountPO po = (AccountPO) VOPOchange.VOtoPO(vo);
		ResultMessage result = null;
		try {
			result = accountData.modify(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<AccountVO> show(){
		ArrayList<AccountVO> vos = null;
		try {
			ArrayList<AccountPO> pos = accountData.show();
			vos = new ArrayList<AccountVO>(pos.size());
			for (AccountPO accountPO : pos) {
				vos.add( (AccountVO)VOPOchange.POtoVO(accountPO));
			}
			
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return vos;
		
		
	}
	
	
}
