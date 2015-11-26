package blservice.usermesblservice;

import util.ResultMessage;
import vo.account.AccountVO;

/**
 * 个人账户信息管理
 * @author czq
 * @date 2015/10/20
 */
public interface UserMesblservice {
	/**
	 * 登录接口
	 * @param vo
	 * @return 若成功返回对应的AccountVO，否则返回null
	 */
	public AccountVO login(AccountVO vo);
	
	/**
	 * 修改个人账户信息
	 * @param vo
	 * @return 是否修改成功
	 */
	public ResultMessage modify(AccountVO vo);
	
	/**
	 * 获得个人账户信息
	 * @return 
	 */
	public AccountVO getMes(String ID);
}
