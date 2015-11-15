package data.datafactory;

import java.rmi.RemoteException;

import data.DTManagedata.DTManageDataImpl;
import data.accountdata.AccountDataServiceImplBySQL;
import data.financedata.FinanceDataImpl;
import data.orderdata.OrderDataImpl;
import data.personneldata.PersonnelDataServiceImpl;
import data.statisticdata.StatisticDataImpl;
import data.storedata.StoreDataImpl;
import data.strategydata.StrategyDataImpl;
import data.transportdata.TransportDataImpl;
import ds.DTManagedataservice.DTManagedateservice;
import ds.accountdataservice.AccountDataService;
import ds.datafactoryservice.DataFactoryService;
import ds.financedataservice.FinanceDataService;
import ds.orderdataservice.OrderDataService;
import ds.personneldataservice.PersonnelDataService;
import ds.statisticdataservice.StatisticDataService;
import ds.storedataservice.StoreDataService;
import ds.strategydataservice.StrategyDataService;
import ds.transportdataservice.Transportdataservice;
 /** 
 *  数据工厂类
 * @author czq 
 * @version 2015年11月5日 下午8:43:10 
 */
public class DataFactory implements DataFactoryService{
	
	private static DataFactory dataFactory;
	
	private DataFactory() {
		
	}
	
	public static DataFactory getDataFactory(){
		if(dataFactory == null){
			dataFactory =  new DataFactory();
		}
		
		return dataFactory;
		
	}
	
	
	
	public AccountDataService getAccountDataImpl() {
		
		AccountDataServiceImplBySQL adservice = null;
		
		try {
			 adservice= new AccountDataServiceImplBySQL();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return adservice;
		
	}

	public DTManagedateservice getDTMangeDataImpl() {
		return new DTManageDataImpl();
	}

	public FinanceDataService getFinanceDataImpl() {
		return new FinanceDataImpl();
	}

	public OrderDataService getOrderDataImpl() {
		return new OrderDataImpl();
	}

	public StatisticDataService getStatisticDataImpl() {
		return new StatisticDataImpl();
	}

	public Transportdataservice getTransportDataImpl() {
		return new TransportDataImpl();
	}

	public StrategyDataService getStrategyDataImpl() {
		return new StrategyDataImpl();
	}

	public PersonnelDataService getPersonnelDataImpl() {
		PersonnelDataService pdservice=null;
		try {
			pdservice=new PersonnelDataServiceImpl();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pdservice;
	}

	public StoreDataService getStoreDataImpl() {
		return new StoreDataImpl();
	}

}
