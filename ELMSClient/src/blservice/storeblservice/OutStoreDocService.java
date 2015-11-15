package blservice.storeblservice;

import java.util.ArrayList;

import blservice.DocApprovalService;
import util.ResultMessage;
import vo.OutStoreDocVO;

/**
 * 
 * @author ymc
 *
 */
public interface OutStoreDocService extends DocApprovalService{
	/**
	 * 
	 * @return ArrayList<OutStoreDocVO>
	 */
	public ArrayList<OutStoreDocVO> showOutStoreDocs();
	/**
	 * 生成新单据  
	 * @param vo
	 * @return
	 */
	public ResultMessage generate(OutStoreDocVO vo);
}
