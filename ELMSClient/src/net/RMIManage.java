package net;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import util.DataServiceType;
import config.StaticMessage;

/**
 * 负责启动客户端的RMI服务
 * 
 * @author czq
 * @version 2015年11月17日 下午7:53:14
 */
public class RMIManage {

	private static String pres = StaticMessage.RMIPres;

	public RMIManage() {

	}

	/**
	 * 初始化网络
	 * 
	 * @return
	 */
	public synchronized boolean netInit() {

		return true;
	}
	
	//TODO 延迟加载 等到登录时再查询
	
	/**
	 * 获取所需数据服务
	 * @param name
	 * @return
	 */
	public static Remote getDataService(DataServiceType type) {
		try {
			return Naming.lookup(pres + type.getName());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
