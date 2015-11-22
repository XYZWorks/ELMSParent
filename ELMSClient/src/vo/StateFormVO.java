package vo;

import java.util.ArrayList;

import util.MyDate;

/**
 * 经营状况表VO类
 * @author czq
 *
 */
public class StateFormVO {
	/**
	 * 起始日期
	 */
	public MyDate startDate;
	/**
	 * 截止日期
	 */
	public MyDate endDate;
	/**
	 * 付款信息
	 */
	public ArrayList<PayVO> pays;
	/**
	 * 
	 * 收款信息
	 */
	public ArrayList<DepositVO> deposits;
	public StateFormVO() {
		// TODO Auto-generated constructor stub
	}
	public StateFormVO(MyDate startDate, MyDate endDate, ArrayList<PayVO> pays,
			ArrayList<DepositVO> deposits) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.pays = pays;
		this.deposits = deposits;
	}
	
	
	
	
}
