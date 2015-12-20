package po.finance;


import java.io.Serializable;

import util.CostType;
import util.MyDate;


/**
 * 成本信息（父类）
 * @author ymc
 *
 */
public class CostPO implements Serializable{
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ID编号
	 */
	private String ID;
	/**
	 * 创建时间
	 */
	private MyDate startDate;
	/**
	 * 结束时间
	 */
	private MyDate endDate;
	/**
	 * 金额
	 */
	private int money;
	/**
	 * cost类型(运费信息、租金信息、人员工资)
	 */
	private CostType costType;
	
	public CostPO() {	}
	

	






	public CostPO(String iD, MyDate startDate, MyDate endDate, int money, CostType costType) {
		super();
		ID = iD;
		this.startDate = startDate;
		this.endDate = endDate;
		this.money = money;
		this.costType = costType;
	}









	public CostType getCostType() {
		return costType;
	}


	public void setCostType(CostType costType) {
		this.costType = costType;
	}






	public MyDate getStartDate() {
		return startDate;
	}



	public void setStartDate(MyDate startDate) {
		this.startDate = startDate;
	}



	public MyDate getEndDate() {
		return endDate;
	}



	public void setEndDate(MyDate endDate) {
		this.endDate = endDate;
	}



	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}
	
}
