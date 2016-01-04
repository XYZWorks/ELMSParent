package transport;

import org.junit.Before;
import org.junit.Test;

import util.ResultMessage;
import bl.transportbl.TransportController;
import blservice.transportblservice.Transportblservice;

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
//		ArrayList<LoadDocVO> ldList = (ArrayList<LoadDocVO>) DataTool.getDocList(DocType.loadDoc);
//		LoadDocVO vo = ldList.get(0);
//		result = bl.add(vo);
//		if(!(result==ResultMessage.SUCCESS))
//			fail("Not yet implemented");
	}

	@Test
	public void testGetDayLoadDocs() {
	
//		ArrayList<LoadDocVO> vos= bl.getDayLoadDocs( new MyDate(2015, 11, 11));
//		if(vos==null)
//			fail("fail to get loadDoc");

	}

	@Test
	public void testAddSendGoodDocVO() {
//		ArrayList<SendGoodDocVO> list = (ArrayList<SendGoodDocVO>) DataTool.getDocList(DocType.sendGoodDoc);
//		SendGoodDocVO vo = list.get(0);
//		result = bl.add(vo);
//		if(!(result==ResultMessage.SUCCESS))
//			fail("Not yet implemented");
	}

	@Test
	public void testGetDaySendDocs() {
//		ArrayList<SendGoodDocVO> vos= bl.getDaySendDocs( new MyDate(2015, 11, 11));
//		if(vos==null)
//			fail("fail to get loadDoc");
	}

	@Test
	public void testAddArriveYYDocVO() {
//		ArrayList<ArriveYYDocVO> list = (ArrayList<ArriveYYDocVO>) DataTool.getDocList(DocType.arriveYYDoc);
//		ArriveYYDocVO vo = list.get(0);
//		result = bl.add(vo);
//		if(!(result==ResultMessage.SUCCESS))
//			fail("Not yet implemented");
	}

	@Test
	public void testGetDayArriveYYDocs() {
//		ArrayList<ArriveYYDocVO> vos= bl.getDayArriveYYDocs( new MyDate(2015, 11, 11));
//		if(vos==null)
//			fail("fail to get loadDoc");
	}

	@Test
	public void testAddArriveZZDocVO() {
//		ArrayList<ArriveZZDocVO> list = (ArrayList<ArriveZZDocVO>) DataTool.getDocList(DocType.arriveZZDoc);
//		ArriveZZDocVO vo = list.get(0);
//		result = bl.add(vo);
//		if(!(result==ResultMessage.SUCCESS))
//			fail("Not yet implemented");
	}

	@Test
	public void testGetDayArriveZZDocs() {
//		ArrayList<ArriveZZDocVO> vos= bl.getDayArriveZZDocs( new MyDate(2015, 11, 11));
//		if(vos==null)
//			fail("fail to get loadDoc");	
		}

	@Test
	public void testAddTransferDocVO() {
//		ArrayList<TransferDocVO> list = (ArrayList<TransferDocVO>) DataTool.getDocList(DocType.transferDoc);
//		TransferDocVO vo = (TransferDocVO)list.get(0);
//		result = bl.add(vo);
//		if(!(result==ResultMessage.SUCCESS))
//			fail("Not yet implemented");	
		}

	@Test
	public void testGetDayTransferDocs() {
//		ArrayList<TransferDocVO> vos= bl.getDayTransferDocs( new MyDate(2015, 11, 11));
//		if(vos==null)
//			fail("fail to get loadDoc");
	}

	@Test
	public void testGetDoc() {
//		ArrayList<DocVO> vos= bl.getDoc( DocType.arriveYYDoc);
//		if(vos==null)
//			fail("fail to get loadDoc");	
		}

	@Test
	public void testGetExpense() {
		
//		ArrayList<ArriveZZDocVO> l1 = (ArrayList<ArriveZZDocVO>) DataTool.getDocList(DocType.arriveZZDoc);
//		ArriveZZDocVO vo1=l1.get(0);
//		
//		ArrayList<TransferDocVO> l2 = (ArrayList<TransferDocVO>) DataTool.getDocList(DocType.transferDoc);
//		TransferDocVO vo2=l2.get(0);

// 		double money = bl.getExpense(vo1, vo2);
 		
//		if(money==0)
//			fail("money is 0");	
	}

	@Test
	public void testGetDocLists() {
		
//		ArrayList<ArriveZZDocVO> vos= (ArrayList<ArriveZZDocVO>) bl.getDocLists(DocType.arriveZZDoc);
//		
//		if(vos==null)
//			fail("fail to get loadDoc");	
	}

	@Test
	public void testChangeDocsState() {
		
		
//		ArrayList<TransferDocVO> list= (ArrayList<TransferDocVO>) DataTool.getDocList(DocType.transferDoc);
//
//		for(DocVO vo:list){
//			vo.state=DocState.pass;
//		}
//		for(DocVO vo:list){
//			if(vo.state!=DocState.pass){
//				result=ResultMessage.FAIL;
//				break;
//			}
//				
//		}
//		
//		if(!(result==ResultMessage.SUCCESS))
//			fail("fail changeDocsState");	
	}

	@Test
	public void testChangeOneDocState() {
		
//		ArrayList<TransferDocVO> list= (ArrayList<TransferDocVO>) DataTool.getDocList(DocType.transferDoc);
//		
//		TransferDocVO vo = list.get(0);
//
//		if(vo.state!=DocState.pass)
//			vo.state=DocState.pass;
//		if(list.get(0).state!=DocState.pass)
//			fail("fail");
			
			
	}

}
