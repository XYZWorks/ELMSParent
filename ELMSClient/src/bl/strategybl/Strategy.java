package bl.strategybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.strategyblservice.StrategyblService;
import ds.strategydataservice.StrategyDataService;
import net.RMIManage;
import po.strategy.ConstPO;
import po.strategy.SalaryWayPO;
import test.java.other.VOPOchange;
import util.DataServiceType;
import util.ResultMessage;
import util.StaffType;
import vo.strategy.ConstVO;
import vo.strategy.SalaryWayVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:50:58 
 *
 */
public class Strategy {
	
	StrategyDataService strategyData;
	
	public Strategy() {
		strategyData = (StrategyDataService) RMIManage.getDataService(DataServiceType.StrategyDataService);
	
//		try {
//			strategyData.initial();
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	public ConstVO getConst() {
		ConstPO po = null;
		try {
			po = strategyData.getConst();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConstVO vo = (ConstVO) VOPOchange.POtoVO(po);
		return vo;
	}

	public ResultMessage setConst(ConstVO vo) {
		ConstPO po = (ConstPO) VOPOchange.VOtoPO(vo);
		
		ResultMessage resultMessage = null;
		
		try {
			resultMessage = strategyData.setConst(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMessage;
	}

	public ArrayList<SalaryWayVO> getsalary() {
		
		ArrayList<SalaryWayPO> pos = null;
		ArrayList<SalaryWayVO> vos = null;
		
		try {
			pos = strategyData.getSalary();
			if(pos!=null)
				vos = new ArrayList<SalaryWayVO>(pos.size());
				for(SalaryWayPO po : pos){
					vos.add((SalaryWayVO)VOPOchange.POtoVO(po));
				}
		} catch (RemoteException e) {

			e.printStackTrace();
		}
		return vos;
	}

	public SalaryWayVO getOneSalary(StaffType type) {
		SalaryWayPO po = null;
		SalaryWayVO vo = null;
		try {
			po = strategyData.getOneSalary(type);
			if(po!=null)
				vo = (SalaryWayVO) VOPOchange.POtoVO(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return vo;
	}

	public ResultMessage setSalary(SalaryWayVO way) {
		SalaryWayPO po = (SalaryWayPO) VOPOchange.VOtoPO(way);
		
		ResultMessage resultMessage= null;
		
		try {
			resultMessage = strategyData.setSalaryWay(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMessage;
	}

}
