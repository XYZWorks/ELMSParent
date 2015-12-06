package bl.transportbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.orderbl.OrderController;
import bl.strategybl.Strategy;
import bl.strategybl.StrategyController;
import blservice.orderblservice.Orderblservice;
import blservice.strategyblservice.StrategyblService;
import ds.transportdataservice.Transportdataservice;
import net.RMIManage;
import po.DocPO;
import po.transport.ArriveYYDocPO;
import po.transport.ArriveZZDocPO;
import po.transport.LoadDocPO;
import po.transport.SendGoodDocPO;
import po.transport.TransferDocPO;
import test.java.other.DataTool;
import test.java.other.VOPOchange;
import util.DataServiceType;
import util.DocType;
import util.MyDate;
import util.ResultMessage;
import vo.DocVO;
import vo.strategy.ConstVO;
import vo.transport.ArriveYYDocVO;
import vo.transport.ArriveZZDocVO;
import vo.transport.LoadDocVO;
import vo.transport.SendGoodDocVO;
import vo.transport.TransferDocVO;

/**
 * @author ymc
 * @version 创建时间：2015年10月27日 下午7:52:01
 *
 */
public class Transport {

	Transportdataservice transportData;

	Orderblservice orderbl;

	StrategyblService strategybl;

	public Transport() {

		transportData = (Transportdataservice) RMIManage.getDataService(DataServiceType.TransportDataService);

		// try {
		// transportData.initial();
		// } catch (RemoteException e) {
		// e.printStackTrace();
		// }

		strategybl = new StrategyController();
		// orderbl = new OrderController();

	}

	public ResultMessage add(LoadDocVO vo) {
		LoadDocPO po = (LoadDocPO) VOPOchange.VOtoPO(vo);
		ResultMessage result = null;
		try {
			result = transportData.addLoadDocPO(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result == ResultMessage.SUCCESS)
			result = orderbl.addDocToList(vo, vo.orderBarCodes);
		return result;
	}

	public ArrayList<LoadDocVO> getDayLoadDocs(MyDate date) {

		ArrayList<LoadDocPO> pos = new ArrayList<LoadDocPO>();
		ArrayList<LoadDocVO> vos = new ArrayList<LoadDocVO>();

		try {
			pos = (ArrayList<LoadDocPO>) transportData.getDocLists(DocType.loadDoc);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (LoadDocPO po : pos) {
			if (po.getDate().equals(date)) {
				vos.add((LoadDocVO) VOPOchange.POtoVO(po));
			}
		}

		return vos;
	}

	public ResultMessage add(SendGoodDocVO vo) {
		SendGoodDocPO po = (SendGoodDocPO) VOPOchange.VOtoPO(vo);
		ResultMessage result = null;

		try {
			result = transportData.addSendGoodDocPO(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == ResultMessage.SUCCESS) {
			ArrayList<String> orderBarCodes = new ArrayList<>(1);
			orderBarCodes.add(vo.orderBarCode);
			result = orderbl.addDocToList(vo, orderBarCodes);
		}
		return result;

	}

	public ArrayList<SendGoodDocVO> getDaySendDocs(MyDate date) {
		ArrayList<SendGoodDocPO> pos = new ArrayList<SendGoodDocPO>();
		ArrayList<SendGoodDocVO> vos = new ArrayList<SendGoodDocVO>();

		try {
			pos = (ArrayList<SendGoodDocPO>) transportData.getDocLists(DocType.sendGoodDoc);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (SendGoodDocPO po : pos) {
			if (po.getDate().equals(date)) {
				vos.add((SendGoodDocVO) VOPOchange.POtoVO(po));
			}
		}

		return vos;
	}

	public ResultMessage add(ArriveYYDocVO vo) {
		ArriveYYDocPO po = (ArriveYYDocPO) VOPOchange.VOtoPO(vo);
		ResultMessage result = null;

		try {
			result = transportData.addArriveYYDocPO(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == ResultMessage.SUCCESS)
			result = orderbl.addDocToList(vo, vo.orderBarCodes);
		return result;
	}

	public ArrayList<ArriveYYDocVO> getDayArriveYYDocs(MyDate date) {
		ArrayList<ArriveYYDocPO> pos = new ArrayList<ArriveYYDocPO>();
		ArrayList<ArriveYYDocVO> vos = new ArrayList<ArriveYYDocVO>();

		try {
			pos = (ArrayList<ArriveYYDocPO>) transportData.getDocLists(DocType.arriveYYDoc);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (ArriveYYDocPO po : pos) {
			if (po.getDate().equals(date)) {
				vos.add((ArriveYYDocVO) VOPOchange.POtoVO(po));
			}
		}

		return vos;
	}

	public ResultMessage add(ArriveZZDocVO vo) {
		ArriveZZDocPO po = (ArriveZZDocPO) VOPOchange.VOtoPO(vo);
		ResultMessage result = null;

		try {
			result = transportData.addArriveZZDocPO(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<ArriveZZDocVO> getDayArriveZZDocs(MyDate date) {
		ArrayList<ArriveZZDocPO> pos = new ArrayList<ArriveZZDocPO>();
		ArrayList<ArriveZZDocVO> vos = new ArrayList<ArriveZZDocVO>();
		// System.out.println(add((ArriveZZDocVO)DataTool.getDocList(DocType.arriveZZDoc).get(0)).name());

		try {
			pos = (ArrayList<ArriveZZDocPO>) transportData.getDocLists(DocType.arriveZZDoc);
			pos.size();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			return (ArrayList<ArriveZZDocVO>) DataTool.getDocList(DocType.arriveZZDoc);
		}
		// System.out.println(pos.size());

		for (ArriveZZDocPO po : pos) {
			// if(po.getDate().equals(date)){
			vos.add((ArriveZZDocVO) VOPOchange.POtoVO(po));
			// }
		}
		// System.out.println(vos.size());
		return vos;
	}

	public ResultMessage add(TransferDocVO vo) {
		TransferDocPO po = (TransferDocPO) VOPOchange.VOtoPO(vo);
		ResultMessage result = null;

		try {
			result = transportData.addTransferDocPO(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<TransferDocVO> getDayTransferDocs(MyDate date) {

		ArrayList<TransferDocPO> pos = new ArrayList<TransferDocPO>();
		ArrayList<TransferDocVO> vos = new ArrayList<TransferDocVO>();

		try {
			pos = (ArrayList<TransferDocPO>) transportData.getDocLists(DocType.transferDoc);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (pos == null) {
			return null;
		}
		for (TransferDocPO po : pos) {
			if (po.getDate().equals(date)) {
				vos.add((TransferDocVO) VOPOchange.POtoVO(po));
			}
		}

		return vos;
	}

	public ArrayList<DocVO> getDoc(DocType type) {
		ArrayList<DocPO> pos = new ArrayList<DocPO>();
		ArrayList<DocVO> vos = new ArrayList<DocVO>();

		try {
			pos = (ArrayList<DocPO>) transportData.getDocLists(type);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (DocPO po : pos) {

			vos.add((TransferDocVO) VOPOchange.POtoVO(po));

		}

		return vos;
	}

	public double getExpense(ArriveZZDocVO arriveVO, TransferDocVO transferVO) {
		ConstVO vo = strategybl.getConst();

		return 0;
	}

}
