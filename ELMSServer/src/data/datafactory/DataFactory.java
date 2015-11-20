package data.datafactory;

import java.rmi.RemoteException;

import data.DTManagedata.DTManageDataImpl;
import data.accountdata.AccountDataServiceImpl;
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
 * 数据工厂类
 * 
 * @author czq
 * @version 2015年11月5日 下午8:43:10
 */
public class DataFactory implements DataFactoryService {

	private static DataFactory dataFactory;

	private DataFactory() {

	}

	public static DataFactory getDataFactory() {
		if (dataFactory == null) {
			dataFactory = new DataFactory();
		}

		return dataFactory;

	}

	public AccountDataService getAccountDataImpl() throws RemoteException {
		return new AccountDataServiceImpl();
	}

	public DTManagedateservice getDTMangeDataImpl() throws RemoteException {
		return new DTManageDataImpl();
	}

	public FinanceDataService getFinanceDataImpl() throws RemoteException {
		return new FinanceDataImpl();
	}

	public OrderDataService getOrderDataImpl() throws RemoteException {
		return new OrderDataImpl();
	}

	public StatisticDataService getStatisticDataImpl() throws RemoteException {
		return new StatisticDataImpl();
	}

	public Transportdataservice getTransportDataImpl() throws RemoteException {
		return new TransportDataImpl();
	}

	public StrategyDataService getStrategyDataImpl() throws RemoteException {
		return new StrategyDataImpl();
	}

	public PersonnelDataService getPersonnelDataImpl() throws RemoteException {
		PersonnelDataService pdservice = null;
		try {
			pdservice = new PersonnelDataServiceImpl();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pdservice;
	}

	public StoreDataService getStoreDataImpl() throws RemoteException {
		return new StoreDataImpl();
	}

}
