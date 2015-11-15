package test.finace;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
 






import util.ResultMessage;
import bl.financebl.FinanceController;
import blservice.financeblservice.BankAccountService;
import blservice.financeblservice.CostService;
import blservice.financeblservice.DepositService;
import blservice.financeblservice.PayService;
import blservice.financeblservice.ProfitService;
/** 
 * 
 * @author czq 
 * @version 2015年11月15日 下午2:38:47 
 */
public class FinanceControllerTest {
	
	BankAccountService bankbl;
	CostService costbl;
	DepositService depositbl;
	PayService paybl;
	ProfitService profitbl;
	ResultMessage result;
	FinanceController controller;
	
	
	@Before
	public void setUp() throws Exception {
		controller = new FinanceController();
		bankbl = controller;
		costbl = controller;
		depositbl = controller;
		paybl = controller;
		profitbl = controller;
	}

	@Test
	public void testGetMessage() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	public void testModify() {
		fail("Not yet implemented");
	}

	@Test
	public void testDel() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowCosts() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowPays() {
		fail("Not yet implemented");
	}

}
