package test.transport;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.transportbl.TransportController;
import blservice.transportblservice.Transportblservice;
import test.DataTool;
import util.DocState;
import util.DocType;
import util.ResultMessage;
import vo.ArriveYYDocVO;
import vo.ArriveZZDocVO;
import vo.DocVO;
import vo.LoadDocVO;
import vo.SendGoodDocVO;
import vo.TransferDocVO;

/**
 * 
 * @author czq
 * @version 2015年11月15日 下午2:39:58
 */
public class TransportControllerTest {

	Transportblservice bl;
	ResultMessage result;

	@Before
	public void setUp() throws Exception {
		bl = new TransportController();
	}

	@Test
	public void testAddLoadDocVO() {
		ArrayList<DocVO> ldList = DataTool.getDocList(DocType.loadDoc);
		LoadDocVO vo = (LoadDocVO)ldList.get(0);
		result = bl.add(vo);
		if(!(result==ResultMessage.SUCCESS))
			fail("Not yet implemented");
	}

	@Test
	public void testGetDayLoadDocs() {
	
		//在别的类中测试
	}

	@Test
	public void testAddSendGoodDocVO() {
		ArrayList<DocVO> list = DataTool.getDocList(DocType.sendGoodDoc);
		SendGoodDocVO vo = (SendGoodDocVO)list.get(0);
		result = bl.add(vo);
		if(!(result==ResultMessage.SUCCESS))
			fail("Not yet implemented");
	}

	@Test
	public void testGetDaySendDocs() {
		//在别的类中测试

	}

	@Test
	public void testAddArriveYYDocVO() {
		ArrayList<DocVO> list = DataTool.getDocList(DocType.arriveYYDoc);
		ArriveYYDocVO vo = (ArriveYYDocVO)list.get(0);
		result = bl.add(vo);
		if(!(result==ResultMessage.SUCCESS))
			fail("Not yet implemented");
	}

	@Test
	public void testGetDayArriveYYDocs() {
		//在别的类中测试
	}

	@Test
	public void testAddArriveZZDocVO() {
		ArrayList<DocVO> list = DataTool.getDocList(DocType.arriveZZDoc);
		ArriveZZDocVO vo = (ArriveZZDocVO)list.get(0);
		result = bl.add(vo);
		if(!(result==ResultMessage.SUCCESS))
			fail("Not yet implemented");
	}

	@Test
	public void testGetDayArriveZZDocs() {
		//在别的类中测试
	}

	@Test
	public void testAddTransferDocVO() {
		ArrayList<DocVO> list = DataTool.getDocList(DocType.transferDoc);
		TransferDocVO vo = (TransferDocVO)list.get(0);
		result = bl.add(vo);
		if(!(result==ResultMessage.SUCCESS))
			fail("Not yet implemented");	}

	@Test
	public void testGetDayTransferDocs() {
		//在别的类中测试
	}

	@Test
	public void testGetDoc() {
		//在别的类中测试
	}

	@Test
	public void testGetExpense() {
		//在别的类中测试
	}

	@Test
	public void testGetDocLists() {
		//在别的类中测试
	}

	@Test
	public void testChangeDocsState() {
		
		
		ArrayList<DocVO> list= DataTool.getDocList(DocType.transferDoc);

		for(DocVO vo:list){
			vo.state=DocState.pass;
		}
		for(DocVO vo:list){
			if(vo.state!=DocState.pass){
				result=ResultMessage.FAIL;
				break;
			}
				
		}
		if(!(result==ResultMessage.SUCCESS))
			fail("fail changeDocsState");	
	}

	@Test
	public void testChangeOneDocState() {
		
		ArrayList<DocVO> list= DataTool.getDocList(DocType.transferDoc);
		
		TransferDocVO vo = (TransferDocVO)list.get(0);

		if(vo.state!=DocState.pass)
			vo.state=DocState.pass;
		if(list.get(0).state!=DocState.pass)
			fail("fail");
			
			
	}

}
