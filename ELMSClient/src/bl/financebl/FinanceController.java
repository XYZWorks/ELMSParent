package bl.financebl;

import java.rmi.Remote;
import java.rmi.RemoteException;
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
import bl.BusinessController;
import blservice.financeblservice.BankAccountBusinessService;
import blservice.financeblservice.CostService;
import blservice.financeblservice.DepositService;
import blservice.financeblservice.PayService;
import blservice.financeblservice.ProfitService;
import ds.financedataservice.FinanceDataService;
import exception.ExceptionHandler;
 /** 
 * 
 * @author czq 
 * @version 2015年11月15日 上午9:17:23 
 */
public class FinanceController extends BusinessController implements BankAccountBusinessService, CostService, PayService , ProfitService,DepositService{
	
	FinanceDataService financeDataService;
	
	private BankAccount bankAccount ;
	private Pay pay;
	private Cost cost;
	private Profit profit;
	private Deposit deposit;
	
	public FinanceController() {
		financeDataService= (FinanceDataService) RMIManage.getDataService(DataServiceType.FinanceDataService);
		myType = DataServiceType.FinanceDataService;
		bankAccount = new BankAccount(financeDataService);
		pay = new Pay(financeDataService);
		cost = new Cost(financeDataService);
		profit = new Profit(financeDataService);
		deposit = new Deposit(financeDataService);
	}
	
	
	@Override
	public ProfitVO getMessage() {
		return profit.getMessage();
	}

	@Override
	public ResultMessage create(PayVO vo) {
		try {
			return pay.create(vo);
		} catch (RemoteException e) {
		  
		  if(ExceptionHandler.myExceptionHandler(myType, this)){
		  
			
				return create(vo);
			}
		}
		return ResultMessage.FAIL;

	}
 
	@Override
	public ArrayList<? extends CostVO> showCosts(CostType type) {
		try {
			return cost.showCosts(type);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return showCosts(type);
			}
		}
		return null;
	}
	
	@Override
	public ResultMessage add(CostVO vo) {
		try {
			return cost.add(vo);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return add(vo);
			}
		}
		return ResultMessage.FAIL;

	}

	@Override
	public ResultMessage modify(CostVO vo) {
		try {
			return cost.modify(vo);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return modify(vo);
			}
		}
		return ResultMessage.FAIL;

	}

	@Override
	public ResultMessage del(CostVO vo) {
		try {
			return cost.del(vo);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return del(vo);
			}
		}
		return ResultMessage.FAIL;

	}


	@Override
	public ArrayList<PayVO> showPays() {
		try {
			return pay.showPays();
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return showPays();
			}
		}
		return null;
	}

	@Override
	public ResultMessage createDeposit(DepositVO vo) {
		try {
			return deposit.create(vo);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return createDeposit(vo);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<DepositVO> showDeposit() {
		try {
			return deposit.show();
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return showDeposit();
			}
		}
		return null;

	}

	@Override
	public ArrayList<BankAccountVO> getAccounts() {
		try {
			return bankAccount.getAccounts();
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return getAccounts();
			}
		}
		return null;

	}

	@Override
	public ResultMessage modifyAccount(BankAccountVO vo) {
		try {
			return bankAccount.modifyAccount(vo);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return modifyAccount(vo);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage deleteAccount(String ID) {
		try {
			return bankAccount.deleteAccount(ID);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return deleteAccount(ID);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage addAccount(BankAccountVO vo) {
		try {
			return bankAccount.addAccount(vo);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return addAccount(vo);
			}
		}
		return ResultMessage.FAIL;
	}


	@Override
	public ResultMessage checkAccount(String ID, int money) {
		
		try {
			return bankAccount.checkAccount(ID, money);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return checkAccount(ID, money);
			}
		}
		return ResultMessage.FAIL;
	}


	@Override
	public void reinitDataService(Remote dataService) {
		financeDataService = (FinanceDataService) dataService;
		bankAccount = new BankAccount(financeDataService);
		pay = new Pay(financeDataService);
		cost = new Cost(financeDataService);
		profit = new Profit(financeDataService);
		deposit = new Deposit(financeDataService);
	}

	


}
