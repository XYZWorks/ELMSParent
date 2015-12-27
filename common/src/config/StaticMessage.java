package config;
 /** 
 * 存放一些静态数据
 * @author czq 
 * @version 2015年11月17日 下午8:19:10 
 */
public class StaticMessage {
	
	public static String RMIPres = "rmi://127.0.0.1:6600/";
	
	public static final String IMAGE_PATH = "image//";
	
	public static final String xmlPath = "docs//";
	
	public static final String ICON_PATH = "element//";
	
	public static final String MAIN_WINDOW = "mainWindow";
	
	public static void setPort(String ip) {
		if(ip!=null&&!ip.equals(""))
			RMIPres = "rmi://"+ip+":6600/";
		
	}
}
