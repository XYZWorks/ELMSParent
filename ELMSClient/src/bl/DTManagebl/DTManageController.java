package bl.DTManagebl;

import java.util.ArrayList;

import blservice.DTManageblservice.DTManageblservice;
import po.DTManage.DriverPO;
import test.java.other.VOPOchange;
import util.ResultMessage;
import vo.DTManage.CarVO;
import vo.DTManage.DriverVO;
 /** 
 * 
 * @author czq 
 * @version 2015年11月15日 上午9:16:29 
 */
public class DTManageController implements DTManageblservice{
	DTManage dtm;
	
	public DTManageController() {
		dtm = new DTManage();
	}
	public ResultMessage add(DriverVO vo) {
		return dtm.add(vo);
	}

	public ArrayList<DriverVO> CheckByName(String name) {
		return dtm.CheckByName(name);
	}

	public DriverVO CheckDriverByID(String ID) {
		
		return dtm.CheckDriverByID(ID);
	}

	public ArrayList<DriverVO> CheckByInst(String InstID) {
		return dtm.CheckByInst(InstID);
	}

	public ResultMessage modify(DriverVO vo) {
		return dtm.modify(vo);
	}

	public ResultMessage Del(DriverVO vo) {
		return dtm.Del(vo);
	}

	public ArrayList<String> getDriverName(String InstID) {
		return dtm.getDriverName(InstID);
	}

	public ResultMessage add(CarVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public CarVO CheckCarByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public CarVO CheckByPlateNum(String PlateNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage modify(CarVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage Del(CarVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getPlateNumber(String InstID) {
		// TODO Auto-generated method stub
		return null;
	}

}
