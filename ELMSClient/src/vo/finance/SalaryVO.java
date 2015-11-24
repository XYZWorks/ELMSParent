package vo.finance;

import util.CostType;
import util.MyDate;

/**
 * 薪水信息
 * @author ymc
 *
 */
public class SalaryVO extends CostVO {
	/**
	 * 员工类型(driver,courier,workman)
	 */
	public String worker;
	
	
	
	public SalaryVO() {}

	

	public SalaryVO(String ID, MyDate startDate, MyDate endDate, int money,CostType costType, String worker) {
		super( ID, startDate, endDate, money , costType);
		this.worker = worker;
	}
	

}
