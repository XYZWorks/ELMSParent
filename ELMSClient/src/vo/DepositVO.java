package vo;

import util.Date;

/**
 * 收款VO类
 * @author ymc
 *
 */
public class DepositVO {
	/**
	 * 时间
	 */
	public Date time;
	/**
	 * 金额
	 */
	public int money;
	/**
	 * 
	 * @param time
	 * @param money
	 */
	public DepositVO(Date time, int money) {
		super();
		this.time = time;
		this.money = money;
	}

}
