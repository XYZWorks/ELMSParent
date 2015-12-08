package vo.order;
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
	public String receiveTime;

	/**
	 * 
	 * @param barCode
	 * @param address
	 * @param name
	 * @param realReceiver
	 * @param receiveTime
	 */
	public PreReceiveVO(String barCode, String address, String name, String realReceiver, String receiveTime) {
		super();
		this.barCode = barCode;
		this.address = address;
		this.name = name;
		this.realReceiver = realReceiver;
		this.receiveTime = receiveTime;
	}
	

}
