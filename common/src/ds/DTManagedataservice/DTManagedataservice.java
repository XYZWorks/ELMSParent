package ds.DTManagedataservice;

import java.rmi.RemoteException;

import po.CarPO;
import po.DriverPO;
import util.ResultMessage;
import ds.DataserviceParent;

/**
 * 车辆、司机信息数据层接口
 * @author JerryZhang
 *
 */
public interface DTManagedataservice extends DataserviceParent{
	/**
	 * 得到司机信息PO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public DriverPO getDriverMes(String id) throws RemoteException;
	/**
	 * 得到车辆信息PO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public CarPO getCarMes(String id) throws RemoteException;
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
	 * 更新一个车辆PO
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage updateCarPo(CarPO po) throws RemoteException;
	
	
}
