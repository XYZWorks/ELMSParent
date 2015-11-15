package test.transport;

import static org.junit.Assert.fail;

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
		fail("Not yet implemented");
	}

	@Test
	public void testGetDayLoadDocs() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddSendGoodDocVO() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDaySendDocs() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddArriveYYDocVO() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDayArriveYYDocs() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddArriveZZDocVO() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDayArriveZZDocs() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddTransferDocVO() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDayTransferDocs() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDoc() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetExpense() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDocLists() {
		fail("Not yet implemented");
	}

	@Test
	public void testChangeDocsState() {
		fail("Not yet implemented");
	}

	@Test
	public void testChangeOneDocState() {
		fail("Not yet implemented");
	}

}
