package bl.transportbl;

import java.util.ArrayList;
import util.MyDate;

import util.DocType;
import util.ResultMessage;
import vo.ArriveYYDocVO;
import vo.ArriveZZDocVO;
import vo.DocVO;
import vo.LoadDocVO;
import vo.SendGoodDocVO;
import vo.TransferDocVO;
import blservice.transportblservice.Transportblservice;
 /** 
 * 货物流转controller类
 * @author czq 
 * @version 2015年11月15日 上午9:27:08 
 */
public class TransportController implements Transportblservice{

	public ResultMessage add(LoadDocVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<LoadDocVO> getDayLoadDocs(MyDate date) {
		// TODO Auto-generated method stub
		return null;
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

	public ArrayList<ArriveYYDocVO> getDayArriveYYDocs(MyDate date) {
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



	public ArrayList<DocVO> getDocLists(DocType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage changeDocsState(ArrayList<String> docsID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage changeOneDocState(String docID) {
		// TODO Auto-generated method stub
		return null;
	}

	public double getExpense(ArriveZZDocVO arriveVO, TransferDocVO transferVO) {
		// TODO Auto-generated method stub
		return 0;
	}


}
