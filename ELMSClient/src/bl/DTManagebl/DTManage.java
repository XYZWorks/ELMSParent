package bl.DTManagebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import po.DTManage.CarPO;
import po.DTManage.DriverPO;
import util.ResultMessage;
import vo.DTManage.CarVO;
import vo.DTManage.DriverVO;
import ds.DTManagedataservice.DTManagedataservice;

/**
 * @author ymc
 * @version 创建时间：2015年10月27日 下午7:45:48
 *
 */
public class DTManage {

	private DTManagedataservice manageData;
	private ResultMessage result = null;

	public DTManage(DTManagedataservice manageData) {
		this.manageData = manageData;
	}

	public ResultMessage addDriver(DriverVO vo) throws RemoteException {

		DriverPO po = (DriverPO) VOPOchange.VOtoPO(vo);
		result = manageData.addDriverPO(po);

		return result;
	}

	public ArrayList<DriverVO> checkDriverByName(String name)
			throws RemoteException {

		ArrayList<DriverPO> pos = new ArrayList<DriverPO>();

		pos = manageData.getDriverByName(name);
		if (pos == null) {
			return null;
		}

		ArrayList<DriverVO> vos = new ArrayList<DriverVO>(pos.size());
		for (DriverPO po : pos) {
			vos.add((DriverVO) VOPOchange.POtoVO(po));
		}
		return vos;
	}

	public DriverVO checkDriverByID(String ID) throws RemoteException {

		DriverPO po = null;

		po = manageData.getDriverMes(ID);

		DriverVO vo = (DriverVO) VOPOchange.POtoVO(po);
		return vo;
	}

	public ArrayList<DriverVO> checkDriverByInst(String InstID)
			throws RemoteException {

		ArrayList<DriverPO> pos = new ArrayList<DriverPO>();

		pos = manageData.getDriverByInst(InstID);

		ArrayList<DriverVO> vos = new ArrayList<DriverVO>(pos.size());
		for (DriverPO po : pos) {
			vos.add((DriverVO) VOPOchange.POtoVO(po));
		}
		return vos;
	}

	public ResultMessage modifyDriver(DriverVO vo) throws RemoteException {
		DriverPO po = (DriverPO) VOPOchange.VOtoPO(vo);
		result = manageData.updateDriverPo(po);

		return result;
	}

	public ResultMessage delDriver(String ID) throws RemoteException {
		result = null;
		result = manageData.delDriverPO(ID);

		return result;
	}

	public ArrayList<String> getDriverName(String InstID)
			throws RemoteException {
		ArrayList<DriverVO> vos = checkDriverByInst(InstID);

		if (vos == null) {
			return null;
		}

		ArrayList<String> names = new ArrayList<String>(vos.size());
		for (DriverVO vo : vos) {
			names.add(vo.name);
		}
		return names;
	}

	public ResultMessage addCar(CarVO vo) throws RemoteException {
		result = null;
		result = manageData.addCarPO((CarPO) VOPOchange.VOtoPO(vo));
		return result;
	}

	public CarVO checkCarByID(String ID) throws RemoteException {

		return (CarVO) VOPOchange.POtoVO(manageData.getCarMes(ID));

	}

	public CarVO checkByPlateNum(String plateNum) throws RemoteException {
		return (CarVO) VOPOchange.POtoVO(manageData.checkByPlateNum(plateNum));
	}

	public ResultMessage modifyCar(CarVO vo) throws RemoteException {
		return manageData.updateCarPo((CarPO) VOPOchange.VOtoPO(vo));

	}

	public ResultMessage delCar(String ID) throws RemoteException {
		return manageData.delCarPO(ID);
	}

	public ArrayList<String> getPlateNumber(String InstID)
			throws RemoteException {
		return manageData.getPlateNums();
	}

	public ArrayList<CarVO> getAllCars() throws RemoteException {
		ArrayList<CarPO> pos = null;
		pos = manageData.getAllCars();
		if (pos == null) {
			return null;
		}

		ArrayList<CarVO> vos = new ArrayList<>(pos.size());
		for (CarPO carPO : pos) {
			vos.add((CarVO) VOPOchange.POtoVO(carPO));
		}

		return vos;
	}

	public ArrayList<DriverVO> getAllDrivers() throws RemoteException {
		ArrayList<DriverPO> pos = null;
		pos = manageData.getAllDrivers();
		if (pos == null) {
			return null;
		}

		ArrayList<DriverVO> vos = new ArrayList<>(pos.size());
		for (DriverPO driverPO : pos) {
			vos.add((DriverVO) VOPOchange.POtoVO(driverPO));
		}

		return vos;
	}
}
