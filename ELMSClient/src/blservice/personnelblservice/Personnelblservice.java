package blservice.personnelblservice;

import java.util.ArrayList;

import util.ResultMessage;
import vo.personnel.InstVO;
import vo.personnel.PersonVO;
/** 
  * 人员机构管理接口类
  * *@author czq 
  * @version 2015年10月24日 
  * 
  * */
public interface Personnelblservice {
	/**
	 * 通过机构读取其下属人员信息
	 * @param ID
	 * @return
	 */
	public ArrayList<PersonVO> getPeopleByInst(String ID);
	/**
	 * 通过人员ID获得人员信息
	 * @param ID
	 * @return
	 */
	public PersonVO getPeopleByID(String ID);
	/**
	 * 通过姓名查找人员信息
	 * @param name
	 * @return
	 */
	public ArrayList<PersonVO> getPeopleByName(String name);
	/**
	 * 增加人员信息
	 * @param vo
	 * @return
	 */
	public ResultMessage addPeople(PersonVO vo);
	/**
	 * 删除人员信息
	 * @param ID
	 * @return
	 */
	public ResultMessage delPeople(String ID);
	/**
	 * 增加机构 
	 * @param vo
	 * @return
	 */
	public ResultMessage addInst(InstVO vo);
	/**
	 * 删除机构
	 * @param ID
	 * @return
	 */
	public ResultMessage delInst(String ID);
	/**
	 * 获得所有机构信息
	 * @return 如果没有，返回空指针
	 */
	public ArrayList<InstVO> getInst();
	
}
