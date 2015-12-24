package vo.finance;

import util.MyDate;
 /** 
 * 经营状况表 成本单
 * @author czq 
 * @version 2015年12月23日 下午9:57:20 
 */
public class FormPayVO {
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
	
	public FormPayVO() {
	}

	public FormPayVO(MyDate time, int money, String type) {
		super();
		this.time = time;
		this.money = money;
		this.type = type;
	}
	
	
}
