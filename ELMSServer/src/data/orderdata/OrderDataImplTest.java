package data.orderdata;

import static org.junit.Assert.fail;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import po.DocPO;
import po.DriverPO;
import po.order.OrderPO;
import util.DocState;
import util.DocType;
import util.MyDate;
import util.ResultMessage;
import vo.CarVO;
 /** 
 * 
 * @author czq 
 * @version 2015年11月19日 上午8:14:31 
 */
public class OrderDataImplTest {
	OrderDataImpl test1;
	static MyDate d1 = new MyDate(2015, 11, 11);
	static MyDate d2 = new MyDate(2015, 11, 12);
	static MyDate d3 = new MyDate(2015, 11, 13);
	static MyDate d4 = new MyDate(2015, 11, 14);
	static MyDate d5 = new MyDate(2015, 11, 15);
	static ArrayList<DocPO> test = null;
	static ArrayList<OrderPO> orders = new ArrayList<OrderPO>();
	static ArrayList<String> locs = new ArrayList<String>();
	static ArrayList<DriverPO> drivers = new ArrayList<DriverPO>();
	static ArrayList<CarVO>  cars = new ArrayList<CarVO>();
	
	ResultMessage result;
	@Before
	public void setUp() throws Exception {
		test1 = new OrderDataImpl();
	}

	@Test
	public void testOrderDataImpl() {
		
	}

	@Test
	public void testGetDayOrderPO() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() throws RemoteException {
		result = test1.add(new OrderPO("2311278906", DocType.order ,d1,DocState.wait, "czq", "13188907872", "nju", "常府街44号", "ymc", "13497269020",
				"hs", "仙林大道163号", 1, "book", 2, 30, 20, 10, "wood box", "fast model", 2, 20, "123" ,"123" , "123" ,"123" ,"123" ,"123" , d2));
		if(result == ResultMessage.SUCCESS){
			
		}else{
			fail("can not add");
		}
	}

	@Test
	public void testDel() throws RemoteException {
		result = test1.del("2311278906");
		
		if(result != ResultMessage.SUCCESS){
			fail("can not del");
		}
		if(result == ResultMessage.SUCCESS){
			fail("allow to delete twice");
		}
		
	}

	@Test
	public void testAddDocToList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSingleOrderPO() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSingleOrderDocs() {
		fail("Not yet implemented");
	}

	@Test
	public void testReceiveInfo() {
		fail("Not yet implemented");
	}

}
