package test.java.data;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;
 






import po.DTManage.CarPO;
import util.ResultMessage;
import data.DTManagedata.DTManageDataImpl;
import ds.DTManagedataservice.DTManagedataservice;
/** 
 * 
 * @author czq 
 * @version 2015年11月19日 上午9:44:05 
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
	public void testGetDriverMes() {
		
	}

	@Test
	public void testGetCarMes() {
		
	}

	@Test
	public void testAddDriverPO() throws RemoteException {
//		ds.initial();
//		result = ds.addCarPO(new CarPO("123344" , "123123",  "粤A345WQ"  , 5));
//		if(result == ResultMessage.SUCCESS){
//			
//		}else
//		{
//			fail();
//		}
	}

	@Test
	public void testAddCarPO() {
		
	}

	@Test
	public void testUpdateDriverPo() throws RemoteException {
		ds.initial();
//		ds.addCarPO(new CarPO("123456", "123166" ,  "粤A345WQ"  , 5));
//		ds.updateCarPo(new CarPO("123459", "123123" ,  "粤A3453Q"  ,6));
//		CarPO po = ds.getCarMes("123123");
//		System.out.println(po==null);
//		
//		
//		if(po.getPlateNum().equalsIgnoreCase("粤A3453Q")){
//
//		}else{
//			fail();
//		}
		
		
		
	}

	@Test
	public void testUpdateCarPo() {
		
	}

}
