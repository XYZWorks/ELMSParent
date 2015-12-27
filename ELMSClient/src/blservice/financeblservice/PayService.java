package blservice.financeblservice;

import java.util.ArrayList;

import util.ResultMessage;
import vo.finance.PayVO;

/**
 * 付款信息
 * @author ymc
 *
 */
public interface PayService {
	/**
	 * 创建付款信息
	 * @param vo
	 * @return 操作结果
	 */
	public ResultMessage create(PayVO vo);
	
	/**
	 * 查看付款信息
	 * @return 查看的pay的ArrayList
	 */
	public ArrayList< PayVO > showPays(); 
}
