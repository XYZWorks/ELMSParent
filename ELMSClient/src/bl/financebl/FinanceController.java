package bl.financebl;

import java.util.ArrayList;

import net.RMIManage;
import util.CostType;
import util.DataServiceType;
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
import ds.financedataservice.FinanceDataService;
 /** 
 * 
 * @author czq 
 * @version 2015年11月15日 上午9:17:23 
 */
public class FinanceController implements BankAccountBusinessService, CostService, PayService , ProfitService,DepositService{
	
	FinanceDataService financeDataService;
	private BankAccount bankAccount ;
	private Pay pay;
	private Cost cost;
	private Profit profit;
	private Deposit deposit;
	
	public FinanceController() {
		financeDataService= (FinanceDataService) RMIManage.getDataService(DataServiceType.FinanceDataService);

		bankAccount = new BankAccount(financeDataService);
		pay = new Pay(financeDataService);
		cost = new Cost(financeDataService);
		profit = new Profit(financeDataService);
		deposit = new Deposit(financeDataService);
	}
	
	
	public ProfitVO getMessage() {
		return profit.getMessage();
	}

	public ResultMessage create(PayVO vo) {
		return pay.create(vo);
	}
 
	public ArrayList<? extends CostVO> showCosts(CostType type) {
		return cost.showCosts(type);
	}
	
	public ResultMessage add(CostVO vo) {
		return cost.add(vo);
	}

	public ResultMessage modify(CostVO vo) {
		return cost.modify(vo);
	}

	public ResultMessage del(CostVO vo) {
		return cost.del(vo);
	}


	public ArrayList<PayVO> showPays() {
		return pay.showPays();
	}

	public ResultMessage createDeposit(DepositVO vo) {
		return deposit.create(vo);
	}

	public ArrayList<DepositVO> showDeposit() {
		return deposit.show();
	}

	@Override
	public ArrayList<BankAccountVO> getAccounts() {
		return bankAccount.getAccounts();
	}

	@Override
	public ResultMessage modifyAccount(BankAccountVO vo) {
		return bankAccount.modifyAccount(vo);
	}

	@Override
	public ResultMessage deleteAccount(String ID) {
		return bankAccount.deleteAccount(ID);
	}

	@Override
	public ResultMessage addAccount(BankAccountVO vo) {
		return bankAccount.addAccount(vo);
	}




}
