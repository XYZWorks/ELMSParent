package bl.accountbl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import net.RMIServiceFactory;
import util.DataServiceType;
import util.ResultMessage;
import vo.account.AccountVO;
import bl.BusinessController;
import blservice.accountblservice.Accountblservice;
import ds.accountdataservice.AccountDataService;
import exception.ExceptionHandler;

/**
 * 
 * @author czq
 * @version 2015年11月15日 上午9:15:28
 */
public class AccountController extends BusinessController implements
		Accountblservice {

	private Account account;
	private AccountDataService accountDataService;

	public AccountController() {
		myType = DataServiceType.AccountDataService;
		accountDataService = RMIServiceFactory.accountDataService;
		account = new Account(accountDataService);
	}

	@Override
	public ResultMessage add(AccountVO vo) {
		try {
			return account.add(vo);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return add(vo);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage delete(String ID) {
		try {
			return account.delete(ID);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return delete(ID);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public AccountVO find(String ID) {
		try {
			return account.find(ID);
		} catch (RemoteException  e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return find(ID);
			}
		}
		return null;
	}

	@Override
	public ResultMessage modify(AccountVO vo) {
		try {
			return account.modify(vo);
		} catch (RemoteException  e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return modify(vo);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<AccountVO> show() {
		try {
			return account.show();
		} catch (RemoteException  e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return show();
			}
		}
		return null;
	}

	@Override
	public void reinitDataService(Remote dataService) {
		accountDataService = (AccountDataService) dataService;
		account = new Account(accountDataService);

	}

}
