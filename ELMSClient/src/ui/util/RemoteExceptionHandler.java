package ui.util;

import java.rmi.Remote;
 /** 
 * 
 * @author czq 
 * @version 2015年12月27日 上午9:33:02 
 */
public interface RemoteExceptionHandler {
	/**
	 * 重新获取服务
	 * @return
	 */
	public void reintitDataService(Remote dataService);
	
}
