package data;

import java.net.InetAddress;
import java.net.UnknownHostException;

import data.accountdata.AccountDataServiceImplBySQL;
 /** 
 * 负责初始化RMI服务
 * @author czq 
 * @version 2015年11月8日 下午11:34:57 
 */
public class RMIManage {
	
	private InetAddress hostInetAddress;
	private String hostAdr;
	private String hostName;
	
	public RMIManage() {
		try {
			hostInetAddress = InetAddress.getLocalHost();
			hostAdr = hostInetAddress.getHostAddress();
			hostName = hostInetAddress.getHostName();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean startRMI(){
//		String pre = "rmi://" + hostAdr 
		
		return false;
	}
	
	public boolean stopRMI(){
		return false;
	}
	
	
}
