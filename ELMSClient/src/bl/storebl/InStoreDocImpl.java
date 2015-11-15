package bl.storebl;

import java.util.ArrayList;

import blservice.orderblservice.Orderblservice;
import blservice.storeblservice.InStoreDocService;
import ds.storedataservice.StoreDataService;
import util.DocType;
import util.ResultMessage;
import vo.DocVO;
import vo.InStoreDocVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:49:33 
 *
 */
public class InStoreDocImpl implements InStoreDocService {
	StoreDataService storeData;
	Orderblservice orderbl;
	public ArrayList<InStoreDocVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage generate(InStoreDocVO vo) {
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

	public ArrayList<InStoreDocVO> showInstoreDocs() {
		// TODO Auto-generated method stub
		return null;
	}

}
