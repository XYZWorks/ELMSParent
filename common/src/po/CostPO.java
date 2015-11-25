package po;


/**
 * 成本信息（父类）
 * @author ymc
 *
 */
public class CostPO {
	

	
	/**
	 * 金额
	 */
	private int money;
	/**
	 * 成本类型
	 */
	private String type;
	/**
	 * 
	 * @param money
	 * @param type
	 */
	public CostPO(int money, String type) {
		super();
		this.money = money;
		this.type = type;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}