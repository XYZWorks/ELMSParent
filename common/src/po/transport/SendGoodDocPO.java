 package po.transport;

import java.io.Serializable;
import java.util.ArrayList;

import po.DocPO;
import util.DocState;
import util.DocType;
import util.MyDate;

/**
 * 派送单PO
 * 
 * @author JerryZhang
 *
 */
public class SendGoodDocPO extends DocPO implements Serializable{
	
	
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 快递员
	 */
	private String sendMan;
	/**
	 * 订单条形码号
	 */
	private ArrayList<String> orderBarCode;
	
	public SendGoodDocPO() {}
	
	/**
	 * 产生单据时使用
	 * @param iD
	 * @param date
	 * @param sendMan
	 * @param orderBarCode
	 */
	public SendGoodDocPO(String iD, MyDate date, String sendMan,
			ArrayList<String> orderBarCode) {
		super(iD, DocType.sendGoodDoc, date, DocState.wait);
		this.sendMan = sendMan;
		this.orderBarCode = orderBarCode;
	}
	/**
	 * 数据库读取时使用
	 * @param iD
	 * @param type
	 * @param date
	 * @param state
	 * @param sendMan
	 * @param orderBarCode
	 */
	public SendGoodDocPO(String iD, DocType type ,MyDate date,DocState state, String sendMan,
			ArrayList<String> orderBarCode) {
		super(iD, type, date, state);
		this.sendMan = sendMan;
		this.orderBarCode = orderBarCode;
	}

	public String getSendMan() {
		return sendMan;
	}

	public void setSendMan(String sendMan) {
		this.sendMan = sendMan;
	}

	public ArrayList<String> getOrderBarCode() {
		return orderBarCode;
	}


}
