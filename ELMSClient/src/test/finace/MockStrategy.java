package test.finace;

import java.util.ArrayList;

import test.DataTool;
import util.StaffType;
import vo.ConstVO;
import vo.SalaryWayVO;

/**
 * 
 * @author czq
 * @version 2015年11月15日 上午11:15:40
 */
public class MockStrategy {

	public ConstVO getConst() {
		return DataTool.getConst();
	}

	public ArrayList<SalaryWayVO> getsalary() {

		return DataTool.getSalarys();
	}

	public SalaryWayVO getOneSalary(StaffType type) {
		switch (type) {
		case courier:
			return DataTool.getSalarys().get(0);
		case driver:
			return DataTool.getSalarys().get(1);
		case financeman:
			return DataTool.getSalarys().get(2);
		case saleman:
			return DataTool.getSalarys().get(3);
		case storeman:
			return DataTool.getSalarys().get(4);
		case storemanager:
			return DataTool.getSalarys().get(5);
		default:
			break;
		}
		return null;
	}

}
