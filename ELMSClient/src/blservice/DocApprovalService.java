package blservice;

import java.util.ArrayList;
 



import util.DocState;
import util.DocType;
import util.ResultMessage;
import vo.DocVO;
/** 
 * 单据审批的接口，提供获取单据和修改单据的接口
 * @author czq 
 * @version 2015年11月15日 上午9:56:03 
 */
public interface DocApprovalService {
	/**
	 * 获得单据列表
	 * @return
	 */
	public ArrayList<? extends DocVO> getDocLists(DocType type);
	/**
	 * 批量修改单据状态
	 * @param docsID
	 * @return
	 */
	public ResultMessage changeDocsState(ArrayList<String> docsID , DocType type , DocState state);
	/**
	 * 修改单个单据状态
	 * @param docID
	 * @return
	 */
	public ResultMessage changeOneDocState(String docID,
			DocType type, DocState state);
	
	
}
