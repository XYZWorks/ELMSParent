package vo.transport;

import java.util.ArrayList;

import util.DocState;
import util.DocType;
import util.MyDate;
import vo.DocVO;
 /** 
 * 付款單VO類
 * @author czq 
 * @version 2015年12月12日 上午11:15:31 
 */
public class PayDocVO extends DocVO{
	
	public int money;
	
	public String YYID;
	
	public String courierName;
	
	public ArrayList<String> orders;
	
	
	public PayDocVO() {
	}


	public PayDocVO(String iD, DocType type, MyDate date, DocState state,
			int money, String yYID, String courierName, ArrayList<String> orders) {
		super(iD, type, date, state);
		this.money = money;
		YYID = yYID;
		this.courierName = courierName;
		this.orders = orders;
	}

	
	
	
	
}
