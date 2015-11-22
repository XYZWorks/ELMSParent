package bl.DTManagebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ds.DTManagedataservice.DTManagedataservice;
import po.DTManage.DriverPO;
import test.java.other.VOPOchange;
import util.ResultMessage;
import vo.DTManage.CarVO;
import vo.DTManage.DriverVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:45:48 
 *
 */
public class DTManage{
	
	
	DTManagedataservice manageData;
	
	
	public ResultMessage add(DriverVO vo) {
		DriverPO po = (DriverPO) VOPOchange.VOtoPO(vo);
		ResultMessage result = null;
		try {
			result = manageData.addDriverPO(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<DriverVO> CheckByName(String name) {
		ArrayList<DriverPO> pos = new ArrayList<DriverPO>();
		ArrayList<DriverVO> vos = new ArrayList<DriverVO>();

		try {
			pos = manageData.getDriverByName(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(DriverPO po : pos){
			vos.add((DriverVO)VOPOchange.POtoVO(pos));
		}
		return vos;
	}

	public DriverVO CheckDriverByID(String ID) {
		DriverPO po = null;
		try {
			po = manageData.getDriverMes(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DriverVO vo = (DriverVO) VOPOchange.POtoVO(po);
		return vo;
	}

	public ArrayList<DriverVO> CheckByInst(String InstID) {
		return null;
	}

	public ResultMessage modify(DriverVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage Del(DriverVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getDriverName(String InstID) {
		// TODO Auto-generated method stub
		return null;
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
