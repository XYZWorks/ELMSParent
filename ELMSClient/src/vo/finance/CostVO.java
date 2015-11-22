package vo.finance;
/**
 * 成本信息（父类）
 * @author ymc
 *
 */
public class CostVO {
	/**
	 * 金额
	 */
	public int money;
	/**
	 * 成本类型
	 */
	public String type;
	
	public CostVO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param money
	 * @param type
	 */
	public CostVO(int money, String type) {
		super();
		this.money = money;
		this.type = type;
	}
}
