package bl.DTManagebl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import net.RMIManage;
import util.DataServiceType;
import util.ResultMessage;
import vo.DTManage.CarVO;
import vo.DTManage.DriverVO;
import bl.BusinessController;
import blservice.DTManageblservice.DTManageblservice;
import ds.DTManagedataservice.DTManagedataservice;
import exception.ExceptionHandler;
 /** 
 * 车辆司机信息管理逻辑层控制器
 * @author czq 
 * @version 2015年11月15日 上午9:16:29 
 */
public class DTManageController extends BusinessController implements DTManageblservice{
	
	private DTManage dtm;
	private DTManagedataservice manageData ;
	
	public DTManageController() {
		myType = DataServiceType.DTManageDataService;
		manageData = (DTManagedataservice) RMIManage.getDataService(DataServiceType.DTManageDataService);
		dtm = new DTManage(manageData);
		
	}
	@Override
	public ResultMessage addDriver(DriverVO vo) {
		try {
			return dtm.addDriver(vo);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return addDriver(vo);
			}
		}
		return ResultMessage.FAIL;
	}
	@Override
	public ArrayList<DriverVO> checkDriverByName(String name) {
		try {
			return dtm.checkDriverByName(name);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return checkDriverByName(name);
			}
		}
		return null;
	}
	@Override
	public DriverVO checkDriverByID(String ID) {
		try {
			return dtm.checkDriverByID(ID);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return checkDriverByID(ID);
			}
		}
		return null;
	}
	@Override
	public ArrayList<DriverVO> checkDriverByInst(String InstID) {
		try {
			return dtm.checkDriverByInst(InstID);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return checkDriverByInst(InstID);
			}
		}
		return null;
	}
	@Override
	public ResultMessage modifyDriver(DriverVO vo) {
		try {
			return dtm.modifyDriver(vo);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return modifyDriver(vo);
			}
		}
		return ResultMessage.FAIL;
	}
	@Override
	public ResultMessage delDriver(String ID) {
		try {
			return dtm.delDriver(ID);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return delDriver(ID);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<String> getDriverName(String InstID) {
		try {
			return dtm.getDriverName(InstID);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return getDriverName(InstID);
			}
		}
		return null;
	}



	@Override
	public CarVO checkCarByID(String ID) {
		try {
			return dtm.checkCarByID(ID);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return checkCarByID(ID);
			}
		}
		return null;
	}

	@Override
	public CarVO checkByPlateNum(String plateNum) {
		try {
			return dtm.checkByPlateNum(plateNum);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return checkByPlateNum(plateNum);
			}
		}
		return null;
	}
	@Override
	public ResultMessage addCar(CarVO vo) {
		try {
			return dtm.addCar(vo);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return addCar(vo);
			}
		}
		return ResultMessage.FAIL;
	}
	@Override
	public ResultMessage modifyCar(CarVO vo) {
		try {
			return dtm.modifyCar(vo);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return modifyCar(vo);
			}

		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage delCar(String ID) {
		try {
			return dtm.delCar(ID);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return delCar(ID);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<String> getPlateNumber(String instID) {
		
		try {
			return dtm.getPlateNumber(instID);
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return getPlateNumber(instID);
			}
		}
		return null;
	}
	@Override
	public ArrayList<CarVO> getAllCars() {
		try {
			return dtm.getAllCars();
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return getAllCars();
			}
		}
		return null;
	}
	@Override
	public ArrayList<DriverVO> getAllDrivers() {
		try {
			return dtm.getAllDrivers();
		} catch (RemoteException e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				return getAllDrivers();
			}
		}
		return null;
	}
	
	@Override
	public void reinitDataService(Remote dataService) {
		manageData = (DTManagedataservice) dataService;
		dtm = new DTManage(manageData);
		
	}
	

}
