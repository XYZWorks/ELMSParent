package blservice.financeblservice;

import java.util.ArrayList;

import util.ResultMessage;
import vo.finance.BankAccountVO;

/** 
 * 银行账户管理接口
 * @author ymc 
 * @version 创建时间：2015年11月1日 下午8:31:19 
 *
 */
public interface BankAccountBusinessService {
	
	public ArrayList<BankAccountVO> getAccounts();
	
	public ResultMessage modifyAccount(BankAccountVO vo);
	
	public ResultMessage deleteAccount(String ID);
	
	public ResultMessage addAccount(BankAccountVO vo);
	
	
}
