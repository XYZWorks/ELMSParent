package data.statisticdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BillPO;
import po.CostIncomePO;
import po.StateFormPO;
import util.ResultMessage;
import dataSuper.DataSuperClass;
import ds.statisticdataservice.StatisticDataService;
 /** 
 * 
 * @author czq 
 * @version 2015年11月5日 下午8:46:54 
 */
public class StatisticDataImpl extends DataSuperClass implements StatisticDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StatisticDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<StateFormPO> getStateForm() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<CostIncomePO> getCostIncomeForm() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage bulidStateForm(StateFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage CostIncomeForm(CostIncomePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage bulidBill(BillPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<BillPO> getBills() {
		// TODO Auto-generated method stub
		return null;
	}

}
