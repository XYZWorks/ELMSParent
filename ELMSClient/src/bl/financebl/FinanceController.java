package bl.financebl;

import java.util.ArrayList;

import util.ResultMessage;
import vo.finance.BankAccountVO;
import vo.finance.CostVO;
import vo.finance.DepositVO;
import vo.finance.PayVO;
import vo.finance.ProfitVO;
import blservice.financeblservice.BankAccountBusinessService;
import blservice.financeblservice.CostService;
import blservice.financeblservice.DepositService;
import blservice.financeblservice.PayService;
import blservice.financeblservice.ProfitService;
 /** 
 * 
 * @author czq 
 * @version 2015年11月15日 上午9:17:23 
 */
public class FinanceController implements BankAccountBusinessService, CostService, PayService , ProfitService,DepositService{

	public ProfitVO getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage create(PayVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
 

	public ResultMessage add(CostVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage modify(CostVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage del(CostVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<CostVO> showCosts() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PayVO> showPays() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage createDeposit(DepositVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DepositVO> showDeposit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BankAccountVO> getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyAccount(BankAccountVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteAccount(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addAccount(BankAccountVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
