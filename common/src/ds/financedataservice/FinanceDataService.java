package ds.financedataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.finance.CostPO;
import po.finance.DepositPO;
import po.finance.PayPO;
import util.ResultMessage;
import ds.DataserviceParent;
/**
 * 财务的数据接口
 * @author ymc
 */
public interface FinanceDataService extends DataserviceParent{
	/**
	 * 收款信息PO
	 * @return
	 */
	public ArrayList<DepositPO> getDepositPO() throws RemoteException;
	/**
	 * 付款信息PO
	 * @return
	 */
	public ArrayList<PayPO> getPayPO() throws RemoteException;
	/**
	 * 增加收款信息
	 * @param po
	 * @return
	 */
	public ResultMessage addDeposit(DepositPO po) throws RemoteException;
	/**
	 * 增加付款信息
	 * @param po
	 * @return
	 */
	public ResultMessage addPay(PayPO po) throws RemoteException;
	/**
	 * 查看cost信息
	 * @return
	 */
	public ArrayList<CostPO> show() throws RemoteException;
	/**
	 * 增加cost信息
	 * @param po
	 * @return
	 */
	public ResultMessage add(CostPO po) throws RemoteException;
	/**
	 * 修改cost信息
	 * @param po
	 * @return
	 */
	public ResultMessage modify(CostPO po) throws RemoteException;
	/**
	 * 删除cost信息
	 * @param po
	 * @return
	 */
	public ResultMessage del(CostPO po) throws RemoteException;
}
