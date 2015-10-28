package blservice.DTManageblservice;

import java.util.ArrayList;

import util.ResultMessage;
import vo.CarVO;
import vo.DriverVO;
/**
 * 司机、车辆信息管理接口类
 * @author JerryZhang
 * 
 */
public interface DTManageblservice{
	/**
	 * 增加司机信息
	 * @param ID
	 * @return
	 */
	public ResultMessage add(DriverVO vo);
	/**
	 * 通过姓名查找司机信息
	 * @param name
	 * @return
	 */
	public ArrayList< DriverVO > CheckByName(String name);
	/**
	 * 通过ID查找司机信息
	 * @param ID
	 * @return
	 */
	public DriverVO CheckDriverByID (String ID);
	/**
	 * 通过机构ID查找司机信息
	 * @param instID
	 * @return
	 */
	public ArrayList< DriverVO > CheckByInst (String InstID);
	/**
	 * 更新司机信息
	 * @param vo
	 * @return
	 */
	public ResultMessage modify (DriverVO vo);
	/**
	 * 删除司机信息
	 * @param vo
	 * @return
	 */
	public ResultMessage Del(DriverVO vo);
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
	public ResultMessage add (CarVO vo);
	/**
	 * 通过ID查找车辆信息
	 * @param ID
	 * @return
	 */
	public CarVO CheckCarByID(String ID);
	/**
	 * 通过PlateNum查找车辆信息
	 * @param PlateNum
	 * @return
	 */
	public CarVO CheckByPlateNum (String PlateNum);
	/**
	 * 更新车辆信息
	 * @param vo
	 * @return
	 */
	public ResultMessage modify (CarVO vo);
	/**
	 * 删除车辆信息
	 * @param vo
	 * @return
	 */
	public ResultMessage Del(CarVO vo);
	/**
	 * 获得该机构下的车牌信息
	 * @param InstID
	 * @return
	 */
	public ArrayList<String> getPlateNumber(String InstID);

}