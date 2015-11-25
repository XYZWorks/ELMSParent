package bl.storebl;

import java.util.ArrayList;

import blservice.approvalblservice.Approvalblservice;
import blservice.orderblservice.Orderblservice;
import blservice.storeblservice.InStoreDocService;
import ds.storedataservice.StoreDataService;
import net.RMIManage;
import util.DataServiceType;
import util.DocState;
import util.DocType;
import util.ResultMessage;
import vo.DocVO;
import vo.store.InStoreDocVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:49:33 
 *
 */
public class InStoreDocImpl implements InStoreDocService {
	
	StoreDataService storeData;
	Approvalblservice approvalbl;
	Orderblservice orderbl;
	
	public InStoreDocImpl() {
		
		storeData = (StoreDataService) RMIManage.getDataService(DataServiceType.StoreDataService);
	}
	public ArrayList<InStoreDocVO> show() {
		
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




	public ArrayList<InStoreDocVO> showInstoreDocs() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage changeDocsState(ArrayList<String> docsID, DocType type, DocState state) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage changeOneDocState(String docID, DocType type, DocState state) {
		// TODO Auto-generated method stub
		return null;
	}

}
