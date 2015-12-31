package vo.transport;

import java.util.ArrayList;

import util.DocState;
import util.DocType;
import util.MyDate;
import vo.DocVO;


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
	public ArrayList<String> orderBarCode;
	
	public SendGoodDocVO() {
	}
	public SendGoodDocVO(String iD, MyDate date,
			 String sendMan, ArrayList<String> orderBarCode) {
		super(iD, DocType.sendGoodDoc, date, DocState.wait);
		this.sendMan = sendMan;
		this.orderBarCode = orderBarCode;
	}
	public SendGoodDocVO(String iD, DocType type, MyDate date, DocState state,
			String sendMan, ArrayList<String> orderBarCode) {
		super(iD, type, date, state);
		this.sendMan = sendMan;
		this.orderBarCode = orderBarCode;
	}

	
}
