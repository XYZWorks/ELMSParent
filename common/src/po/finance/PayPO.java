package po.finance;

import java.io.Serializable;

import util.MyDate;
/**
 * 付款信息
 * @author Administrator
 *
 */
public class PayPO implements Serializable{
	
	
	
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ID
	 */
	private String ID;
	/**
	 * 时间
	 */
	private MyDate time;
	/**
	 * 银行账户
	 */
	private String account;
	/**
	 * 金额
	 */
	private int money;
	/**
	 * 经手人
	 */
	private String person;
	/**
	 * 租金
	 */
	private int rent;
	/**
	 * 运费
	 */
	private int freight;
	/**
	 * 工资
	 */
	private int salary;
	
	public PayPO() {}

	public PayPO(String iD, MyDate time, String account, int money,
			String person, int rent, int freight, int salary) {
		super();
		ID = iD;
		this.time = time;
		this.account = account;
		this.money = money;
		this.person = person;
		this.rent = rent;
		this.freight = freight;
		this.salary = salary;
	}

	public String getID() {
		return ID;
	}

	public MyDate getTime() {
		return time;
	}

	public String getAccount() {
		return account;
	}

	public int getMoney() {
		return money;
	}

	public String getPerson() {
		return person;
	}

	public int getRent() {
		return rent;
	}

	public int getFreight() {
		return freight;
	}

	public int getSalary() {
		return salary;
	}
	
	
}
