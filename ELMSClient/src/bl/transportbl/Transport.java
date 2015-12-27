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
import test.java.other.VOPOchange;
import util.City;
import util.DocState;
import util.DocType;
import util.MyDate;
import util.ResultMessage;
import util.TransferWay;
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

	public ResultMessage add(LoadDocVO vo) throws RemoteException {
		LoadDocPO po = (LoadDocPO) VOPOchange.VOtoPO(vo);
		ResultMessage result = null;
			result = transportData.addLoadDocPO(po);

		if (result == ResultMessage.SUCCESS)
			orderbl.addDocToList(vo, vo.orderBarCodes);
		return result;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<LoadDocVO> getDayLoadDocs(MyDate date) throws RemoteException {

		ArrayList<LoadDocPO> pos = new ArrayList<LoadDocPO>();
		ArrayList<LoadDocVO> vos = new ArrayList<LoadDocVO>();

			pos = (ArrayList<LoadDocPO>) transportData
					.getDocLists(DocType.loadDoc);

		if (pos == null) {
			return null;
		}

		for (LoadDocPO po : pos) {
			vos.add((LoadDocVO) VOPOchange.POtoVO(po));
		}

		return vos;
	}

	public ResultMessage add(SendGoodDocVO vo) throws RemoteException {
		SendGoodDocPO po = (SendGoodDocPO) VOPOchange.VOtoPO(vo);
		ResultMessage result = null;

			result = transportData.addSendGoodDocPO(po);
		if (result == ResultMessage.SUCCESS) {
			ArrayList<String> orderBarCodes = new ArrayList<>(1);
			orderBarCodes.add(vo.orderBarCode);
			orderbl.addDocToList(vo, orderBarCodes);
		}
		return result;

	}

	@SuppressWarnings("unchecked")
	public ArrayList<SendGoodDocVO> getDaySendDocs(MyDate date) throws RemoteException {
		ArrayList<SendGoodDocPO> pos ;
		ArrayList<SendGoodDocVO> vos = new ArrayList<SendGoodDocVO>();

			pos = (ArrayList<SendGoodDocPO>) transportData
					.getDocLists(DocType.sendGoodDoc);

		if (pos == null) {
			return null;
		}

		for (SendGoodDocPO po : pos) {
			vos.add((SendGoodDocVO) VOPOchange.POtoVO(po));
		}

		return vos;
	}

	public ResultMessage add(ArriveYYDocVO vo) throws RemoteException {
		ArriveYYDocPO po = (ArriveYYDocPO) VOPOchange.VOtoPO(vo);
		ResultMessage result = null;

			result = transportData.addArriveYYDocPO(po);
		if (result == ResultMessage.SUCCESS) {
			orderbl.addDocToList(vo, vo.orderBarCodes);
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<ArriveYYDocVO> getDayArriveYYDocs(MyDate date) throws RemoteException {
		ArrayList<ArriveYYDocPO> pos = new ArrayList<ArriveYYDocPO>();
		ArrayList<ArriveYYDocVO> vos = new ArrayList<ArriveYYDocVO>();

			pos = (ArrayList<ArriveYYDocPO>) transportData
					.getDocLists(DocType.arriveYYDoc);
		if (pos == null) {
			return null;
		}

		for (ArriveYYDocPO po : pos) {
			vos.add((ArriveYYDocVO) VOPOchange.POtoVO(po));
		}

		return vos;
	}

	public ResultMessage add(ArriveZZDocVO vo) throws RemoteException {
		ArriveZZDocPO po = (ArriveZZDocPO) VOPOchange.VOtoPO(vo);
		return transportData.addArriveZZDocPO(po);
		
	}

	@SuppressWarnings("unchecked")
	public ArrayList<ArriveZZDocVO> getDayArriveZZDocs(MyDate date) throws RemoteException {
		ArrayList<ArriveZZDocPO> pos = new ArrayList<ArriveZZDocPO>();
		ArrayList<ArriveZZDocVO> vos = new ArrayList<ArriveZZDocVO>();

			pos = (ArrayList<ArriveZZDocPO>) transportData
					.getDocLists(DocType.arriveZZDoc);
		if (pos == null) {
			return null;
		}

		for (ArriveZZDocPO po : pos) {
			vos.add((ArriveZZDocVO) VOPOchange.POtoVO(po));
		}
		return vos;
	}

	public ResultMessage addTransferDoc(TransferDocVO vo) throws RemoteException {
		TransferDocPO po = (TransferDocPO) VOPOchange.VOtoPO(vo);
			return transportData.addTransferDocPO(po);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<TransferDocVO> getDayTransferDocs(MyDate date) throws RemoteException {

		ArrayList<TransferDocPO> pos = new ArrayList<TransferDocPO>();
		ArrayList<TransferDocVO> vos = new ArrayList<TransferDocVO>();

			pos = (ArrayList<TransferDocPO>) transportData
					.getDocLists(DocType.transferDoc);

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
	public ArrayList<DocVO> getDoc(DocType type) throws RemoteException {
		ArrayList<DocPO> pos ;
		ArrayList<DocVO> vos = new ArrayList<DocVO>();

			pos = (ArrayList<DocPO>) transportData.getDocLists(type);

		for (DocPO po : pos) {
			vos.add((TransferDocVO) VOPOchange.POtoVO(po));
		}

		return vos;
	}

	public DocVO getDocByID(String ID, DocType type) throws RemoteException {
		DocPO po = null;
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

		if (po == null) {
			return null;
		}
		return (DocVO) VOPOchange.POtoVO(po);

	}

	public double getExpense(OutStoreDocVO outStoreDocVO,
			TransferDocVO transferVO) {
		ConstVO vo = strategybl.getConst();
		City one = outStoreDocVO.loc;
		City two = transferVO.sendCity;
		double instance = vo.getInstance(one, two);
		double perCost = 0;
		if(outStoreDocVO.shipWay==TransferWay.plane)
			perCost = vo.plane;
		else if(outStoreDocVO.shipWay==TransferWay.train)
			perCost = vo.train;
		else if(outStoreDocVO.shipWay==TransferWay.car)
			perCost = vo.truck;
		
		return instance*perCost;
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

	@SuppressWarnings("unchecked")
	public ArrayList<? extends DocVO> getDocLists(DocType type) throws RemoteException {
		ArrayList<DocVO> docVOs = new ArrayList<>();
		ArrayList<DocPO> docPOs;
		
			docPOs = (ArrayList<DocPO>) transportData.getDocLists(type);
			if(docPOs == null || docPOs.isEmpty()){
				return null;
			}
			
			docVOs = new ArrayList<>(docPOs.size());
			switch (type) {
			case arriveYYDoc:
				for (DocPO docPO : docPOs) {
					docVOs.add((ArriveYYDocVO) VOPOchange.POtoVO(docPO));
				}
				break;
			case loadDoc:
				for (DocPO docPO : docPOs) {
					docVOs.add((LoadDocVO) VOPOchange.POtoVO(docPO));
				}
				break;
			case sendGoodDoc:
				for (DocPO docPO : docPOs) {
					docVOs.add((SendGoodDocVO) VOPOchange.POtoVO(docPO));
				}
				break;
			case transferDoc:
				for (DocPO docPO : docPOs) {
					docVOs.add((TransferDocVO) VOPOchange.POtoVO(docPO));
				}
				break;
			case arriveZZDoc:
				for (DocPO docPO : docPOs) {
					docVOs.add((ArriveZZDocVO) VOPOchange.POtoVO(docPO));
				}
				break;
			default:
				System.err.println("类型传递错误，transport不应有其他单据类型！");
				return null;
			}
		
		
		
		return docVOs;
	}

	public ResultMessage changeDocsState(ArrayList<String> docsID,
			DocType type, DocState state) throws RemoteException {
		
			return transportData.changeDocsState(docsID, type, state);
	}

	public ResultMessage changeOneDocState(String docID, DocType type,
			DocState state) throws RemoteException {
			return transportData.changeOneDocState(docID, type, state);
	}

	public int getDayDocCount(DocType type) throws RemoteException {
			switch (type) {
			case arriveYYDoc:
				
				return transportData.getDayDocCount(DocType.arriveYYDoc, MyDate.getNowTime());
			case arriveZZDoc:
				
				return transportData.getDayDocCount(DocType.arriveZZDoc, MyDate.getNowTime());
			case loadDoc:
				return transportData.getDayDocCount(DocType.loadDoc, MyDate.getNowTime());
			case sendGoodDoc:
				return transportData.getDayDocCount(DocType.sendGoodDoc, MyDate.getNowTime());

			case transferDoc:
				return transportData.getDayDocCount(DocType.transferDoc, MyDate.getNowTime());

	
			default:
				break;
			}
		return -1;
	}

}
