package po;

import java.io.Serializable;

import util.MyDate;

/**
 * 利润信息PO类
 * @author ymc
 *
 */
public class ProfitPO implements Serializable{
	
	public ProfitPO() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 时间
	 */
	private MyDate time;
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
	public MyDate getTime() {
		return time;
	}
	public void setTime(MyDate time) {
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
	public ProfitPO(MyDate time, int deposit, int pay, int profit) {
		super();
		this.time = time;
		this.deposit = deposit;
		this.pay = pay;
		this.profit = profit;
	}
}
