package blservice.accountblservice;

import util.AccountType;
import util.ResultMessage;
import vo.account.AccountVO;

/** * @author czq @version 创建时间：2015年10月25日 下午2:47:45 * 简单说明 */
public class Accountblservice_Driver {
	public void drive(Accountblservice account) {
		ResultMessage result;
		AccountVO vo;
		System.out.println("添加账户：");
		result = account.add(new AccountVO("123456", "王企鹅", AccountType.courier, "123456"));
		if (result == ResultMessage.SUCCESS) {
			System.out.println("账户添加成功");
		}

		System.out.println("查找账户：111111");
		vo = account.find("111111");
		System.out.println("查找结果");

		System.out.println(vo.ID + " " + vo.name + " " + vo.mail);
		
		System.out.println("删除信息：");
//		result = account.delete(new AccountVO("111111", "wqe", AccountType.manager, "123456"));
		if(result == ResultMessage.SUCCESS){
			System.out.println("账户删除成功");
		}
		
		System.out.println("修改账户信息");
		result = account.modify(new AccountVO("123456", "azc", AccountType.storeman , "123456", "13184836488", "1300236145@qq.com"));
		if(result == ResultMessage.SUCCESS){
			System.out.println("账户修改成功");
		}
		System.out.println(vo.ID + " " + vo.name + vo.mail);


	}
}
