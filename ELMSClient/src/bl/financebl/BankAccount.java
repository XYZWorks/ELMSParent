package bl.financebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import net.RMIManage;
import po.finance.BankAccountPO;
import test.java.other.VOPOchange;
import util.DataServiceType;
import util.ResultMessage;
import vo.finance.BankAccountVO;
import ds.financedataservice.FinanceDataService;
 /** 
 * 
 * @author czq 
 * @version 2015年12月7日 上午10:59:43 
 */
public class BankAccount {
	
	FinanceDataService dataService ;
	
	public BankAccount(FinanceDataService financeDataService) {
		this.dataService = financeDataService;
	}

	public ArrayList<BankAccountVO> getAccounts() {
		ArrayList<BankAccountVO> vos = null;
		try {
			ArrayList<BankAccountPO> pos = dataService.getAccounts();
			if(pos == null){
				return null;
			}
			
			
			vos = new ArrayList<BankAccountVO>(pos.size());
			for (BankAccountPO accountPO : pos) {
				vos.add( (BankAccountVO)VOPOchange.POtoVO(accountPO));
			}
			
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vos;
	}

	public ResultMessage modifyAccount(BankAccountVO vo) {
		
		try {
			return dataService.modifyAccount((BankAccountPO) VOPOchange.VOtoPO(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	public ResultMessage deleteAccount(String ID) {
		try {
			return dataService.deleteAccount(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	public ResultMessage addAccount(BankAccountVO vo) {
		try {
			return dataService.addAccount((BankAccountPO) VOPOchange.VOtoPO(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}
}
