package po.DTManage;

import java.io.Serializable;

/**
 * 车辆信息PO类
 * @author JerryZhang
 *
 */
public class CarPO implements Serializable{
	public CarPO() {
	}
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 车辆编号
	 */
	private  String ID ;
	/**
	 * 机构ID
	 */
	private String instID;
	/**
	 * 车牌号
	 */
	private  String plateNum;
	/**
	 * 服役时间
	 */
	private  int useYear;


	public CarPO(String iD, String instID, String plateNum, int useYear) {
		super();
		this.instID = instID;
		ID = iD;
		this.plateNum = plateNum;
		this.useYear = useYear;
	}

	public String getInstID() {
		return instID;
	}

	public void setInstID(String instID) {
		this.instID = instID;
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
