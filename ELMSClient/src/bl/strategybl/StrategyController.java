package bl.strategybl;

import java.util.ArrayList;

import util.ResultMessage;
import util.StaffType;
import vo.strategy.ConstVO;
import vo.strategy.SalaryWayVO;
import blservice.strategyblservice.StrategyblService;
 /** 
 * 
 * @author czq 
 * @version 2015年11月15日 上午9:26:46 
 */
public class StrategyController implements StrategyblService{
	
	Strategy strategy ;
	
	public StrategyController() {
		strategy = new Strategy();
	}
	
	public ConstVO getConst() {

		return strategy.getConst();
	}

	public ResultMessage setConst(ConstVO vo) {
		return strategy.setConst(vo);
	}

	public ArrayList<SalaryWayVO> getsalary() {
		return strategy.getsalary();
	}

	public SalaryWayVO getOneSalary(StaffType type) {
		return strategy.getOneSalary(type);
	}

	public ResultMessage setSalary(SalaryWayVO way) {
		return strategy.setSalary(way);
	}

}
