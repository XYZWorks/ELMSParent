package bl.transportbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import util.DataServiceType;
import util.DocType;
import util.MyDate;
import util.ResultMessage;
import vo.DocVO;
import vo.transport.ArriveYYDocVO;
import vo.transport.ArriveZZDocVO;
import vo.transport.LoadDocVO;
import vo.transport.SendGoodDocVO;
import vo.transport.TransferDocVO;
import blservice.orderblservice.Orderblservice;
import blservice.strategyblservice.StrategyblService;
import blservice.transportblservice.transportblservice_Driver;
import ds.transportdataservice.Transportdataservice;
import net.RMIManage;
import po.transport.LoadDocPO;
import test.java.other.VOPOchange;

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

		try {
			transportData.initial();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
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
		
		for(LoadDocPO po: pos){
			if(po.getDate().equals(date)){
				vos.add((LoadDocVO)VOPOchange.POtoVO(po));
			}
		}
		
		return vos;
	}

	public ResultMessage add(SendGoodDocVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<SendGoodDocVO> getDaySendDocs(MyDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage add(ArriveYYDocVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ArriveZZDocVO> getDayArriveYYDocs(MyDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage add(ArriveZZDocVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ArriveZZDocVO> getDayArriveZZDocs(MyDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage add(TransferDocVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<TransferDocVO> getDayTransferDocs(MyDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DocVO> getDoc(DocType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public double getExpense(DocType type) {
		// TODO Auto-generated method stub
		return 0;
	}

}
