package vo.strategy;

import util.StaffType;
import util.WageStrategy;

/**
 * 薪水策略
 * @author czq
 *
 */
public class SalaryWayVO {
	/**
	 * 职员类型
	 */
	public StaffType type;
	/**
	 * 底薪
	 */
	public int basicSalary;
	/**
	 * 提成
	 */
	public int moreMoney;
	/**
	 * 计费策略  
	 */
	public WageStrategy way;
	public SalaryWayVO() {
		// TODO Auto-generated constructor stub
	}
	
	public SalaryWayVO(StaffType type, int basicSalary, int moreMoney,
			WageStrategy way) {
		super();
		this.type = type;
		this.basicSalary = basicSalary;
		this.moreMoney = moreMoney;
		this.way = way;
	}
	
	
}
