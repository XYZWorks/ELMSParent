package po;

import java.io.Serializable;

import util.Date;

/**
 * 利润信息PO类
 * @author ymc
 *
 */
public class ProfitPO implements Serializable{
	
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 时间
	 */
	private Date time;
	/**
	 * 收款
	 */
	private int deposit;
	/**
	 * 付款
	 */
	private int pay;
	/**
	 * 收益
	 */
	private int profit;
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public int getProfit() {
		return profit;
	}
	public void setProfit(int profit) {
		this.profit = profit;
	}
	/**
	 * 
	 * @param time
	 * @param deposit
	 * @param pay
	 * @param profit
	 */
	public ProfitPO(Date time, int deposit, int pay, int profit) {
		super();
		this.time = time;
		this.deposit = deposit;
		this.pay = pay;
		this.profit = profit;
	}
}
