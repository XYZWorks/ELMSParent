package bl.statisticbl;

import java.util.ArrayList;

import blservice.statisticblservice.Statisticblservice;
import ds.financedataservice.FinanceDataService;
import ds.statisticdataservice.StatisticDataService;
import util.ResultMessage;
import vo.BillVO;
import vo.CostIncomeVO;
import vo.StateFormVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:49:05 
 *
 */
public class Statistic {
	StatisticDataService statisticData;
	FinanceDataService financeData;
	public ResultMessage bulidStateForm(StateFormVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage bulidCostIncomeForm(CostIncomeVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<StateFormVO> getStateForm() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<CostIncomeVO> getIncomeForm() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage bulidBill(BillVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<BillVO> getBills() {
		// TODO Auto-generated method stub
		return null;
	}

}
