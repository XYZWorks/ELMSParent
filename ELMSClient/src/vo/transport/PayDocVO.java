package vo.transport;

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
	
	public PayDocVO() {
	}
	
	public PayDocVO(String iD, int money, String yYID, MyDate date,
			String courierName) {
		super();
		this.ID = iD;
		this.money = money;
		this.YYID = yYID;
		this.date = date;
		this.courierName = courierName;
	}
	
	
}
