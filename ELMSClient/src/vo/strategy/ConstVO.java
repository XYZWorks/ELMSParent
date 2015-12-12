package vo.strategy;
/**
 * 常量VO类
 * @author czq
 * @date 2015-10-22
 */
public class ConstVO {
	
	
	/**
	 * 北京、南京距离
	 */
	public int mileInBN;
	/**
	 * 北京、上海距离
	 */
	public int mileInBS;
	/**
	 * 北京、广州距离
	 */
	public int mileInBG;
	/**
	 * 南京、上海距离
	 */
	public int mileInNS;
	/**
	 * 南京、广州距离
	 */
	public int mileInNG;
	/**
	 * 上海、广州距离
	 */
	public int mileINSG;
	/**
	 * 飞机每公里价格
	 */
	public double plane;
	/**
	 * 火车每公里价格
	 */
	public double train;
	/**
	 * 汽车每公里价格
	 */
	public double truck;
	/**
	 * 纸箱价格
	 */
	public int paperBox;
	/**
	 * 木箱价格
	 */
	public int woodBox;
	/**
	 * 快递袋价格
	 */
	public int plasticBag;
	
	/**
	 * 经济快递、标准快递、次晨特快价格比
	 */
	public int[] ratios;
	
	public ConstVO() {}
	public ConstVO( int mileInBN, int mileInBS, int mileInBG,
			int mileInNS, int mileInNG, int mileINSG, double plane,
			double train, double truck, int paperBox, int woodBox,
			int plasticBag,int[] ratios) {
		super();
		this.ratios = ratios;
		this.mileInBN = mileInBN;
		this.mileInBS = mileInBS;
		this.mileInBG = mileInBG;
		this.mileInNS = mileInNS;
		this.mileInNG = mileInNG;
		this.mileINSG = mileINSG;
		this.plane = plane;
		this.train = train;
		this.truck = truck;
		this.paperBox = paperBox;
		this.woodBox = woodBox;
		this.plasticBag = plasticBag;
	}
	
	
	
}
