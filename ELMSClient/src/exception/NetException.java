package exception;
 /** 
 * 
 * @author czq 
 * @version 2015年12月13日 下午5:34:42 
 */
@SuppressWarnings("serial")
public class NetException extends Exception {
	
	public NetException() {
		// TODO Auto-generated constructor stub
	}
	public NetException(String meString) {
		super(meString);
	}
	
}
