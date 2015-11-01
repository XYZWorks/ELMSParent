package po;

import java.io.Serializable;

/** 
* @author ymc 
* @version 创建时间：2015年10月26日 下午7:09:23 
* 薪水信息
*/
public class SalaryPO extends CostPO implements Serializable{
	
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 员工类型(driver,courier,workman)
	 */
	private String worker;

	public void setWorker(String worker) {
		this.worker = worker;
	}

	public SalaryPO(int money, String type, String worker) {
		super(money, type);
		this.worker = worker;
	}

	public String getWorker() {
		// TODO Auto-generated method stub
		return worker;
	}
	

}
