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
	public double mileInBN;
	/**
	 * 北京、上海距离
	 */
	public double mileInBS;
	/**
	 * 北京、广州距离
	 */
	public double mileInBG;
	/**
	 * 南京、上海距离
	 */
	public double mileInNS;
	/**
	 * 南京、广州距离
	 */
	public double mileInNG;
	/**
	 * 上海、广州距离
	 */
	public double mileINSG;
	/**
	 * 飞机每公里每吨价格
	 */
	public double plane;
	/**
	 * 火车每公里每吨价格
	 */
	public double train;
	/**
	 * 汽车每公里每吨价格
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
	public ConstVO( double mileInBN, double mileInBS, double mileInBG,
			double mileInNS, double mileInNG, double mileINSG, double plane,
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
