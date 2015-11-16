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

	public BillPO(String finaceman, Date date, ArrayList<InstPO> instituations,
			ArrayList<PersonPO> persons, ArrayList<CarPO> cars) {
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

	public Date getDate() {
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
