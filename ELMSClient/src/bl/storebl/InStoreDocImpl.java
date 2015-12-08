package bl.storebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.approvalblservice.Approvalblservice;
import blservice.orderblservice.Orderblservice;
import blservice.storeblservice.InStoreDocService;
import ds.storedataservice.StoreDataService;
import net.RMIManage;
import po.store.InStoreDocPO;
import test.java.other.DataTool;
import test.java.other.VOPOchange;
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
public class InStoreDocImpl  {
	
	StoreDataService storeData;
	Approvalblservice approvalbl;
	Orderblservice orderbl;
	
	public InStoreDocImpl(StoreDataService storeDataService) {
		
		storeData = storeDataService;
	}
	public ArrayList<InStoreDocVO> show() {
		ArrayList<InStoreDocPO> pos = new ArrayList<InStoreDocPO>();
		
		generate((InStoreDocVO)DataTool.getDocList(DocType.inStoreDoc).get(0));
		generate((InStoreDocVO)DataTool.getDocList(DocType.inStoreDoc).get(1));
		generate((InStoreDocVO)DataTool.getDocList(DocType.inStoreDoc).get(2));
		try {
			pos = storeData.getIn();
			pos.size();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NullPointerException e) {
			System.err.println("pos is null");
			return null;
		}
		ArrayList<InStoreDocVO> vos = new ArrayList<InStoreDocVO>(pos.size());
		
		for(InStoreDocPO po : pos ){
			vos .add((InStoreDocVO)VOPOchange.POtoVO(po));
		} 
		return vos;
	}

	public ResultMessage generate(InStoreDocVO vo) {
		
		InStoreDocPO po = (InStoreDocPO) VOPOchange.VOtoPO(vo);
		try {
			return storeData.addIn(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	public ArrayList<DocVO> getDocLists(DocType type) {
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
	public DocVO getByID(String iD) {
		// TODO Auto-generated method stub
		return null;
	}

}
