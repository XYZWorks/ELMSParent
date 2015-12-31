package bl.storebl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import net.RMIManage;
import util.City;
import util.DataServiceType;
import util.DocState;
import util.DocType;
import util.ResultMessage;
import util.TransferWay;
import vo.DocVO;
import vo.store.InStoreDocVO;
import vo.store.OutStoreDocVO;
import vo.store.StoreCheckVO;
import vo.store.StoreMessageVO;
import bl.BusinessController;
import blservice.storeblservice.InStoreDocService;
import blservice.storeblservice.OutStoreDocService;
import blservice.storeblservice.StoreblService;
import ds.storedataservice.StoreDataService;
import exception.ExceptionHandler;

/**
 * 库存管理、出库入库单Controller类
 * 
 * @author czq
 * @version 2015年11月15日 上午9:25:23
 */
public class StoreController extends BusinessController implements
		StoreblService, InStoreDocService, OutStoreDocService {

	private Store store;

	private InStoreDocImpl inStoreDocImpl;

	private OutStoreDocImpl outStoreDocImpl;

	private StoreDataService storeDataService;

	public StoreController() {
		storeDataService = (StoreDataService) RMIManage
				.getDataService(DataServiceType.StoreDataService);
		store = new Store(storeDataService);
		myType = DataServiceType.StoreDataService;
		inStoreDocImpl = new InStoreDocImpl(storeDataService);
		outStoreDocImpl = new OutStoreDocImpl(storeDataService);

	}

	@Override
	public ArrayList<StoreMessageVO> show() {
		try {
			return store.show();
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return show();
			}
		}
		return null;

	}

	@Override
	public ArrayList<StoreCheckVO> showCheck() {
		try {
			return store.showCheck();
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return showCheck();
			}
		}
		return null;
	}

	@Override
	public ResultMessage exportExcel(String path, StoreMessageVO vo) {
		return store.exportExcel(path, vo);
	}

	@Override
	public ResultMessage update(StoreMessageVO vo) {
		try {
			return store.update(vo);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return update(vo);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<? extends DocVO> getDocLists(DocType type) {
		try {
			switch (type) {
			case inStoreDoc:

				return inStoreDocImpl.getDocLists(type);

			case outStoreDoc:
				return outStoreDocImpl.getDocLists(type);
			default:
				return null;
			}
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return getDocLists(type);
			}
		}
		return null;
	}

	@Override
	public ResultMessage generate(OutStoreDocVO vo) {
		try {
			return outStoreDocImpl.generate(vo);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return generate(vo);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage generate(InStoreDocVO vo) {
		try {
			return inStoreDocImpl.generate(vo);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return generate(vo);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<OutStoreDocVO> showOutStoreDocs() {
		try {
			return outStoreDocImpl.show();
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return showOutStoreDocs();
			}
		}
		return null;
	}

	@Override
	public ArrayList<InStoreDocVO> showInstoreDocs() {
		try {
			return inStoreDocImpl.show();
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return showInstoreDocs();
			}
		}
		return null;
	}

	@Override
	public ResultMessage changeDocsState(ArrayList<String> docsID,
			DocType type, DocState state) {
		try {
			switch (type) {
			case inStoreDoc:

				return inStoreDocImpl.changeDocsState(docsID, type, state);

			case outStoreDoc:
				return outStoreDocImpl.changeDocsState(docsID, type, state);
			default:
				return null;
			}
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return changeDocsState(docsID, type, state);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage changeOneDocState(String docID, DocType type,
			DocState state) {
		try {
			switch (type) {
			case inStoreDoc:
				return inStoreDocImpl.changeOneDocState(docID, type, state);
			case outStoreDoc:
				return outStoreDocImpl.changeOneDocState(docID, type, state);
			default:
				return null;
			}
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return changeOneDocState(docID, type, state);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage setAlarmValue(String value, City city) {
		try {
			return store.setAlarmValue(value, city);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return setAlarmValue(value, city);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public String getAlarmValue(City city) {
		try {
			return store.getAlarmValue(city);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return getAlarmValue(city);
			}
		}
		return null;
	}

	@Override
	public DocVO getByID(String ID, DocType type) {
		try {
			if (type == DocType.inStoreDoc) {
				return inStoreDocImpl.getByID(ID, DocType.inStoreDoc);
			} else if (type == DocType.outStoreDoc) {
				return outStoreDocImpl.getByID(ID, DocType.outStoreDoc);
			} else {
				return null;
			}
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return getByID(ID, type);
			}
		}
		return null;

	}

	@Override
	public ResultMessage updateStore(City loc, TransferWay way, String ID,
			DocType type) {
		DocVO tmp = getByID(ID, type);
		try {
			return store.updateStore(loc, way, tmp);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return updateStore(loc, way, ID, type);
			}
		}
		return ResultMessage.FAIL;

	}

	@Override
	public int getDayDocCount(DocType type) {
		try {
			if (type == DocType.inStoreDoc)
				return inStoreDocImpl.getDayDocCount();
			else if (type == DocType.outStoreDoc)
				return outStoreDocImpl.getDayDocCount();
			return -1;
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return getDayDocCount(type);
			}
		}
		return -1;
	}

	@Override
	public void reinitDataService(Remote dataService) {
		storeDataService = (StoreDataService) dataService;
		store = new Store(storeDataService);
		inStoreDocImpl = new InStoreDocImpl(storeDataService);
		outStoreDocImpl = new OutStoreDocImpl(storeDataService);
	}

}
