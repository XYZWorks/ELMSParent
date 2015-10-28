package po;
/**
 * 车辆信息PO类
 * @author JerryZhang
 *
 */
public class CarPO {
	/**
	 * 车辆编号
	 */
	private  String ID;
	/**
	 * 车牌号
	 */
	private  String plateNum;
	/**
	 * 服役时间
	 */
	private  int useYear;

	/**
	 * 
	 * @param ID
	 * @param PlateNum
	 * @param useYear
	 */

	public CarPO(String ID, String PlateNum, int useYear) {
		super();
		this.ID = ID;
		this.plateNum = PlateNum;
		this.useYear = useYear;

	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPlateNum() {
		return plateNum;
	}

	public void setPlateNum(String plateNum) {
		this.plateNum = plateNum;
	}

	public int getUseYear() {
		return useYear;
	}

	public void setUseYear(int useYear) {
		this.useYear = useYear;
	}

}
