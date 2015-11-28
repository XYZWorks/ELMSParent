package blservice.storeblservice;
/**
 * 库存相关接口
 * @author ymc
 */
import java.util.ArrayList;

import util.City;
import util.ResultMessage;
import vo.store.StoreCheckVO;
import vo.store.StoreMessageVO;
/**
 * 库存管理接口
 * @author ymc
 *
 *
 */
public interface StoreblService {
	/**
	 * 显示库存信息
	 * @return
	 */
	public ArrayList<StoreMessageVO> show();
	/**
	 * 显示库存快照
	 * @return
	 */
	public ArrayList<StoreCheckVO> showCheck();
	/**
	 * 库存快照导出excel
	 * @param path
	 * @return
	 */
	public ResultMessage exportExcel(String path);
	/**
	 * 更新库存信息
	 * @param vo
	 * @return
	 */
	public ResultMessage update(StoreMessageVO vo);
	/**
	 * 设置库存报警值
	 * @param value
	 * @return
	 */
	public ResultMessage setAlarmValue(String value,City city);
	/**
	 * 得到库存报警值
	 * @return
	 */
	public String getAlarmValue(String city);


}
