package blservice.DTManageblservice;

import java.util.ArrayList;

import util.ResultMessage;
import vo.DTManage.CarVO;
import vo.DTManage.DriverVO;
/**
 * 司机、车辆信息管理接口类
 * @author JerryZhang
 * 
 */
public interface DTManageblservice{
	
	
	/**
	 * 获得所有车辆信息
	 * @return
	 */
	public ArrayList<CarVO> getAllCars() ;
	/**
	 * 获得所有司机信息
	 * @return
	 */
	public ArrayList<DriverVO> getAllDrivers() ;
	
	/**
	 * 增加司机信息
	 * @param ID
	 * @return
	 */
	public ResultMessage addDriver(DriverVO vo);
	/**
	 * 通过姓名查找司机信息
	 * @param name
	 * @return
	 */
	public ArrayList< DriverVO > checkDriverByName(String name);
	/**
	 * 通过ID查找司机信息
	 * @param ID
	 * @return
	 */
	public DriverVO checkDriverByID (String ID);
	/**
	 * 通过机构ID查找司机信息
	 * @param instID
	 * @return
	 */
	public ArrayList< DriverVO > checkDriverByInst (String InstID);
	/**
	 * 更新司机信息
	 * @param vo
	 * @return
	 */
	public ResultMessage modifyDriver (DriverVO vo);
	/**
	 * 删除司机信息
	 * @param vo
	 * @return
	 */
	public ResultMessage delDriver(DriverVO vo);
	/**
	 * 获得该机构下的司机姓名列表
	 * @param InstID
	 * @return 
	 */
	public ArrayList< String > getDriverName(String InstID);
    /**
     * 增加车辆信息
     * @param vo
     * @return
     */
	public ResultMessage addCar (CarVO vo);
	/**
	 * 通过ID查找车辆信息
	 * @param ID
	 * @return
	 */
	public CarVO checkCarByID(String ID);
	/**
	 * 通过PlateNum查找车辆信息
	 * @param PlateNum
	 * @return
	 */
	public CarVO checkByPlateNum (String PlateNum);
	/**
	 * 更新车辆信息
	 * @param vo
	 * @return
	 */
	public ResultMessage modifyCar (CarVO vo);
	/**
	 * 删除车辆信息
	 * @param vo
	 * @return
	 */
	public ResultMessage delCar(CarVO vo);
	/**
	 * 获得该机构下的车牌信息
	 * @param InstID
	 * @return
	 */
	public ArrayList<String> getPlateNumber(String InstID);

}