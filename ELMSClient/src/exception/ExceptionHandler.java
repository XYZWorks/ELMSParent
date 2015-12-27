package exception;

import java.rmi.Remote;

import bl.BusinessController;
import ui.tools.MyOptionPane;
import util.DataServiceType;
import ds.accountdataservice.AccountDataService;


 /** 
 * 网络断线连接处理
 * @author czq 
 * @version 2015年12月26日 下午10:54:55 
 */
public class ExceptionHandler {
	public ExceptionHandler(AccountDataService accountData) {
		net.RMIManage.getDataService(DataServiceType.AccountDataService);
		new MyOptionPane(null, "网络异常，请重试！");
//		new MyThread(accountData, DataServiceType.AccountDataService);
	}
	
//	public static ExceptionMes ExceptionHandler(Remote service) {
//			service = net.RMIManage.getDataService(DataServiceType.AccountDataService);
//			if(service != null){
//				new MyOptionPane(null, "服务器已恢复正常");
//				return new ExceptionMes(service, true);
//			}else{
//				new MyOptionPane(null, "网络异常，请重试！");
//			}
//		return new ExceptionMes(null, false);
//	}
	
	public static boolean myExceptionHandler(DataServiceType myType , BusinessController controller) {
		Remote service = net.RMIManage.getDataService(type);
		if(service != null){
			new MyOptionPane(null, "服务器已恢复正常~");
			controller.reinitDataService(service);
			return true;
		}else{
			new MyOptionPane(null, "网络异常，请重试！");
		}
	return false;
}
	
//	public static Remote getDataServiceAgain(DataServiceType type) {
//		
//			new Thread(new Runnable() {
//				Remote service;
//				@Override
//				public void run() {
//					while(true){
//						service = net.RMIManage.getDataService(DataServiceType.AccountDataService);
//						if(service != null){
//							new MyOptionPane(null, "服务器已恢复正常");
//						}
//						break;
//					}
//					
//				}
//			}).start();
//		
//			
//	}
//	
//	class MyThread extends Thread{
//		DataServiceType type;
//		Object service;
//		public MyThread(Object service , DataServiceType type) {
//			this.type = type;
//			service
//			this.start();
//			
//		}
//		
//		private 
//		@Override
//		public void run() {
//			while(true){
//				service = net.RMIManage.getDataService(type);
//				if(service != null){
//					new MyOptionPane(null, "服务器已恢复正常");
//					break;
//				}
//			}
//		}
//		
//	}
	
	
}
