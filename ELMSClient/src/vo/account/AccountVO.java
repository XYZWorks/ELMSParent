package vo.account;

import util.AccountType;

/**
 * 账户VO类
 * @author czq
 * @date 2015/10/20
 */
public class AccountVO {
	
	/**
	 * 账户ID 
	 */
	public String ID;
	/**
	 * 账户姓名
	 */
	public String name;
	/**
	 * 账户种类
	 */
	public AccountType type;
	/**
	 * 账户密码
	 */
	public String password;
	/**
	 * 个人手机号 
	 */
	public String phoneNum;
	/**
	 * 电子邮箱
	 */
	public String mail;
	
	
	
	
	public AccountVO() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * 登录时使用
	 * @param iD
	 * @param password
	 */
	public AccountVO(String iD, String password,AccountType type) {
		super();
		ID = iD;
		this.password = password;
		this.type=type;
	}

	/**
	 * 账户VO类构造器  用于管理员对账户的操作
	 * @param iD
	 * @param name
	 * @param type
	 * @param password
	 */
	public AccountVO(String ID, String name, AccountType type, String password) {
		super();
		this.ID = ID;
		this.name = name;
		this.type = type;
		this.password = password;
	}

	/**
	 * 用于传递用户所需的信息
	 * @param iD
	 * @param name
	 * @param type
	 * @param password
	 * @param phoneNum
	 * @param mail
	 */
	public AccountVO(String iD, String name, AccountType type, String password,
			String phoneNum, String mail) {
		super();
		ID = iD;
		this.name = name;
		this.type = type;
		this.password = password;
		this.phoneNum = phoneNum;
		this.mail = mail;
	}
	
	
	
	
}
