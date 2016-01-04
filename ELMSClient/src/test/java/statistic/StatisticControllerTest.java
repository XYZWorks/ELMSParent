package statistic;

import org.junit.Before;
import org.junit.Test;

import util.ResultMessage;
import vo.statistic.StateFormVO;
import bl.DataTool;
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
		StateFormVO vo = DataTool.getStateForm();
//		result = bl.bulidStateForm(vo);
//		if(result!=ResultMessage.SUCCESS)
//			fail("fail to build state form");
			
	}

	@Test
	public void testBulidCostIncomeForm() {
//		CostIncomeVO vo = DataTool.getCostIncomeForm();
//		result = bl.bulidCostIncomeForm(vo);
//		System.out.println("---------------------------");
//		System.out.println(result);
//		if(result!=ResultMessage.SUCCESS)
//			fail("fail to build income form");
	}

	@Test
	public void testGetStateForm() {
//		
//		ArrayList<StateFormVO> list = bl.getStateForm();
//				
//			if(list.isEmpty())
//				fail("Not get form");
	}

	@Test
	public void testGetIncomeForm() {
		
//		ArrayList<CostIncomeVO> list = bl.getIncomeForm();
//		
//		if(list.isEmpty())
//			fail("Not get form");
	}

	@Test
	public void testBulidBill() {
		
//		BillVO vo = DataTool.getBill();
//		
//		result = bl.bulidBill(vo);
//		
//		if(result!=ResultMessage.SUCCESS)
//			fail("fail to build bill");
	}

	@Test
	public void testGetBills() {
		
//		ArrayList<BillVO> vos= bl.getBills();
//		
//		if(vos==null)
//			fail("fail to get bill");
	}

}
