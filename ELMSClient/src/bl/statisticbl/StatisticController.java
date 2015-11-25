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
	
	Statistic sta;
	
	public StatisticController(){
		sta = new Statistic();
	}
	public ResultMessage bulidStateForm(StateFormVO vo) {
		return sta.bulidStateForm(vo);
	}

	public ResultMessage bulidCostIncomeForm(CostIncomeVO vo) {
		return sta.bulidCostIncomeForm(vo);
	}

	public ArrayList<StateFormVO> getStateForm() {
		return sta.getStateForm();
	}

	public ArrayList<CostIncomeVO> getIncomeForm() {
		return sta.getIncomeForm();
	}

	public ResultMessage bulidBill(BillVO vo) {
		return sta.bulidBill(vo);
	}

	public ArrayList<BillVO> getBills() {
		return sta.getBills();
	}

}
