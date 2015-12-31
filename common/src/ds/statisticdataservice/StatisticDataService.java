package ds.statisticdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.finance.PayPO;
import po.statistic.BillPO;
import po.statistic.CostIncomePO;
import po.statistic.StateFormPO;
import po.transport.PayDocPO;
import util.MyDate;
import util.ResultMessage;
import ds.DataserviceParent;

/**
 * 成本收益表、经营状况表增查接口
 * @author czq
 * @date 2015-10-22
 */
public interface StatisticDataService extends DataserviceParent {
	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public ArrayList<PayPO> getDatePays(MyDate start , MyDate end)throws RemoteException;
	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public ArrayList<PayDocPO> getDatePayDocs(MyDate start , MyDate end)throws RemoteException;
	/**
	 * 获取所有的经营状况表
	 * @return
	 */
	public ArrayList<StateFormPO> getStateForm() throws RemoteException;

	/**
	 * 获取所有的成本收益表
	 * @return
	 */
	public ArrayList<CostIncomePO> getCostIncomeForm() throws RemoteException;

	/**
	 * 增加经营状况表
	 * @param po 必须数据合法
	 * @return
	 */
	public ResultMessage bulidStateForm(StateFormPO po) throws RemoteException;

	/**
	 * 增加成本收益表
	 * @param po 必须数据合法
	 * @return
	 */
	public ResultMessage CostIncomeForm(CostIncomePO po) throws RemoteException;
	/**
	 * 期初建账
	 * @param po
	 * @return
	 */
	public ResultMessage bulidBill(BillPO po) throws RemoteException;
	/**
	 * 获得所有期初建账的账单
	 * @return
	 */
	public ArrayList<BillPO> getBills() throws RemoteException;
	
}
