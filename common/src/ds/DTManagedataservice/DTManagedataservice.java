package ds.DTManagedataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.DTManage.CarPO;
import po.DTManage.DriverPO;
import util.ResultMessage;
import ds.DataserviceParent;

/**
 * 车辆、司机信息数据层接口
 * @author JerryZhang
 *
 */
public interface DTManagedataservice extends DataserviceParent{
	
	/**
	 * 获得所有车辆信息
	 * @return
	 */
	public ArrayList<CarPO> getAllCars()  throws RemoteException;
	/**
	 * 获得所有司机信息
	 * @return
	 */
	public ArrayList<DriverPO> getAllDrivers()  throws RemoteException;
	/**
	 * 得到司机信息PO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public DriverPO getDriverMes(String id) throws RemoteException;
	/**
	 * 通过名字得到司机信息
	 * @param name
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<DriverPO> getDriverByName(String name) throws RemoteException;
	/**
	 * 通过机构得到司机信息
	 * @param inst
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<DriverPO> getDriverByInst(String inst) throws RemoteException;
	/**
	 * 得到车辆信息PO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public CarPO getCarMes(String id) throws RemoteException;
	
	/**
	 * 根据车牌号获得车辆信息
	 * @param plateNum
	 * @return
	 * @throws RemoteException
	 */
	public CarPO checkByPlateNum(String plateNum)throws RemoteException;
	/**
	 * 增加一个司机PO
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addDriverPO(DriverPO po)throws RemoteException;
	/**
	 * 增加一个车辆PO
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addCarPO(CarPO po)throws RemoteException;
	/**
	 * 更新一个司机PO
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage updateDriverPo(DriverPO po) throws RemoteException;
	/**
	 * 删除司机信息
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage delDriverPO(String ID) throws RemoteException;
	/**
	 * 更新一个车辆PO
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage updateCarPo(CarPO po) throws RemoteException;
	/**
	 * 删除车辆信息
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage delCarPO(String ID) throws RemoteException;
	
}
