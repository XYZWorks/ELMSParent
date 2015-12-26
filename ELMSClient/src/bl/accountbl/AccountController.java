package bl.accountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import net.RMIServiceFactory;
import util.DataServiceType;
import util.ResultMessage;
import vo.account.AccountVO;
import blservice.accountblservice.Accountblservice;
import ds.accountdataservice.AccountDataService;
import exception.ExceptionHandler;
 /** 
 * 
 * @author czq 
 * @version 2015年11月15日 上午9:15:28 
 */
public class AccountController implements Accountblservice{
	
	private Account account;
	private AccountDataService accountDataService ;
	public AccountController(){
		
		accountDataService = RMIServiceFactory.accountDataService;
		account=new Account(accountDataService);
	}
	
	@Override
	public ResultMessage add(AccountVO vo) {
		try {
			return account.add(vo);
		} catch (Exception e) {
			account = new Account((AccountDataService) ExceptionHandler.myExceptionHandler(DataServiceType.AccountDataService));
			if(account != null){
				try {
					return account.add(vo);
				} catch (RemoteException e1) {
				}
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage delete(String ID ){
		try {
			return account.delete(ID);
		} catch (Exception e) {
			account = new Account((AccountDataService) ExceptionHandler.myExceptionHandler(DataServiceType.AccountDataService));
			try {
				return account.delete(ID);
			} catch (RemoteException e1) {
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public AccountVO find(String ID) {
		try {
			return account.find(ID);
		} catch (RemoteException e) {
			account = new Account((AccountDataService) ExceptionHandler.myExceptionHandler(DataServiceType.AccountDataService));
			try {
				return account.find(ID);
			} catch (RemoteException e1) {
			}
		}
		return null;
	}

	@Override
	public ResultMessage modify(AccountVO vo) {
		try {
			return account.modify(vo);
		} catch (RemoteException e) {
			account = new Account((AccountDataService) ExceptionHandler.myExceptionHandler(DataServiceType.AccountDataService));
			try {
				return account.modify(vo);
			} catch (RemoteException e1) {
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<AccountVO> show() {
		try {
			return account.show();
		} catch (RemoteException e) {
			account = new Account((AccountDataService) ExceptionHandler.myExceptionHandler(DataServiceType.AccountDataService));
			try {
				return account.show();
			} catch (RemoteException e1) {
			}
		}
		return null;
	}

}
