package data.storedata;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月23日 下午4:25:32 
 *
 */
public class StoreDataImplTest {

	@Test
	public void testInitial() {
		try {
			new StoreDataImpl().initial();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
	}

}
