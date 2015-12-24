package bl.strategybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.strategy.ConstPO;
import po.strategy.EstiDatePO;
import po.strategy.SalaryWayPO;
import test.java.other.VOPOchange;
import util.ResultMessage;
import util.StaffType;
import vo.strategy.ConstVO;
import vo.strategy.EstiDateVO;
import vo.strategy.SalaryWayVO;
import ds.strategydataservice.StrategyDataService;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:50:58 
 *
 */
public class Strategy {
	
	
	StrategyDataService strategyData;
	public Strategy(StrategyDataService strategyData) {
		this.strategyData =strategyData;

	}
	public ConstVO getConst() {
		ConstPO po = null;
		try {
			po = strategyData.getConst();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(po == null){
			return null;
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
			e.printStackTrace();
		}
		return resultMessage;
	}
	public EstiDateVO getEstiDateVO() {
		
		EstiDatePO po = null;
		po = strategyData.getEstiDatePO();
		
		EstiDateVO vo = (EstiDateVO) VOPOchange.POtoVO(po);
		return vo;
	}
	public ResultMessage setEstiDateVO(EstiDateVO vo) {
		EstiDatePO po = (EstiDatePO) VOPOchange.VOtoPO(vo);
		return strategyData.setEstiDatePO(po);
	}

}
