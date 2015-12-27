package bl;

import java.rmi.Remote;

import util.DataServiceType;
 /** 
 * 
 * @author czq 
 * @version 2015年12月27日 上午9:38:06 
 */
public abstract class BusinessController {
	
	protected DataServiceType myType;
	
	
	public abstract void reinitDataService(Remote dataService);
	
	
}
