package blservice.storeblservice;

import java.util.ArrayList;

import util.City;
import util.DocType;
import util.ResultMessage;
import util.TransferWay;
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

	public String getAlarmValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage setAlarmValue(String value, String city) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAlarmValue(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage setAlarmValue(String value, City city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAlarmValue(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateStore(City loc, TransferWay way, String ID, DocType type) {
		// TODO Auto-generated method stub
		return null;
	}

}
