package vo;

import util.Date;
import util.DocState;
import util.DocType;


/**
 * 派送单VO类
 * @author JerryZhang
 *
 */
public class SendGoodDocVO extends DocVO{
	/**
	 * 到达日期
	 */
	public Date arriveDate;
	/**
	 * 快递员
	 */
	public String SendMan;
	/**
	 *订单条形码号
	 */
	public String orderBarCode;
	
	public SendGoodDocVO(String iD, Date date,
			Date arriveDate, String sendMan, String orderBarCode) {
		super(iD, DocType.sendGoodDoc, date, DocState.wait);
		this.arriveDate = arriveDate;
		SendMan = sendMan;
		this.orderBarCode = orderBarCode;
	}

	
}
