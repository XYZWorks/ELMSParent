package po.transport;

import java.io.Serializable;

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
	
	private String ID;
	
	private int money;
	
	private String YYID;
	
	private MyDate date;
	
	private String courierName;
	
	public PayDocPO() {
	}

	public PayDocPO(String iD, int money, String yYID, MyDate date,
			String courierName) {
		super();
		ID = iD;
		this.money = money;
		YYID = yYID;
		this.date = date;
		this.courierName = courierName;
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
