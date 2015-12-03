/**
 * 管理员账户管理逻辑接口
 * @author czq
 * @date 2015/10/20
 */
package blservice.accountblservice;

import java.util.ArrayList;

import util.ResultMessage;
import vo.account.AccountVO;

public interface Accountblservice {
	/**
	 * 增加账户
	 * @param vo  新账户信息
	 * @return 是否增加成功
	 */
	public ResultMessage add(AccountVO vo);
	/**
	 * 删除账户
	 * @param vo 该账户信息
	 * @return 是否删除成功
	 */
	public ResultMessage delete(AccountVO vo);
	/**
	 * 根据ID查找账户
	 * @param ID 用户ID
	 * @return 查找信息，若查找不到返回null
	 */
	public AccountVO find(String ID);
	/**
	 * 修改账户信息
	 * @param vo 账户信息
	 * @return 是否修改成功
	 */
	public ResultMessage modify(AccountVO vo);
	
	public ArrayList<AccountVO> show();
	
}
