package vo.transport;

import java.util.ArrayList;

import util.MyDate;
 /** 
 * 付款單VO類
 * @author czq 
 * @version 2015年12月12日 上午11:15:31 
 */
public class PayDocVO {
	public String ID;
	
	public int money;
	
	public String YYID;
	
	public MyDate date;
	
	public String courierName;
	
	public ArrayList<String> orders;
	
	public PayDocVO() {
	}

	public PayDocVO(String iD, int money, String yYID, MyDate date,
			String courierName, ArrayList<String> orders) {
		super();
		ID = iD;
		this.money = money;
		YYID = yYID;
		this.date = date;
		this.courierName = courierName;
		this.orders = orders;
	}
	
	
	
}
