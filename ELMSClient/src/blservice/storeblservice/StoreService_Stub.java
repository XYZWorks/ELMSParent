package blservice.storeblservice;

import java.util.ArrayList;

import util.ResultMessage;
import vo.StoreCheckVO;
import vo.StoreMessageVO;
/**
 * 
 * @author ymc
 *
 */
public class StoreService_Stub implements StoreblService {

	public ArrayList<StoreMessageVO> show() {
		StoreMessageVO vo1=new StoreMessageVO("上海", 1000, null, null);
		StoreMessageVO vo2=new StoreMessageVO("南京", 900, null, null);
		ArrayList<StoreMessageVO> storeMes=new ArrayList<StoreMessageVO>();
		storeMes.add(vo1);
		storeMes.add(vo2);
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
