package blservice.storeblservice;

import java.util.ArrayList;

import vo.InStoreDocVO;
import util.ResultMessage;

/**
 * 入库单借口
 * @author ymc
 *
 */
public interface InStoreDocService {
	/**
	 * 显示生成的入库单
	 * @return ArrayList<InStoreDocVO>
	 */
	public ArrayList<InStoreDocVO> show();
	/**
	 * 生成新单据  
	 * @param vo
	 * @return
	 */
	public ResultMessage generate(InStoreDocVO vo);
}
