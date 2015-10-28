package vo;

import util.Date;

/**
 * 成本收益表PO类
 * @author czq
 * @date 2015-10-23
 */
public class CostIncomeVO {
	/**
	 * 总收入，根据所有订单生成
	 */
	public int income;
	/**
	 * 总支出
	 */
	public int expense;
	
	/**
	 * 起始日期
	 */
	public Date startDate;
	
	/**
	 * 结束日期
	 */
	public Date endDate;

	public CostIncomeVO(int income, int expense, Date startDate,
			Date endDate) {
		super();
		this.income = income;
		this.expense = expense;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	
}
