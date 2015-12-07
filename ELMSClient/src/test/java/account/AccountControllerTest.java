package test.java.account;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.AccountType;
import util.ResultMessage;
import vo.account.AccountVO;
import bl.accountbl.AccountController;
import blservice.accountblservice.Accountblservice;


/**
 * 
 * @author czq
 * @version 2015年11月15日 下午2:37:03
 */
public class AccountControllerTest {

	Accountblservice bl;
	ResultMessage result;

	@Before
	public void setUp() throws Exception {
		bl = new AccountController();
	}

	@Test
	public void testAdd() {
		result = bl.add(new AccountVO("112233", "zxcvbn",AccountType.courier));
		//System.out.println(result.name());
		if (bl.find("112233").password.equalsIgnoreCase("zxcvbn")
				&& result == ResultMessage.SUCCESS) {
			return;
		} else {
			fail("fail to add account");
		}
		
		if(bl.add(new AccountVO("112233", "zxcvbn",AccountType.courier)) == ResultMessage.SUCCESS){
			fail("");
		}
		
	}

	@Test
	public void testDelete() {
//		result = bl.delete(new AccountVO("112233", "zxcvbn",AccountType.courier));
//
//		if (bl.find("112233") != null) {
//			fail("delete fail!!!");
//		} else if (bl.delete(new AccountVO("999999", "999999",AccountType.courier)) == ResultMessage.SUCCESS) {
//			fail("删除空账户，没有报错");
//		}
		
	}

	@Test
	public void testFind() {
		// 在其他方法实现测试
	}

	@Test
	public void testModify() {
		bl.add(new AccountVO("1111111", "1233456",AccountType.courier));
		
		result = bl.modify(new AccountVO("1111111", "aaaaaa",AccountType.courier));
		
		if(result == ResultMessage.SUCCESS && bl.find("1111111").password.equalsIgnoreCase("aaaaaa")){
			return;
		}else{
			fail("can not modify an account");
		}
	}

}
