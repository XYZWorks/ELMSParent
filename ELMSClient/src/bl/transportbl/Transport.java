package bl.transportbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.DocPO;
import po.transport.ArriveYYDocPO;
import po.transport.ArriveZZDocPO;
import po.transport.LoadDocPO;
import po.transport.PayDocPO;
import po.transport.SendGoodDocPO;
import po.transport.TransferDocPO;
import test.java.other.DataTool;
import test.java.other.VOPOchange;
import util.DocState;
import util.DocType;
import util.MyDate;
import util.ResultMessage;
import vo.DocVO;
import vo.store.OutStoreDocVO;
import vo.strategy.ConstVO;
import vo.transport.ArriveYYDocVO;
import vo.transport.ArriveZZDocVO;
import vo.transport.LoadDocVO;
import vo.transport.PayDocVO;
import vo.transport.SendGoodDocVO;
import vo.transport.TransferDocVO;
import blservice.orderblservice.Orderblservice;
import blservice.strategyblservice.StrategyblService;
import ds.transportdataservice.Transportdataservice;

/**
 * @author ymc
 * @version 创建时间：2015年10月27日 下午7:52:01
 *
 */
public class Transport {

	private Transportdataservice transportData;

	private Orderblservice orderbl;

	private StrategyblService strategybl;

	public Transport(Transportdataservice transportdataservice,
			Orderblservice orderbl, StrategyblService strategybl) {

		this.transportData = transportdataservice;
		this.orderbl = orderbl;
		this.strategybl = strategybl;

	}

	public ResultMessage add(LoadDocVO vo) {
		LoadDocPO po = (LoadDocPO) VOPOchange.VOtoPO(vo);
		ResultMessage result = null;
		try {
			result = transportData.addLoadDocPO(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		if (result == ResultMessage.SUCCESS)
			orderbl.addDocToList(vo, vo.orderBarCodes);
		return result;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<LoadDocVO> getDayLoadDocs(MyDate date) {

		ArrayList<LoadDocPO> pos = new ArrayList<LoadDocPO>();
		ArrayList<LoadDocVO> vos = new ArrayList<LoadDocVO>();

		try {
			pos = (ArrayList<LoadDocPO>) transportData
					.getDocLists(DocType.loadDoc);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		if (pos == null) {
			return null;
		}

		for (LoadDocPO po : pos) {
			vos.add((LoadDocVO) VOPOchange.POtoVO(po));
		}

		return vos;
	}

	public ResultMessage add(SendGoodDocVO vo) {
		SendGoodDocPO po = (SendGoodDocPO) VOPOchange.VOtoPO(vo);
		ResultMessage result = null;

		try {
			result = transportData.addSendGoodDocPO(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if (result == ResultMessage.SUCCESS) {
			ArrayList<String> orderBarCodes = new ArrayList<>(1);
			orderBarCodes.add(vo.orderBarCode);
			orderbl.addDocToList(vo, orderBarCodes);
		}
		return result;

	}

	@SuppressWarnings("unchecked")
	public ArrayList<SendGoodDocVO> getDaySendDocs(MyDate date) {
		ArrayList<SendGoodDocPO> pos = new ArrayList<SendGoodDocPO>();
		ArrayList<SendGoodDocVO> vos = new ArrayList<SendGoodDocVO>();

		try {
			pos = (ArrayList<SendGoodDocPO>) transportData
					.getDocLists(DocType.sendGoodDoc);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		if (pos == null) {
			return null;
		}

		for (SendGoodDocPO po : pos) {
			// if (po.getDate().equals(date)) {
			vos.add((SendGoodDocVO) VOPOchange.POtoVO(po));
			// }
		}

		return vos;
	}

	public ResultMessage add(ArriveYYDocVO vo) {
		ArriveYYDocPO po = (ArriveYYDocPO) VOPOchange.VOtoPO(vo);
		ResultMessage result = null;

		try {
			result = transportData.addArriveYYDocPO(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if (result == ResultMessage.SUCCESS) {
			orderbl.addDocToList(vo, vo.orderBarCodes);
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<ArriveYYDocVO> getDayArriveYYDocs(MyDate date) {
		ArrayList<ArriveYYDocPO> pos = new ArrayList<ArriveYYDocPO>();
		ArrayList<ArriveYYDocVO> vos = new ArrayList<ArriveYYDocVO>();

		try {
			pos = (ArrayList<ArriveYYDocPO>) transportData
					.getDocLists(DocType.arriveYYDoc);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if (pos == null) {
			return null;
		}

		for (ArriveYYDocPO po : pos) {
			// if (po.getDate().equals(date)) {
			vos.add((ArriveYYDocVO) VOPOchange.POtoVO(po));
			// }
		}

		return vos;
	}

	public ResultMessage add(ArriveZZDocVO vo) {
		ArriveZZDocPO po = (ArriveZZDocPO) VOPOchange.VOtoPO(vo);
		ResultMessage result = null;

		try {
			result = transportData.addArriveZZDocPO(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<ArriveZZDocVO> getDayArriveZZDocs(MyDate date) {
		ArrayList<ArriveZZDocPO> pos = new ArrayList<ArriveZZDocPO>();
		ArrayList<ArriveZZDocVO> vos = new ArrayList<ArriveZZDocVO>();

		try {
			pos = (ArrayList<ArriveZZDocPO>) transportData
					.getDocLists(DocType.arriveZZDoc);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			return (ArrayList<ArriveZZDocVO>) DataTool
					.getDocList(DocType.arriveZZDoc);
		}
		if (pos == null) {
			return null;
		}

		for (ArriveZZDocPO po : pos) {
			vos.add((ArriveZZDocVO) VOPOchange.POtoVO(po));
		}
		return vos;
	}

	public ResultMessage addTransferDoc(TransferDocVO vo) {
		TransferDocPO po = (TransferDocPO) VOPOchange.VOtoPO(vo);

		ResultMessage result = null;

		try {
			result = transportData.addTransferDocPO(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<TransferDocVO> getDayTransferDocs(MyDate date) {

		ArrayList<TransferDocPO> pos = new ArrayList<TransferDocPO>();
		ArrayList<TransferDocVO> vos = new ArrayList<TransferDocVO>();

		try {
			pos = (ArrayList<TransferDocPO>) transportData
					.getDocLists(DocType.transferDoc);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		if (pos == null) {
			System.err.println("po is null");
			return null;
		}

		for (TransferDocPO po : pos) {
			vos.add((TransferDocVO) VOPOchange.POtoVO(po));
		}

		return vos;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<DocVO> getDoc(DocType type) {
		ArrayList<DocPO> pos = new ArrayList<DocPO>();
		ArrayList<DocVO> vos = new ArrayList<DocVO>();

		try {
			pos = (ArrayList<DocPO>) transportData.getDocLists(type);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		for (DocPO po : pos) {
			vos.add((TransferDocVO) VOPOchange.POtoVO(po));
		}

		return vos;
	}

	public DocVO getDocByID(String ID, DocType type) {
		DocPO po = null;
		try {
			switch (type) {
			case transferDoc:
				po = transportData.getTransferDocPO(ID);
				break;
			case arriveYYDoc:
				po = transportData.getArriveYYDocPO(ID);
				break;
			case arriveZZDoc:
				po = transportData.getArriveZZDocPO(ID);
				break;
			case loadDoc:
				po = transportData.getLoadDocPO(ID);
				break;
			case sendGoodDoc:
				po = transportData.getSendGoodDocPO(ID);
				break;
			default:
				break;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}

		if (po == null) {
			return null;
		}
		return (DocVO) VOPOchange.POtoVO(po);

	}

	// TODO 求运费==
	public double getExpense(OutStoreDocVO outStoreDocVO,
			TransferDocVO transferVO) {
		ConstVO vo = strategybl.getConst();

		return 0;
	}

	public ResultMessage addOnePay(PayDocVO vo) {
		PayDocPO po = (PayDocPO) VOPOchange.VOtoPO(vo);
		ResultMessage result = null;

		try {
			result = transportData.addPayDoc(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<PayDocVO> getPays() {
		ArrayList<PayDocPO> pos = null;
		try {
			pos = transportData.getPays();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(pos != null){
			ArrayList<PayDocVO> vos = new ArrayList<>(pos.size());
			for (PayDocPO payDocPO : pos) {
				vos.add((PayDocVO) VOPOchange.POtoVO(payDocPO));
			}
			return vos.isEmpty()?null:vos;
		}
		
		
		return null;
	}

	public ArrayList<? extends DocVO> getDocLists(DocType type) {
		ArrayList<DocVO> docVOs = new ArrayList<>();
		ArrayList<DocPO> docPOs;
		
		try {
			docPOs = (ArrayList<DocPO>) transportData.getDocLists(type);
			if(docPOs == null || docPOs.isEmpty()){
				return null;
			}
			
			docVOs = new ArrayList<>(docPOs.size());
			switch (type) {
			case arriveYYDoc:
				for (DocPO docPO : docPOs) {
					docVOs.add((ArriveYYDocVO) VOPOchange.POtoVO((ArriveYYDocPO)docPO));
				}
				break;
			case loadDoc:
				for (DocPO docPO : docPOs) {
					docVOs.add((LoadDocVO) VOPOchange.POtoVO((LoadDocPO)docPO));
				}
				break;
			case sendGoodDoc:
				for (DocPO docPO : docPOs) {
					docVOs.add((SendGoodDocVO) VOPOchange.POtoVO((SendGoodDocPO)docPO));
				}
				break;
			case transferDoc:
				for (DocPO docPO : docPOs) {
					docVOs.add((TransferDocVO) VOPOchange.POtoVO((TransferDocPO)docPO));
				}
				break;
			case arriveZZDoc:
				for (DocPO docPO : docPOs) {
					docVOs.add((ArriveZZDocVO) VOPOchange.POtoVO((ArriveZZDocPO)docPO));
				}
				break;
			default:
				System.err.println("类型传递错误，transport不应有其他单据类型！");
				return null;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
		
		return docVOs;
	}

	public ResultMessage changeDocsState(ArrayList<String> docsID,
			DocType type, DocState state) {
		
		try {
			return transportData.changeDocsState(docsID, type, state);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.SQL_ERROR;
	}

	public ResultMessage changeOneDocState(String docID, DocType type,
			DocState state) {
		try {
			return transportData.changeOneDocState(docID, type, state);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.SQL_ERROR;
	}

}
