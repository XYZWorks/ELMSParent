package blservice.financeblservice;

import java.util.ArrayList;

import util.CostType;
import util.ResultMessage;
import vo.finance.CostVO;
import vo.finance.FreightVO;
import vo.finance.RentVO;
import vo.finance.SalaryVO;

/**
 * 成本信息管理接口
 * @author ymc
 *
 */
public interface CostService {
	/**
	 * 查看cost信息
	 * @return
	 */
	public ArrayList<? extends CostVO> showCosts(CostType type);
	/**
	 * 增加cost信息
	 * @param vo
	 * @return
	 */
	public ResultMessage add(CostVO vo);
	/**
	 * 修改cost信息
	 * @param vo
	 * @return
	 */
	public ResultMessage modify(CostVO vo);
	/**
	 * 删除cost信息
	 * @param vo
	 * @return
	 */
	public ResultMessage del(CostVO vo);
	

}
