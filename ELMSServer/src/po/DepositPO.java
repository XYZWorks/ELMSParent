package po;

public class DepositPO {
	/**
	 * 时间
	 */
	private String time;
	/**
	 * 金额
	 */
	private int money;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
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
	public DepositPO(String time, int money) {
		super();
		this.time = time;
		this.money = money;
	}
}
