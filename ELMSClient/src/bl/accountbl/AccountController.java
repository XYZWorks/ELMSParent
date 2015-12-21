package bl.accountbl;

import java.util.ArrayList;

import net.RMIManage;
import ds.accountdataservice.AccountDataService;
import util.DataServiceType;
import util.ResultMessage;
import vo.account.AccountVO;
import blservice.accountblservice.Accountblservice;
 /** 
 * 
 * @author czq 
 * @version 2015年11月15日 上午9:15:28 
 */
public class AccountController implements Accountblservice{
	
	private Account account;
	private AccountDataService accountDataService ;
	public AccountController(){
		
		accountDataService = (AccountDataService) RMIManage.getDataService(DataServiceType.AccountDataService);
		account=new Account(accountDataService);
	}
	
	public ResultMessage add(AccountVO vo) {
		return account.add(vo);
	}

	public ResultMessage delete(String ID ){
		return account.delete(ID);
	}

	public AccountVO find(String ID) {
		return account.find(ID);
	}

	public ResultMessage modify(AccountVO vo) {
		return account.modify(vo);
	}

	public ArrayList<AccountVO> show() {
		return account.show();
	}

}
