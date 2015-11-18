package po;

import java.io.Serializable;

import util.AccountType;
/**
 * 账户PO类
 * @author czq
 * @date 2015-10-22
 */
public class AccountPO  implements Serializable {
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 账户ID
	 */
	private String ID;
	/**
	 * 账户姓名
	 */
	private String name;
	/**
	 * 账户种类
	 */
	private AccountType type;
	/**
	 * 账户密码
	 */
	private String password;
	/**
	 * 个人手机号
	 */
	private String phoneNum;
	/**
	 * 电子邮箱
	 */
	private String mail;
	
	public AccountPO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	/**
	 * 用于用户对自己信息的查看与修改
	 * @param iD
	 * @param name
	 * @param type
	 * @param password
	 * @param phoneNum
	 * @param mail
	 */
	public AccountPO(String iD, String name, AccountType type, String password,
			String phoneNum, String mail) {
		super();
		ID = iD;
		this.name = name;
		this.type = type;
		this.password = password;
		this.phoneNum = phoneNum;
		this.mail = mail;
	}
	/**
	 * 管理员时使用，不需要对电子邮箱和电话赋值
	 * @param iD
	 * @param name
	 * @param type
	 * @param password
	 */
	public AccountPO(String iD, String name, AccountType type, String password) {
		super();
		ID = iD;
		this.name = name;
		this.type = type;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getID() {
		return ID;
	}
	
	
	
}
