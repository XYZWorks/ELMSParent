package po;

import java.io.Serializable;

import util.Date;

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
	private Date time;
	/**
	 * 金额
	 */
	private int money;
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
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
	public DepositPO(Date time, int money) {
		super();
		this.time = time;
		this.money = money;
	}
}
