package bl.DTManagebl;

import java.util.ArrayList;

import util.ResultMessage;
import vo.DTManage.CarVO;
import vo.DTManage.DriverVO;
import blservice.DTManageblservice.DTManageblservice;
 /** 
 * 
 * @author czq 
 * @version 2015年11月15日 上午9:16:29 
 */
public class DTManageController implements DTManageblservice{

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
