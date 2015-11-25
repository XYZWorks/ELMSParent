package util;
 /** 
 * 
 * @author czq 
 * @version 2015年11月17日 下午8:31:56 
 */
public enum DataServiceType {
	
	AccountDataService("AccountDataService"),
	DTManageDataService("DTManageDataService"),
	FinanceDataService("FinanceDataService"),
	OrderDataService("OrderDataService"),
	PersonnelDataService("PersonnelDataService"),
	StrategyDataService("StrategyDataService"),
	StoreDataService("StoreDataService"),
	StatisticDataService("StatisticDataService"),
	TransportDataService("TransportDataService");
	
	private DataServiceType(String name){
		this.name = name;
	}
	
	private String name;
	
	public String getName(){
		return this.name;
	}
	
}
