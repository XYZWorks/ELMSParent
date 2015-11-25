package po.statistic;

import java.io.Serializable;
import java.util.ArrayList;

import po.DTManage.CarPO;
import po.personnel.InstPO;
import po.personnel.PersonPO;
import util.MyDate;

/**
 * 期初建账数据PO类
 * @author czq
 *
 */
public class BillPO implements Serializable{
	
	public BillPO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 财务人员姓名
	 */
	private String finaceman;
	
	/**
	 * 
	 */
	private MyDate date;
	
	
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

	public BillPO(String finaceman, MyDate date,
			ArrayList<InstPO> instituations, ArrayList<PersonPO> persons,
			ArrayList<CarPO> cars) {
		super();
		this.finaceman = finaceman;
		this.date = date;
		this.instituations = instituations;
		this.persons = persons;
		this.cars = cars;
	}

	public String getFinaceman() {
		return finaceman;
	}

	public MyDate getDate() {
		return date;
	}

	public ArrayList<InstPO> getInstituations() {
		return instituations;
	}

	public ArrayList<PersonPO> getPersons() {
		return persons;
	}

	public ArrayList<CarPO> getCars() {
		return cars;
	}

	 
	 
	 
	 
}
