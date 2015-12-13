package bl.storebl;

import java.util.ArrayList;

import po.store.StoreCheckPO;
import util.City;
import util.ResultMessage;
import vo.store.StoreCheckVO;
import vo.store.StoreMessageVO;
import ds.storedataservice.StoreDataService;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:50:20 
 *
 */
public class Store {
	private StoreDataService storeData;

	public Store(StoreDataService storeDataService) {
		storeData = storeDataService;
	}
	
	public ArrayList<StoreMessageVO> show() {
		ArrayList<StoreMessageVO> pos = storeData.g();
		return storeData.getStoreMessage();
	}

	public ArrayList<StoreCheckVO> showCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage exportExcel(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage update(StoreMessageVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage setAlarmValue(String value,City city) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getAlarmValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
