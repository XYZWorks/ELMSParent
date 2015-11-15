package blservice.financeblservice;

import java.util.ArrayList;

import util.ResultMessage;
import vo.CostVO;

/**
 * 
 * @author ymc
 *
 */
public interface CostService {
	/**
	 * 查看cost信息
	 * @return
	 */
	public ArrayList<CostVO> showCosts();
	/**
	 * 增加cost信息
	 * @param vo
	 * @return
	 */
	public ResultMessage add(CostVO vo);
	/**
	 * 修改cost信息
	 * @param vo
	 * @return
	 */
	public ResultMessage modify(CostVO vo);
	/**
	 * 删除cost信息
	 * @param vo
	 * @return
	 */
	public ResultMessage del(CostVO vo);
	

}
