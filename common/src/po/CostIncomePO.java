package po;

import java.io.Serializable;


/**
 * 成本收益表
 * @author czq
 * @date 2015-10-23
 */
public class CostIncomePO implements Serializable{
	
	public CostIncomePO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 总收入，根据所有订单生成
	 */
	private int income;
	/**
	 * 总支出
	 */
	private int expense;
	
	/**
	 * 起始日期
	 */
	private String startDate;
	
	/**
	 * 结束日期
	 */
	private String endDate;

	public CostIncomePO(int income, int expense, String startDate,
			String endDate) {
		super();
		this.income = income;
		this.expense = expense;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	/**
	 * 表生成后不能修改，故只有get方法
	 */
	public int getIncome() {
		return income;
	}

	public int getExpense() {
		return expense;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}
	
	
	
	
	
}
