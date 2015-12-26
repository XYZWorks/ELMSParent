package blservice.statisticblservice;

import java.util.ArrayList;

import util.ResultMessage;
import vo.statistic.BillVO;
import vo.statistic.CostIncomeVO;
import vo.statistic.StateFormVO;
 /** * @author czq @version 创建时间：2015年10月26日 上午12:15:05 * 简单说明 */
public class StatisticblService_Stub implements Statisticblservice{

	@Override
	public ResultMessage bulidStateForm(StateFormVO vo) {
		
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage bulidCostIncomeForm(CostIncomeVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<StateFormVO> getStateForm() {
		ArrayList<StateFormVO> stateForms = new ArrayList<StateFormVO>();
		stateForms.add(new StateFormVO(null, null, null, null));
		stateForms.add(new StateFormVO(null, null, null, null));
		return stateForms;
	}

	@Override
	public ArrayList<CostIncomeVO> getIncomeForm() {
		ArrayList<CostIncomeVO> cost = new ArrayList<CostIncomeVO>();
		cost.add(new CostIncomeVO(3000, 2000, null, null));
		cost.add(new CostIncomeVO(5000, 7000, null, null));
		return cost;
	}

	@Override
	public ResultMessage bulidBill(BillVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<BillVO> getBills() {
		ArrayList<BillVO> bills = new ArrayList<BillVO>();
		bills.add(new BillVO());
		bills.add(new BillVO());
		return bills;
	}

}
