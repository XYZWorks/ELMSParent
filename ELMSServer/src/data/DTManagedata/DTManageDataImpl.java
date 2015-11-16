package data.DTManagedata;

import java.rmi.RemoteException;

import po.CarPO;
import po.DriverPO;
import util.ResultMessage;
import dataSuper.DataSuperClass;
import ds.DTManagedataservice.DTManagedateservice;
 /** 
 * 车辆司机信息管理
 * @author czq 
 * @version 2015年11月5日 下午8:45:11 
 */
public class DTManageDataImpl extends DataSuperClass implements DTManagedateservice{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DTManageDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public DriverPO getDriverMes(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public CarPO getCarMes(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addDriverPO(DriverPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addCarPO(CarPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage updateDriverPo(DriverPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage updateCarPo(CarPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
