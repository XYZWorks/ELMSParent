package bl.strategybl;

import java.util.ArrayList;

import net.RMIManage;
import ds.strategydataservice.StrategyDataService;
import util.DataServiceType;
import util.ResultMessage;
import util.StaffType;
import vo.strategy.ConstVO;
import vo.strategy.EstiDateVO;
import vo.strategy.SalaryWayVO;
import blservice.strategyblservice.StrategyblService;
 /** 
 * 
 * @author czq 
 * @version 2015年11月15日 上午9:26:46 
 */
public class StrategyController implements StrategyblService{
	
	private Strategy strategy ;
	private StrategyDataService strategyData ;
	public StrategyController() {
		strategyData = (StrategyDataService) RMIManage.getDataService(DataServiceType.StrategyDataService);
		strategy = new Strategy(strategyData);
	}
	
	@Override
	public ConstVO getConst() {

		return strategy.getConst();
	}

	@Override
	public ResultMessage setConst(ConstVO vo) {
		return strategy.setConst(vo);
	}

	@Override
	public ArrayList<SalaryWayVO> getsalary() {
		return strategy.getsalary();
	}

	@Override
	public SalaryWayVO getOneSalary(StaffType type) {
		return strategy.getOneSalary(type);
	}

	@Override
	public ResultMessage setSalary(SalaryWayVO way) {
		return strategy.setSalary(way);
	}

	@Override
	public EstiDateVO getEstiDateVO() {	
		return strategy.getEstiDateVO();
	}

	@Override
	public ResultMessage setEstiDateVO(EstiDateVO vo) {
		return strategy.setEstiDateVO(vo);
	}

}
