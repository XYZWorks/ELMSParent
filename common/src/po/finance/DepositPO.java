package po.finance;

import java.io.Serializable;

import util.MyDate;

/**
 * 利润信息
 * @author ymc
 *
 */
public class DepositPO implements Serializable{
	
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 时间
	 */
	private MyDate time;
	/**
	 * 金额
	 */
	private int money;
	
	public DepositPO() {}
	
	
	
	public MyDate getTime() {
		return time;
	}
	public void setTime(MyDate time) {
		this.time = time;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	/**
	 * 
	 * @param time
	 * @param money
	 */
	public DepositPO(MyDate time, int money) {
		super();
		this.time = time;
		this.money = money;
	}
}
