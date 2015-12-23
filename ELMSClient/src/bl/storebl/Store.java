package bl.storebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.sound.midi.Synthesizer;

import po.store.StoreCheckPO;
import po.store.StoreMessagePO;
import test.java.other.DataTool;
import test.java.other.ExportExcel;
import test.java.other.VOPOchange;
import ui.generalmanager.salary.SalaryStrategyMesTablePanel;
import ui.inital.initialPanel3;
import util.City;
import util.DocType;
import util.ResultMessage;
import util.TransferWay;
import vo.DocVO;
import vo.store.InStoreDocVO;
import vo.store.OutStoreDocVO;
import vo.store.StoreCheckVO;
import vo.store.StoreMessageVO;
import vo.store.StoreShowVO;
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
//			System.out.println("pos size ------"+pos.size());
			if(pos.size()==0){
				initial();
				pos = storeData.getStoreMessages();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		ArrayList<StoreMessageVO> vos = new ArrayList<>();
		if(pos!=null){
			
//			System.err.println(pos.get(0).getTotalNum());
			for(StoreMessagePO po:pos)
				vos.add((StoreMessageVO)VOPOchange.POtoVO(po));
		}
//		System.err.println(vos.get(0).totalNum);
		return vos;
	}

	private void initial() {
		ArrayList<StoreMessageVO> vos = DataTool.getStoreMessage();
		
		for(StoreMessageVO vo: vos)
			update(vo);
		
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

	public ResultMessage exportExcel(String path,StoreMessageVO vo) {
		StoreShowVO storevo = new StoreShowVO();
		
		storevo.location = vo.location;
		storevo.number = vo.number;
		storevo.totalNum = vo.totalNum;
		storevo.storeLoc = vo.storeLoc;
		for (int i = 0; i < vo.inStoreDocs.size(); i++) {
			storevo.inStoreDocs.add(vo.inStoreDocs.get(i).ID);
		}
		for (int i = 0; i < vo.outStoreDocs.size(); i++) {
			storevo.outStoreDocs.add(vo.outStoreDocs.get(i).ID);
		}
		getOrders(vo.inStoreDocs, vo.outStoreDocs, storevo);
		return ExportExcel.exportExcel(path, storevo);
	}
	
	private boolean hasOut(String ord,ArrayList<String> ordertmp) {
		
		for(String tmp : ordertmp){
			if(ord.equals(tmp)){
				return true;
			}
		}
			
		return false;
	}
	
	public void getOrders(ArrayList<InStoreDocVO> ins,ArrayList<OutStoreDocVO> outs,StoreShowVO storevo){
		ArrayList<String> ordertmp = new ArrayList<>();
		//得到出库单中的订单号
		for(OutStoreDocVO out : outs){
			for(String order : out.orders)
				ordertmp.add(order);
		}
		
		//将已经出库的订单从订单列表删除
		for(InStoreDocVO in : ins){
			for(int i =0;i<in.orders.size();i++){
				if(hasOut(in.orders.get(i),ordertmp)){
					continue;
				}
				
				storevo.orders.add(in.orders.get(i));
				storevo.locs.add(in.location.get(i));
				
			}
		}
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
			target = new StoreMessageVO(loc,way,0,300,new ArrayList<InStoreDocVO>(),new ArrayList<OutStoreDocVO>());
			
		}
		if(DocType.inStoreDoc==tmp.type){
			InStoreDocVO vo = (InStoreDocVO)tmp;
			target.inStoreDocs.add(vo);
			int addNum = vo.orders.size();
			target.number = target.number+addNum;
			
		}
		else if(DocType.outStoreDoc==tmp.type){
			OutStoreDocVO vo = (OutStoreDocVO)tmp;
			target.outStoreDocs.add(vo);
			System.err.println(vo.loc);
			int delNum = vo.orders.size();
			target.number = target.number-delNum;
		}
		
		return update(target);
	}

}
