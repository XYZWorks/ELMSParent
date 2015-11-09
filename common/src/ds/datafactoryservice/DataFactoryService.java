package ds.datafactoryservice;

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
 * @author czq 
 * @version 2015年11月5日 下午7:06:59 
 */
public interface DataFactoryService {
	
	public AccountDataService getAccountDataImpl();
	
	public DTManagedateservice getDTMangeDataImpl();
	
	public FinanceDataService getFinanceDataImpl();
	
	public OrderDataService getOrderDataImpl();
	
	public StatisticDataService getStatisticDataImpl();
	
	public Transportdataservice getTransportDataImpl();
	
	public StrategyDataService getStrategyDataImpl();
	
	public PersonnelDataService getPersonnelDataImpl();
	
	public StoreDataService getStoreDataImpl();
}
