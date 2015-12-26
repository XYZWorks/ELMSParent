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
import vo.transport.PayDocVO;
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
	private Transportdataservice transportData;
	public TransportController() {
		transportData  = (Transportdataservice) RMIManage.getDataService(DataServiceType.TransportDataService);

		transport = new Transport(transportData , BusinessLogicDataFactory.getFactory().getOrderBussinessLogic() , BusinessLogicDataFactory.getFactory().getStrategyBusinessLogic());

	}
	
	@Override
	public ResultMessage add(LoadDocVO vo) {
		return transport.add(vo);
	}

	@Override
	public ArrayList<LoadDocVO> getDayLoadDocs(MyDate date) {
		return transport.getDayLoadDocs(date);
	}

	@Override
	public ResultMessage add(SendGoodDocVO vo) {
		return transport.add(vo);
	}

	@Override
	public ArrayList<SendGoodDocVO> getDaySendDocs(MyDate date) {
		return transport.getDaySendDocs(date);
	}

	@Override
	public ResultMessage add(ArriveYYDocVO vo) {
		return transport.add(vo);
	}

	@Override
	public ArrayList<ArriveYYDocVO> getDayArriveYYDocs(MyDate date) {
		return transport.getDayArriveYYDocs(date);
	}

	@Override
	public ResultMessage add(ArriveZZDocVO vo) {
		return transport.add(vo);
	}

	@Override
	public ArrayList<ArriveZZDocVO> getDayArriveZZDocs(MyDate date) {
		return transport.getDayArriveZZDocs(date);
	}

	@Override
	public ResultMessage add(TransferDocVO vo) {
		return transport.addTransferDoc(vo);
	}

	@Override
	public ArrayList<TransferDocVO> getDayTransferDocs(MyDate date) {
		return transport.getDayTransferDocs(date);
	}

	@Override
	public ArrayList<DocVO> getDoc(DocType type) {
		return transport.getDoc(type);
	}


	@Override
	public double getExpense(OutStoreDocVO outStoreVO, TransferDocVO transferVO) {
		return transport.getExpense(outStoreVO,transferVO);
	}

	@Override
	public ResultMessage changeDocsState(ArrayList<String> docsID, DocType type, DocState state) {
		return transport.changeDocsState(docsID , type , state);
	}

	@Override
	public ResultMessage changeOneDocState(String docID, DocType type, DocState state) {
		return transport.changeOneDocState(docID , type , state);
	}
	@Override
	public ArrayList<? extends DocVO> getDocLists(DocType type) {
		return transport.getDocLists(type);
	}
	@Override
	public DocVO getByID(String ID , DocType type) {
		return transport.getDocByID(ID , type);
	}

	@Override
	public ResultMessage addOnePay(PayDocVO vo) {
		
		return transport.addOnePay(vo);
	}

	@Override
	public ArrayList<PayDocVO> getPays() {
		return transport.getPays();
	}

	@Override
	public int getDayDocCount(DocType type) {
		
		return transport.getDayDocCount(type);
	}
	
	

}
