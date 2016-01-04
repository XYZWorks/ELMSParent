

import junit.framework.TestCase;
import order.OrderControllerTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import personnel.PersonnelControllerTest;
import statistic.StatisticControllerTest;
import store.StoreControllerTest;
import strategy.StrategyControllerTest;
import DTManage.DTManageControllerTest;
import account.AccountControllerTest;
import approval.ApprovalControllerTest;
import finace.FinanceControllerTest;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月20日 下午2:34:22 
 *
 */
@RunWith(Suite.class)  
@Suite.SuiteClasses({   
	AccountControllerTest.class,
	ApprovalControllerTest.class,
	DTManageControllerTest.class,
	FinanceControllerTest.class,

	OrderControllerTest.class,
	PersonnelControllerTest.class,
	StatisticControllerTest.class,
	
	StoreControllerTest.class,
    StrategyControllerTest.class,   
    
})
public class TestAll extends TestCase{
	


}
