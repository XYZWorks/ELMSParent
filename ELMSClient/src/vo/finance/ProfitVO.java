package vo.finance;

import util.MyDate;

/**
 * 利润信息
 * @author ymc
 *
 */
public class ProfitVO {
	/**
	 * 时间
	 */
	public MyDate time;
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
	public ProfitVO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param time
	 * @param deposit
	 * @param pay
	 * @param profit
	 */
	public ProfitVO(MyDate time, int deposit, int pay, int profit) {
		super();
		this.time = time;
		this.deposit = deposit;
		this.pay = pay;
		this.profit = profit;
	}
}
