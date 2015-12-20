package test.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import junit.framework.JUnit4TestAdapter;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import test.java.DTManage.DTManageControllerTest;
import test.java.account.AccountControllerTest;
import test.java.approval.ApprovalControllerTest;
import test.java.finace.FinanceControllerTest;
import test.java.order.OrderControllerTest;
import test.java.personnel.PersonnelControllerTest;
import test.java.statistic.StatisticControllerTest;
import test.java.store.StoreControllerTest;
import test.java.strategy.StrategyControllerTest;

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
