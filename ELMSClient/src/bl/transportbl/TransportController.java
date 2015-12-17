package bl.transportbl;

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
import vo.transport.SendGoodDocVO;
import vo.transport.TransferDocVO;
import bl.BusinessLogicDataFactory;
import blservice.transportblservice.Transportblservice;
import ds.transportdataservice.Transportdataservice;
 /** 
 * 货物流转controller类
 * @author czq 
 * @version 2015年11月15日 上午9:27:08 
 */
public class TransportController implements Transportblservice{

	private Transport transport ;
	private Transportdataservice transportData = (Transportdataservice) RMIManage.getDataService(DataServiceType.TransportDataService);
	public TransportController() {
	}
	public void myInit(){
		transport = new Transport(transportData , BusinessLogicDataFactory.getFactory().getOrderBussinessLogic() , BusinessLogicDataFactory.getFactory().getStrategyBusinessLogic());
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
		return transport.addTransferDoc(vo);
	}

	public ArrayList<TransferDocVO> getDayTransferDocs(MyDate date) {
		return transport.getDayTransferDocs(date);
	}

	public ArrayList<DocVO> getDoc(DocType type) {
		return transport.getDoc(type);
	}


	public double getExpense(OutStoreDocVO outStoreVO, TransferDocVO transferVO) {
		return transport.getExpense(outStoreVO,transferVO);
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
	public DocVO getByID(String ID , DocType type) {
		return transport.getDocByID(ID , type);
	}
	
	

}
