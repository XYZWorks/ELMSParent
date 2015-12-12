package bl.DTManagebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.DTManage.CarPO;
import po.DTManage.DriverPO;
import test.java.other.VOPOchange;
import util.ResultMessage;
import vo.DTManage.CarVO;
import vo.DTManage.DriverVO;
import ds.DTManagedataservice.DTManagedataservice;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:45:48 
 *
 */
public class DTManage{
	
	
	private DTManagedataservice manageData;
	private ResultMessage result = null;
	public DTManage(DTManagedataservice manageData) {
		this.manageData = manageData;
	}
	public ResultMessage addDriver(DriverVO vo) {
		
		DriverPO po = (DriverPO) VOPOchange.VOtoPO(vo);
		try {
			result = manageData.addDriverPO(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public ArrayList<DriverVO> checkDriverByName(String name) {
		
		ArrayList<DriverPO> pos = new ArrayList<DriverPO>();
		

		try {
			pos = manageData.getDriverByName(name);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if (pos == null) {
			return null;
		}
		
		ArrayList<DriverVO> vos = new ArrayList<DriverVO>(pos.size());
		for(DriverPO po : pos){
			vos.add((DriverVO)VOPOchange.POtoVO(po));
		}
		return vos;
	}

	public DriverVO checkDriverByID(String ID) {
		
		DriverPO po = null;
		
		try {
			po = manageData.getDriverMes(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		DriverVO vo = (DriverVO) VOPOchange.POtoVO(po);
		return vo;
	}

	public ArrayList<DriverVO> checkDriverByInst(String InstID) {
		
		ArrayList<DriverPO> pos = new ArrayList<DriverPO>();
		

		try {
			pos = manageData.getDriverByInst(InstID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		ArrayList<DriverVO> vos = new ArrayList<DriverVO>(pos.size());
		for(DriverPO po : pos){
			vos.add((DriverVO)VOPOchange.POtoVO(po));
		}
		return vos;
	}

	public ResultMessage modifyDriver(DriverVO vo) {
		DriverPO po = (DriverPO) VOPOchange.VOtoPO(vo);
		try {
			result = manageData.updateDriverPo(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public ResultMessage delDriver(String ID) {
		result = null;
		try {
			result = manageData.delDriverPO(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public ArrayList<String> getDriverName(String InstID) {
		ArrayList<DriverVO> vos = checkDriverByInst(InstID);
		
		
		if (vos == null) {
			return null;
		}
		
		ArrayList<String> names = new ArrayList<String>(vos.size());
		for(DriverVO vo : vos){
			names.add(vo.name);
		}
		return names;
	}

	public ResultMessage addCar(CarVO vo) {
		result = null;
		try {
			result =  manageData.addCarPO((CarPO) VOPOchange.VOtoPO(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public CarVO checkCarByID(String ID) {
		CarVO vo = null;
		
		try {
			vo = (CarVO) VOPOchange.POtoVO(manageData.getCarMes(ID));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vo;
	}

	public CarVO checkByPlateNum(String plateNum) {
		CarVO vo = null;
		
		try {
			vo = (CarVO) VOPOchange.POtoVO(manageData.checkByPlateNum(plateNum));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vo;
	}

	public ResultMessage modifyCar(CarVO vo) {
		try {
			return manageData.updateCarPo((CarPO) VOPOchange.VOtoPO(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return ResultMessage.FAIL;
	}

	public ResultMessage delCar(String ID) {
		try {
			return manageData.delCarPO(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	public ArrayList<String> getPlateNumber(String InstID) {
		
		return null;
	}
	public ArrayList<CarVO> getAllCars() {
		
		return null;
	}
	public ArrayList<DriverVO> getAllDrivers() {
		// TODO Auto-generated method stub
		return null;
	}
}
