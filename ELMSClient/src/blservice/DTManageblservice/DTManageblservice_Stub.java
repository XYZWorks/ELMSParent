package blservice.DTManageblservice;

import java.util.ArrayList;

import test.java.other.DataTool;
import util.MyDate;
import util.CarList;
import util.DriverList;
import util.ResultMessage;
import util.StaffType;
import vo.DTManage.CarVO;
import vo.DTManage.DriverVO;
import vo.personnel.PersonVO;

public class DTManageblservice_Stub implements DTManageblservice{

	public ResultMessage add(DriverVO vo) {
		// TODO 自动生成的方法存根
		return ResultMessage.SUCCESS;
	}

	public ArrayList<DriverVO> CheckByName(String name) {
		;
		ArrayList<DriverVO> temp = new ArrayList<DriverVO>();

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

	@Override
	public ArrayList<CarVO> getAllCars() {
		
		return DataTool.getcarlist();
	}

	@Override
	public ArrayList<DriverVO> getAllDrivers() {
		// TODO Auto-generated method stub
		return DataTool.getDriverList();
	}

}
