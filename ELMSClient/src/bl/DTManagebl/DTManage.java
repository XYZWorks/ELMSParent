package bl.DTManagebl;

import java.util.ArrayList;

import blservice.DTManageblservice.DTManageblservice;
import ds.DTManagedataservice.DTManagedateservice;
import util.ResultMessage;
import vo.CarVO;
import vo.DriverVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:45:48 
 *
 */
public class DTManage{
	
	
	DTManagedateservice manageData;
	
	
	public ResultMessage add(DriverVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DriverVO> CheckByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public DriverVO CheckDriverByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DriverVO> CheckByInst(String InstID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage modify(DriverVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage Del(DriverVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getDriverName(String InstID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage add(CarVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public CarVO CheckCarByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public CarVO CheckByPlateNum(String PlateNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage modify(CarVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage Del(CarVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getPlateNumber(String InstID) {
		// TODO Auto-generated method stub
		return null;
	}

}
