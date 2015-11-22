package ds.personneldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.personnel.InstPO;
import po.personnel.PersonPO;
import util.ResultMessage;
import ds.DataserviceParent;

/**
 * 人员机构管理数据接口类
 * @author czq
 * @date 2015/10/20
 */
public interface PersonnelDataService extends DataserviceParent{
	/**
	 * 通过机构ID查找机构下属人员
	 * @param ID
	 * @return 该机构下属人员信息，若无该机构，返回null
	 */
	public ArrayList<PersonPO> getPeoByInst(String ID) throws RemoteException;
	/**
	 * 通过人员iD查找人员信息
	 * @param ID
	 * @return 返回人员信息，null则为找不到
	 */
	public PersonPO getPersonByID(String ID) throws RemoteException;
	/**
	 * 通过人员姓名查找人员信息
	 * @param name
	 * @return 相关的人员信息（模糊查找）
	 */
	public ArrayList<PersonPO> getPeoByName(String name) throws RemoteException;
	/**
	 * 增加人员，将其变为持久化对象
	 * @param po 
	 * @return 是否成功
	 */
	public ResultMessage addPerson(PersonPO po) throws RemoteException;
	/**
	 * 删除人员
	 * @param po
	 * @return 是否成功
	 */
	public ResultMessage delPerson(String ID) throws RemoteException;
	/**
	 * 增加机构
	 * @param po
	 * @return 是否成功
	 */
	public ResultMessage addInst(InstPO po) throws RemoteException;
	/**
	 * 删除机构
	 * @param po
	 * @return 是否成功
	 */
	public ResultMessage delInst(InstPO po) throws RemoteException;
	/**
	 * 获得所有机构信息
	 * @return
	 */
	public ArrayList<InstPO> getInst() throws RemoteException;
}
