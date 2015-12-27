package blservice.DTManageblservice;

import java.util.ArrayList;

import test.java.other.DataTool;
import util.ResultMessage;
import vo.DTManage.CarVO;
import vo.DTManage.DriverVO;

public class DTManageblservice_Stub implements DTManageblservice{

	@Override
	public ResultMessage addDriver(DriverVO vo) {
		// TODO 自动生成的方法存根
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<DriverVO> checkDriverByName(String name) {
		;
		ArrayList<DriverVO> temp = new ArrayList<DriverVO>();

		return temp;
	}

	@Override
	public DriverVO checkDriverByID(String ID) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<DriverVO> checkDriverByInst(String InstID) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage modifyDriver(DriverVO vo) {
		// TODO 自动生成的方法存根
		return ResultMessage.SUCCESS;
	}

	public ResultMessage delDriver(DriverVO vo) {
		// TODO 自动生成的方法存根
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<String> getDriverName(String InstID) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage addCar(CarVO vo) {
		// TODO 自动生成的方法存根
		return ResultMessage.SUCCESS;
	}

	@Override
	public CarVO checkCarByID(String ID) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public CarVO checkByPlateNum(String PlateNum) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage modifyCar(CarVO vo) {
		// TODO 自动生成的方法存根
		return ResultMessage.SUCCESS;
	}

	public ResultMessage delCar(CarVO vo) {
		// TODO 自动生成的方法存根
		return ResultMessage.SUCCESS;
	}

	@Override
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

	@Override
	public ResultMessage delDriver(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delCar(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

}
