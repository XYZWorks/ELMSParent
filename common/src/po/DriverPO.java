package po;

import java.io.Serializable;
import java.util.Date;
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
	private  Date birthDay;
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
	private  int isman;
	/**
	 * 驾驶证期限
	 */
	private int licenseYear;
	
	/**
	 * 
	 * @param ID
	 * @param name
	 * @param birthDay
	 * @param IDcard
	 * @param phoneNum
	 * @param isman
	 * @param licenseYear
	 */
	public DriverPO(String ID,String name,Date birthDay,String IDcard,
			String phoneNum,int isman,int licenseYear){
		super();
		this.birthDay=birthDay;
		this.ID=ID;
		this.IDcard=IDcard;
		this.isman=isman;
		this.licenseYear=licenseYear;
		this.name=name;
		this.phoneNum=phoneNum;
		
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

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
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

	public int getIsman() {
		return isman;
	}

	public void setIsman(int isman) {
		this.isman = isman;
	}

	public int getLicenseYear() {
		return licenseYear;
	}

	public void setLicenseYear(int licenseYear) {
		this.licenseYear = licenseYear;
	}
	
	
}
