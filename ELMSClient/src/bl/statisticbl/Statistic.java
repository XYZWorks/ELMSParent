package bl.statisticbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.statistic.BillPO;
import po.statistic.CostIncomePO;
import po.statistic.StateFormPO;
import test.java.other.VOPOchange;
import util.ResultMessage;
import vo.statistic.BillVO;
import vo.statistic.CostIncomeVO;
import vo.statistic.StateFormVO;
import ds.statisticdataservice.StatisticDataService;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:49:05 
 *
 */
public class Statistic {
	private StatisticDataService statisticData;
	public Statistic(StatisticDataService statisticData) {
		this.statisticData = statisticData;
	}
	public ResultMessage bulidStateForm(StateFormVO vo) throws RemoteException {
		
		StateFormPO po = (StateFormPO) VOPOchange.VOtoPO(vo);
		return statisticData.bulidStateForm(po);
	}

	public ResultMessage bulidCostIncomeForm(CostIncomeVO vo) throws RemoteException {
		
		CostIncomePO po = (CostIncomePO) VOPOchange.VOtoPO(vo);
		
		return statisticData.CostIncomeForm(po);
	}

	public ArrayList<StateFormVO> getStateForm() throws RemoteException {
		
		ArrayList<StateFormPO> pos = new ArrayList<StateFormPO>();
		
		
			pos = statisticData.getStateForm();
		if(pos == null){
			return null;
		}
		
		ArrayList<StateFormVO> vos = new ArrayList<StateFormVO>(pos.size());
		
		for(StateFormPO po : pos ){
			vos.add((StateFormVO)VOPOchange.POtoVO(po));
		}
		return vos;
	}

	public ArrayList<CostIncomeVO> getIncomeForm() throws RemoteException {

		ArrayList<CostIncomePO> pos = new ArrayList<CostIncomePO>();
		
			pos = statisticData.getCostIncomeForm();
		
		if(pos == null){
			return null;
		}
		ArrayList<CostIncomeVO> vos = new ArrayList<CostIncomeVO>(pos.size());
		for(CostIncomePO po : pos ){
			vos.add((CostIncomeVO)VOPOchange.POtoVO(po));
		}
		return vos;	
	}

	public ResultMessage bulidBill(BillVO vo) throws RemoteException {
		BillPO po = (BillPO) VOPOchange.VOtoPO(vo);
		
		return statisticData.bulidBill(po);
	}

	public ArrayList<BillVO> getBills() throws RemoteException {
		
		ArrayList<BillPO> pos = new ArrayList<BillPO>();
		
		
			pos = statisticData.getBills();
		
		if(pos == null){
			return null;
		}
		ArrayList<BillVO> vos = new ArrayList<BillVO>(pos.size());
		for(BillPO po : pos ){
			vos.add((BillVO)VOPOchange.POtoVO(po));
		}
		return vos;	
	}

}
