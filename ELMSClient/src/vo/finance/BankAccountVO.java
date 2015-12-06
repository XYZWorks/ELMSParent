package vo.finance;

/**
 * 银行账户VO
 * @author czq
 * @version 2015年12月6日 下午8:55:16
 */
public class BankAccountVO {
	public String ID;

	public String password;

	public String money;

	public BankAccountVO(String iD, String password, String money) {
		super();
		ID = iD;
		this.password = password;
		this.money = money;
	}
	
	
}
