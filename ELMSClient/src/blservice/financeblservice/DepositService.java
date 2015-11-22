/**
 * 收款信息逻辑接口
 * @author ymc
 * 
 */
package blservice.financeblservice;

import vo.*;
import vo.finance.DepositVO;

import java.util.ArrayList;

import util.ResultMessage;

public interface DepositService {
	/**
	 * 创建收款信息
	 * @param vo
	 * @return 操作结果
	 */
	public ResultMessage createDeposit(DepositVO vo);
	/**
	 * 查看收款信息
	 * @return 查看的Deposit的ArrayList
	 */
	public ArrayList< DepositVO > showDeposit(); 
}
