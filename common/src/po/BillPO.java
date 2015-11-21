package po;

import java.io.Serializable;
import java.util.ArrayList;

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
	 private ArrayList<String> instituations;
	
	 /**
	  * 人员信息列表
	  */
	 private ArrayList<String> persons;
	 
	 /**
	  * 车辆信息列表
	  */
	 private ArrayList<String> cars;

	public BillPO(String finaceman, MyDate date, ArrayList<String> instituations,
			ArrayList<String> persons, ArrayList<String> cars) {
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

	public ArrayList<String> getInstituations() {
		return instituations;
	}

	public ArrayList<String> getPersons() {
		return persons;
	}

	public ArrayList<String> getCars() {
		return cars;
	}
	 
	 
	 
	 
}
