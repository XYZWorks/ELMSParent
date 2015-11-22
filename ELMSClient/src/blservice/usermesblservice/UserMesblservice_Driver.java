package blservice.usermesblservice;

import util.AccountType;
import util.ResultMessage;
import vo.account.AccountVO;
 /** * @author czq @version 创建时间：2015年10月25日 下午4:26:47 * 简单说明 */
public class UserMesblservice_Driver {
	public void drive(UserMesblservice bl){
		ResultMessage result;
		
		System.out.println("判断登录是否成功");
		result = bl.login(new AccountVO("123456", null, null, "123456"));
		if(result == ResultMessage.SUCCESS){
			
			System.out.println("登录成功");
		}
		
		
		System.out.println("获得用户信息");
		AccountVO temp = bl.getMes("123456");
		System.out.println("获得成功，信息为:");
		System.out.println(temp.ID + temp.mail + temp.name + "......");
		
		
		System.out.println("修改用户信息");
		result = bl.modify(new AccountVO("123456", "czq", AccountType.financeman, "123456", "13183822344", "1300236145@qq.com"));
if(result == ResultMessage.SUCCESS){
			
			System.out.println("修改成功");
		}
				
		
		
	}
}
