package bl.personnelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.personnel.InstPO;
import po.personnel.PersonPO;
import test.java.other.VOPOchange;
import util.ResultMessage;
import vo.personnel.InstVO;
import vo.personnel.PersonVO;
import ds.personneldataservice.PersonnelDataService;

/** 
 * 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:48:36 
 *
 */
public class Personnel {
	
	
	private PersonnelDataService personnelData;
	private ResultMessage result = null;
	public Personnel(PersonnelDataService personnelData) {
		this.personnelData = personnelData;
		
	}
	public ArrayList<PersonVO> getPeopleByInst(String ID)  {
		
		
		ArrayList<PersonPO> pos = new ArrayList<PersonPO>();
		
		try {
			pos = personnelData.getPeoByInst(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(pos == null){
			return null;
		}
		
		ArrayList<PersonVO> vos = new ArrayList<PersonVO>(pos.size());
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
			e.printStackTrace();
		}
		
		if(po == null){
			return null;
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
			e.printStackTrace();
		}
		
		if(pos == null){
			return null;
		}
		
		
		for(PersonPO po: pos){
			vos.add((PersonVO)VOPOchange.POtoVO(po));
		}
		return vos;
	}

	public ResultMessage addPeople(PersonVO vo) {
		
		PersonPO po = (PersonPO) VOPOchange.VOtoPO(vo);
		
		try {
			result = personnelData.addPerson(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public ResultMessage delPeople(String ID) {
		
		try {
			result = personnelData.delPerson(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ResultMessage addInst(InstVO vo) {
		
		InstPO po = (InstPO) VOPOchange.VOtoPO(vo);
		
		try {
			result = personnelData.addInst(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
		return result;

	}

	public ResultMessage delInst(String ID) {
		
		try {
			result = personnelData.delInst(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public ArrayList<InstVO> getInst() {
		
		
		ArrayList<InstPO> pos = new ArrayList<InstPO>();
		
		try {
			pos = personnelData.getInst();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(pos == null){
			return null;
		}
		
		
		ArrayList<InstVO> vos = new ArrayList<InstVO>(pos.size());
		for(InstPO po:pos){
			vos.add((InstVO)VOPOchange.POtoVO(po));
		}
		return vos;
	}

}
