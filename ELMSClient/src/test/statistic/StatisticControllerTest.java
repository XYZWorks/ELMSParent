package test.statistic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
 


import util.ResultMessage;
import bl.statisticbl.StatisticController;
import blservice.statisticblservice.Statisticblservice;
/** 
 * 
 * @author czq 
 * @version 2015年11月15日 下午2:39:20 
 */
public class StatisticControllerTest {
	
	Statisticblservice bl;
	ResultMessage result;
	
	
	@Before
	public void setUp() throws Exception {
		bl = new StatisticController();
	}

	@Test
	public void testBulidStateForm() {
		fail("Not yet implemented");
	}

	@Test
	public void testBulidCostIncomeForm() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStateForm() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIncomeForm() {
		fail("Not yet implemented");
	}

	@Test
	public void testBulidBill() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBills() {
		fail("Not yet implemented");
	}

}