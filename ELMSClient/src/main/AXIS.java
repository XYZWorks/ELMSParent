package main;

import java.rmi.RemoteException;

import po.account.AccountPO;
import util.AccountType;
import util.DataServiceType;
import net.RMIManage;
import ds.accountdataservice.AccountDataService;

 /** 
 * 程序入口
 * @author czq 
 * @version 2015年11月17日 下午8:37:52 
 */
public class AXIS {
	
	
	
	public static void main(String[] args) throws RemoteException {
		
		//启动登陆界面（在登陆界面构造函数中启动RMI服务）
		//new loginFrame();
		AccountDataService accountds = (AccountDataService) RMIManage.getDataService(DataServiceType.AccountDataService);
		accountds.add(new AccountPO("123455", "czq", AccountType.Adminstrator, "123456"));
		System.out.println(accountds.find("123455").getPassword());;
	}
}
