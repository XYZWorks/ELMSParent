package vo.order;

import util.MyDate;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月8日 下午8:03:28 
 *
 */
public class PreReceiveVO {
	

	public String barCode;
	
 	public String address;
	
	public String name;
	//真实收件人
	public String realReceiver;
	//接收日期
	public MyDate receiveTime;

	/**
	 * 
	 * @param barCode
	 * @param address
	 * @param name
	 * @param realReceiver
	 * @param myDate
	 */
	public PreReceiveVO(String barCode, String address, String name, String realReceiver, MyDate myDate) {
		super();
		this.barCode = barCode;
		this.address = address;
		this.name = name;
		this.realReceiver = realReceiver;
		this.receiveTime = myDate;
	}
	/**
	 * 
	 * @param barCode
	 * @param address
	 * @param name
	 */
	public PreReceiveVO(String barCode, String address, String name) {
		super();
		this.barCode = barCode;
		this.address = address;
		this.name = name;
	}
	

}
