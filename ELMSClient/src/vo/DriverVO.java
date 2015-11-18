package vo;

import util.MyDate;

/**
 * DriverVO类
 * @author JerryZhang
 *
 */
public class DriverVO {
	/**
	 * 司机编号   6位
	 */
	public String ID;
	/**
	 * 司机姓名
	 */
	public String name;
	/**
	 * 机构ID
	 */
	public String InstID;
	/**
	 * 出生日期
	 */
	public MyDate birthDay;
	/**
	 * 身份证号
	 */
	public String IDcard;
	/**
	 * 手机号码
	 */
	public String phoneNum;
	/**
	 * 性别
	 */
	public boolean isman;
	/**
	 * 驾驶证期限
	 */
	public int licenseYear;
	public DriverVO(String iD, String name, String instID, MyDate birthDay,
			String iDcard, String phoneNum, boolean isman, int licenseYear) {
		super();
		ID = iD;
		this.name = name;
		InstID = instID;
		this.birthDay = birthDay;
		IDcard = iDcard;
		this.phoneNum = phoneNum;
		this.isman = isman;
		this.licenseYear = licenseYear;
	}
	
	
	
	
}
