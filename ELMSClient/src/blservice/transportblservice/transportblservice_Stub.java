package blservice.transportblservice;

import java.util.ArrayList;
import util.MyDate;

import util.DocType;
import util.ResultMessage;
import vo.DocVO;
import vo.transport.ArriveYYDocVO;
import vo.transport.ArriveZZDocVO;
import vo.transport.LoadDocVO;
import vo.transport.SendGoodDocVO;
import vo.transport.TransferDocVO;

public class transportblservice_Stub implements Transportblservice{

	public ResultMessage add(LoadDocVO vo) {
		// TODO 自动生成的方法存根
		return ResultMessage.SUCCESS;
	}

	

	public ResultMessage add(SendGoodDocVO vo) {
		return ResultMessage.SUCCESS;
	}

	

	public ResultMessage add(ArriveYYDocVO vo) {
		// TODO 自动生成的方法存根
		return ResultMessage.SUCCESS;
	}

	public ArrayList<ArriveYYDocVO> getDayArriveYYDocs(MyDate date) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ResultMessage add(ArriveZZDocVO vo) {
		// TODO 自动生成的方法存根
		return ResultMessage.SUCCESS;
	}

	public ArrayList<ArriveZZDocVO> getDayArriveZZDocs(MyDate date) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ResultMessage add(TransferDocVO vo) {
		// TODO 自动生成的方法存根
		return ResultMessage.SUCCESS;
	}

	public ArrayList<TransferDocVO> getDayTransferDocs(MyDate date) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<DocVO> getDoc(DocType type) {
		// TODO 自动生成的方法存根
		return null;
	}

	public double getExpense(DocType type) {
		// TODO 自动生成的方法存根
		return 1000;
	}

	public ArrayList<LoadDocVO> getDayLoadDocs(MyDate date) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<SendGoodDocVO> getDaySendDocs(MyDate date) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<DocVO> getDocLists() {
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

	public ArrayList<DocVO> getDocLists(DocType type) {
		// TODO Auto-generated method stub
		return null;
	}



	public double getExpense(ArriveZZDocVO arriveVO, TransferDocVO transferVO) {
		// TODO Auto-generated method stub
		return 0;
	}

}
