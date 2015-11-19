package vo;

import java.util.ArrayList;

import po.CarPO;
import po.InstPO;
import po.PersonPO;
import util.MyDate;

/**
 * 期初建账账单VO类
 * @author czq
 *
 */
public class BillVO {
	/**
	 * 财务人员姓名
	 */
	public String finaceman;
	
	/**
	 * 
	 */
	public MyDate date;
	
	
	/**
	 * 机构列表
	 */
	public ArrayList<InstPO> instituations;
	
	 /**
	  * 人员信息列表
	  */
	public ArrayList<PersonPO> persons;
	 
	 /**
	  * 车辆信息列表
	  */
	public ArrayList<CarPO> cars;
}
