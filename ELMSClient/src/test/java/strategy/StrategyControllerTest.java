package test.java.strategy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
 


import util.ResultMessage;
import util.StaffType;
import util.WageStrategy;
import vo.strategy.SalaryWayVO;
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
//		 if(bl.getConst()==null)
//			 fail("fail to get");
	}

	@Test
	public void testSetConst() {
//		ConstVO vo=new ConstVO(132, 221, 332, 412, 521, 621, 71, 8, 23, 41, 14, 2, null);
//		result = bl.setConst(vo);
//		if(result!=ResultMessage.SUCCESS)
//			fail("Not yet implemented");
	}

	@Test
	public void testGetsalary() {
		if(bl.getsalary()==null)
			 fail("fail to get");
	}

	@Test
	public void testGetOneSalary() {
		if(bl.getOneSalary(StaffType.driver)==null)
			 fail("fail to get driver");
		if(bl.getOneSalary(StaffType.courier)==null)
			 fail("fail to get courier");
		if(bl.getOneSalary(StaffType.saleman)==null)
			 fail("fail to get saleman");
	}

	@Test
	public void testSetSalary() {
		SalaryWayVO vo = new SalaryWayVO(StaffType.courier, 1000, 3000, WageStrategy.byTimes);
		result = bl.setSalary(vo);
		System.out.println(result);
		if(result!=ResultMessage.SUCCESS)
			fail("Not yet implemented");
	}

}
