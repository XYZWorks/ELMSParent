package vo;

import util.Date;

/**
 * 付款信息
 * @author ymc
 *
 */
public class PayVO {
	/**
	 * 时间
	 */
	public Date time;
	/**
	 * 金额
	 */
	public int money;
	/**
	 * 类型
	 */
	public String type;
	/**
	 * 
	 * @param time
	 * @param money
	 */
	public PayVO(Date time, int money,String type) {
		super();
		this.time = time;
		this.money = money;
		this.type=type;
	}
}
