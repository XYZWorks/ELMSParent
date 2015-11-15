package bl.approvalbl;

import java.util.ArrayList;

import util.DocType;
import util.ResultMessage;
import vo.DocVO;
import blservice.orderblservice.Orderblservice;
import blservice.storeblservice.StoreblService;
import blservice.transportblservice.Transportblservice;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:45:13 
 *
 */
public class Approval {
	Transportblservice transportbl;
	Orderblservice orderbl;
	StoreblService storebl;
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
