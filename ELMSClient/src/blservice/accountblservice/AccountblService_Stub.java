package blservice.accountblservice;

import java.util.ArrayList;

import util.AccountType;
import util.ResultMessage;
import vo.account.AccountVO;
 /** * @author czq @version 创建时间：2015年10月25日 上午9:40:39 * 简单说明 */
public class AccountblService_Stub implements Accountblservice{
	
	@Override
	public ResultMessage add(AccountVO vo) {
		return ResultMessage.SUCCESS;
	}

	public ResultMessage delete(AccountVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public AccountVO find(String ID) {
		return new AccountVO(ID, "盛大", AccountType.financeman, "123456");
	}

	@Override
	public ResultMessage modify(AccountVO vo) {
		
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<AccountVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
