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
	private ResultMessage result = null;
	public Statistic(StatisticDataService statisticData) {
		this.statisticData = statisticData;
	}
	public ResultMessage bulidStateForm(StateFormVO vo) {
		
		StateFormPO po = (StateFormPO) VOPOchange.VOtoPO(vo);
		
		try {
			result = statisticData.bulidStateForm(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ResultMessage bulidCostIncomeForm(CostIncomeVO vo) {
		
		CostIncomePO po = (CostIncomePO) VOPOchange.VOtoPO(vo);
		
		try {
			result = statisticData.CostIncomeForm(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<StateFormVO> getStateForm() {
		
		ArrayList<StateFormPO> pos = new ArrayList<StateFormPO>();
		
		
		try {
			pos = statisticData.getStateForm();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(pos == null){
			return null;
		}
		
		ArrayList<StateFormVO> vos = new ArrayList<StateFormVO>(pos.size());
		
		for(StateFormPO po : pos ){
			vos.add((StateFormVO)VOPOchange.POtoVO(po));
		}
		return vos;
	}

	public ArrayList<CostIncomeVO> getIncomeForm() {

		ArrayList<CostIncomePO> pos = new ArrayList<CostIncomePO>();
		
		try {
			pos = statisticData.getCostIncomeForm();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(pos == null){
			return null;
		}
		ArrayList<CostIncomeVO> vos = new ArrayList<CostIncomeVO>(pos.size());
		for(CostIncomePO po : pos ){
			vos.add((CostIncomeVO)VOPOchange.POtoVO(po));
		}
		return vos;	
	}

	public ResultMessage bulidBill(BillVO vo) {
		BillPO po = (BillPO) VOPOchange.VOtoPO(vo);
		
		try {
			result = statisticData.bulidBill(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<BillVO> getBills() {
		
		ArrayList<BillPO> pos = new ArrayList<BillPO>();
		
		
		try {
			pos = statisticData.getBills();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
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
