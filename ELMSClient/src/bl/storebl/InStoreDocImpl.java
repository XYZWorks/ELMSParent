package bl.storebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import po.DocPO;
import po.store.InStoreDocPO;
import util.DocState;
import util.DocType;
import util.MyDate;
import util.ResultMessage;
import vo.DocVO;
import vo.store.InStoreDocVO;
import ds.storedataservice.StoreDataService;

/**
 * @author ymc
 * @version 创建时间：2015年10月27日 下午7:49:33
 *
 */
public class InStoreDocImpl {

	private StoreDataService storeData;

	public InStoreDocImpl(StoreDataService storeDataService) {
		storeData = storeDataService;
	}

	public ArrayList<InStoreDocVO> show() throws RemoteException {
		ArrayList<InStoreDocPO> pos = new ArrayList<InStoreDocPO>();
		pos = storeData.getIn();

		if (pos == null) {
			return null;
		}

		ArrayList<InStoreDocVO> vos = new ArrayList<InStoreDocVO>(pos.size());

		for (InStoreDocPO po : pos) {
			vos.add((InStoreDocVO) VOPOchange.POtoVO(po));
		}
		return vos;
	}

	public ResultMessage generate(InStoreDocVO vo) throws RemoteException {

		InStoreDocPO po = (InStoreDocPO) VOPOchange.VOtoPO(vo);
		return storeData.addIn(po);
	}

	public ArrayList<? extends DocVO> getDocLists(DocType type)
			throws RemoteException {
		ArrayList<? extends DocPO> pos = null;
		pos = storeData.getDocLists(DocType.inStoreDoc);

		if (pos == null) {
			return null;
		}

		ArrayList<InStoreDocVO> vos = new ArrayList<>(pos.size());
		for (int i = 0; i < pos.size(); i++) {
			vos.add((InStoreDocVO) VOPOchange.POtoVO(pos.get(i)));
		}

		return vos;
	}

	public ResultMessage changeDocsState(ArrayList<String> docsID,
			DocType type, DocState state) throws RemoteException {
		return storeData.changeDocsState(docsID, type, state);
	}

	public ResultMessage changeOneDocState(String docID, DocType type,
			DocState state) throws RemoteException {
		return storeData.changeOneDocState(docID, type, state);
	}

	public DocVO getByID(String iD, DocType instoredoc) throws RemoteException {
		InStoreDocPO po = null;
		po = storeData.getOneInstoreDoc(iD);

		if (po == null) {
			return null;
		} else {
			InStoreDocVO test = (InStoreDocVO) VOPOchange.POtoVO(po);

			return test;
		}
	}

	public int getDayDocCount() throws RemoteException {
		return storeData
				.getDayDocCount(DocType.inStoreDoc, MyDate.getNowTime());
	}

}
