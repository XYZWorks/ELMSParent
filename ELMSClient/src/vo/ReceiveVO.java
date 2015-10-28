package vo;

import util.Date;

/**
 * 收件信息录入
 * 
 * @author xingcheng
 *
 */
public class ReceiveVO {
	/**
	 * 订单号
	 */
	public String orderBarCode;

	/**
	 * 收件日期
	 */
	public Date orderDate;

	/**
	 * 真实收件人
	 */
	public String realReceiver;

	public ReceiveVO(String orderBarCode, Date orderDate, String realReceiver) {
		super();
		this.orderBarCode = orderBarCode;
		this.orderDate = orderDate;
		this.realReceiver = realReceiver;
	}
	
	

}
