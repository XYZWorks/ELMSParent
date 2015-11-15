package test.personnel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
 


import util.ResultMessage;
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
		fail("Not yet implemented");
	}

	@Test
	public void testGetPeopleByID() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPeopleByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddPeople() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelPeople() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddInst() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelInst() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInst() {
		fail("Not yet implemented");
	}

}
