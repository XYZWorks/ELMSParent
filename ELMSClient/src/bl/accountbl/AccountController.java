package bl.accountbl;

import java.rmi.Remote;
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
		} catch (Exception e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				try {
					return account.add(vo);
				} catch (Exception e1) {
				}
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage delete(String ID) {
		try {
			return account.delete(ID);
		} catch (Exception e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				try {
					return account.delete(ID);
				} catch (Exception e1) {
				}
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public AccountVO find(String ID) {
		try {
			return account.find(ID);
		} catch (Exception e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				try {
					return account.find(ID);
				} catch (Exception e1) {
				}
			}
		}
		return null;
	}

	@Override
	public ResultMessage modify(AccountVO vo) {
		try {
			return account.modify(vo);
		} catch (Exception e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				try {
					return account.modify(vo);
				} catch (Exception e1) {
				}
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<AccountVO> show() {
		try {
			return account.show();
		} catch (Exception e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				try {
					return account.show();
				} catch (Exception e1) {
				}
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
