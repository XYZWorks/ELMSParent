package bl.personnelbl;

import java.util.ArrayList;

import util.ResultMessage;
import vo.personnel.InstVO;
import vo.personnel.PersonVO;
import blservice.personnelblservice.Personnelblservice;
 /** 
 * 
 * @author czq 
 * @version 2015年11月15日 上午9:24:36 
 */
public class PersonnelController implements Personnelblservice{

	public ArrayList<PersonVO> getPeopleByInst(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public PersonVO getPeopleByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PersonVO> getPeopleByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addPeople(PersonVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage delPeople(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addInst(InstVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage delInst(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<InstVO> getInst() {
		// TODO Auto-generated method stub
		return null;
	}

}
