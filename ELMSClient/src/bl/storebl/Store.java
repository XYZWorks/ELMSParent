package bl.storebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.store.StoreCheckPO;
import po.store.StoreMessagePO;
import test.java.other.VOPOchange;
import util.City;
import util.DocType;
import util.ResultMessage;
import util.TransferWay;
import vo.DocVO;
import vo.store.InStoreDocVO;
import vo.store.OutStoreDocVO;
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
		ArrayList<StoreMessagePO> pos = new ArrayList<>();
		
		try {
			pos = storeData.getStoreMessages();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ArrayList<StoreMessageVO> vos = null;
		if(pos!=null){
			vos = new ArrayList<>(pos.size());
			for(StoreMessagePO po:pos)
				vos.add((StoreMessageVO)VOPOchange.POtoVO(po));
		}
		
		return vos;
	}

	public ArrayList<StoreCheckVO> showCheck() {
		ArrayList<StoreCheckPO> pos = null;
		try {
			pos = storeData.getCheck();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(pos == null){
			return null;
		}
		ArrayList<StoreCheckVO> vos = new ArrayList<>(pos.size());
		for (StoreCheckPO storeCheckPO : pos) {
			vos.add((StoreCheckVO) VOPOchange.POtoVO(storeCheckPO));
		}
		
		return vos;
	}

	public ResultMessage exportExcel(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage update(StoreMessageVO vo) {
		StoreMessagePO po = (StoreMessagePO) VOPOchange.VOtoPO(vo);
		
		try {
			return storeData.update(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	public ResultMessage setAlarmValue(String value,City city) {
		try {
			return storeData.setAlarmValue(value, city);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}
	
	public String getAlarmValue(City city) {
		
		try {
			return storeData.getAlarmValue(city);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage updateStore(City loc, TransferWay way,DocVO tmp) {
		ArrayList<StoreMessageVO> vos = show();
		StoreMessageVO target = null;
		for(StoreMessageVO vo : vos){
			if(vo.location==loc&&vo.storeLoc==way){
				target = vo;
				break;
			}
		}
		if(target==null){
			return ResultMessage.FAIL;
			
		}
		if(DocType.inStoreDoc==tmp.type){
			InStoreDocVO vo = (InStoreDocVO)tmp;
			target.inStoreDocs.add(vo);
			int addNum = vo.orders.size();
			target.number = target.number+addNum;
			
		}
		else if(DocType.outStoreDoc==tmp.type){
			OutStoreDocVO vo = (OutStoreDocVO)tmp;
			target.OutStoreDocs.add(vo);
			int delNum = vo.orders.size();
			target.number = target.number-delNum;
		}
		return update(target);
	}

}
