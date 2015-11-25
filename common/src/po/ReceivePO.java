package po;

import java.io.Serializable;

import util.Date;
/**
 * 收件信息录入
 * @author xingcheng
 *
 */
public class ReceivePO implements Serializable{
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	  * 订单号
	  */
	private	String orderBarCode;
		
	/**
	 *  收件日期
	 */
	private	Date orderDate;
		
	/**
	 * 真实收件人
	 */
	private	String realReceiver;

	public ReceivePO(String orderBarCode, Date orderDate, String realReceiver) {
		super();
		this.orderBarCode = orderBarCode;
		this.orderDate = orderDate;
		this.realReceiver = realReceiver;
	}

	public String getOrderBarCode() {
		return orderBarCode;
	}

	public void setOrderBarCode(String orderBarCode) {
		this.orderBarCode = orderBarCode;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getRealReceiver() {
		return realReceiver;
	}

	public void setRealReceiver(String realReceiver) {
		this.realReceiver = realReceiver;
	}

	
	
	
	
		
}
