package bl.storebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.DocPO;
import po.store.InStoreDocPO;
import test.java.other.VOPOchange;
import util.DocState;
import util.DocType;
import util.ResultMessage;
import vo.DocVO;
import vo.store.InStoreDocVO;
import ds.storedataservice.StoreDataService;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:49:33 
 *
 */
public class InStoreDocImpl  {
	
	private StoreDataService storeData;
	
	public InStoreDocImpl(StoreDataService storeDataService) {
		storeData = storeDataService;
	}
	
	public ArrayList<InStoreDocVO> show() {
		ArrayList<InStoreDocPO> pos = new ArrayList<InStoreDocPO>();
		
		try {
			pos = storeData.getIn();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(pos == null){
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
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	public ArrayList< ? extends DocVO> getDocLists(DocType type) {
		ArrayList<? extends DocPO> pos = null;
		try {
			pos = storeData.getDocLists(DocType.inStoreDoc);
		} catch (RemoteException e) {
			e.printStackTrace();
		} 
		
		if(pos == null){
			return null;
		}
		
		ArrayList<InStoreDocVO> vos = new ArrayList<>(pos.size());
		for (int i = 0; i < pos.size(); i++) {
			vos.add((InStoreDocVO) VOPOchange.POtoVO(pos.get(i)));
		}
		
		return vos;
	}



	public ResultMessage changeDocsState(ArrayList<String> docsID, DocType type, DocState state) {
		try {
			return storeData.changeDocsState(docsID, type, state);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	public ResultMessage changeOneDocState(String docID, DocType type, DocState state) {
		try {
			return storeData.changeOneDocState(docID, type, state);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}
	public DocVO getByID(String iD, DocType instoredoc) {
		InStoreDocPO po = null;
		try {
			po = storeData.getOneInstoreDoc(iD);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(po == null){
			return null;
		}else{
			return (DocVO) VOPOchange.POtoVO(po);
		}
	}

}
