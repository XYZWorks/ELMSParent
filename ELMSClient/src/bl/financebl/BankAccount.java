package bl.financebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.finance.BankAccountPO;
import test.java.other.VOPOchange;
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

	public ArrayList<BankAccountVO> getAccounts() throws RemoteException {
		ArrayList<BankAccountVO> vos = null;
			ArrayList<BankAccountPO> pos = dataService.getAccounts();
			if(pos == null){
				return null;
			}
			
			
			vos = new ArrayList<BankAccountVO>(pos.size());
			for (BankAccountPO accountPO : pos) {
				vos.add( (BankAccountVO)VOPOchange.POtoVO(accountPO));
			}
			
			
		return vos;
	}

	public ResultMessage modifyAccount(BankAccountVO vo) throws RemoteException {
		
			return dataService.modifyAccount((BankAccountPO) VOPOchange.VOtoPO(vo));
	}

	public ResultMessage deleteAccount(String ID) throws RemoteException {
			return dataService.deleteAccount(ID);
	}

	public ResultMessage addAccount(BankAccountVO vo) throws RemoteException {
			return dataService.addAccount((BankAccountPO) VOPOchange.VOtoPO(vo));
	}

	public ResultMessage checkAccount(String iD, int money)
			throws RemoteException {
		
			return dataService.checkAccount(iD , money);
	}
}
