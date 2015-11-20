package ds;

import java.rmi.Remote;
import java.rmi.RemoteException;
 /** 
 * 数据层接口的接口==
 * @author czq 
 * @version 2015年11月20日 下午12:58:41 
 */
public interface DataserviceParent extends Remote{
	
	/**
	 * 初始化数据
	 */
	public void initial() throws RemoteException;
}
