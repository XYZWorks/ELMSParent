package blservice.strategyblservice;

import java.util.ArrayList;

import util.ResultMessage;
import util.StaffType;
import util.WageStrategy;
import vo.ConstVO;
import vo.SalaryWayVO;
 /** * @author czq @version 创建时间：2015年10月25日 下午4:25:54 * 简单说明 */
public class Strategyblservice_Stub implements StrategyblService{

	public ConstVO getConst() {
		return new ConstVO(100, 200, 300, 400, 400, 100, 3000, 1000, 2000, 1, 5, 3, null);
	}

	public ResultMessage setConst(ConstVO vo) {
		return ResultMessage.SUCCESS;
	}

	public ArrayList<SalaryWayVO> getsalary() {
		ArrayList<SalaryWayVO> temp = new ArrayList<SalaryWayVO>();
		temp.add(new SalaryWayVO(StaffType.driver, 2000, 0, WageStrategy.byMonth));
		temp.add(new SalaryWayVO(StaffType.courier, 2000, 1500, WageStrategy.baseAndMore));
		
		return temp;
	}

	public SalaryWayVO getOneSalary(StaffType type) {
		return new SalaryWayVO(type, 2000, 1500, WageStrategy.baseAndMore);
	}

	public ResultMessage setSalary(SalaryWayVO way) {
		return ResultMessage.SUCCESS;
	}

}
