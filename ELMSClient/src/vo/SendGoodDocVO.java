package vo;

import util.MyDate;
import util.DocState;
import util.DocType;


/**
 * 派送单VO类
 * @author JerryZhang
 *
 */
public class SendGoodDocVO extends DocVO{

	/**
	 * 快递员
	 */
	public String SendMan;
	/**
	 *订单条形码号
	 */
	public String orderBarCode;
	public SendGoodDocVO() {
		// TODO Auto-generated constructor stub
	}
	public SendGoodDocVO(String iD, MyDate date,
			 String sendMan, String orderBarCode) {
		super(iD, DocType.sendGoodDoc, date, DocState.wait);
		
		SendMan = sendMan;
		this.orderBarCode = orderBarCode;
	}

	
}
