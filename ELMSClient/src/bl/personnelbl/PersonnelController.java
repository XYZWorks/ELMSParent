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
	Personnel per;
	
	public PersonnelController() {
		per = new Personnel();
	}
	public ArrayList<PersonVO> getPeopleByInst(String ID) {
		
		return per.getPeopleByInst(ID);
	}

	public PersonVO getPeopleByID(String ID) {
		return per.getPeopleByID(ID);
	}

	public ArrayList<PersonVO> getPeopleByName(String name) {
		return per.getPeopleByName(name);
	}

	public ResultMessage addPeople(PersonVO vo) {
		return per.addPeople(vo);
	}

	public ResultMessage delPeople(String ID) {
		return per.delPeople(ID);
	}

	public ResultMessage addInst(InstVO vo) {
		return per.addInst(vo);
	}

	public ResultMessage delInst(String ID) {
		return per.delInst(ID);
	}

	public ArrayList<InstVO> getInst() {
		return per.getInst();
	}

}
