package bl.financebl;

import java.util.ArrayList;

import blservice.financeblservice.CostService;
import blservice.personnelblservice.Personnelblservice;
import blservice.strategyblservice.StrategyblService;
import blservice.transportblservice.Transportblservice;
import ds.financedataservice.FinanceDataService;
import util.ResultMessage;
import vo.CostVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:46:21 
 *
 */
public class CostImpl implements CostService {
	FinanceDataService financeData;
	StrategyblService strategybl;
	Transportblservice transportbl;
	Personnelblservice personnelbl;
	public ArrayList<CostVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage add(CostVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage modify(CostVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage del(CostVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
