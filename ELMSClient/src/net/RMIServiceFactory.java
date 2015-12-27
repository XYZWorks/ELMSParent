package net;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import ds.accountdataservice.AccountDataService;
import util.AccountType;
import util.DataServiceType;
 /** 
 * 
 * @author czq 
 * @version 2015年12月26日 下午11:50:55 
 */
public class RMIServiceFactory {
	
	public static AccountDataService accountDataService;
	
	private static RMIServiceFactory rmiServiceFactory;
	
	
	private RMIServiceFactory() {
		try {
			accountDataService = (AccountDataService) RMIManage.mygetDataService(DataServiceType.AccountDataService);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			
		}
	}
	static{
		try {
			accountDataService = (AccountDataService) RMIManage.mygetDataService(DataServiceType.AccountDataService);
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
		
		
	}
	
	public static void getServiceAgain(){
		getAgain();
	}
	
	private static void getAgain(){
		try {
			accountDataService = (AccountDataService) RMIManage.mygetDataService(DataServiceType.AccountDataService);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			getAgain();
		}
	}
}
