package bl;

import bl.DTManagebl.DTManageController;
import bl.accountbl.AccountController;
import bl.approvalbl.ApprovalController;
import bl.financebl.FinanceController;
import bl.orderbl.orderbl_stub;
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
	private AccountController accountController = new AccountController();
	private ApprovalController approvalController =new ApprovalController();
	private DTManageController dtManageController = new DTManageController();
	private UserController userController = new UserController();
	private StrategyController strategyController = new StrategyController();
	private PersonnelController personnelController = new PersonnelController();
	private StatisticController statisticController = new StatisticController();
	private TransportController transportController = new TransportController();
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
		return accountController;
	}
	
	public Approvalblservice getApprovalBusinessLogic(){
		return approvalController;
	}
	
	public DTManageblservice getDTManageBusinessLogic(){
		return dtManageController;
	}
	
	public UserMesblservice getUserMesBusinessLogic(){
		return userController;
		
		
	}
	
	public StrategyblService getStrategyBusinessLogic(){
		return strategyController;
	}
	
	public Personnelblservice getPersonnelBusinessLogic(){
		return personnelController;
	}
	
	public Statisticblservice getStatisticBusinessLogic(){
		return statisticController;
	}
	

	public Orderblservice getOrderBussinessLogic(){
		return new orderbl_stub();
		//return new OrderController();
	}
	
	public StrategyblService getStrategyBussinessLogic(){
		return strategyController;
	}

	public Transportblservice getTransportblservice(){
		return transportController;
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
