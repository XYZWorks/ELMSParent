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

	private AccountDataService accountData;
	private ResultMessage result = null;
	public Account(AccountDataService accountDataService) {
		this.accountData = accountDataService;

	}

	public ResultMessage add(AccountVO vo) {
		AccountPO po = null;
		result = null;
		
		po = (AccountPO) VOPOchange.VOtoPO(vo);
		
		try {
			result = accountData.add(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ResultMessage delete(String ID ) {
		result = null;
		try {
			result = accountData.delete(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public AccountVO find(String ID) {
		AccountPO po = null;
		try {
			po = accountData.find(ID);
		} catch (RemoteException e) {
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
