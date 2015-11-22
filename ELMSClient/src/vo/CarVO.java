package vo;

/**
 * DriverVO类
 * 
 * @author JerryZhang
 *
 */
public class CarVO{
	/**
	 * 车辆代号（城市编号（电话号码区号南京025）+营业厅编号（000三位数字）+000三位数字
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
	public CarVO() {
		// TODO Auto-generated constructor stub
	}
	public CarVO(String ID, String PlateNum, int useYear) {
		super();
		this.ID = ID;
		this.plateNum = PlateNum;
		this.useYear = useYear;

	}
}
