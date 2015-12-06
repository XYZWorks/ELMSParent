package vo.finance;

import util.MyDate;

/**
 * 付款信息
 * @author ymc
 *
 */
public class PayVO {
	/**
	 * 时间
	 */
	public MyDate time;
	/**
	 * 金额
	 */
	public int money;
	/**
	 * 类型
	 */
	public String type;
	public PayVO() {}
	/**
	 * 
	 * @param time
	 * @param money
	 */
	public PayVO(MyDate time, int money,String type) {
		super();
		this.time = time;
		this.money = money;
		this.type=type;
	}
}
