package test.DTManage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bl.DTManagebl.DTManageController;
import blservice.DTManageblservice.DTManageblservice;
import util.ResultMessage;
 /** 
 * 
 * @author czq 
 * @version 2015年11月15日 下午2:38:30 
 */
public class DTManageControllerTest {
	
	DTManageblservice bl; 
	ResultMessage result;
	
	@Before
	public void setUp() throws Exception {
		bl = new DTManageController();
	}

	@Test
	public void testAddDriverVO() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckDriverByID() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckByInst() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifyDriverVO() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelDriverVO() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDriverName() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddCarVO() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckCarByID() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckByPlateNum() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifyCarVO() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelCarVO() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPlateNumber() {
		fail("Not yet implemented");
	}

}
