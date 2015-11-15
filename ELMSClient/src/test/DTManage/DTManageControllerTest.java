package test.DTManage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bl.DTManagebl.DTManageController;
import blservice.DTManageblservice.DTManageblservice;
import test.DataTool;
import util.ResultMessage;
import vo.DriverVO;
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
		
		bl.add(DataTool.getcarlist().get(0));
	}

	@Test
	public void testAddDriverVO() {
		result = bl.add(DataTool.getDriverList().get(0));
		if(result == ResultMessage.SUCCESS){
			
		}else{
			fail("can not add a driver");
		}
		
		
		
	}

	@Test
	public void testCheckByName() {
		String name = DataTool.getDriverList().get(0).name;
		DriverVO vo = bl.CheckByName(name).get(0);
		if(vo.name.equalsIgnoreCase(name)){
			
		}else{
			fail("check by name fail");
		}
		
	}

	@Test
	public void testCheckDriverByID() {
		String ID = DataTool.getDriverList().get(0).ID;
		DriverVO vo = bl.CheckByName(ID).get(0);
		if(vo.ID.equalsIgnoreCase(ID)){
			
		}else{
			fail("check by ID fail");
		}
	}

	@Test
	public void testCheckByInst() {
		String instid = DataTool.getDriverList().get(0).InstID;
		DriverVO vo = bl.CheckByName(instid).get(0);
		if(vo.ID.equalsIgnoreCase(instid)){
			
		}else{
			fail("check by instID fail");
		}
	}

	@Test
	public void testModifyDriverVO() {
		DriverVO vo = DataTool.getDriverList().get(0);
		vo.InstID = "123456";
		result = bl.modify(vo);
		if(result == ResultMessage.SUCCESS && vo.InstID.equalsIgnoreCase("123456")){
			
		}else{
			fail("fail to modify");
		}
		
		
		
	}

	@Test
	public void testDelDriverVO() {
		DriverVO vo = DataTool.getDriverList().get(1);
		result = bl.Del(vo);
		if(result == ResultMessage.SUCCESS){
			fail("允许删除空数据");
		}
		bl.add(vo);
		result = bl.Del(vo);
		if(result == ResultMessage.FAIL){
			fail("删除失败");
		}
		
		
	}

	@Test
	public void testGetDriverName() {
		//在其他方法测试
	}

	@Test
	public void testAddCarVO() {
		result = bl.add(DataTool.getcarlist().get(0));
		if(result == ResultMessage.SUCCESS){
			
		}else{
			fail("can not add a car");
		}
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
