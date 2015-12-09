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
	Damage("损坏"),
	/**
	 * 完整
	 */
	Complete("完整"),
	/**
	 * 丢失
	 */
	Lost("丢失");

	private final String name;
	
	private GoodsState(String name){
		this.name = name;
	}
	
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

	public String getName() {
		
		return name;
	}
	
	
}
