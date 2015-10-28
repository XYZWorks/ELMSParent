package po;

import java.io.Serializable;

import util.Date;
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
	 * 到达日期
	 */
	private Date arriveDate;
	/**
	 * 快递员
	 */
	private String SendMan;
	/**
	 * 订单条形码号
	 */
	private String orderBarCode;

	public SendGoodDocPO(String iD, Date date, Date arriveDate, String sendMan,
			String orderBarCode) {
		super(iD, DocType.sendGoodDoc, date, DocState.wait);
		this.arriveDate = arriveDate;
		SendMan = sendMan;
		this.orderBarCode = orderBarCode;
	}

	public Date getArriveDate() {
		return arriveDate;
	}

	public void setArriveDate(Date arriveDate) {
		this.arriveDate = arriveDate;
	}

	public String getSendMan() {
		return SendMan;
	}

	public void setSendMan(String sendMan) {
		SendMan = sendMan;
	}

	public String getOrderBarCode() {
		return orderBarCode;
	}

	public void setOrderBarCode(String orderBarCode) {
		this.orderBarCode = orderBarCode;
	}

}
