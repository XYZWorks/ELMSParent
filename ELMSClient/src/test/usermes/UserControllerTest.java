package test.usermes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
 


import util.ResultMessage;
import bl.userbl.UserController;
import blservice.usermesblservice.UserMesblservice;
/** 
 * 
 * @author czq 
 * @version 2015年11月15日 下午2:40:09 
 */
public class UserControllerTest {
	
	UserMesblservice bl;
	ResultMessage result;
	
	@Before
	public void setUp() throws Exception {
		bl = new UserController();
		
	}

	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testModify() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMes() {
		fail("Not yet implemented");
	}

}
