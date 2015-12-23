package bl.strategybl;

import java.util.ArrayList;

import blservice.strategyblservice.StrategyblService;
import util.ResultMessage;
import util.StaffType;
import vo.strategy.ConstVO;
import vo.strategy.SalaryWayVO;

/**
*
*@author:xingcheng
*@version 2015年12月23日
*/
public class strategybl_stub implements StrategyblService {

	@Override
	public ConstVO getConst() {
		//int mileInBN, int mileInBS, int mileInBG,
//		int mileInNS, int mileInNG, int mileINSG, double plane,
//		double train, double truck, int paperBox, int woodBox,
//		int plasticBag,int[] ratios
		int [] ratios={18,23,25};
		ConstVO c=new ConstVO(900,1064.7,1888.8,266,1132,1213,20,0.2,2,5,10,1, ratios);
		
		return c;
	}

	@Override
	public ResultMessage setConst(ConstVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SalaryWayVO> getsalary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SalaryWayVO getOneSalary(StaffType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage setSalary(SalaryWayVO way) {
		// TODO Auto-generated method stub
		return null;
	}

}
