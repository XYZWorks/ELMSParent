package test.java.finace;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import test.java.other.DataTool;
import util.CostType;
import util.ResultMessage;
import vo.finance.CostVO;
import vo.finance.DepositVO;
import vo.finance.ProfitVO;
import bl.financebl.FinanceController;
import blservice.financeblservice.BankAccountBusinessService;
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
	
	BankAccountBusinessService bankbl;
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
//		ProfitVO vo = profitbl.getMessage();
//		if(vo != null ){
//			return;
//		}
//		
//		fail("can not get profit mes");
	}

	@Test
	public void testCreate() {
//		result = paybl.create(DataTool.getpays().get(0));
//		if(result == ResultMessage.SUCCESS){
//			return;
//		}
//		fail("can not create profitvo");
	}

	@Test
	public void testAdd() {
//		result = costbl.add(DataTool.getcosts().get(0));
//		
//		if(result == ResultMessage.SUCCESS || result == ResultMessage.hasExist){
//			return;
//		}
//		fail("can not add costvo");
	}

	@Test
	public void testModify() {
//		ArrayList<CostVO> temp = costbl.showCosts();
//		if(temp.size() == 0){
//			fail("can not show cost");
//		}else{
//			temp.get(0).costType = CostType.FREIGHT;
//			result  =  costbl.modify(temp.get(0));
//			if(result == ResultMessage.SUCCESS ){
//				return;
//			}
//			
//		}
//		fail("can not modify cost ");
		
	}

	@Test
	public void testDel() {
		costbl.add(DataTool.getcosts().get(0));
		result =  costbl.del(DataTool.getcosts().get(0));
		if(result == ResultMessage.FAIL){
			fail("can not del");
		}
		result = costbl.del(DataTool.getcosts().get(0));
		if(result == ResultMessage.SUCCESS){
			fail("allow to delete twice");
		}
	}

	@Test
	public void testShowCosts() {
		//在testmodify方法测试
	}

	@Test
	public void testShowPays() {
		//在其他方法测试
	}
	@Test
	public void testCreateDeposit() {
//		result = depositbl.createDeposit(DataTool.getDeposits().get(0));
//		if(result ==ResultMessage.SUCCESS){
//			return;
//		}
//		fail("can ot return deposit");
	}

	@Test
	public void testShowDeposit() {
//		ArrayList<DepositVO> temp = depositbl.showDeposit();
//		if(temp.size() == 0){
//			fail("can not get deposits");		
//			}
	}
}
