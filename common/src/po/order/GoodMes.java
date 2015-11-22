package po.order;
 /** 
 * 货物信息
 * @author czq 
 * @version 2015年11月22日 下午12:06:26 
 */
public class GoodMes {
	/**
	 * 货物数量
	 */
	int goodNum;
	/**
	 * 货物名字
	 */
	String goodName;
	
	/**
	 * 货物重量
	 */
	int goodWeight;
	
	/**
	 * 货物体积
	 */
	int goodLong;
	int goodWidth;
	int goodHeight;
	public GoodMes(int goodNum, String goodName, int goodWeight, int goodLong,
			int goodWidth, int goodHeight) {
		super();
		this.goodNum = goodNum;
		this.goodName = goodName;
		this.goodWeight = goodWeight;
		this.goodLong = goodLong;
		this.goodWidth = goodWidth;
		this.goodHeight = goodHeight;
	}
	
	
}
