package po.finance;

import java.io.Serializable;
 /** 
 * 银行账户PO
 * @author czq 
 * @version 2015年12月6日 下午8:53:44 
 */
public class BankAccountPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ID;
	
	private String password;
	
	private String money;
	
	public BankAccountPO() {}
	
	public BankAccountPO(String iD, String password, String money) {
		super();
		ID = iD;
		this.password = password;
		this.money = money;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}
	
	
}
