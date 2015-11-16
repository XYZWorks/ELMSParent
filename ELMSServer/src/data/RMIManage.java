package data;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.ExportException;

import data.datafactory.DataFactory;
 /** 
 * 负责初始化RMI服务
 * @author czq 
 * @version 2015年11月8日 下午11:34:57 
 */
public class RMIManage {
	
	private InetAddress hostInetAddress;
	private String hostAdr;
	private String hostName;
	private String port;
	private DataFactory datafactory;
	
	public RMIManage() {
		try {
			hostInetAddress = InetAddress.getLocalHost();
			hostAdr = hostInetAddress.getHostAddress();
			hostName = hostInetAddress.getHostName();
			port = "6600";
			datafactory = DataFactory.getDataFactory();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean startRMI(){
		String pres = "rmi://" + hostAdr + ":" + port +"/";
		System.out.println(pres);
		try {
			LocateRegistry.createRegistry(Integer.parseInt(port));
			Naming.rebind(pres + "AccountDataService", datafactory.getAccountDataImpl());
			Naming.rebind(pres + "DTManageDataService", datafactory.getDTMangeDataImpl());
			Naming.rebind(pres + "FinanceDataService", datafactory.getFinanceDataImpl());
			Naming.rebind(pres + "OrderDataService", datafactory.getOrderDataImpl());
			Naming.rebind(pres + "PersonnelDataService", datafactory.getPersonnelDataImpl());
			Naming.rebind(pres + "StatisticDataService", datafactory.getStatisticDataImpl());
			Naming.rebind(pres + "StoreDataService", datafactory.getStoreDataImpl());
			Naming.rebind(pres + "StrategyDataService", datafactory.getStrategyDataImpl());
			Naming.rebind(pres + "TransportDataService", datafactory.getTransportDataImpl());
			
		} catch (NumberFormatException e) {
			System.err.println("port 转换错误");
			e.printStackTrace();
		}catch (ExportException e) {
			System.err.println("端口被占用出错");
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
//		String pre = "rmi://" + hostAdr 
		
		return false;
	}
	
	public void stopRMI(){
		System.exit(0);
	}
	
	public static void main(String[] args) {
		RMIManage rmi = new RMIManage();
		rmi.startRMI();
		
		
	}
}
