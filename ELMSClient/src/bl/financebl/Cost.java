package bl.financebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.financeblservice.CostService;
import blservice.personnelblservice.Personnelblservice;
import blservice.strategyblservice.StrategyblService;
import blservice.transportblservice.Transportblservice;
import ds.financedataservice.FinanceDataService;
import po.finance.CostPO;
import po.finance.SalaryPO;
import test.java.other.VOPOchange;
import util.CostType;
import util.ResultMessage;
import vo.finance.CostVO;
import vo.finance.SalaryVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:46:21 
 *
 */
public class Cost {
	FinanceDataService financeData;
	StrategyblService strategybl;
	Transportblservice transportbl;
	Personnelblservice personnelbl;
	public ArrayList<CostVO> showCosts() {
		
		ArrayList<CostVO> vos = null;
		ArrayList<CostPO> pos = null;
		
		try {
			ArrayList<CostPO> fre=financeData.show(CostType.FREIGHT);
			ArrayList<CostPO> ren=financeData.show(CostType.RENT);
			ArrayList<CostPO> sal=financeData.show(CostType.SALARY);
			pos = new ArrayList<CostPO>();
			for(CostPO f : fre)
				pos.add(f);
			for(CostPO r : ren)
				pos.add(r);
			for(CostPO s : sal)
				pos.add(s);
			vos = new ArrayList<CostVO>();
			if(pos!=null)
				for(CostPO po:pos){
					vos.add((CostVO)VOPOchange.POtoVO(po));
				}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vos;
	}

	public ResultMessage add(CostVO vo) {
		CostPO po=(CostPO) VOPOchange.VOtoPO(vo);
		ResultMessage result = null;
		try {
			result = financeData.add(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public ResultMessage modify(CostVO vo) {
		CostPO po=(CostPO) VOPOchange.VOtoPO(vo);
		ResultMessage result = null;
		try {
			result = financeData.modify(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public ResultMessage del(CostVO vo) {
	
		ResultMessage result = null;
		try {
			result = financeData.del(vo.ID, vo.costType);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
