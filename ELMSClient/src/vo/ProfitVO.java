package vo;

import util.Date;

/**
 * 利润信息
 * @author ymc
 *
 */
public class ProfitVO {
	/**
	 * 时间
	 */
	public Date time;
	/**
	 * 收款
	 */
	public int deposit;
	/**
	 * 付款
	 */
	public int pay;
	/**
	 * 收益
	 */
	public int profit;
	/**
	 * 
	 * @param time
	 * @param deposit
	 * @param pay
	 * @param profit
	 */
	public ProfitVO(Date time, int deposit, int pay, int profit) {
		super();
		this.time = time;
		this.deposit = deposit;
		this.pay = pay;
		this.profit = profit;
	}
}
