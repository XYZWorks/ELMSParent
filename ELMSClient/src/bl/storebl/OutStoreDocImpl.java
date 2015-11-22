package bl.storebl;

import java.util.ArrayList;

import blservice.orderblservice.Orderblservice;
import blservice.storeblservice.OutStoreDocService;
import ds.storedataservice.StoreDataService;
import util.DocState;
import util.DocType;
import util.ResultMessage;
import vo.DocVO;
import vo.store.OutStoreDocVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:49:58 
 *
 */
public class OutStoreDocImpl implements OutStoreDocService {
	
	StoreDataService storeData;
	Orderblservice orderbl;
	
	public ArrayList<OutStoreDocVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage generate(OutStoreDocVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DocVO> getDocLists(DocType type) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage changeOneDocState(String docID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OutStoreDocVO> showOutStoreDocs() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage changeDocsState(ArrayList<String> docsID, DocType type, DocState state) {
		// TODO Auto-generated method stub
		return null;
	}

}
