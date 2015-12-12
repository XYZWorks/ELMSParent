package vo.transport;

import util.MyDate;
import vo.DocVO;
import util.City;
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
	public String sendMan;
	/**
	 *订单条形码号
	 */
	public String orderBarCode;
	/**
	 * 目的地
	 */
	public City sendCity;
	
	public SendGoodDocVO() {
	}
	public SendGoodDocVO(String iD, MyDate date,
			 String sendMan, String orderBarCode,City sendCity) {
		super(iD, DocType.sendGoodDoc, date, DocState.wait);
		this.sendCity = sendCity;
		this.sendMan = sendMan;
		this.orderBarCode = orderBarCode;
	}

	
}
