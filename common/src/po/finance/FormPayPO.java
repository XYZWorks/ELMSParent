package po.finance;

import java.io.Serializable;

import util.MyDate;
 /** 
 * 
 * @author czq 
 * @version 2015年12月31日 上午9:24:49 
 */
public class FormPayPO implements Serializable{
	/**
	 * 
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
	/**
	 * 类型
	 */
	private String type;
	public FormPayPO() {
	}
	public FormPayPO(MyDate time, int money, String type) {
		super();
		this.time = time;
		this.money = money;
		this.type = type;
	}
	public MyDate getTime() {
		return time;
	}
	public int getMoney() {
		return money;
	}
	public String getType() {
		return type;
	}
	
	
	
}
