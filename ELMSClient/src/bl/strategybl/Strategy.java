package bl.strategybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import po.strategy.ConstPO;
import po.strategy.EstiDatePO;
import po.strategy.SalaryWayPO;
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
		this.strategyData = strategyData;

	}

	public ConstVO getConst() throws RemoteException {
		ConstPO po = null;
		po = strategyData.getConst();
		if (po == null) {
			return null;
		}

		ConstVO vo = (ConstVO) VOPOchange.POtoVO(po);
		return vo;
	}

	public ResultMessage setConst(ConstVO vo) throws RemoteException {
		ConstPO po = (ConstPO) VOPOchange.VOtoPO(vo);
		return strategyData.setConst(po);
	}

	public ArrayList<SalaryWayVO> getsalary() throws RemoteException {

		ArrayList<SalaryWayPO> pos = null;
		ArrayList<SalaryWayVO> vos = null;
		pos = strategyData.getSalary();
		if (pos != null)
			vos = new ArrayList<SalaryWayVO>(pos.size());
		for (SalaryWayPO po : pos) {
			vos.add((SalaryWayVO) VOPOchange.POtoVO(po));
		}
		return vos;
	}

	public SalaryWayVO getOneSalary(StaffType type) throws RemoteException {
		SalaryWayPO po = null;
		SalaryWayVO vo = null;
		po = strategyData.getOneSalary(type);
		if (po != null)
			vo = (SalaryWayVO) VOPOchange.POtoVO(po);
		return vo;
	}

	public ResultMessage setSalary(SalaryWayVO way) throws RemoteException {
		SalaryWayPO po = (SalaryWayPO) VOPOchange.VOtoPO(way);
		return strategyData.setSalaryWay(po);
	}

	public EstiDateVO getEstiDateVO() throws RemoteException {
		EstiDatePO po = strategyData.getEstiDatePO();
		EstiDateVO vo =  (EstiDateVO) VOPOchange.POtoVO(po);
//		if(vo.dayInBG==null){
//			initialEstiDate(vo);
//		}
		return vo;
	}

	public ResultMessage setEstiDateVO(EstiDateVO vo) throws RemoteException {
		EstiDatePO po = (EstiDatePO) VOPOchange.VOtoPO(vo);
		return strategyData.setEstiDatePO(po);
	}

}
