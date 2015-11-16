package data.personneldata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import po.InstPO;
import po.PersonPO;
import util.ResultMessage;
import util.StaffType;
import dataSuper.DataSuperClass;
import ds.personneldataservice.PersonnelDataService;

/**
 * 
 * @author czq
 * @version 2015年10月31日 上午8:59:35
 */
@SuppressWarnings("serial")
public class PersonnelDataServiceImpl extends DataSuperClass implements
		PersonnelDataService {

	public PersonnelDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<PersonPO> getPeoByInst(String ID) throws RemoteException {
		ArrayList<PersonPO> personPOs = new ArrayList<PersonPO>();
		try {
			sql = "SELECT * from `person` WHERE `instid` = " + ID;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			
			
			
			while(result.next()){
					personPOs.add(new PersonPO(result.getString(1), result.getString(2), result.getString(3), StaffType.getType(result.getString(4)), result.getString(5))) ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(personPOs.isEmpty()){
			return null;
		}else{
			return personPOs;
		}
	}

	public PersonPO getPersonByID(String ID) throws RemoteException {
		try {
			sql = "SELECT * FROM `person` WHERE `id` =" + ID;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while(result.next()){
				return new PersonPO(result.getString(1), result.getString(2), result.getString(3), StaffType.getType(result.getString(4)), result.getString(5)) ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<PersonPO> getPeoByName(String name) throws RemoteException {
		ArrayList<PersonPO> persons = new ArrayList<PersonPO>();
		
		
		try {
			sql = "SELECT * FROM `account` WHERE `name` LIKE '%" + name + "%'";
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				persons.add(new PersonPO(result.getString(1), result
						.getString(2), result.getString(3), StaffType
						.getType(result.getString(4)), result.getString(5)));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	public ResultMessage addPerson(PersonPO po) throws RemoteException {
		
		try {
			sql = "INSERT INTO `person` values(?,?,?,?,?)";
			preState = conn.prepareStatement(sql);
			preState.setString(1, po.getInstID());
			preState.setString(2, po.getID());
			preState.setString(3, po.getName());
			preState.setString(4, po.getType().getName());
			preState.setString(5, po.getName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getDoResult(preState);
	}

	public ResultMessage delPerson(PersonPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addInst(InstPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage delInst(InstPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<InstPO> getInst() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) throws RemoteException {
		PersonnelDataService test = new PersonnelDataServiceImpl();
//		test.addPerson(new PersonPO("112233", "111111", "张薇", StaffType.storemanager, "13184836488"));
//		test.addPerson(new PersonPO("112233", "111112", "张薇按", StaffType.storemanager, "13184836488"));
		test.addPerson(new PersonPO("112233", "111114", "时辰", StaffType.storemanager, "13184836488"));
		System.out.println(test.getPeoByInst("112233").size());;
	}

}
