package bl.personnelbl;

import java.rmi.Remote;
import java.util.ArrayList;

import net.RMIManage;
import util.DataServiceType;
import util.ResultMessage;
import vo.personnel.InstVO;
import vo.personnel.PersonVO;
import bl.BusinessController;
import blservice.personnelblservice.Personnelblservice;
import ds.personneldataservice.PersonnelDataService;
import exception.ExceptionHandler;
 /** 
 * 人員機構管理控制類
 * @author czq 
 * @version 2015年11月15日 上午9:24:36 
 */
public class PersonnelController extends BusinessController implements Personnelblservice{
	private Personnel per;
	private PersonnelDataService personnelDataService;
	public PersonnelController() {
		personnelDataService = (PersonnelDataService) RMIManage.getDataService(DataServiceType.PersonnelDataService);
		per = new Personnel(personnelDataService);
	}
	@Override
	public ArrayList<PersonVO> getPeopleByInst(String ID) {
		try {
			return per.getPeopleByInst(ID);
		} catch (Exception e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				try {
					return per.getPeopleByInst(ID);
				} catch (Exception e1) {}
			}
		}return null;
	}

	@Override
	public PersonVO getPeopleByID(String ID) {
		try {
			return per.getPeopleByID(ID);
		} catch (Exception e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				try {
					return per.getPeopleByID(ID);
				} catch (Exception e1) {}
			}
		}return null;
	}

	@Override
	public ArrayList<PersonVO> getPeopleByName(String name) {
		try {
			return per.getPeopleByName(name);
		} catch (Exception e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				try {
					return per.getPeopleByName(name);
				} catch (Exception e1) {}
			}
		}return null;
	}

	@Override
	public ResultMessage addPeople(PersonVO vo) {
		try {
			return per.addPeople(vo);
		} catch (Exception e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				try {
					return per.addPeople(vo);
				} catch (Exception e1) {}
			}
		}return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage delPeople(String ID) {
		try {
			return per.delPeople(ID);
		} catch (Exception e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				try {
					return per.delPeople(ID);
				} catch (Exception e1) {}
			}
		}return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage addInst(InstVO vo) {
		try {
			return per.addInst(vo);
		} catch (Exception e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				try {
					return per.addInst(vo);
				} catch (Exception e1) {}
			}
		}return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage delInst(String ID) {
		try {
			return per.delInst(ID);
		} catch (Exception e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				try {
					return per.delInst(ID);
				} catch (Exception e1) {}
			}
		}return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<InstVO> getInst() {
		try {
			return per.getInst();
		} catch (Exception e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				try {
					return per.getInst();
				} catch (Exception e1) {}
			}
		}return null;
	}
	@Override
	public ArrayList<PersonVO> getPersons() {
		try {
			return per.getPersons();
		} catch (Exception e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				try {
					return per.getPersons();
				} catch (Exception e1) {}
			}
		}return null;
	}
	@Override
	public ResultMessage modifyInst(InstVO vo) {
		
		try {
			return per.modifyInst(vo);
		} catch (Exception e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				try {
					return per.modifyInst(vo);
				} catch (Exception e1) {}
			}
		}return ResultMessage.FAIL;
	}
	@Override
	public ResultMessage modifyPerson(PersonVO vo) {
		
		try {
			return per.modifyPerson(vo);
		} catch (Exception e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				try {
					return per.modifyPerson(vo);
				} catch (Exception e1) {}
			}
		}return ResultMessage.FAIL;
	}
	@Override
	public void reinitDataService(Remote dataService) {
		personnelDataService = (PersonnelDataService) dataService;
		per = new Personnel(personnelDataService);
		
	}

}
