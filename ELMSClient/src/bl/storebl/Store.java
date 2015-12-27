package bl.storebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.ExportExcel;
import bl.VOPOchange;
import po.store.StoreCheckPO;
import po.store.StoreMessagePO;
import test.java.other.DataTool;
import util.City;
import util.DocType;
import util.ResultMessage;
import util.TransferWay;
import vo.DocVO;
import vo.store.InStoreDocVO;
import vo.store.OutStoreDocVO;
import vo.store.StoreCheckVO;
import vo.store.StoreMessageVO;
import vo.store.StoreShowVO;
import ds.storedataservice.StoreDataService;

/**
 * @author ymc
 * @version 创建时间：2015年10月27日 下午7:50:20
 *
 */
public class Store {
	private StoreDataService storeData;

	public Store(StoreDataService storeDataService) {
		storeData = storeDataService;
	}

	public ArrayList<StoreMessageVO> show() throws RemoteException {
		ArrayList<StoreMessagePO> pos = new ArrayList<>();

		pos = storeData.getStoreMessages();
		if (pos.size() == 0) {
			initial();
			pos = storeData.getStoreMessages();
		}

		ArrayList<StoreMessageVO> vos = new ArrayList<>();
		if (pos != null) {

			for (StoreMessagePO po : pos)
				vos.add((StoreMessageVO) VOPOchange.POtoVO(po));
		}
		return vos;
	}

	private void initial() throws RemoteException {
		ArrayList<StoreMessageVO> vos = DataTool.getStoreMessage();

		for (StoreMessageVO vo : vos)
			update(vo);

	}

	public ArrayList<StoreCheckVO> showCheck() throws RemoteException {
		ArrayList<StoreCheckPO> pos = null;
		pos = storeData.getCheck();

		if (pos == null) {
			return null;
		}
		ArrayList<StoreCheckVO> vos = new ArrayList<>(pos.size());
		for (StoreCheckPO storeCheckPO : pos) {
			vos.add((StoreCheckVO) VOPOchange.POtoVO(storeCheckPO));
		}

		return vos;
	}

	public ResultMessage exportExcel(String path, StoreMessageVO vo) {
		StoreShowVO storevo = StoreShowVO.getStoreShow(vo);
		return ExportExcel.exportExcel(path, storevo);
	}

	public ResultMessage update(StoreMessageVO vo) throws RemoteException {
		StoreMessagePO po = (StoreMessagePO) VOPOchange.VOtoPO(vo);
		return storeData.update(po);
	}

	public ResultMessage setAlarmValue(String value, City city)
			throws RemoteException {
		return storeData.setAlarmValue(value, city);
	}

	public String getAlarmValue(City city) throws RemoteException {

		return storeData.getAlarmValue(city);
	}

	public ResultMessage updateStore(City loc, TransferWay way, DocVO tmp)
			throws RemoteException {
		ArrayList<StoreMessageVO> vos = show();
		StoreMessageVO target = null;
		for (StoreMessageVO vo : vos) {
			if (vo.location == loc && vo.storeLoc == way) {
				target = vo;
				break;
			}
		}
		if (target == null) {
			target = new StoreMessageVO(loc, way, 0, 300,
					new ArrayList<InStoreDocVO>(),
					new ArrayList<OutStoreDocVO>());

		}
		if (DocType.inStoreDoc == tmp.type) {
			InStoreDocVO vo = (InStoreDocVO) tmp;
			target.inStoreDocs.add(vo);
			int addNum = vo.orders.size();
			target.number = target.number + addNum;

		} else if (DocType.outStoreDoc == tmp.type) {
			OutStoreDocVO vo = (OutStoreDocVO) tmp;
			target.outStoreDocs.add(vo);
			System.err.println(vo.loc);
			int delNum = vo.orders.size();
			target.number = target.number - delNum;
		}

		return update(target);
	}

}
