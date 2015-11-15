package test.strategy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
 


import util.ResultMessage;
import bl.strategybl.StrategyController;
import blservice.strategyblservice.StrategyblService;
/** 
 * 
 * @author czq 
 * @version 2015年11月15日 下午2:39:44 
 */
public class StrategyControllerTest {
	
	StrategyblService bl ;
	ResultMessage result;
	
	@Before
	public void setUp() throws Exception {
		bl = new StrategyController();
		
	}

	@Test
	public void testGetConst() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetConst() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetsalary() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOneSalary() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSalary() {
		fail("Not yet implemented");
	}

}
