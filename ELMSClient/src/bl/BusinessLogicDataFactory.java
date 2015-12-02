package bl;

import bl.DTManagebl.DTManageController;
import bl.accountbl.AccountController;
import bl.approvalbl.ApprovalController;
import bl.strategybl.StrategyController;
import bl.userbl.UserController;
import bl.userbl.UserMes;
import blservice.DTManageblservice.DTManageblservice;
import blservice.accountblservice.Accountblservice;
import blservice.approvalblservice.Approvalblservice;
import blservice.strategyblservice.StrategyblService;
import blservice.usermesblservice.UserMesblservice;
/** 
 * 逻辑层工厂类
 * @author czq 
 * @version 2015年11月24日 下午11:49:56 
 */
public class BusinessLogicDataFactory {
	
	private static BusinessLogicDataFactory factory;
	
	
	private BusinessLogicDataFactory() {}
	
	public static BusinessLogicDataFactory getFactory(){
		if(factory == null){
			factory = new BusinessLogicDataFactory();
		}
		
		return factory;
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
	
	
}
