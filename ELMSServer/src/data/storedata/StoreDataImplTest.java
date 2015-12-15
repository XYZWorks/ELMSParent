package data.storedata;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
 





import po.store.StoreMessagePO;
import test.java.other.DataTool;
import ui.inital.testframeforczq;
import util.ResultMessage;
/** 
 * 
 * @author czq 
 * @version 2015年12月15日 下午10:53:40 
 */
public class StoreDataImplTest {
	StoreDataImpl test;
	@Before
	public void setUp() throws Exception {
		test = new StoreDataImpl();
	}

	@Test
	public void testUpdate() {
		if(test.update(DataTool.getStoreMessagePO()) == ResultMessage.SUCCESS){
			return;
		}
		fail();
	}

	@Test
	public void testGetStoreMessages() throws RemoteException {
		ArrayList<StoreMessagePO> pos = test.getStoreMessages();
		
		
		if(pos != null){
			System.out.println(pos.size());
			return;
		}
		
		fail("Not yet implemented");
	}

	@Test
	public void testStoreCheck() {
		fail("Not yet implemented");
	}

}
