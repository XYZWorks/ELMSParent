package ds.datafactoryservice;

import java.rmi.RemoteException;

import ds.DTManagedataservice.DTManagedateservice;
import ds.accountdataservice.AccountDataService;
import ds.financedataservice.FinanceDataService;
import ds.orderdataservice.OrderDataService;
import ds.personneldataservice.PersonnelDataService;
import ds.statisticdataservice.StatisticDataService;
import ds.storedataservice.StoreDataService;
import ds.strategydataservice.StrategyDataService;
import ds.transportdataservice.Transportdataservice;

/**
 * 数据工厂
 * 
 * @author czq
 * @version 2015年11月5日 下午7:06:59
 */
public interface DataFactoryService {

	public AccountDataService getAccountDataImpl() throws RemoteException;

	public DTManagedateservice getDTMangeDataImpl() throws RemoteException;

	public FinanceDataService getFinanceDataImpl() throws RemoteException;

	public OrderDataService getOrderDataImpl() throws RemoteException;

	public StatisticDataService getStatisticDataImpl() throws RemoteException;

	public Transportdataservice getTransportDataImpl() throws RemoteException;

	public StrategyDataService getStrategyDataImpl() throws RemoteException;

	public PersonnelDataService getPersonnelDataImpl() throws RemoteException;

	public StoreDataService getStoreDataImpl() throws RemoteException;
}
