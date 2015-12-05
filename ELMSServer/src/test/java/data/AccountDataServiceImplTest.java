package test.java.data;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;
 





import data.accountdata.AccountDataServiceImpl;
import po.account.AccountPO;
import util.AccountType;
import util.ResultMessage;
/** 
 * 
 * @author czq 
 * @version 2015年11月19日 上午8:55:01 
 */
public class AccountDataServiceImplTest {
	AccountDataServiceImpl test ;
	ResultMessage result ;
	@Before
	public void setUp() throws Exception {
		test = new AccountDataServiceImpl();
	}

	@Test
	public void testAccountDataServiceImpl() {
	}

	@Test
	public void testAdd() throws RemoteException {
		test.initial();
		result = test.add(new AccountPO("111111", "czq", AccountType.courier, "123", "1231111", "123"));
		if(result == ResultMessage.SUCCESS){
			
		}else if(result == ResultMessage.hasExist){
			
			System.out.println("has exist");
		}else{
			fail();
		}
	}

	@Test
	public void testInitial() throws RemoteException {}

	@Test
	public void testFind() throws RemoteException {
		test.initial();
		test.add(new AccountPO("123456", "陈自强", AccountType.manager, "123566"));
		AccountPO po = test.find("123456");
		AccountPO po2 = test.find("111111");
		if(po == null || po2!= null){
			fail();
		}else{
//			System.out.println(po.getID() + " " + po.getName());
		}
		
	}

	@Test
	public void testDelete() throws RemoteException {
		test.initial();
		test.add(new AccountPO("123456", "陈自强", AccountType.manager, "123566"));
		if(test.delete("123456") == ResultMessage.FAIL){
			fail();
		}
		

	}

	@Test
	public void testModify() throws RemoteException {
		test.initial();
		test.add(new AccountPO("123456", "陈自强", AccountType.manager, "123566"));
		result = test.modify(new AccountPO("123456", "asd强", AccountType.manager, "123236"));
		if(result == ResultMessage.FAIL){
			fail();
		}
		AccountPO po = test.find("123456");
		if(po.getName().equalsIgnoreCase("asd强")){
			
		}else{
			fail();
		}
		
		
	}

//	@Test
//	public void testCheck() throws RemoteException {
//		test.initial();
//		test.add(new AccountPO("123456", "陈自强", AccountType.manager, "123566"));
//		if(test.check("123456", "123500") == ResultMessage.SUCCESS){
//			fail();
//		};
//		if(test.check("123400", "123566") == ResultMessage.SUCCESS){
//			fail();
//		};
//		if(test.check("123456", "123566") == ResultMessage.FAIL){
//			fail();
//		};
//		
//	}

	@Test
	public void testGetMes() {
	}


}
