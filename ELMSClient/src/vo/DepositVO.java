package vo;

import util.MyDate;

/**
 * 收款VO类
 * @author ymc
 *
 */
public class DepositVO {
	/**
	 * 时间
	 */
	public MyDate time;
	/**
	 * 金额
	 */
	public int money;
	/**
	 * 
	 * @param time
	 * @param money
	 */
	public DepositVO(MyDate time, int money) {
		super();
		this.time = time;
		this.money = money;
	}

}
