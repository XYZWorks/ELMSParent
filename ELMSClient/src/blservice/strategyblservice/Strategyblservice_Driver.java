package blservice.strategyblservice;

import java.util.ArrayList;

import util.ResultMessage;
import util.StaffType;
import util.WageStrategy;
import vo.ConstVO;
import vo.SalaryWayVO;
 /** * @author czq @version 创建时间：2015年10月25日 下午4:26:09 * 简单说明 */
public class Strategyblservice_Driver {
	public void drive(StrategyblService bl){
		ResultMessage result;
		
		System.out.println("获得常量");
		ConstVO temp = bl.getConst();
		System.out.println("成功获得，例如南京北京距离为");
		System.out.println(temp.mileInBN);
		
		System.out.println("设置常量");
		result = bl.setConst(new ConstVO(100, 200, 300, 400, 400, 100, 3000, 1000, 2000, 1, 5, 3, null));
		if(result == ResultMessage.SUCCESS){
			System.out.println("设置常量成功");
		}
		
		System.out.println("获得薪水策略");
		ArrayList<SalaryWayVO> temp2 = bl.getsalary();
		System.out.println("成功获得薪水策略");
		for (SalaryWayVO salaryWayVO : temp2) {
			System.out.println(salaryWayVO.type);
			System.out.println(salaryWayVO.basicSalary);
		}
		
		System.out.println("获得单一薪水策略");
		SalaryWayVO temp3 = bl.getOneSalary(StaffType.courier);
		System.out.println("成功获得快递员薪水策略");
		System.out.println(temp3.basicSalary);
		
		System.out.println("设置薪水策略");
		result = bl.setSalary(new SalaryWayVO(StaffType.courier, 2000, 1500, WageStrategy.baseAndMore));
		if(result == ResultMessage.SUCCESS){
			System.out.println("设置薪水策略成功");
		}
		
	}
}
