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
	private int goodNum;
	/**
	 * 货物名字
	 */
	private String goodName;
	
	/**
	 * 货物重量
	 */
	private int goodWeight;
	
	/**
	 * 货物体积
	 */
	private int goodLong;
	private int goodWidth;
	private int goodHeight;
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
	public int getGoodNum() {
		return goodNum;
	}
	public void setGoodNum(int goodNum) {
		this.goodNum = goodNum;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public int getGoodWeight() {
		return goodWeight;
	}
	public void setGoodWeight(int goodWeight) {
		this.goodWeight = goodWeight;
	}
	public int getGoodLong() {
		return goodLong;
	}
	public void setGoodLong(int goodLong) {
		this.goodLong = goodLong;
	}
	public int getGoodWidth() {
		return goodWidth;
	}
	public void setGoodWidth(int goodWidth) {
		this.goodWidth = goodWidth;
	}
	public int getGoodHeight() {
		return goodHeight;
	}
	public void setGoodHeight(int goodHeight) {
		this.goodHeight = goodHeight;
	}
	
	
}
