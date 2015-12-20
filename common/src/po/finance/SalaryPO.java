package po.finance;

import util.CostType;
import util.MyDate;
import util.StaffType;



/**
 * 薪水信息
 * 
 * @author ymc
 * @version 创建时间：2015年10月26日 下午7:09:23
 * 
 */
public class SalaryPO extends CostPO {
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 员工类型(driver,courier,workman)
	 */
	private StaffType worker;
	
	
	
	public SalaryPO() {}

	

	public SalaryPO(String ID,MyDate startDate, MyDate endDate, int money,CostType costType, StaffType worker) {
		super(ID, startDate, endDate, money , costType);
		this.worker = worker;
	}

	public StaffType getWorker() {
		return worker;
	}
	public void setWorker(StaffType worker) {
		this.worker = worker;
	}
	

}
