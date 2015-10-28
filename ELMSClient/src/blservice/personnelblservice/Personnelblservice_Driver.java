package blservice.personnelblservice;

import java.util.ArrayList;

import util.ResultMessage;
import util.StaffType;
import vo.InstVO;
import vo.PersonVO;

 /** * @author czq @version 创建时间：2015年10月25日 下午11:12:25 * 简单说明 */
public class Personnelblservice_Driver {

	public void drive(Personnelblservice bl) {
		ResultMessage result;
		
		
		System.out.println("增加人员：");
		result = bl.addPeople(new PersonVO("111111","111111","czq",StaffType.driver,"13182831233"));
		if(result == ResultMessage.SUCCESS){
			System.out.println("增加人员成功");
		}
		
		System.out.println("删除人员：");
		result = bl.delPeople("111111");
		if(result == ResultMessage.SUCCESS){
			System.out.println("删除人员成功");
		}
		
		System.out.println("通过机构ID查找人员：");
		ArrayList<PersonVO> res = bl.getPeopleByInst("111111");
		System.out.println("查找成功：");
		for (PersonVO personVO : res) {
			System.out.println("人员信息是" + personVO.name);
		}
		
		System.out.println("通过姓名查找人员：");
		res = bl.getPeopleByName("强");
		System.out.println("查找成功：");
		for (PersonVO personVO : res) {
			System.out.println("人员信息是" + personVO.name);
		}
		
		System.out.println("通过人员ID查找人员：");
		PersonVO temp = bl.getPeopleByID("111111");
		System.out.println("成功查找到");
		System.out.println(temp.name);
		
		System.out.println("删除机构");
		result = bl.delInst("111111");
		if(result == ResultMessage.SUCCESS){
			System.out.println("删除机构成功");
		}
		
		System.out.println("获得所有机构信息");
		ArrayList<InstVO> temp2 = bl.getInst();
		System.out.println("查找成功");
		for (InstVO instVO : temp2) {
			System.out.println("机构的ID：" + instVO.ID);
		}
		
		System.out.println("增加机构：");
		result = bl.delInst("111111");
		if(result == ResultMessage.SUCCESS){
			System.out.println("增加机构成功");
		}
		
	}

}
