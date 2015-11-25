package blservice.statisticblservice;

import java.util.ArrayList;

import util.ResultMessage;
import vo.statistic.BillVO;
import vo.statistic.CostIncomeVO;
import vo.statistic.StateFormVO;
 /**
  * 查看经营状况表、成本收益表、期初建账逻辑接口
  * @author czq
  *
  */
public interface Statisticblservice {
	/**
	 * 建立经营状况表
	 * @param vo
	 * @return
	 */
	public ResultMessage bulidStateForm(StateFormVO vo);
	/**
	 * 建立成本收益表
	 * @param vo
	 * @return
	 */
	public ResultMessage bulidCostIncomeForm(CostIncomeVO vo);
	/**
	 * 获得经营状况表
	 * @return
	 */
	public ArrayList<StateFormVO> getStateForm();
	/**
	 * 获得成本收益表
	 * @return
	 */
	public ArrayList<CostIncomeVO> getIncomeForm();

	/**
	 * 期初建账
	 * @param vo
	 * @return
	 */
	public ResultMessage bulidBill(BillVO vo);
	
	/**
	 * 获得所有账单
	 * @return
	 */
	public ArrayList<BillVO> getBills();
}
