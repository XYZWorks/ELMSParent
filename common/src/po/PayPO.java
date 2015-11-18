package po;

import java.io.Serializable;

import util.MyDate;
/**
 * 付款信息
 * @author Administrator
 *
 */
public class PayPO implements Serializable{
	
	public PayPO() {
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
	 * 金额
	 */
	private int money;
	/**
	 * 类型
	 */
	private String type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 
	 * @param time
	 * @param money
	 */
	public PayPO(MyDate time, int money,String type) {
		super();
		this.time = time;
		this.money = money;
		this.type=type;
	}
}
