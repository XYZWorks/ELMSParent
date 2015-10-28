package vo;

import java.util.ArrayList;

import util.Date;

/**
 * 经营状况表VO类
 * @author czq
 *
 */
public class StateFormVO {
	/**
	 * 起始日期
	 */
	public Date startDate;
	/**
	 * 截止日期
	 */
	public Date endDate;
	/**
	 * 付款信息
	 */
	public ArrayList<PayVO> pays;
	/**
	 * 
	 * 收款信息
	 */
	public ArrayList<DepositVO> deposits;
	public StateFormVO(Date startDate, Date endDate, ArrayList<PayVO> pays,
			ArrayList<DepositVO> deposits) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.pays = pays;
		this.deposits = deposits;
	}
	
	
	
	
}
