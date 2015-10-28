package blservice.storeblservice;

import java.util.ArrayList;

import util.ResultMessage;
import vo.OutStoreDocVO;

/**
 * 
 * @author ymc
 *
 */
public interface OutStoreDocService {
	/**
	 * 
	 * @return ArrayList<OutStoreDocVO>
	 */
	public ArrayList<OutStoreDocVO> show();
	/**
	 * 生成新单据  
	 * @param vo
	 * @return
	 */
	public ResultMessage generate(OutStoreDocVO vo);
}
