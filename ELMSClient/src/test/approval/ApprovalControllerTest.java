package test.approval;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
 


import util.ResultMessage;
import bl.approvalbl.ApprovalController;
import blservice.approvalblservice.Approvalblservice;
/** 
 * 
 * @author czq 
 * @version 2015年11月15日 下午2:37:43 
 */
public class ApprovalControllerTest {
	
	Approvalblservice bl ;
	ResultMessage result;
	
	@Before
	public void setUp() throws Exception {
		bl = new ApprovalController();
	}

	@Test
	public void testGetBills() {
		fail("Not yet implemented");
	}

	@Test
	public void testApproveOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testApproveMany() {
		fail("Not yet implemented");
	}

}
