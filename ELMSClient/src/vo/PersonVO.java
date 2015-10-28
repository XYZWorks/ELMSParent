package vo;

import util.StaffType;
/**
 * 人员信息VO类
 * @author czq
 *
 */
public class PersonVO {
	/**
	 * 所在机构编号
	 */
	public String instID;

	/**
	 * 人员ID
	 */
	public String ID;
	/**
	 * 人员姓名
	 */
	public String name;
	/**
	 * 人员职位
	 */
	public StaffType type;
	/**
	 * 手机号码
	 */
	public String phoneNum;
	public PersonVO(String instID, String iD, String name, StaffType type,
			String phoneNum) {
		super();
		this.instID = instID;
		ID = iD;
		this.name = name;
		this.type = type;
		this.phoneNum = phoneNum;
	}
	
}
