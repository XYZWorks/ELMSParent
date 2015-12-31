package po.transport;

import java.io.Serializable;
import java.util.ArrayList;

import po.DocPO;
import util.DocState;
import util.DocType;
import util.MyDate;
/** 
 * 收款單信息
 * @author czq 
 * 
 * @version 2015年12月12日 上午11:12:24 
 */
public class PayDocPO extends DocPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 金额
	 */
	private int money;
	/**
	 * 营业厅ID
	 */
	private String YYID;
	/**
	 * 快递员姓名
	 */
	private String courierName;
	
	
	private ArrayList<String> orders;
	
	public PayDocPO() {
	}

	public PayDocPO(String iD, DocType type, MyDate date, DocState state,
			int money, String yYID, String courierName, ArrayList<String> orders) {
		super(iD, type, date, state);
		this.money = money;
		YYID = yYID;
		this.courierName = courierName;
		this.orders = orders;
	}

	public int getMoney() {
		return money;
	}

	public String getYYID() {
		return YYID;
	}

	public String getCourierName() {
		return courierName;
	}

	public ArrayList<String> getOrders() {
		return orders;
	}

	

	

	
	
	
}
