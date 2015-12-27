package blservice.strategyblservice;

import java.util.ArrayList;

import util.ResultMessage;
import util.StaffType;
import vo.strategy.ConstVO;
import vo.strategy.EstiDateVO;
import vo.strategy.SalaryWayVO;

/**
 * 薪水策略、常量的逻辑接口
 * @author czq
 *
 */
public interface StrategyblService {
	/**
	 * 获得所有常量
	 * @return
	 */
	public ConstVO getConst();
	/**
	 * 设置常量
	 * @param vo
	 * @return
	 */
	public ResultMessage setConst(ConstVO vo);
	/**
	 * 返回所有薪水策略
	 * @return
	 */
	public ArrayList<SalaryWayVO> getsalary();
	/**
	 * 获得某一职员的薪水策略
	 * @return
	 */
	public SalaryWayVO getOneSalary(StaffType type);
	/**
	 * 设置某一职员的薪水策略
	 * @param way
	 * @return
	 */
	public ResultMessage setSalary(SalaryWayVO way);
	/**
	 * 得到预计时间
	 * @return
	 */
	public EstiDateVO getEstiDateVO();
	/**
	 * 设置预计时间
	 * @return
	 */
	public ResultMessage setEstiDateVO(EstiDateVO vo);
}
