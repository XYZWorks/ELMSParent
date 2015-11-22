package vo.order;

import util.MyDate;

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
	public MyDate orderDate;

	/**
	 * 真实收件人
	 */
	public String realReceiver;
	public ReceiveVO() {
		// TODO Auto-generated constructor stub
	}
	public ReceiveVO(String orderBarCode, MyDate orderDate, String realReceiver) {
		super();
		this.orderBarCode = orderBarCode;
		this.orderDate = orderDate;
		this.realReceiver = realReceiver;
	}
	
	

}
