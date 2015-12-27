package bl.userbl;

import java.rmi.Remote;

import net.RMIManage;
import util.DataServiceType;
import util.ResultMessage;
import vo.account.AccountVO;
import bl.BusinessController;
import blservice.usermesblservice.UserMesblservice;
import ds.accountdataservice.AccountDataService;
import exception.ExceptionHandler;

/**
 * 
 * @author czq
 * @version 2015年11月15日 上午9:27:39
 */
public class UserController extends BusinessController implements
		UserMesblservice {
	private AccountDataService accountds;
	private UserMes userMes;

	public UserController() {
		myType = DataServiceType.AccountDataService;
		accountds = (AccountDataService) RMIManage
				.getDataService(DataServiceType.AccountDataService);

		userMes = new UserMes(accountds);
	}

	@Override
	public AccountVO login(AccountVO vo) {
		try {
			return userMes.login(vo);
		} catch (Exception e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return login(vo);
			}
		}
		return null;
	}

	@Override
	public ResultMessage modify(AccountVO vo) {
		try {
			return userMes.modify(vo);
		} catch (Exception e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return modify(vo);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public AccountVO getMes(String ID) {
		try {
			return userMes.getMes(ID);
		} catch (Exception e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return getMes(ID);
			}
		}
		return null;
	}

	@Override
	public void reinitDataService(Remote dataService) {
		accountds = (AccountDataService) dataService;
		userMes = new UserMes(accountds);

	}

}
