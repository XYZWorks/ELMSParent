package bl.personnelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import po.personnel.InstPO;
import po.personnel.PersonPO;
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

	// private ResultMessage result = null;
	public Personnel(PersonnelDataService personnelData) {
		this.personnelData = personnelData;

	}

	public ArrayList<PersonVO> getPeopleByInst(String ID)
			throws RemoteException {

		ArrayList<PersonPO> pos = new ArrayList<PersonPO>();

		pos = personnelData.getPeoByInst(ID);

		if (pos == null) {
			return null;
		}

		ArrayList<PersonVO> vos = new ArrayList<PersonVO>(pos.size());
		for (PersonPO po : pos) {
			vos.add((PersonVO) VOPOchange.POtoVO(po));
		}
		return vos;
	}

	public PersonVO getPeopleByID(String ID) throws RemoteException {

		PersonVO vo = null;
		PersonPO po = null;

		po = personnelData.getPersonByID(ID);

		if (po == null) {
			return null;
		}

		vo = (PersonVO) VOPOchange.POtoVO(po);
		return vo;
	}

	public ArrayList<PersonVO> getPeopleByName(String name)
			throws RemoteException {

		ArrayList<PersonVO> vos = new ArrayList<PersonVO>();
		ArrayList<PersonPO> pos = new ArrayList<PersonPO>();

		pos = personnelData.getPeoByName(name);

		if (pos == null) {
			return null;
		}

		for (PersonPO po : pos) {
			vos.add((PersonVO) VOPOchange.POtoVO(po));
		}
		return vos;
	}

	public ResultMessage addPeople(PersonVO vo) throws RemoteException {

		PersonPO po = (PersonPO) VOPOchange.VOtoPO(vo);

		return personnelData.addPerson(po);

	}

	public ResultMessage delPeople(String ID) throws RemoteException {

		return personnelData.delPerson(ID);
	}

	public ResultMessage addInst(InstVO vo) throws RemoteException {

		InstPO po = (InstPO) VOPOchange.VOtoPO(vo);

		return personnelData.addInst(po);

	}

	public ResultMessage delInst(String ID) throws RemoteException {
		return personnelData.delInst(ID);
	}

	public ArrayList<InstVO> getInst() throws RemoteException {

		ArrayList<InstPO> pos = new ArrayList<InstPO>();

		pos = personnelData.getInst();
		if (pos == null) {
			return null;
		}

		ArrayList<InstVO> vos = new ArrayList<InstVO>(pos.size());
		for (InstPO po : pos) {
			vos.add((InstVO) VOPOchange.POtoVO(po));
		}
		return vos;
	}

	public ArrayList<PersonVO> getPersons() throws RemoteException {
		ArrayList<PersonPO> pos = new ArrayList<PersonPO>();

		pos = personnelData.getPersons();
		if (pos == null) {
			return null;
		}

		ArrayList<PersonVO> vos = new ArrayList<PersonVO>(pos.size());
		for (PersonPO po : pos) {
			vos.add((PersonVO) VOPOchange.POtoVO(po));
		}
		return vos;
	}

	public ResultMessage modifyInst(InstVO vo) throws RemoteException {
		return personnelData.modifyInst((InstPO) VOPOchange.VOtoPO(vo));
	}

	public ResultMessage modifyPerson(PersonVO vo) throws RemoteException {
		return personnelData.modifyPerson((PersonPO) VOPOchange.VOtoPO(vo));
	}

}
