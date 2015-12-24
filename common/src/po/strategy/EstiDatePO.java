package po.strategy;
/** 
 * 时间估计
 * @author ymc 
 * @version 创建时间：2015年12月24日 上午9:47:43 
 *
 */
public class EstiDatePO {
	/**
	 * 北京、南京预计时间
	 */
	private double dayInBN;
	/**
	 * 北京、上海预计时间
	 */
	private double dayInBS;
	/**
	 * 北京、广州预计时间
	 */
	private double dayInBG;
	/**
	 * 南京、上海预计时间
	 */
	private double dayInNS;
	/**
	 * 南京、广州预计时间
	 */
	private double dayInNG;
	/**
	 * 上海、广州预计时间
	 */
	private double dayInSG;
	
	public EstiDatePO() {
	}
	
	public double getDayInBN() {
		return dayInBN;
	}
	public void setDayInBN(double dayInBN) {
		this.dayInBN = dayInBN;
	}
	public double getDayInBS() {
		return dayInBS;
	}
	public void setDayInBS(double dayInBS) {
		this.dayInBS = dayInBS;
	}
	public double getDayInBG() {
		return dayInBG;
	}
	public void setDayInBG(double dayInBG) {
		this.dayInBG = dayInBG;
	}
	public double getDayInNS() {
		return dayInNS;
	}
	public void setDayInNS(double dayInNS) {
		this.dayInNS = dayInNS;
	}
	public double getDayInNG() {
		return dayInNG;
	}
	public void setDayInNG(double dayInNG) {
		this.dayInNG = dayInNG;
	}
	public double getDayInSG() {
		return dayInSG;
	}
	public void setDayInSG(double dayInSG) {
		this.dayInSG = dayInSG;
	}
	/**
	 * 
	 * @param dayInBN
	 * @param dayInBS
	 * @param dayInBG
	 * @param dayInNS
	 * @param dayInNG
	 * @param dayInSG
	 */
	public EstiDatePO(double dayInBN, double dayInBS, double dayInBG, double dayInNS, double dayInNG, double dayInSG) {
		super();
		this.dayInBN = dayInBN;
		this.dayInBS = dayInBS;
		this.dayInBG = dayInBG;
		this.dayInNS = dayInNS;
		this.dayInNG = dayInNG;
		this.dayInSG = dayInSG;
	}
	
}
