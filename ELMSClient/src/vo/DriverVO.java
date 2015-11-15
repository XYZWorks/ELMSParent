package vo;

import util.Date;

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
	 * 出生日期
	 */
	public Date birthDay;
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
	public DriverVO(String ID,String name,Date birthDay,String IDcard,
			String phoneNum,boolean isman,int licenseYear){
		super();
		this.birthDay=birthDay;
		this.ID=ID;
		this.IDcard=IDcard;
		this.isman=isman;
		this.licenseYear=licenseYear;
		this.name=name;
		this.phoneNum=phoneNum;
		
	}
	
	
}
