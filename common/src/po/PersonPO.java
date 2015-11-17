package po;

import java.io.Serializable;

import util.StaffType;

/**
 * 人员信息PO类
 * 
 * @author czq
 * @date 2015/10/20
 */
public class PersonPO implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 所在机构编号
	 */
	private String instID;

	/**
	 * 人员ID
	 */
	private String ID;
	/**
	 * 人员姓名
	 */
	private String name;
	/**
	 * 人员职位
	 */
	private StaffType type;
	/**
	 * 手机号码
	 */
	private String phoneNum;

	public PersonPO(String instID, String iD, String name, StaffType type,
			String phoneNum) {
		super();
		this.instID = instID;
		ID = iD;
		this.name = name;
		this.type = type;
		this.phoneNum = phoneNum;
	}

	public String getInstID() {
		return instID;
	}

	public void setInstID(String instID) {
		this.instID = instID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StaffType getType() {
		return type;
	}

	public void setType(StaffType type) {
		this.type = type;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getID() {
		return ID;
	}

}
