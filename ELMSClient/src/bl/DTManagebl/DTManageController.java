package bl.DTManagebl;

import java.util.ArrayList;

import net.RMIManage;
import util.DataServiceType;
import util.ResultMessage;
import vo.DTManage.CarVO;
import vo.DTManage.DriverVO;
import blservice.DTManageblservice.DTManageblservice;
import ds.DTManagedataservice.DTManagedataservice;
 /** 
 * 车辆司机信息管理逻辑层控制器
 * @author czq 
 * @version 2015年11月15日 上午9:16:29 
 */
public class DTManageController implements DTManageblservice{
	
	private DTManage dtm;
	private DTManagedataservice manageData = (DTManagedataservice) RMIManage.getDataService(DataServiceType.DTManageDataService);
	
	public DTManageController() {
		dtm = new DTManage(manageData);
	}
	@Override
	public ResultMessage addDriver(DriverVO vo) {
		return dtm.addDriver(vo);
	}
	@Override
	public ArrayList<DriverVO> checkDriverByName(String name) {
		return dtm.checkDriverByName(name);
	}
	@Override
	public DriverVO checkDriverByID(String ID) {
		return dtm.checkDriverByID(ID);
	}
	@Override
	public ArrayList<DriverVO> checkDriverByInst(String InstID) {
		return dtm.checkDriverByInst(InstID);
	}
	@Override
	public ResultMessage modifyDriver(DriverVO vo) {
		return dtm.modifyDriver(vo);
	}
	@Override
	public ResultMessage delDriver(DriverVO vo) {
		return dtm.delDriver(vo);
	}

	public ArrayList<String> getDriverName(String InstID) {
		return dtm.getDriverName(InstID);
	}



	public CarVO checkCarByID(String ID) {
		return dtm.checkCarByID(ID);
	}

	public CarVO checkByPlateNum(String plateNum) {
		return dtm.checkByPlateNum(plateNum);
	}
	@Override
	public ResultMessage addCar(CarVO vo) {
		return dtm.addCar(vo);
	}
	public ResultMessage modifyCar(CarVO vo) {
		return dtm.modifyCar(vo);
	}

	public ResultMessage delCar(CarVO vo) {
		return dtm.delCar(vo);
	}

	public ArrayList<String> getPlateNumber(String instID) {
		
		return dtm.getPlateNumber(instID);
	}
	@Override
	public ArrayList<CarVO> getAllCars() {
		return dtm.getAllCars();
	}
	@Override
	public ArrayList<DriverVO> getAllDrivers() {
		return dtm.getAllDrivers();
	}
	

}
