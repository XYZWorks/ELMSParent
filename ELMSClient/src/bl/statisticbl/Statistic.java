package bl.statisticbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import net.RMIManage;
import po.statistic.BillPO;
import po.statistic.CostIncomePO;
import po.statistic.StateFormPO;
import test.java.other.VOPOchange;
import util.DataServiceType;
import util.ResultMessage;
import vo.statistic.BillVO;
import vo.statistic.CostIncomeVO;
import vo.statistic.StateFormVO;
import ds.financedataservice.FinanceDataService;
import ds.statisticdataservice.StatisticDataService;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:49:05 
 *
 */
public class Statistic {
	private StatisticDataService statisticData;
	private FinanceDataService financeData;
	
	public Statistic() {
		statisticData = (StatisticDataService) RMIManage.getDataService(DataServiceType.StatisticDataService);
		financeData = (FinanceDataService) RMIManage.getDataService(DataServiceType.FinanceDataService);
		
		try {
			statisticData.initial();
		} catch (RemoteException e) {
			System.err.println("statistic data initial error");
			e.printStackTrace();
		}
		
		try {
			financeData.initial();
		} catch (RemoteException e) {
			System.err.println("finance data initial error");
			e.printStackTrace();
		}
	}
	public ResultMessage bulidStateForm(StateFormVO vo) {
		
		StateFormPO po = (StateFormPO) VOPOchange.VOtoPO(vo);
		ResultMessage result = null;
		
		try {
			result = statisticData.bulidStateForm(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ResultMessage bulidCostIncomeForm(CostIncomeVO vo) {
		
		CostIncomePO po = (CostIncomePO) VOPOchange.VOtoPO(vo);
		
		ResultMessage result = null;

		try {
			result = statisticData.CostIncomeForm(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<StateFormVO> getStateForm() {
		
		ArrayList<StateFormPO> pos = new ArrayList<StateFormPO>();
		ArrayList<StateFormVO> vos = new ArrayList<StateFormVO>();
		
		try {
			pos = statisticData.getStateForm();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(pos == null){
			return null;
		}
		
		
		
		for(StateFormPO po : pos ){
			vos.add((StateFormVO)VOPOchange.POtoVO(po));
		}
		return vos;
	}

	public ArrayList<CostIncomeVO> getIncomeForm() {

		ArrayList<CostIncomePO> pos = new ArrayList<CostIncomePO>();
		ArrayList<CostIncomeVO> vos = new ArrayList<CostIncomeVO>();
		
		try {
			pos = statisticData.getCostIncomeForm();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(pos == null){
			return null;
		}
		
		for(CostIncomePO po : pos ){
			vos.add((CostIncomeVO)VOPOchange.POtoVO(po));
		}
		return vos;	
	}

	public ResultMessage bulidBill(BillVO vo) {
		BillPO po = (BillPO) VOPOchange.VOtoPO(vo);
		
		ResultMessage result = null;

		try {
			result = statisticData.bulidBill(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<BillVO> getBills() {
		
		ArrayList<BillPO> pos = new ArrayList<BillPO>();
		ArrayList<BillVO> vos = new ArrayList<BillVO>();
		
		try {
			pos = statisticData.getBills();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(pos == null){
			return null;
		}
		
		for(BillPO po : pos ){
			vos.add((BillVO)VOPOchange.POtoVO(po));
		}
		return vos;	
	}

}
