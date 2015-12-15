package data.transportdata;

import static org.junit.Assert.fail;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import po.transport.ArriveZZDocPO;
import test.java.other.DataTool;
import test.java.other.VOPOchange;
import util.DocType;
import util.ResultMessage;
 /** 
 * 
 * @author czq 
 * @version 2015年12月5日 上午11:46:53 
 */
public class TransportDataImplTest {
	TransportDataImpl test;
	@Before
	public void setUp() throws Exception {
		test = new TransportDataImpl();
	}

	@Test
	public void testGetArriveZZDocPO() {
		ResultMessage resultMessage = null;
		try {
			resultMessage = test.addArriveZZDocPO((ArriveZZDocPO)VOPOchange.VOtoPO(DataTool.getDocList(DocType.arriveZZDoc).get(0)));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(resultMessage);
		if(resultMessage!=ResultMessage.SUCCESS)
		fail("Not yet implemented");
	}

	@Test
	public void testAddArriveZZDocPO() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDocLists() throws RemoteException {
//		ArrayList<ArriveZZDocPO> pos =  (ArrayList<ArriveZZDocPO>) test.getDocLists(DocType.arriveZZDoc);
//		System.out.println(pos.size());
//		System.out.println(pos.get(0).getID());
		
		
		fail("Not yet implemented");
	}

}
