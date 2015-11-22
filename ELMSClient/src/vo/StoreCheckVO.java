package vo;
/**
 * 库存快照信息
 * @author ymc
 *
 */
public class StoreCheckVO {
	/**
	 * 时间
	 */
	public String time;
	/**
	 * 库存信息
	 */
	public StoreMessageVO vo;
	public StoreCheckVO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param time
	 * @param vo
	 */
	public StoreCheckVO(String time, StoreMessageVO vo) {
		super();
		this.time = time;
		this.vo = vo;
	}
	
	
}
