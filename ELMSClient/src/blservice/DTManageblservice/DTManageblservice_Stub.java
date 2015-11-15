package blservice.DTManageblservice;

import java.util.ArrayList;
import util.Date;

import util.CarList;
import util.DriverList;
import util.ResultMessage;
import util.StaffType;
import vo.CarVO;
import vo.DriverVO;
import vo.PersonVO;

public class DTManageblservice_Stub implements DTManageblservice{

	public ResultMessage add(DriverVO vo) {
		// TODO 自动生成的方法存根
		return ResultMessage.SUCCESS;
	}

	public ArrayList<DriverVO> CheckByName(String name) {
		;
		ArrayList<DriverVO> temp = new ArrayList<DriverVO>();
//		temp.add(new DriverVO("11111111","张三",new Date(2013, 11, 12),"11111111","12345678901",true, 1));
//		temp.add(new DriverVO("11111111","张三",new Date(2013, 11, 12),"11111111","12345678901",true , 0));
		return temp;
	}

	public DriverVO CheckDriverByID(String ID) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<DriverVO> CheckByInst(String InstID) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ResultMessage modify(DriverVO vo) {
		// TODO 自动生成的方法存根
		return ResultMessage.SUCCESS;
	}

	public ResultMessage Del(DriverVO vo) {
		// TODO 自动生成的方法存根
		return ResultMessage.SUCCESS;
	}

	public ArrayList<String> getDriverName(String InstID) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ResultMessage add(CarVO vo) {
		// TODO 自动生成的方法存根
		return ResultMessage.SUCCESS;
	}

	public CarVO CheckCarByID(String ID) {
		// TODO 自动生成的方法存根
		return null;
	}

	public CarVO CheckByPlateNum(String PlateNum) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ResultMessage modify(CarVO vo) {
		// TODO 自动生成的方法存根
		return ResultMessage.SUCCESS;
	}

	public ResultMessage Del(CarVO vo) {
		// TODO 自动生成的方法存根
		return ResultMessage.SUCCESS;
	}

	public ArrayList<String> getPlateNumber(String InstID) {
		// TODO 自动生成的方法存根
		return null;
	}

}
