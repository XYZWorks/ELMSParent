package blservice.usermesblservice;

import util.AccountType;
import util.ResultMessage;
import vo.account.AccountVO;
 /** * @author czq @version 创建时间：2015年10月25日 下午4:26:34 * 简单说明 */
public class UserMesblservice_Stub implements UserMesblservice {
	
//	public ResultMessage login(AccountVO vo) {
//		
//		
//		return ResultMessage.SUCCESS;
//	}

	@Override
	public ResultMessage modify(AccountVO vo) {
		return ResultMessage.SUCCESS;
	}


	@Override
	public AccountVO getMes(String ID) {
		return new AccountVO("123456", "czq", AccountType.financeman, "123456", "13183822344", "1300236145@qq.com");

	}


	@Override
	public AccountVO login(AccountVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
