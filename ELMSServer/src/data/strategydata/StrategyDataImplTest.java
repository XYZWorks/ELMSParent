package data.strategydata;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;
 





import po.strategy.SalaryWayPO;
import util.StaffType;
import data.statisticdata.StatisticDataImpl;
import ds.statisticdataservice.StatisticDataService;
import ds.strategydataservice.StrategyDataService;
/** 
 * 
 * @author czq 
 * @version 2015年11月24日 下午10:25:57 
 */
public class StrategyDataImplTest {
	StrategyDataService ds;
	@Before
	public void setUp() throws Exception {
		ds = new StrategyDataImpl();
	}

	@Test
	public void testStrategyDataImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testInitial() {
		try {
			ds.initial();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public void testGetSalary() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSalaryWay() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOneSalary() {
		try {
			SalaryWayPO po = ds.getOneSalary(StaffType.courier);
			System.out.println(po.getBasicSalary());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
