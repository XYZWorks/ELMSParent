package bl.financebl;

import java.util.ArrayList;

import blservice.financeblservice.DepositService;
import blservice.orderblservice.Orderblservice;
import ds.financedataservice.FinanceDataService;
import util.ResultMessage;
import vo.finance.DepositVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:46:46 
 *
 */
public class Deposit {
	FinanceDataService financeData;
	Orderblservice orderbl;
	public Deposit(FinanceDataService financeDataService) {
		// TODO Auto-generated constructor stub
	}

	public ResultMessage create(DepositVO vo) {
		// TODO Auto-generated method stub
		return null;
	} 

	public ArrayList<DepositVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

}
