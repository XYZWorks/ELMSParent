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
