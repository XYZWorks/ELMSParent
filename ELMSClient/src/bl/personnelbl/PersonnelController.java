package bl.personnelbl;

import java.util.ArrayList;

import net.RMIManage;
import ds.personneldataservice.PersonnelDataService;
import util.DataServiceType;
import util.ResultMessage;
import vo.personnel.InstVO;
import vo.personnel.PersonVO;
import blservice.personnelblservice.Personnelblservice;
 /** 
 * 人員機構管理控制類
 * @author czq 
 * @version 2015年11月15日 上午9:24:36 
 */
public class PersonnelController implements Personnelblservice{
	private Personnel per;
	private PersonnelDataService personnelDataService;
	public PersonnelController() {
		personnelDataService = (PersonnelDataService) RMIManage.getDataService(DataServiceType.PersonnelDataService);
		per = new Personnel(personnelDataService);
	}
	public ArrayList<PersonVO> getPeopleByInst(String ID) {
		return per.getPeopleByInst(ID);
	}

	public PersonVO getPeopleByID(String ID) {
		return per.getPeopleByID(ID);
	}

	public ArrayList<PersonVO> getPeopleByName(String name) {
		return per.getPeopleByName(name);
	}

	public ResultMessage addPeople(PersonVO vo) {
		return per.addPeople(vo);
	}

	public ResultMessage delPeople(String ID) {
		return per.delPeople(ID);
	}

	public ResultMessage addInst(InstVO vo) {
		return per.addInst(vo);
	}

	public ResultMessage delInst(String ID) {
		return per.delInst(ID);
	}

	public ArrayList<InstVO> getInst() {
		return per.getInst();
	}
	@Override
	public ArrayList<PersonVO> getPersons() {
		return per.getPersons();
	}
	@Override
	public ResultMessage modifyInst(InstVO vo) {
		
		return per.modifyInst(vo);
	}

}
