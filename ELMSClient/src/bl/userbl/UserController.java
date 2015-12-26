package bl.userbl;

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
	private AccountDataService accountds;
	private UserMes userMes ;
	
	public UserController() {
		accountds = (AccountDataService) RMIManage.getDataService(DataServiceType.AccountDataService);

		userMes = new UserMes(accountds);
	}
	@Override
	public AccountVO login(AccountVO vo) {
		return userMes.login(vo);
	}

	@Override
	public ResultMessage modify(AccountVO vo) {
		return userMes.modify(vo);
	}



	@Override
	public AccountVO getMes(String ID) {
		return userMes.getMes(ID);
	}

}
