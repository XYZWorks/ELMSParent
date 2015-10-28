package vo;

/**
 * DriverVO类
 * 
 * @author JerryZhang
 *
 */
public class CarVO{
	/**
	 * 车辆编号
	 */
	public String ID;
	/**
	 * 车牌号
	 */
	public String plateNum;
	/**
	 * 服役时间
	 */
	public int useYear;

	/**
	 * 
	 * @param ID
	 * @param PlateNum
	 * @param useYear
	 */

	public CarVO(String ID, String PlateNum, int useYear) {
		super();
		this.ID = ID;
		this.plateNum = PlateNum;
		this.useYear = useYear;

	}
}
