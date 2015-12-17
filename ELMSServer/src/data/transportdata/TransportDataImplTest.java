package data.transportdata;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import po.transport.ArriveYYDocPO;
import util.City;
import util.DocState;
import util.DocType;
import util.GoodsState;
import util.MyDate;
 /** 
 * 
 * @author czq 
 * @version 2015年12月17日 下午10:17:38 
 */
public class TransportDataImplTest {
	TransportDataImpl test;
	@Before
	public void setUp() throws Exception {
		test = new TransportDataImpl();
	}

	@Test
	public void testAddLoadDocPO() throws RemoteException  {
//		test.addLoadDocPO(po);
	}

	@Test
	public void testAddSendGoodDocPO() throws RemoteException  {
//		test.addSendGoodDocPO(po);
	}

	@Test
	public void testAddTransferDocPO() throws RemoteException  {
//		test.addTransferDocPO(po);
	}

	@Test
	public void testAddArriveZZDocPO()  throws RemoteException {
//		test.addArriveZZDocPO(po);
	}

	@Test
	public void testAddArriveYYDocPO() throws RemoteException {
		test.addArriveYYDocPO(new ArriveYYDocPO("JSD000001", DocType.arriveYYDoc, MyDate.getNowTime(), DocState.wait, "asdasd", City.NANJING, GoodsState.Complete, null));
	}

}
