package bl.financebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.financeblservice.CostService;
import blservice.personnelblservice.Personnelblservice;
import blservice.strategyblservice.StrategyblService;
import blservice.transportblservice.Transportblservice;
import ds.financedataservice.FinanceDataService;
import po.CostPO;
import po.SalaryPO;
import util.ResultMessage;
import vo.CostVO;
import vo.SalaryVO;

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
		try {
			ArrayList<CostPO> pos=financeData.show();
			vos = new ArrayList<CostVO>();
			if(pos!=null)
				for(CostPO po:pos){
					vos.add(getValue(po));
				}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vos;
	}

	public ResultMessage add(CostVO vo) {
		CostPO po=setValue(vo);
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
		CostPO po=setValue(vo);
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
		CostPO po=setValue(vo);
		ResultMessage result = null;
		try {
			result = financeData.del(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	private  CostVO getValue(CostPO po){
		CostVO vo;
		if(po.getType().equals("salary")){
			SalaryVO so= new SalaryVO(po.getMoney(), po.getType(),((SalaryPO) po).getWorker());
			return so;
		}
		else
			vo= new CostVO(po.getMoney(), po.getType());
		
		return vo;
		
	} 
	private CostPO setValue(CostVO vo){
		CostPO po;
		if(vo.type.equals("salary")){
			SalaryPO so=new SalaryPO(vo.money, vo.type, ((SalaryVO)vo).worker);
			return so;
		}
		else
			po=new CostPO(vo.money, vo.type);
		
		return po;
	}
}
