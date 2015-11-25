package vo.order;

/**
 * 订单VO类
 * 
 * @author xc
 * @date 2015/11/15
 */
public class OrderSimpleInfoVO {
	/**
	 * 得到简易物流信息的条形码
	 */
	public String orderBarCode;
	/**
	 * 得到简易信息的地点
	 */
	public String place;
	
	/**
	 * 得到简易信息的时间
	 */
	public String time;
	public OrderSimpleInfoVO() {
		// TODO Auto-generated constructor stub
	}
	public OrderSimpleInfoVO(String orderBarCode,String place,String time){
		this.orderBarCode=orderBarCode;
		this.place=place;
		this.time=time;
		
	}
}
