package test.approval;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import test.DataTool;
import util.DocType;
import util.ResultMessage;
import vo.DocVO;
import bl.approvalbl.ApprovalController;
import blservice.approvalblservice.Approvalblservice;

/**
 * 
 * @author czq
 * @version 2015年11月15日 下午2:37:43
 */
public class ApprovalControllerTest {

	Approvalblservice bl;
	ResultMessage result;
	MockDocs docs;
	ArrayList<DocVO> docsVO;

	@Before
	public void setUp() throws Exception {
		bl = new ApprovalController();
	}

	@Test
	public void testGetBills() {
		docsVO = bl.getBills(DocType.arriveYYDoc);
		if (docsVO == null) {
			fail("can not get the bills");
		}
	}

	@Test
	public void testApproveOne() {
		docsVO = docs.getDocLists(DocType.arriveYYDoc);
		result = bl.approveOne(docsVO.get(0));
		if (result == ResultMessage.SUCCESS) {
			
		} else {
			fail("fail to approve one doc");
		}

	}

	@Test
	public void testApproveMany() {
		docsVO = DataTool.getDocList(DocType.arriveYYDoc);
		if(bl.approveMany(docsVO) == ResultMessage.SUCCESS){
			
		}else{
			fail("fail to approve many docs");
		}
	}

}
