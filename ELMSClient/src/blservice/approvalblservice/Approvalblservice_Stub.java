package blservice.approvalblservice;

import java.util.ArrayList;

import util.DocType;
import util.ResultMessage;
import vo.DocVO;
import vo.LoadDocVO;
import vo.OrderVO;
 /** * @author czq @version 创建时间：2015年10月25日 下午3:28:42 * 简单说明 */
public class Approvalblservice_Stub implements Approvalblservice {
	public ArrayList<DocVO> getBills(DocType type) {
		ArrayList<DocVO> result = new ArrayList<DocVO>();
		result.add(new OrderVO(null, null, null, null, null, null, null, null, null, null, null, null, 0, null, 0, 0, 0, 0, null, null, 0, 0, null));
		result.add(new LoadDocVO(null, null, 0, 0, null, 0, null, null));
		return result;
		
	}

	public ResultMessage approveOne(DocVO vo) {
		return ResultMessage.SUCCESS;
		
	}

	public ResultMessage approveMany(ArrayList<DocVO> vos) {
		return ResultMessage.SUCCESS;
	}

}
