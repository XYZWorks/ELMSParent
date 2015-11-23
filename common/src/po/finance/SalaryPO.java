package po.finance;

import util.CostType;
import util.MyDate;



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
	private String worker;
	
	
	
	public SalaryPO() {}

	

	public SalaryPO(MyDate startDate, MyDate endDate, int money,CostType costType, String worker) {
		super(startDate, endDate, money , costType);
		this.worker = worker;
	}

	public String getWorker() {
		return worker;
	}
	public void setWorker(String worker) {
		this.worker = worker;
	}
	

}
