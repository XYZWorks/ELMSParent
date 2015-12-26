package exception;

import java.rmi.Remote;
 /** 
 * 
 * @author czq 
 * @version 2015年12月27日 上午12:54:45 
 */
public class ExceptionMes {
	public Remote dataservice;
	public boolean result;
	public ExceptionMes(Remote dataservice, boolean result) {
		super();
		this.dataservice = dataservice;
		this.result = result;
	}
	
}
