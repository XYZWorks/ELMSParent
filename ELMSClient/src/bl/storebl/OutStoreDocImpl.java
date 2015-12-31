package bl.storebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import bl.orderbl.OrderController;
import blservice.orderblservice.Orderblservice;
import ds.storedataservice.StoreDataService;
import po.DocPO;
import po.store.OutStoreDocPO;
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
public class OutStoreDocImpl {
	
	StoreDataService storeData;
	private OrderController orderController;

	public OutStoreDocImpl(StoreDataService storeDataService, OrderController orderController) {
		this.orderController=orderController;

		storeData = storeDataService;
	}
	
	public ArrayList<OutStoreDocVO> show() throws RemoteException {
	ArrayList<OutStoreDocPO> pos = new ArrayList<OutStoreDocPO>();
		
//		generate((OutStoreDocVO)DataTool.getDocList(DocType.outStoreDoc).get(0));
//		generate((OutStoreDocVO)DataTool.getDocList(DocType.outStoreDoc).get(1));
//		generate((OutStoreDocVO)DataTool.getDocList(DocType.outStoreDoc).get(2));
			pos = storeData.getOut();
		
		if(pos == null){
			return null;
		}
		
		
		ArrayList<OutStoreDocVO> vos = new ArrayList<OutStoreDocVO>(pos.size());
		
		for(OutStoreDocPO po : pos ){
			vos .add((OutStoreDocVO)VOPOchange.POtoVO(po));
		} 
		return vos;
	}

	public ResultMessage generate(OutStoreDocVO vo) throws RemoteException {
		OutStoreDocPO po = (OutStoreDocPO) VOPOchange.VOtoPO(vo);
			ResultMessage result =  storeData.addOut(po);
			if (result == ResultMessage.SUCCESS) {
				orderController.addDocToList(vo, vo.orders);
			}
			return  result;
	}

	public ArrayList< ? extends DocVO> getDocLists(DocType type) throws RemoteException {
		ArrayList<? extends DocPO> pos = null;
			pos = storeData.getDocLists(DocType.outStoreDoc);
		
		if(pos == null){
			return null;
		}
		
		ArrayList<OutStoreDocVO> vos = new ArrayList<>(pos.size());
		for (int i = 0; i < pos.size(); i++) {
			vos.add((OutStoreDocVO) VOPOchange.POtoVO(pos.get(i)));
		}
		
		return vos;
	}



	public ArrayList<OutStoreDocVO> showOutStoreDocs() throws RemoteException {
		ArrayList<OutStoreDocPO> pos = null;
			pos = storeData.getOut();
		
		if(pos == null){
			return null;
		}
		
		ArrayList<OutStoreDocVO> vos = new ArrayList<>(pos.size());
		for (int i = 0; i < pos.size(); i++) {
			vos.add((OutStoreDocVO) VOPOchange.POtoVO(pos.get(i)));
		}
		
		return vos;
	}

	public ResultMessage changeDocsState(ArrayList<String> docsID, DocType type, DocState state) throws RemoteException {
			return storeData.changeDocsState(docsID, type, state);
	}

	public ResultMessage changeOneDocState(String docID, DocType type, DocState state) throws RemoteException {
			return storeData.changeOneDocState(docID, type, state);
	}


	public DocVO getByID(String ID, DocType type) throws RemoteException {
		OutStoreDocPO po = null;
			po = storeData.getOneOutStoreDoc(ID);
		if(po == null){
			return null;
		}else{
			OutStoreDocVO out = (OutStoreDocVO) VOPOchange.POtoVO(po);
			return out;
		}
		
	}

	public int getDayDocCount() throws RemoteException {
			return storeData.getDayDocCount(DocType.outStoreDoc, MyDate.getNowTime());
	}
	

}
