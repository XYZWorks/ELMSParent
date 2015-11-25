package main;

import java.rmi.RemoteException;

import ui.login.LoginFrame;

 /** 
 * 程序入口
 * @author czq 
 * @version 2015年11月17日 下午8:37:52 
 */
public class AXIS {
	
	
	
	public static void main(String[] args) throws RemoteException {
		
		//启动登陆界面（在登陆界面构造函数中启动RMI服务）
		new LoginFrame(null);
		
	}
}
