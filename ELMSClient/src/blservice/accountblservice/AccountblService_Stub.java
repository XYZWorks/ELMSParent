package blservice.accountblservice;

import util.AccountType;
import util.ResultMessage;
import vo.AccountVO;
 /** * @author czq @version 创建时间：2015年10月25日 上午9:40:39 * 简单说明 */
public class AccountblService_Stub implements Accountblservice{
	
	public ResultMessage add(AccountVO vo) {
		return ResultMessage.SUCCESS;
	}

	public ResultMessage delete(AccountVO vo) {
		return ResultMessage.SUCCESS;
	}

	public AccountVO find(String ID) {
		return new AccountVO(ID, "盛大", AccountType.financeman, "123456");
	}

	public ResultMessage modify(AccountVO vo) {
		
		return ResultMessage.SUCCESS;
	}

	

}
