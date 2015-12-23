package vo.finance;

import util.CostType;
import util.MyDate;

/**
 * 成本信息（父类）
 * @author ymc
 *
 */
public class CostVO {
	
	public String ID;
	/**
	 * 创建时间
	 */
	public MyDate startDate;
	/**
	 * 结束时间
	 */
	public MyDate endDate;
	
	/**
	 * 金额
	 */
	public int money;
	/**
	 * cost类型(运费信息、租金信息、人员工资)
	 */
	public CostType costType;
	
	public CostVO() {}
	

	public CostVO(String ID ,MyDate startDate, MyDate endDate, int money, 
			CostType costType) {
		super();
		this.ID = ID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.money = money;
		this.costType = costType;
	}


}
