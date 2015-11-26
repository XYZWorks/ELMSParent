package main;

import data.RMIServer;


 /** 
 * 服务端启动类
 * @author czq 
 * @version 2015年11月8日 下午11:45:30 
 */
public class ServerMain {
	
	public static void main(String[] args) {
		//启动RMI
		RMIServer server = new RMIServer();
		if(server.startRMI()){
			
			System.out.println("服务器端运行中--------------------------");
		}
		
		//生成窗口
		
		
		
		
	}
	
	
}
