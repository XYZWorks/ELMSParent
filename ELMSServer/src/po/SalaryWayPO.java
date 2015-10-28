package po;

import util.StaffType;
import util.WageStrategy;

/**
 * 薪水策略PO类
 * @author czq
 * @date 2015-10-22
 */
public class SalaryWayPO {
	
	/**
	 * 职员类型
	 */
	private StaffType type;
	/**
	 * 底薪
	 */
	private int basicSalary;
	/**
	 * 提成
	 */
	private int moreMoney;
	/**
	 * 计费策略  
	 */
	private WageStrategy way;
	
	public SalaryWayPO(StaffType type, int basicSalary, int moreMoney,
			WageStrategy way) {
		super();
		this.type = type;
		this.basicSalary = basicSalary;
		this.moreMoney = moreMoney;
		this.way = way;
	}

	
	
	
	public int getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}

	public int getMoreMoney() {
		return moreMoney;
	}

	public void setMoreMoney(int moreMoney) {
		this.moreMoney = moreMoney;
	}

	public WageStrategy getWay() {
		return way;
	}

	public void setWay(WageStrategy way) {
		this.way = way;
	}

	public StaffType getType() {
		return type;
	}
	
	
	
}
