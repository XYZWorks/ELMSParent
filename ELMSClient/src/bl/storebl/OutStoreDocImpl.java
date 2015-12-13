package bl.storebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.orderblservice.Orderblservice;
import blservice.storeblservice.OutStoreDocService;
import ds.storedataservice.StoreDataService;
import po.DocPO;
import po.store.InStoreDocPO;
import po.store.OutStoreDocPO;
import test.java.other.DataTool;
import test.java.other.VOPOchange;
import util.DocState;
import util.DocType;
import util.MyDate;
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
	
	public OutStoreDocImpl(StoreDataService storeDataService) {
		
		storeData = storeDataService;
	}
	
	public ArrayList<OutStoreDocVO> show() {
	ArrayList<OutStoreDocPO> pos = new ArrayList<OutStoreDocPO>();
		
//		generate((OutStoreDocVO)DataTool.getDocList(DocType.outStoreDoc).get(0));
//		generate((OutStoreDocVO)DataTool.getDocList(DocType.outStoreDoc).get(1));
//		generate((OutStoreDocVO)DataTool.getDocList(DocType.outStoreDoc).get(2));
		try {
			pos = storeData.getOut();
			pos.size();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NullPointerException e) {
			System.err.println("pos is null");
			return null;
		}
		ArrayList<OutStoreDocVO> vos = new ArrayList<OutStoreDocVO>(pos.size());
		
		for(OutStoreDocPO po : pos ){
			vos .add((OutStoreDocVO)VOPOchange.POtoVO(po));
		} 
		return vos;
	}

	public ResultMessage generate(OutStoreDocVO vo) {
		OutStoreDocPO po = (OutStoreDocPO) VOPOchange.VOtoPO(vo);
		try {
			return storeData.addOut(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	public ArrayList< ? extends DocVO> getDocLists(DocType type) {
		ArrayList<? extends DocPO> pos = null;
		try {
			pos = storeData.getDocLists(DocType.outStoreDoc);
		} catch (RemoteException e) {
			e.printStackTrace();
		} 
		
		if(pos == null){
			return null;
		}
		
		ArrayList<OutStoreDocVO> vos = new ArrayList<>(pos.size());
		for (int i = 0; i < pos.size(); i++) {
			vos.add((OutStoreDocVO) VOPOchange.POtoVO(pos.get(i)));
		}
		
		return vos;
	}



	public ArrayList<OutStoreDocVO> showOutStoreDocs() {
		ArrayList<OutStoreDocPO> pos = null;
		try {
			pos = storeData.getOut();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(pos == null){
			return null;
		}
		
		ArrayList<OutStoreDocVO> vos = new ArrayList<>(pos.size());
		for (int i = 0; i < pos.size(); i++) {
			vos.add((OutStoreDocVO) VOPOchange.POtoVO(pos.get(i)));
		}
		
		return vos;
	}

	public ResultMessage changeDocsState(ArrayList<String> docsID, DocType type, DocState state) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage changeOneDocState(String docID, DocType type, DocState state) {
		// TODO Auto-generated method stub
		return null;
	}

	public DocVO getByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

}
