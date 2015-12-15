package data.statisticdata;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import po.statistic.StateFormPO;
import test.java.other.DataTool;
import util.ResultMessage;
 /** 
 * 
 * @author czq 
 * @version 2015年12月15日 下午11:04:30 
 */
public class StatisticDataImplTest {
	StatisticDataImpl test;
	@Before
	public void setUp() throws Exception {
		test = new StatisticDataImpl();
	}
	@Test
	public void testBulidStateForm() throws RemoteException {
		
		if(test.bulidStateForm(DataTool.getStateFormPO()) == ResultMessage.SUCCESS){
			return;
		}
		
		fail();
	}
	@Test
	public void testGetStateForm() throws RemoteException {
		ArrayList<StateFormPO> pos = test.getStateForm();
		if(pos != null){
			System.out.println(pos.size());
			return;
		}
		fail();
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
