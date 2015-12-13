package bl.storebl;

import java.util.ArrayList;

import net.RMIManage;
import util.City;
import util.DataServiceType;
import util.DocState;
import util.DocType;
import util.ResultMessage;
import vo.DocVO;
import vo.store.InStoreDocVO;
import vo.store.OutStoreDocVO;
import vo.store.StoreCheckVO;
import vo.store.StoreMessageVO;
import blservice.storeblservice.InStoreDocService;
import blservice.storeblservice.OutStoreDocService;
import blservice.storeblservice.StoreblService;
import ds.storedataservice.StoreDataService;
 /** 
 * 库存管理、出库入库单Controller类
 * @author czq 
 * @version 2015年11月15日 上午9:25:23 
 */
public class StoreController implements StoreblService , InStoreDocService , OutStoreDocService{
	
	private Store store;
	
	private InStoreDocImpl inStoreDocImpl;
	
	private OutStoreDocImpl outStoreDocImpl;
	
	private StoreDataService storeDataService = (StoreDataService) RMIManage.getDataService(DataServiceType.StoreDataService);
	
	public StoreController() {
		store = new Store(storeDataService);
		inStoreDocImpl = new InStoreDocImpl(storeDataService);
		outStoreDocImpl = new OutStoreDocImpl(storeDataService);
	}
	public ArrayList<StoreMessageVO> show() {
		return store.show();
	}

	public ArrayList<StoreCheckVO> showCheck() {
		return store.showCheck();
	}

	public ResultMessage exportExcel(String path) {
		return store.exportExcel(path);
	}

	public ResultMessage update(StoreMessageVO vo) {
		return store.update(vo);
	}


	public ArrayList<DocVO> getDocLists(DocType type) {
		switch (type) {
		case inStoreDoc:
			return inStoreDocImpl.getDocLists(type);
		case outStoreDoc:
			return outStoreDocImpl.getDocLists(type);
		default:
			return null;
		}
	}




	public ResultMessage generate(OutStoreDocVO vo) {
		return outStoreDocImpl.generate(vo);
	}

	public ResultMessage generate(InStoreDocVO vo) {
		return inStoreDocImpl.generate(vo);
	}

	public ArrayList<OutStoreDocVO> showOutStoreDocs() {
		return outStoreDocImpl.show();
	}

	public ArrayList<InStoreDocVO> showInstoreDocs() {
		return inStoreDocImpl.show();
	}

	public ResultMessage changeDocsState(ArrayList<String> docsID, DocType type, DocState state) {
		switch (type) {
		case inStoreDoc:
			return inStoreDocImpl.changeDocsState(docsID, type, state);
		case outStoreDoc:
			return outStoreDocImpl.changeDocsState(docsID, type, state);
		default:
			return null;
		}
	}

	public ResultMessage changeOneDocState(String docID, DocType type, DocState state) {
		switch (type) {
		case inStoreDoc:
			return inStoreDocImpl.changeOneDocState(docID, type, state);
		case outStoreDoc:
			return outStoreDocImpl.changeOneDocState(docID, type, state);
		default:
			return null;
		}
	}


	public ResultMessage setAlarmValue(String value, City city) {
		return store.setAlarmValue(value,city);
	}

	public String getAlarmValue(String city) {
		//TODO 
		return null;
	}
	public DocVO getByID(String ID) {
		try{
			return inStoreDocImpl.getByID(ID);
		}
		catch(NullPointerException e){
			return outStoreDocImpl.getByID(ID);
		}
		
				
	}

}
