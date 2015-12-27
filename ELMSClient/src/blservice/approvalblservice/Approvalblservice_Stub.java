package blservice.approvalblservice;

import java.util.ArrayList;

import test.java.other.DataTool;
import util.DocType;
import util.ResultMessage;
import vo.DocVO;
 /** * @author czq @version 创建时间：2015年10月25日 下午3:28:42 * 简单说明 */
public class Approvalblservice_Stub implements Approvalblservice {
	@Override
	public ArrayList<? extends DocVO> getBills(DocType type) {
		
		return DataTool.getDocList(DocType.arriveYYDoc);
		
	}

	@Override
	public ResultMessage approveOne(DocVO vo) {
		return ResultMessage.SUCCESS;
		
	}

	

	@Override
	public ResultMessage approveMany(ArrayList<? extends DocVO> docsVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
