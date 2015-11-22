package test.java.personnel;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import test.java.other.DataTool;
import util.ResultMessage;
import vo.personnel.InstVO;
import vo.personnel.PersonVO;
import bl.personnelbl.PersonnelController;
import blservice.personnelblservice.Personnelblservice;

/**
 * 
 * @author czq
 * @version 2015年11月15日 下午2:39:11
 */
public class PersonnelControllerTest {

	Personnelblservice bl;
	ResultMessage result;

	@Before
	public void setUp() throws Exception {
		bl = new PersonnelController();
	}

	@Test
	public void testGetPeopleByInst() {
		// 在byname 方法测试
	}

	@Test
	public void testGetPeopleByID() {
		// 在byname 方法测试
	}

	@Test
	public void testGetPeopleByName() {
		ArrayList<PersonVO> persons = DataTool.getpersons();
		persons.get(0).name = "陈平";
		persons.get(1).name = "陈安杰";
		bl.delPeople(persons.get(0).ID);
		bl.delPeople(persons.get(1).ID);
		bl.addPeople(persons.get(0));
		bl.addPeople(persons.get(1));

		persons = bl.getPeopleByName("陈");
		if (persons.size() < 2) {
			fail("can not get people by name");

		} else {
			if (!persons.get(0).name.equalsIgnoreCase("陈平")) {
				fail("can not get people by name");
			}
			if (!persons.get(1).name.equalsIgnoreCase("陈安杰")) {
				fail("can not get people by name");
			}

		}

		PersonVO vo = bl.getPeopleByID(persons.get(0).ID);
		if (!vo.name.equalsIgnoreCase("陈平")) {
			fail("can not find people by id");
		}

		persons = bl.getPeopleByInst(persons.get(0).instID);
		if (!persons.get(0).name.equalsIgnoreCase("陈平")) {
			fail("can not find people by instid");
		}

	}

	@Test
	public void testAddPeople() {
		if (bl.addPeople(DataTool.getpersons().get(0)) == ResultMessage.SUCCESS) {
			return;
		}
		fail("fail to add people");
	}

	@Test
	public void testDelPeople() {
		PersonVO vo = DataTool.getpersons().get(0);
		bl.addPeople(vo);
		if (bl.delPeople(vo.ID) == ResultMessage.FAIL) {
			fail("can not del people");
		}
		result = bl.delPeople(vo.ID);
		if (result == ResultMessage.SUCCESS) {
			fail("allow to del twice");
		}

	}

	@Test
	public void testAddInst() {
		result = bl.addInst(DataTool.getInsts().get(0));
		if(result == ResultMessage.FAIL){
			fail();
		}
	}

	@Test
	public void testDelInst() {
		InstVO vo = DataTool.getInsts().get(0);
		if(bl.delInst(vo.ID) == ResultMessage.FAIL){
			fail("can not del a inst");
		}
		
		if(bl.delInst(vo.ID) == ResultMessage.SUCCESS){
			fail("allow to del twice");
		}
	}

	@Test
	public void testGetInst() {}

}
