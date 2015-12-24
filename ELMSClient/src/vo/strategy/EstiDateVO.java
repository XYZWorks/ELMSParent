package vo.strategy;
/** 
 * @author ymc 
 * @version 创建时间：2015年12月24日 上午9:46:48 
 *
 */
public class EstiDateVO {
	/**
	 * 北京、南京预计时间
	 */
	public double dayInBN;
	/**
	 * 北京、上海预计时间
	 */
	public double dayInBS;
	/**
	 * 北京、广州预计时间
	 */
	public double dayInBG;
	/**
	 * 南京、上海预计时间
	 */
	public double dayInNS;
	/**
	 * 南京、广州预计时间
	 */
	public double dayInNG;
	/**
	 * 上海、广州预计时间
	 */
	public double dayInSG;
	
	public EstiDateVO() {
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
	public EstiDateVO(double dayInBN, double dayInBS, double dayInBG, double dayInNS, double dayInNG, double dayInSG) {
		super();
		this.dayInBN = dayInBN;
		this.dayInBS = dayInBS;
		this.dayInBG = dayInBG;
		this.dayInNS = dayInNS;
		this.dayInNG = dayInNG;
		this.dayInSG = dayInSG;
	}
}
