package blservice.approvalblservice;

import java.util.ArrayList;

import util.DocType;
import util.ResultMessage;
import vo.DocVO;
 /**
  * 审批单据逻辑接口类
  * @author czq
  *
  */
public interface Approvalblservice {
	/**
	 * 获得某种类型单据单日的所有未审批单据
	 * @param type
	 * @return
	 */
	public ArrayList<? extends DocVO> getBills(DocType type);
	/**
	 * 审批通过单个单据
	 * @param vo
	 * @return
	 */
	public ResultMessage approveOne(DocVO vo);
	/**
	 * 审批通过多个单据
	 * @param docsVO
	 * @return
	 */
	public ResultMessage approveMany(ArrayList<? extends DocVO> docsVO);
}
