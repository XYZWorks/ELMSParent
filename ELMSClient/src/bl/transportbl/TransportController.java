package bl.transportbl;

import java.util.ArrayList;
import util.MyDate;
import util.DocState;
import util.DocType;
import util.ResultMessage;
import vo.DocVO;
import vo.transport.ArriveYYDocVO;
import vo.transport.ArriveZZDocVO;
import vo.transport.LoadDocVO;
import vo.transport.SendGoodDocVO;
import vo.transport.TransferDocVO;
import blservice.transportblservice.Transportblservice;
 /** 
 * 货物流转controller类
 * @author czq 
 * @version 2015年11月15日 上午9:27:08 
 */
public class TransportController implements Transportblservice{

	Transport transport ;
	
	public TransportController() {
		transport = new Transport();
	}
	public ResultMessage add(LoadDocVO vo) {
		return transport.add(vo);
	}

	public ArrayList<LoadDocVO> getDayLoadDocs(MyDate date) {
		return transport.getDayLoadDocs(date);
	}

	public ResultMessage add(SendGoodDocVO vo) {
		return transport.add(vo);
	}

	public ArrayList<SendGoodDocVO> getDaySendDocs(MyDate date) {
		return transport.getDaySendDocs(date);
	}

	public ResultMessage add(ArriveYYDocVO vo) {
		return transport.add(vo);
	}

	public ArrayList<ArriveYYDocVO> getDayArriveYYDocs(MyDate date) {
		return transport.getDayArriveYYDocs(date);
	}

	public ResultMessage add(ArriveZZDocVO vo) {
		return transport.add(vo);
	}

	public ArrayList<ArriveZZDocVO> getDayArriveZZDocs(MyDate date) {
		return transport.getDayArriveZZDocs(date);
	}

	public ResultMessage add(TransferDocVO vo) {
		return transport.add(vo);
	}

	public ArrayList<TransferDocVO> getDayTransferDocs(MyDate date) {
		return transport.getDayTransferDocs(date);
	}

	public ArrayList<DocVO> getDoc(DocType type) {
		return transport.getDoc(type);
	}


	public double getExpense(ArriveZZDocVO arriveVO, TransferDocVO transferVO) {
		return transport.getExpense(arriveVO,transferVO);
	}

	public ResultMessage changeDocsState(ArrayList<String> docsID, DocType type, DocState state) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage changeOneDocState(String docID, DocType type, DocState state) {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<? extends DocVO> getDocLists(DocType type) {
		// TODO Auto-generated method stub
		return null;
	}
	public DocVO getByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
