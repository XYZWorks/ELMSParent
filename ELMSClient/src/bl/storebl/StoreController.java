package bl.storebl;

import java.util.ArrayList;

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
 /** 
 * 库存管理、出库入库单Controller类
 * @author czq 
 * @version 2015年11月15日 上午9:25:23 
 */
public class StoreController implements StoreblService , InStoreDocService , OutStoreDocService{

	public ArrayList<StoreMessageVO> show() {
		// TODO Auto-generated method stub
		return null;
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

	public ResultMessage setAlarmValue(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DocVO> getDocLists(DocType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage changeDocsState(ArrayList<String> docsID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage changeOneDocState(String docID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage generate(OutStoreDocVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage generate(InStoreDocVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OutStoreDocVO> showOutStoreDocs() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<InStoreDocVO> showInstoreDocs() {
		// TODO Auto-generated method stub
		return null;
	}

}
