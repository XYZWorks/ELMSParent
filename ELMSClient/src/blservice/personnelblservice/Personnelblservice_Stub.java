package blservice.personnelblservice;

import java.util.ArrayList;

import util.InstType;
import util.ResultMessage;
import util.StaffType;
import vo.personnel.InstVO;
import vo.personnel.PersonVO;
 
public class Personnelblservice_Stub implements Personnelblservice {

	public ArrayList<PersonVO> getPeopleByInst(String ID) {
		ArrayList<PersonVO> temp = new ArrayList<PersonVO>();
		temp.add(new PersonVO(ID,"111111","czq",StaffType.driver,"13182831233"));
		temp.add(new PersonVO(ID,"111112","czq",StaffType.financeman,"13182841233"));
		return temp;
	}

	public PersonVO getPeopleByID(String ID) {
		
		return new PersonVO("111111", "111111", "czq", StaffType.saleman, "13122331233");
	}

	public ArrayList<PersonVO> getPeopleByName(String name) {
		ArrayList<PersonVO> temp = new ArrayList<PersonVO>();
		temp.add(new PersonVO("111111","111111",name,StaffType.driver,"13182831233"));
		temp.add(new PersonVO("111111","111112",name,StaffType.financeman,"13182841233"));
		return temp;
	}

	public ResultMessage addPeople(PersonVO vo) {
		return ResultMessage.SUCCESS;
	}

	public ResultMessage delPeople(String ID) {
		return ResultMessage.SUCCESS;
	}

	public ResultMessage addInst(InstVO vo) {
		return ResultMessage.SUCCESS;
	}

	public ResultMessage delInst(String ID) {
		return ResultMessage.SUCCESS;
	}

	public ArrayList<InstVO> getInst() {
		ArrayList<InstVO> temp = new ArrayList<InstVO>();
		temp.add(new InstVO("123456", "南京", InstType.businessHall));
		temp.add(new InstVO("123459", "北京", InstType.businessHall));
		return temp;
	}

}
