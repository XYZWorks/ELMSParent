package vo.DTManage;

/**
 * DriverVO类
 * 
 * @author JerryZhang
 *
 */
public class CarVO{
	/**
	 * 机构ID
	 */
	public String instID;
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
	}

	public CarVO(String instID, String iD, String plateNum, int useYear) {
		super();
		this.instID = instID;
		this.ID = iD;
		this.plateNum = plateNum;
		this.useYear = useYear;
	}
	
}
