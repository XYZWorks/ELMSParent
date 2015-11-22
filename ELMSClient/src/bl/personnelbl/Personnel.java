package bl.personnelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ds.personneldataservice.PersonnelDataService;
import net.RMIManage;
import po.personnel.PersonPO;
import test.java.other.VOPOchange;
import util.DataServiceType;
import util.ResultMessage;
import vo.personnel.InstVO;
import vo.personnel.PersonVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:48:36 
 *
 */
public class Personnel {
	
	
	PersonnelDataService personnelData;
	
	public Personnel() {
		personnelData = (PersonnelDataService) RMIManage.getDataService(DataServiceType.PersonnelDataService);
		
		try {
			personnelData.initial();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<PersonVO> getPeopleByInst(String ID) {
		
		ArrayList<PersonVO> vos = new ArrayList<PersonVO>();
		ArrayList<PersonPO> pos = new ArrayList<PersonPO>();
		
		try {
			pos = personnelData.getPeoByInst(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(PersonPO po: pos){
			vos.add((PersonVO)VOPOchange.POtoVO(po));
		}
		return vos;
	}

	public PersonVO getPeopleByID(String ID) {
		
		PersonVO vo = null;
		PersonPO po = null;
		
		try {
			po = personnelData.getPersonByID(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		vo = (PersonVO) VOPOchange.POtoVO(po);
		return vo;
	}
	

	public ArrayList<PersonVO> getPeopleByName(String name) {
		
		ArrayList<PersonVO> vos = new ArrayList<PersonVO>();
		ArrayList<PersonPO> pos = new ArrayList<PersonPO>();
		
		try {
			pos = personnelData.getPeoByName(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(PersonPO po: pos){
			vos.add((PersonVO)VOPOchange.POtoVO(po));
		}
		return vos;
	}

	public ResultMessage addPeople(PersonVO vo) {
		
		PersonPO po = (PersonPO) VOPOchange.VOtoPO(vo);
		ResultMessage result = null;
		
		try {
			result = personnelData.addPerson(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public ResultMessage delPeople(String ID) {
		try {
			personnelData.delPerson(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
