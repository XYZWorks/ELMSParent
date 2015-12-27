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
	/**
	 * 获得所有银行账户
	 * @return
	 */
	public ArrayList<BankAccountVO> getAccounts();
	/**
	 * 修改银行账户信息
	 * @param vo
	 * @return
	 */
	public ResultMessage modifyAccount(BankAccountVO vo);
	/**
	 * 删除账户
	 * @param ID
	 * @return
	 */
	public ResultMessage deleteAccount(String ID);
	/**
	 * 增加账户
	 * @param vo
	 * @return
	 */
	public ResultMessage addAccount(BankAccountVO vo);
	/**
	 * 检查账户是否存在，且余额是否充足
	 * @param ID
	 * @param money 要付款的钱
	 * @return
	 */
	public ResultMessage checkAccount(String ID, int money);
	
}
