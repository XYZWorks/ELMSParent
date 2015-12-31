package po.statistic;

import java.io.Serializable;
import java.util.ArrayList;

import po.finance.DepositPO;
import po.finance.FormPayPO;
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
	private ArrayList<DepositPO> deposits;
	/**
	 * 付款信息
	 */
	private ArrayList<FormPayPO> pays;
	
	public StateFormPO() {}
	
	public StateFormPO(MyDate startDate, MyDate endDate,
			ArrayList<DepositPO> deposits, ArrayList<FormPayPO> pays) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.deposits = deposits;
		this.pays = pays;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public MyDate getStartDate() {
		return startDate;
	}

	public MyDate getEndDate() {
		return endDate;
	}

	public ArrayList<DepositPO> getDeposits() {
		return deposits;
	}

	public ArrayList<FormPayPO> getPays() {
		return pays;
	}

	
	
	
	
}
