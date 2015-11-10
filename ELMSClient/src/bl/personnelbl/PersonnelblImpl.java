package bl.personnelbl;

import java.util.ArrayList;

import blservice.personnelblservice.Personnelblservice;
import util.ResultMessage;
import vo.InstVO;
import vo.PersonVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:48:36 
 *
 */
public class PersonnelblImpl implements Personnelblservice {
	Personnelblservice personnelbl;
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
