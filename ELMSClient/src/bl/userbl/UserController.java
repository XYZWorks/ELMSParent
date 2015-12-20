package bl.userbl;

import java.rmi.server.RMIClassLoader;

import net.RMIManage;
import util.DataServiceType;
import util.ResultMessage;
import vo.account.AccountVO;
import blservice.usermesblservice.UserMesblservice;
import ds.accountdataservice.AccountDataService;
 /** 
 * 
 * @author czq 
 * @version 2015年11月15日 上午9:27:39 
 */
public class UserController implements UserMesblservice{
	private AccountDataService accountds = (AccountDataService) RMIManage.getDataService(DataServiceType.AccountDataService);
	private UserMes userMes ;
	
	public UserController() {
		userMes = new UserMes(accountds);
	}
	public AccountVO login(AccountVO vo) {
		return userMes.login(vo);
	}

	public ResultMessage modify(AccountVO vo) {
		return userMes.modify(vo);
	}



	public AccountVO getMes(String ID) {
		return userMes.getMes(ID);
	}

}
