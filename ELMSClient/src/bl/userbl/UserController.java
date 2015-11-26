package bl.userbl;

import util.AccountType;
import util.ResultMessage;
import vo.account.AccountVO;
import blservice.usermesblservice.UserMesblservice;
 /** 
 * 
 * @author czq 
 * @version 2015年11月15日 上午9:27:39 
 */
public class UserController implements UserMesblservice{
	
	UserMes userMes ;
	
	public UserController() {
		userMes = new UserMes();
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
