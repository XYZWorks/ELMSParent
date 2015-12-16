package ui.config;
 /** 
 * 
 * @author czq 
 * @version 2015年12月16日 下午1:21:31 
 */
public class SimpleDataFormat {
	public String message;
	public DataType type;
	public String chineseName;
	public SimpleDataFormat(String message, DataType type,  String chineseName) {
		super();
		this.message = message;
		this.type = type;
		this.chineseName = chineseName;
	}
	
}
