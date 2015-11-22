package vo;
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
	public SalaryVO() {
		// TODO Auto-generated constructor stub
	}
	public SalaryVO(int money, String type, String worker) {
		super(money, type);
		this.worker = worker;
	}
	

}
