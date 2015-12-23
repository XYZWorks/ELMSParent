package po.transport;

import java.io.Serializable;
import java.util.ArrayList;

import util.MyDate;
/** 
 * 收款單信息
 * @author czq 
 * 
 * @version 2015年12月12日 上午11:12:24 
 */
public class PayDocPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 单据ID
	 */
	private String ID;
	/**
	 * 金额
	 */
	private int money;
	/**
	 * 营业厅ID
	 */
	private String YYID;
	/**
	 * 日期
	 */
	private MyDate date;
	/**
	 * 快递员姓名
	 */
	private String courierName;
	
	
	private ArrayList<String> orders;
	
	public PayDocPO() {
	}

	

	public ArrayList<String> getOrders() {
		return orders;
	}



	public PayDocPO(String iD, int money, String yYID, MyDate date,
			String courierName, ArrayList<String> orders) {
		super();
		ID = iD;
		this.money = money;
		YYID = yYID;
		this.date = date;
		this.courierName = courierName;
		this.orders = orders;
	}



	public String getID() {
		return ID;
	}

	public int getMoney() {
		return money;
	}

	public String getYYID() {
		return YYID;
	}

	public MyDate getDate() {
		return date;
	}

	public String getCourierName() {
		return courierName;
	}
	
	
	
	
}
