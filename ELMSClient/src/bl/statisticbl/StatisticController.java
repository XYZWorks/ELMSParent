package bl.statisticbl;

import java.util.ArrayList;

import util.ResultMessage;
import vo.statistic.BillVO;
import vo.statistic.CostIncomeVO;
import vo.statistic.StateFormVO;
import blservice.statisticblservice.Statisticblservice;
 /** 
 * 
 * @author czq 
 * @version 2015年11月15日 上午9:24:59 
 */
public class StatisticController implements Statisticblservice{
	
	Statistic statistic;
	
	public StatisticController(){
		statistic = new Statistic();
	}
	public ResultMessage bulidStateForm(StateFormVO vo) {
		return statistic.bulidStateForm(vo);
	}

	public ResultMessage bulidCostIncomeForm(CostIncomeVO vo) {
		return statistic.bulidCostIncomeForm(vo);
	}

	public ArrayList<StateFormVO> getStateForm() {
		return statistic.getStateForm();
	}

	public ArrayList<CostIncomeVO> getIncomeForm() {
		return statistic.getIncomeForm();
	}

	public ResultMessage bulidBill(BillVO vo) {
		return statistic.bulidBill(vo);
	}

	public ArrayList<BillVO> getBills() {
		return statistic.getBills();
	}

}
