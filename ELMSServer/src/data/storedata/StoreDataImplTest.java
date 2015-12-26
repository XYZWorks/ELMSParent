package data.storedata;

import org.junit.Test;

import util.DocType;
import util.MyDate;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月23日 下午4:25:32 
 *
 */
public class StoreDataImplTest {

//	@Test
//	public void testInitial() {
//		try {
//			new StoreDataImpl().initial();
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//		
//		
//	}
	@Test
	public void testGetDocCount() throws Exception{
		System.out.println(new StoreDataImpl().getDayDocCount(DocType.inStoreDoc , MyDate.getNowTime()));;
	}
	
	
}
