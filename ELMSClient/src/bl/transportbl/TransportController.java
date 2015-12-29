package bl.transportbl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import net.RMIManage;
import util.DataServiceType;
import util.DocState;
import util.DocType;
import util.MyDate;
import util.ResultMessage;
import vo.DocVO;
import vo.store.OutStoreDocVO;
import vo.transport.ArriveYYDocVO;
import vo.transport.ArriveZZDocVO;
import vo.transport.LoadDocVO;
import vo.transport.PayDocVO;
import vo.transport.SendGoodDocVO;
import vo.transport.TransferDocVO;
import bl.BusinessController;
import bl.BusinessLogicDataFactory;
import bl.orderbl.OrderController;
import blservice.transportblservice.Transportblservice;
import ds.transportdataservice.Transportdataservice;
import exception.ExceptionHandler;

/**
 * 货物流转controller类
 * 
 * @author czq
 * @version 2015年11月15日 上午9:27:08
 */
public class TransportController extends BusinessController implements
		Transportblservice {

	private Transport transport;
	private Transportdataservice transportData;

	public TransportController() {
		myType = DataServiceType.TransportDataService;
		transportData = (Transportdataservice) RMIManage
				.getDataService(DataServiceType.TransportDataService);

		transport = new Transport(transportData, BusinessLogicDataFactory
				.getFactory().getOrderBussinessLogic(),
				BusinessLogicDataFactory.getFactory()
						.getStrategyBusinessLogic());

	}

	public TransportController(OrderController orderController) {
		myType = DataServiceType.TransportDataService;
		transportData = (Transportdataservice) RMIManage
				.getDataService(DataServiceType.TransportDataService);
		transport = new Transport(transportData, orderController,
				BusinessLogicDataFactory.getFactory()
						.getStrategyBusinessLogic());
		
	}

	@Override
	public ResultMessage add(LoadDocVO vo) {
		try {
			return transport.add(vo);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return add(vo);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<LoadDocVO> getDayLoadDocs(MyDate date) {
		try {
			return transport.getDayLoadDocs(date);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return getDayLoadDocs(date);
			}
		}
		return null;
	}

	@Override
	public ResultMessage add(SendGoodDocVO vo) {
		try {
			return transport.add(vo);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return add(vo);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<SendGoodDocVO> getDaySendDocs(MyDate date) {
		try {
			return transport.getDaySendDocs(date);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return getDaySendDocs(date);
			}
		}
		return null;
	}

	@Override
	public ResultMessage add(ArriveYYDocVO vo) {
		try {
			return transport.add(vo);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return add(vo);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<ArriveYYDocVO> getDayArriveYYDocs(MyDate date) {
		try {
			return transport.getDayArriveYYDocs(date);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return getDayArriveYYDocs(date);
			}
		}
		return null;
	}

	@Override
	public ResultMessage add(ArriveZZDocVO vo) {
		try {
			return transport.add(vo);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return add(vo);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<ArriveZZDocVO> getDayArriveZZDocs(MyDate date) {
		try {
			return transport.getDayArriveZZDocs(date);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return getDayArriveZZDocs(date);
			}
		}
		return null;
	}

	@Override
	public ResultMessage add(TransferDocVO vo) {
		try {
			return transport.addTransferDoc(vo);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return add(vo);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<TransferDocVO> getDayTransferDocs(MyDate date) {
		try {
			return transport.getDayTransferDocs(date);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return getDayTransferDocs(date);
			}
		}
		return null;
	}

	@Override
	public ArrayList<DocVO> getDoc(DocType type) {
		try {
			return transport.getDoc(type);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return getDoc(type);
			}
		}
		return null;
	}

	@Override
	public double getExpense(OutStoreDocVO outStoreVO, TransferDocVO transferVO) {
		return transport.getExpense(outStoreVO, transferVO);
	}

	@Override
	public ResultMessage changeDocsState(ArrayList<String> docsID,
			DocType type, DocState state) {
		try {
			return transport.changeDocsState(docsID, type, state);
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
			return transport.changeOneDocState(docID, type, state);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return changeOneDocState(docID, type, state);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<? extends DocVO> getDocLists(DocType type) {
		try {
			return transport.getDocLists(type);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return getDocLists(type);
			}
		}
		return null;
	}

	@Override
	public DocVO getByID(String ID, DocType type) {
		try {
			return transport.getDocByID(ID, type);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return getByID(ID, type);
			}
		}
		return null;
	}

	@Override
	public ResultMessage addOnePay(PayDocVO vo) {

		try {
			return transport.addOnePay(vo);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return addOnePay(vo);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<PayDocVO> getPays() {
		try {
			return transport.getPays();
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return getPays();
			}

		}
		return null;
	}

	@Override
	public int getDayDocCount(DocType type) {

		try {
			return transport.getDayDocCount(type);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return getDayDocCount(type);
			}
		}
		return -1;
	}

	@Override
	public void reinitDataService(Remote dataService) {
		transportData = (Transportdataservice) dataService;

		transport = new Transport(transportData, BusinessLogicDataFactory
				.getFactory().getOrderBussinessLogic(),
				BusinessLogicDataFactory.getFactory()
						.getStrategyBusinessLogic());

	}

}
