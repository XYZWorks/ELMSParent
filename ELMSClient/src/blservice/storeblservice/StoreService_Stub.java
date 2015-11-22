package blservice.storeblservice;

import java.util.ArrayList;

import util.ResultMessage;
import vo.store.StoreCheckVO;
import vo.store.StoreMessageVO;
/**
 * 
 * @author ymc
 *
 */
public class StoreService_Stub implements StoreblService {

	public ArrayList<StoreMessageVO> show() {

		ArrayList<StoreMessageVO> storeMes=new ArrayList<StoreMessageVO>();
		
		return storeMes;
	}

	public ArrayList<StoreCheckVO> showCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage exportExcel(String path) {
		if("/".equals(path.substring(0,1)))
			return ResultMessage.SUCCESS;
		else
			return ResultMessage.FAIL;
	}

	public ResultMessage update(StoreMessageVO vo) {
		
		return ResultMessage.SUCCESS;
	}

	public ResultMessage setAlarmValue(String value) {
		if(Integer.parseInt(value)<100&&Integer.parseInt(value)>0)		
			return ResultMessage.SUCCESS;
		else 
			return ResultMessage.FAIL;
	}

}
