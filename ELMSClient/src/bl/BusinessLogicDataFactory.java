package bl;

import bl.DTManagebl.DTManageController;
import bl.accountbl.AccountController;
import bl.approvalbl.ApprovalController;
import bl.financebl.FinanceController;
import bl.orderbl.OrderController;
import bl.personnelbl.PersonnelController;
import bl.statisticbl.StatisticController;
import bl.storebl.StoreController;
import bl.strategybl.StrategyController;
import bl.transportbl.TransportController;
import bl.userbl.UserController;
import blservice.DTManageblservice.DTManageblservice;
import blservice.accountblservice.Accountblservice;
import blservice.approvalblservice.Approvalblservice;
import blservice.financeblservice.BankAccountBusinessService;
import blservice.financeblservice.CostService;
import blservice.financeblservice.DepositService;
import blservice.financeblservice.PayService;
import blservice.financeblservice.ProfitService;
import blservice.orderblservice.Orderblservice;
import blservice.personnelblservice.Personnelblservice;
import blservice.statisticblservice.Statisticblservice;
import blservice.storeblservice.InStoreDocService;
import blservice.storeblservice.OutStoreDocService;
import blservice.storeblservice.StoreblService;
import blservice.strategyblservice.StrategyblService;
import blservice.transportblservice.Transportblservice;
import blservice.usermesblservice.UserMesblservice;
/** 
 * 逻辑层工厂类
 * @author czq 
 * @version 2015年11月24日 下午11:49:56 
 */
public class BusinessLogicDataFactory {
	
	private static BusinessLogicDataFactory factory;
	
	
	private BusinessLogicDataFactory() {}
	
	private FinanceController financeController = new FinanceController();
	
	private StoreController storeController = new StoreController();
	
	public static BusinessLogicDataFactory getFactory(){
		if(factory == null){
			factory = new BusinessLogicDataFactory();
		}
		
		return factory;
	}
	
	public BankAccountBusinessService getBankAccountService(){
		return financeController;
	}
	public CostService getCostService() {
		return financeController;
	}
	public DepositService getDepositService() {
		return financeController;
	}
	public PayService getPayService(){
		return financeController;
	}
	public ProfitService getProfitService(){
		return financeController;
	}
	
	public Accountblservice getAccountBusinessLogic(){
		return new AccountController();
	}
	
	public Approvalblservice getApprovalBusinessLogic(){
		return new ApprovalController();
	}
	
	public DTManageblservice getDTManageBusinessLogic(){
		return new DTManageController();
	}
	
	public UserMesblservice getUserMesBusinessLogic(){
		return new UserController();
		
		
	}
	
	public StrategyblService getStrategyBusinessLogic(){
		return new StrategyController();
	}
	
	public Personnelblservice getPersonnelBusinessLogic(){
		return new PersonnelController();
	}
	
	public Statisticblservice getStatisticBusinessLogic(){
		return new StatisticController();
	}
	

	public Orderblservice getOrderBussinessLogic(){
		return new OrderController();
	}
	
	public StrategyblService getStrategyBussinessLogic(){
		return new StrategyController();
	}

	public Transportblservice getTransportblservice(){
		return new TransportController();
	}
	
	public InStoreDocService getInstoreService(){
		return storeController;
	}
	public OutStoreDocService getOutStoreService(){
		return storeController;
	}
	public StoreblService getStoreBlService(){
		return storeController;
	}

	
}
