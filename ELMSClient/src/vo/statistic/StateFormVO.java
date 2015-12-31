package vo.statistic;

import java.util.ArrayList;

import util.MyDate;
import vo.finance.DepositVO;
import vo.finance.FormPayVO;
import vo.finance.PayVO;

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
	public ArrayList<FormPayVO> pays;
	/**
	 * 
	 * 收款信息
	 */
	public ArrayList<DepositVO> deposits;
	public StateFormVO() {
	}
	public StateFormVO(MyDate startDate, MyDate endDate, ArrayList<FormPayVO> pays,
			ArrayList<DepositVO> deposits) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.pays = pays;
		this.deposits = deposits;
	}
	
	
	
	
}
