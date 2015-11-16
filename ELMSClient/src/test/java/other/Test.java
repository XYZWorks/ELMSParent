package other;

import java.util.Date;

import blservice.accountblservice.AccountblService_Stub;
import blservice.accountblservice.Accountblservice_Driver;
import blservice.financeblservice.CostService_Driver;
import blservice.financeblservice.CostService_Stub;
import blservice.storeblservice.StoreService_Driver;
import blservice.storeblservice.StoreService_Stub;
 /** * @author czq @version 创建时间：2015年10月25日 下午2:57:28 * 简单说明 */
public class Test {
	public static void main(String[] args) {
		
		Accountblservice_Driver accountDriver = new Accountblservice_Driver();
		accountDriver.drive(new AccountblService_Stub());
		System.out.println("-----------------------------------");
		StoreService_Driver storeDriver=new StoreService_Driver();
		storeDriver.drive(new StoreService_Stub());
		System.out.println("-----------------------------------");
		CostService_Driver costDriver=new CostService_Driver();
		costDriver.drive(new CostService_Stub());
		
	}
	
	
	
}
