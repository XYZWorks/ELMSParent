package test.java.usermes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.AccountType;
import util.ResultMessage;
import vo.account.AccountVO;
import bl.accountbl.AccountController;
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
	AccountController ac;

	@Before
	public void setUp() throws Exception {
		bl = new UserController();
		ac = new AccountController();

	}

	@Test
	public void testLogin() {
//		AccountType type  = bl.login(new AccountVO("0001", "123456", AccountType.courier));
//		//System.out.println(result);
//		if (type != AccountType.courier) {
//			
//			fail("Not yet implemented");
//		} else {
//			if (ac.find("0001") == null) {
//				fail("Not exist!");
//			} else if (!ac.find("0001").password.equals("123456")) {
//				fail("Wrong password");
//			}
//		}
	}

	@Test
	public void testModify() {
		result = bl.modify(new AccountVO("0001", "123456", AccountType.courier));
		if (result != ResultMessage.SUCCESS) {
			fail("Not yet implemented");
		} else {
			if (ac.find("0001") == null) {
				fail("No exist");
			} else if (!ac.find("0001").password.equals("123456")) {
				fail("Modify fail");
			}
		}

	}

	@Test
	public void testGetMes() {
		// 由其他类测试
	}

}
