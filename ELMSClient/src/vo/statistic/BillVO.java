package vo.statistic;

import java.util.ArrayList;

import util.MyDate;
import vo.DTManage.CarVO;
import vo.personnel.InstVO;
import vo.personnel.PersonVO;

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
	public ArrayList<InstVO> instituations;
	
	 /**
	  * 人员信息列表
	  */
	public ArrayList<PersonVO> persons;
	 
	 /**
	  * 车辆信息列表
	  */
	public ArrayList<CarVO> cars;
	
	public BillVO() {
		// TODO Auto-generated constructor stub
	}
}
