package bl.approvalbl;

import java.util.ArrayList;

import blservice.approvalblservice.Approvalblservice;
import blservice.orderblservice.Orderblservice;
import blservice.storeblservice.StoreService;
import blservice.transportblservice.Transportblservice;
import util.DocType;
import util.ResultMessage;
import vo.DocVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:45:13 
 *
 */
public class ApprovalblImpl implements Approvalblservice {
	Transportblservice transportbl;
	Orderblservice orderbl;
	StoreService storebl;
	public ArrayList<DocVO> getBills(DocType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage approveOne(DocVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage approveMany(ArrayList<DocVO> vos) {
		// TODO Auto-generated method stub
		return null;
	}

}
