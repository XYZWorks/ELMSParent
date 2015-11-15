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
		return result;
		
	}

	public ResultMessage approveOne(DocVO vo) {
		return ResultMessage.SUCCESS;
		
	}

	public ResultMessage approveMany(ArrayList<DocVO> vos) {
		return ResultMessage.SUCCESS;
	}

}
