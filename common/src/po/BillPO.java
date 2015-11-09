package po;

import java.util.ArrayList;

import util.Date;

/**
 * 期初建账数据PO类
 * @author czq
 *
 */
public class BillPO {
	
	
	/**
	 * 
	 */
	private String finaceman;
	
	/**
	 * 
	 */
	private Date date;
	
	
	/**
	 * 机构列表
	 */
	 private ArrayList<InstPO> instituations;
	
	 /**
	  * 人员信息列表
	  */
	 private ArrayList<PersonPO> persons;
	 
	 /**
	  * 车辆信息列表
	  */
	 private ArrayList<CarPO> cars;
}
