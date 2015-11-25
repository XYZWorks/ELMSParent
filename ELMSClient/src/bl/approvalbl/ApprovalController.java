package bl.approvalbl;

import java.util.ArrayList;

import bl.orderbl.OrderController;
import bl.storebl.StoreController;
import bl.transportbl.TransportController;
import util.DocType;
import util.ResultMessage;
import vo.DocVO;
import blservice.approvalblservice.Approvalblservice;
import blservice.orderblservice.Orderblservice;
import blservice.storeblservice.StoreblService;
import blservice.transportblservice.Transportblservice;

/**
 * 
 * @author czq
 * @version 2015年11月15日 上午9:16:14
 */
public class ApprovalController implements Approvalblservice {

	Transportblservice transportbl;
	Orderblservice orderbl;
	StoreblService storebl;
	
	Approval approval;

	public ApprovalController() {
		
		
		approval = new Approval();
	}

	public ArrayList<DocVO> getBills(DocType type) {
		transportbl = new TransportController();	
		storebl = new StoreController();
		orderbl = new OrderController();
		
		
		return approval.getBills(type);
	}

	public ResultMessage approveOne(DocVO vo) {
		return approval.approveOne(vo);
	}

	public ResultMessage approveMany(ArrayList<? extends DocVO> docsVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
