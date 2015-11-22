package test.java.data;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.sql.ResultSet;

import org.junit.Before;
import org.junit.Test;
 




import util.ResultMessage;
import data.DTManagedata.DTManageDataImpl;
import ds.DTManagedataservice.DTManagedataservice;
/** 
 * 
 * @author czq 
 * @version 2015年11月17日 上午12:31:41 
 */
public class DTManageDataImplTest {
	DTManagedataservice ds;
	ResultMessage result;
	@Before
	public void setUp() throws Exception {
		ds = new DTManageDataImpl();
	}

	@Test
	public void testDTManageDataImpl() {}

	@Test
	public void testGetDriverMes() throws RemoteException {
		ds.initial();
		
	}

	@Test
	public void testGetCarMes() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddDriverPO() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddCarPO() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateDriverPo() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateCarPo() {
		fail("Not yet implemented");
	}

}
