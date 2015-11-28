 package po.transport;

import java.io.Serializable;

import po.DocPO;
import util.MyDate;
import util.City;
import util.DocState;
import util.DocType;

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
	private String orderBarCode;
	/**
	 * 目的地
	 */
	private City sendCity;
	
	public SendGoodDocPO() {}
	
	/**
	 * 产生单据时使用
	 * @param iD
	 * @param date
	 * @param sendMan
	 * @param orderBarCode
	 */
	public SendGoodDocPO(String iD, MyDate date, String sendMan,
			String orderBarCode,City sendCity) {
		super(iD, DocType.sendGoodDoc, date, DocState.wait);
		this.sendMan = sendMan;
		this.orderBarCode = orderBarCode;
		this.sendCity = sendCity;
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
			String orderBarCode,City sendCity) {
		super(iD, type, date, state);
		this.sendMan = sendMan;
		this.sendCity= sendCity;
		this.orderBarCode = orderBarCode;
	}

	public String getSendMan() {
		return sendMan;
	}

	public void setSendMan(String sendMan) {
		this.sendMan = sendMan;
	}

	public String getOrderBarCode() {
		return orderBarCode;
	}

	public void setOrderBarCode(String orderBarCode) {
		this.orderBarCode = orderBarCode;
	}

	public City getSendCity() {
		return sendCity;
	}

	public void setSendCity(City sendCity) {
		this.sendCity = sendCity;
	}

}
