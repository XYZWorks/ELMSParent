package util;
/**
 * 货物到达状态
 * @author JerryZhang
 *
 */
public enum GoodsState {
	/**
	 * 损坏
	 */
	Damage,
	/**
	 * 完整
	 */
	Complete,
	/**
	 * 丢失
	 */
	Lost;

	public static GoodsState toGoodState(String state) {
		switch (state) {
		case "损坏":
			
			return Damage;
		case "完整":
			return Complete;
		case "丢失":
			return Lost;
		default:
			System.err.println("goodState not exist");
			return null;
		}
		
	}
	
	
}
