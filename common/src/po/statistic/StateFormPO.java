package po.statistic;

import java.io.Serializable;
import java.util.ArrayList;

import util.MyDate;

/**
 * 经营状况表PO类
 * @author czq
 * @date 2015-10-23
 */
public class StateFormPO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 开始日期
	 */
	private MyDate startDate;
	/**
	 * 结束日期
	 */
	private MyDate endDate;
	/**
	 * 收款信息
	 */
	private ArrayList<String> deposits;
	/**
	 * 付款信息
	 */
	private ArrayList<String> pays;
	
	public StateFormPO() {}
	
	public StateFormPO(MyDate startDate, MyDate endDate,
			ArrayList<String> deposits, ArrayList<String> pays) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.deposits = deposits;
		this.pays = pays;
	}
	
	//生成之后不可改变，只有get方法
	public MyDate getStartDate() {
		return startDate;
	}
	public MyDate getEndDate() {
		return endDate;
	}
	public ArrayList<String> getDeposits() {
		return deposits;
	}
	public ArrayList<String> getPays() {
		return pays;
	}
	
	
	
	
}
