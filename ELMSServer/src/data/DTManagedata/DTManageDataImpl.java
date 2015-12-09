package data.DTManagedata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import po.DTManage.CarPO;
import po.DTManage.DriverPO;
import util.MyDate;
import util.ResultMessage;
import dataSuper.DataSuperClass;
import ds.DTManagedataservice.DTManagedataservice;
 /** 
 * 车辆司机信息管理
 * @author czq 
 * @version 2015年11月5日 下午8:45:11 
 */
public class DTManageDataImpl extends DataSuperClass implements DTManagedataservice{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 车辆信息表
	 */
	private final String carTable = "car";
	/**
	 * 司机信息表 
	 */
	private final String driverTable = "driver";
	
	
	public DTManageDataImpl() throws RemoteException {}
	
	public void initial() throws RemoteException {
		initialFromSQL(carTable);
		initialFromSQL(driverTable);
	}

	public DriverPO getDriverMes(String ID) throws RemoteException {
		findMes = findFromSQL(driverTable, ID);
		if(findMes == null){
			return null;
		}else{
			return new DriverPO(findMes.get(0), findMes.get(1), MyDate.getDate(findMes.get(2)), findMes.get(3), findMes.get(4),findMes.get(5) , helper.changeFromInt(findMes.get(6)), Integer.parseInt(findMes.get(7)));
		}
		
	}

	public CarPO getCarMes(String ID) throws RemoteException {
		findMes = findFromSQL(carTable, ID);
		if(findMes == null){
			return null;
		}else{
			return new CarPO(findMes.get(0), findMes.get(1), Integer.parseInt(findMes.get(2)));
		}
		
	}

	public ResultMessage addDriverPO(DriverPO po) throws RemoteException {
		return addToSQL(driverTable, po.getID() , po.getName() , MyDate.toString(po.getBirthDay()) , po.getIDcard() , po.getPhoneNum() , po.getIsman()?"1":"0" , String.valueOf(po.getLicenseYear()));
	}

	public ResultMessage addCarPO(CarPO po) throws RemoteException {
		return addToSQL(carTable, po.getID() , po.getPlateNum() , String.valueOf(po.getUseYear()));
	}

	public ResultMessage updateDriverPo(DriverPO po) throws RemoteException {
		return modifyFromSQL(driverTable,  po.getID() , po.getName() , MyDate.toString(po.getBirthDay()) , po.getIDcard() , po.getPhoneNum() , po.getIsman()?"1":"0" , String.valueOf(po.getLicenseYear()));
	}

	public ResultMessage updateCarPo(CarPO po) throws RemoteException {
		return modifyFromSQL(carTable,  po.getID() , po.getPlateNum() , String.valueOf(po.getUseYear()));
	}

	public ArrayList<DriverPO> getDriverByName(String name) throws RemoteException {
		ArrayList<DriverPO> pos = new ArrayList<DriverPO>();
		try {
			sql = "SELECT * FROM `" + driverTable +  "` WHERE `name` LIKE '%" + name + "%'";
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				pos.add(new DriverPO(result.getString(1), result.getString(2), MyDate.getDate(result.getString(3)), result.getString(4), result.getString(5),result.getString(6) ,  helper.changeFromInt(result.getString(7)), Integer.parseInt(result.getString(8))));
			}
			return (pos.isEmpty())?null:pos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	public ArrayList<DriverPO> getDriverByInst(String inst) throws RemoteException {
		ArrayList<DriverPO> pos = new ArrayList<DriverPO>();
		try {
			sql = "SELECT * FROM `" + driverTable +  "` WHERE instid = " +"\"" + inst +"\"";
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				pos.add(new DriverPO(result.getString(1), result.getString(2), MyDate.getDate(result.getString(3)), result.getString(4),result.getString(5) , result.getString(6), helper.changeFromInt(result.getString(7)), Integer.parseInt(result.getString(8))));
			}
			return (pos.isEmpty())?null:pos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	public ResultMessage delDriverPO(DriverPO po) throws RemoteException {
		
		return delFromSQL(driverTable, po.getID());
	}

	@Override
	public ArrayList<CarPO> getAllCars()  throws RemoteException{
		ArrayList<CarPO> pos = new ArrayList<CarPO>(50);
		try {
			sql = "SELECT * FROM `" + driverTable ;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				pos.add(new CarPO(result.getString(1), result.getString(2), Integer.parseInt(result.getString(3))));
			}
			return (pos.isEmpty())?null:pos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public ArrayList<DriverPO> getAllDrivers() throws RemoteException {
		ArrayList<DriverPO> pos = new ArrayList<DriverPO>(50);
		try {
			sql = "SELECT * FROM `" + driverTable ;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				pos.add(new DriverPO(result.getString(1), result.getString(2), MyDate.getDate(result.getString(3)), result.getString(4),result.getString(5) , result.getString(6), helper.changeFromInt(result.getString(7)), Integer.parseInt(result.getString(8))));
			}
			return (pos.isEmpty())?null:pos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;	}

	

}
