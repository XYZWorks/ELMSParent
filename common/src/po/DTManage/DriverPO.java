package po.DTManage;

import java.io.Serializable;
import util.MyDate;
/**
 * 司机信息PO类
 * @author JerryZhang
 *
 */
public class DriverPO implements Serializable{
	
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 司机编号
	 */
	private  String ID;
	/**
	 * 司机姓名
	 */
	private  String name;
	/**
	 * 出生日期
	 */
	private  MyDate birthDay;
	/**
	 * 机构ID
	 */
	private String InstID;
	/**
	 * 身份证号
	 */
	private  String IDcard;
	/**
	 * 手机号码
	 */
	private  String phoneNum;
	/**
	 * 性别
	 */
	private  boolean isman;
	/**
	 * 驾驶证期限
	 */
	private int licenseYear;
	
	public DriverPO() {}
	
	/**
	 * 
	 * @param iD
	 * @param name
	 * @param birthDay
	 * @param instID
	 * @param iDcard
	 * @param phoneNum
	 * @param isman
	 * @param licenseYear
	 */
	public DriverPO(String iD, String name, MyDate birthDay, String instID, String iDcard, String phoneNum,
			boolean isman, int licenseYear) {
		super();
		ID = iD;
		this.name = name;
		this.birthDay = birthDay;
		InstID = instID;
		IDcard = iDcard;
		this.phoneNum = phoneNum;
		this.isman = isman;
		this.licenseYear = licenseYear;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(MyDate birthDay) {
		this.birthDay = birthDay;
	}

	public String getIDcard() {
		return IDcard;
	}

	public void setIDcard(String iDcard) {
		IDcard = iDcard;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public boolean getIsman() {
		return isman;
	}

	public void setIsman(boolean isman) {
		this.isman = isman;
	}

	public int getLicenseYear() {
		return licenseYear;
	}

	public void setLicenseYear(int licenseYear) {
		this.licenseYear = licenseYear;
	}

	public String getInstID() {
		return InstID;
	}

	public void setInstID(String instID) {
		InstID = instID;
	}
	
	
}
