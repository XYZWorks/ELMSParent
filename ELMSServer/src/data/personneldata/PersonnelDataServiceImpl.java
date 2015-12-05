package data.personneldata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import po.personnel.InstPO;
import po.personnel.PersonPO;
import util.InstType;
import util.ResultMessage;
import util.StaffType;
import dataSuper.DataSuperClass;
import ds.personneldataservice.PersonnelDataService;

/**
 * 
 * @author czq
 * @version 2015年10月31日 上午8:59:35
 */

public class PersonnelDataServiceImpl extends DataSuperClass implements
		PersonnelDataService {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String personTable = "person";
	
	private final String instTable = "inst";

	public PersonnelDataServiceImpl() throws RemoteException {}
	
	public void initial() throws RemoteException {
		initialFromSQL(instTable);
		initialFromSQL(personTable);
	}

	public ArrayList<PersonPO> getPeoByInst(String ID) throws RemoteException {
		ArrayList<PersonPO> personPOs = new ArrayList<PersonPO>();
		try {
			sql = "SELECT * FROM `person` WHERE `instid` = " +"\""+ ID+"\"";
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				personPOs.add(new PersonPO(result.getString(1), result
						.getString(2), result.getString(3), StaffType
						.valueOf(result.getString(4)), result.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (personPOs.isEmpty()) {
			return null;
		} else {
			return personPOs;
		}
	}

	public PersonPO getPersonByID(String ID) throws RemoteException {
		
		findMes = findFromSQL(personTable, ID);
		if(findMes == null){
			return null;
		}else{
			//instid 在 id前
			return new PersonPO(findMes.get(1),findMes.get(0), findMes.get(2), StaffType.valueOf(findMes.get(3)), findMes.get(4));
		}
	}

	public ArrayList<PersonPO> getPeoByName(String name) throws RemoteException {
		ArrayList<PersonPO> persons = new ArrayList<PersonPO>();
		
		
		try {
			sql = "SELECT * FROM `" + personTable +  "` WHERE `name` LIKE '%" + name + "%'";
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				//instid 在 id前
				persons.add(new PersonPO(result.getString(2), result
						.getString(1), result.getString(3), StaffType
						.valueOf(result.getString(4)), result.getString(5)));

			}
			return persons.isEmpty()?null:persons;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	public ResultMessage addPerson(PersonPO po) throws RemoteException {
		return addToSQL(personTable, po.getID() , po.getInstID() , po.getName() , po.getType().name() , po.getPhoneNum());
	}

	public ResultMessage delPerson(String ID) throws RemoteException {
		return delFromSQL(personTable, ID);
	}

	public ResultMessage addInst(InstPO po) throws RemoteException {
		return addToSQL(instTable, po.getID() , po.getLocation() , po.getType().name());
	}

	public ResultMessage delInst(String ID) throws RemoteException {
		return delFromSQL(instTable, ID);
	}

	public ArrayList<InstPO> getInst() throws RemoteException {
		ArrayList<InstPO> institutions = new ArrayList<InstPO>();
		InstPO po;
		try {
			sql = "SELECT　* FROM " + instTable ;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while(result.next()){
				po = new InstPO(result.getString(1), result.getString(2), InstType.valueOf(result.getString(3)));
				institutions.add(po);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(institutions.isEmpty()){
			return null;
		}else{
			return institutions;
		}
		
		
		
	}

	
	
//	public static void main(String[] args) throws RemoteException {
//		PersonnelDataService test = new PersonnelDataServiceImpl();
////		test.addPerson(new PersonPO("112233", "111111", "张薇", StaffType.storemanager, "13184836488"));
////		test.addPerson(new PersonPO("112233", "111112", "张薇按", StaffType.storemanager, "13184836488"));
//		test.addPerson(new PersonPO("112233", "111114", "时辰", StaffType.storemanager, "13184836488"));
//		System.out.println(test.getPeoByInst("112233").size());;
//	}

}
