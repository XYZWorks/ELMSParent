package test.java.DTManage;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import test.java.other.DataTool;
import util.ResultMessage;
import vo.DTManage.CarVO;
import vo.DTManage.DriverVO;
import bl.DTManagebl.DTManageController;
import blservice.DTManageblservice.DTManageblservice;
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
		result = bl.addDriver(DataTool.getDriverList().get(0));
		System.out.println(result);
		if(result == ResultMessage.SUCCESS){
		}else{
			fail("can not add a driver");
		}
		
		
		
	}

	@Test
	public void testCheckByName() {
		String name = DataTool.getDriverList().get(0).name;
		DriverVO vo = bl.checkDriverByName(name).get(0);
		if(vo.name.equalsIgnoreCase(name)){
			
		}else{
			fail("check by name fail");
		}
		
	}

	@Test
	public void testCheckDriverByID() {
		String ID = DataTool.getDriverList().get(0).ID;
		DriverVO vo = bl.checkDriverByName(ID).get(0);
		if(vo.ID.equalsIgnoreCase(ID)){
			
		}else{
			fail("check by ID fail");
		}
	}

	@Test
	public void testCheckByInst() {
		String instid = DataTool.getDriverList().get(0).InstID;
		DriverVO vo = bl.checkDriverByName(instid).get(0);
		if(vo.ID.equalsIgnoreCase(instid)){
			
		}else{
			fail("check by instID fail");
		}
	}

	@Test
	public void testModifyDriverVO() {
		DriverVO vo = DataTool.getDriverList().get(0);
		vo.InstID = "123456";
		result = bl.modifyDriver(vo);
		System.out.println(result);
		if(result == ResultMessage.SUCCESS && vo.InstID.equalsIgnoreCase("123456")){
			
		}else{
			fail("fail to modify");
		}
		
		
		
	}

	@Test
	public void testDelDriverVO() {
		DriverVO vo = DataTool.getDriverList().get(1);
		result = bl.delDriver(vo);
		if(result == ResultMessage.SUCCESS){
			fail("允许删除空数据");
		}
		bl.addDriver(vo);
		result = bl.delDriver(vo);
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
		result = bl.addCar(DataTool.getcarlist().get(0));
		if(result == ResultMessage.SUCCESS){
			
		}else{
			fail("can not add a car");
		}
	}

	@Test
	public void testCheckCarByID() {
		String id = DataTool.getcarlist().get(0).ID;
		CarVO vo = bl.checkCarByID(id);
		
		if(vo.plateNum.equalsIgnoreCase(DataTool.getcarlist().get(0).plateNum))
			return ;
		
		
		fail("fail to check car by id");
	}

	@Test
	public void testCheckByPlateNum() {
		String plateNum = DataTool.getcarlist().get(0).plateNum;
		CarVO vo = bl.checkByPlateNum(plateNum);
		
		if(vo.ID.equalsIgnoreCase(DataTool.getcarlist().get(0).ID))
			return ;
		
		
		fail("fail to check car by plate num");
	}

	@Test
	public void testModifyCarVO() {
		CarVO vo =DataTool.getcarlist().get(0);
		vo.useYear = 8;
		result = bl.modifyCar(vo);
		
		if(result == ResultMessage.SUCCESS && bl.checkCarByID(vo.ID).useYear == 8){
			
			
		}else{
			fail("can not modify carVO");
		}
		
		
	}

	@Test
	public void testDelCarVO() {
		CarVO vo = DataTool.getcarlist().get(1);
		result = bl.delCar(vo);
		if(result == ResultMessage.SUCCESS){
			fail("允许删除空数据");
		}
		bl.addCar(vo);
		result = bl.delCar(vo);
		if(result == ResultMessage.FAIL){
			fail("删除失败");
		}
	}

	@Test
	public void testGetPlateNumber() {
		//在其他方法测试
	}

}
