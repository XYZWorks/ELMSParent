package bl.transportbl;

import java.util.ArrayList;
import java.util.Date;

import util.DocType;
import util.ResultMessage;
import vo.DocVO;
import vo.transport.ArriveYYDocVO;
import vo.transport.ArriveZZDocVO;
import vo.transport.LoadDocVO;
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
	
	Transportdataservice tansportData;
	
	Orderblservice orderbl;
	
	StrategyblService strategybl;
	
	
	public ResultMessage add(LoadDocVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<LoadDocVO> getDayLoadDocs(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage add(SendGoodDocVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<SendGoodDocVO> getDaySendDocs(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage add(ArriveYYDocVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ArriveZZDocVO> getDayArriveYYDocs(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage add(ArriveZZDocVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ArriveZZDocVO> getDayArriveZZDocs(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage add(TransferDocVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<TransferDocVO> getDayTransferDocs(Date date) {
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
