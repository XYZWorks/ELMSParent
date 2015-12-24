package po.strategy;

import java.io.Serializable;


/**
 * 系统常量PO类
 * @author czq
 * @date 2015-10-22
 */
public class ConstPO implements Serializable{
	
	public ConstPO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 北京、南京距离
	 */
	private double mileInBN;
	/**
	 * 北京、上海距离
	 */
	private double mileInBS;
	/**
	 * 北京、广州距离
	 */
	private double mileInBG;
	/**
	 * 南京、上海距离
	 */
	private double mileInNS;
	/**
	 * 南京、广州距离
	 */
	private double mileInNG;
	/**
	 * 上海、广州距离
	 */
	private double mileINSG;
	/**
	 * 飞机每公里价格
	 */
	private double plane;
	/**
	 * 火车每公里价格
	 */
	private double train;
	/**
	 * 汽车每公里价格
	 */
	private double truck;
	/**
	 * 纸箱价格
	 */
	private int paperBox;
	/**
	 * 木箱价格
	 */
	private int woodBox;
	/**
	 * 快递袋价格
	 */
	private int plasticBag;
	
	/**
	 * 经济快递、标准快递、次晨特快价格比
	 */
	private int[] ratios;
	
	
	
	public ConstPO(double mileInBN, double mileInBS, double mileInBG, double mileInNS,
			double mileInNG, double mileINSG, double plane, double train,
			double truck, int paperBox, int woodBox, int plasticBag, int[] ratio) {
		super();
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
		this.ratios = ratio;
	}
	public double getMileInBN() {
		return mileInBN;
	}
	public void setMileInBN(int mileInBN) {
		this.mileInBN = mileInBN;
	}
	public double getMileInBS() {
		return mileInBS;
	}
	public void setMileInBS(int mileInBS) {
		this.mileInBS = mileInBS;
	}
	public double getMileInBG() {
		return mileInBG;
	}
	public void setMileInBG(int mileInBG) {
		this.mileInBG = mileInBG;
	}
	public double getMileInNS() {
		return mileInNS;
	}
	public void setMileInNS(int mileInNS) {
		this.mileInNS = mileInNS;
	}
	public double getMileInNG() {
		return mileInNG;
	}
	public void setMileInNG(int mileInNG) {
		this.mileInNG = mileInNG;
	}
	public double getMileINSG() {
		return mileINSG;
	}
	public void setMileINSG(int mileINSG) {
		this.mileINSG = mileINSG;
	}
	public double getPlane() {
		return plane;
	}
	public void setPlane(double plane) {
		this.plane = plane;
	}
	public double getTrain() {
		return train;
	}
	public void setTrain(double train) {
		this.train = train;
	}
	public double getTruck() {
		return truck;
	}
	public void setTruck(double truck) {
		this.truck = truck;
	}
	public int getPaperBox() {
		return paperBox;
	}
	public void setPaperBox(int paperBox) {
		this.paperBox = paperBox;
	}
	public int getWoodBox() {
		return woodBox;
	}
	public void setWoodBox(int woodBox) {
		this.woodBox = woodBox;
	}
	public int getPlasticBag() {
		return plasticBag;
	}
	public void setPlasticBag(int plasticBag) {
		this.plasticBag = plasticBag;
	}
	public int[] getRatios() {
		return ratios;
	}
	public void setRatios(int[] ratio) {
		this.ratios = ratio;
	}
	
	
}
