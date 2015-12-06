package ds.financedataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.finance.BankAccountPO;
import po.finance.CostPO;
import po.finance.DepositPO;
import po.finance.PayPO;
import util.CostType;
import util.ResultMessage;
import ds.DataserviceParent;
/**
 * 财务的数据接口
 * @author ymc
 */
public interface FinanceDataService extends DataserviceParent{
	/**
	 * 获得所有银行账户
	 * @return
	 */
	public ArrayList<BankAccountPO> getAccounts();
	/**
	 * 修改银行账户信息
	 * @param vo
	 * @return
	 */
	public ResultMessage modifyAccount(BankAccountPO vo);
	/**
	 * 删除一个银行账户
	 * @param ID
	 * @return
	 */
	public ResultMessage deleteAccount(String ID);
	/**
	 * 修改一个银行账户
	 * @param vo
	 * @return
	 */
	public ResultMessage addAccount(BankAccountPO vo);
	
	
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
	public ArrayList<CostPO> show(CostType type) throws RemoteException;
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
	public ResultMessage del(String ID , CostType type) throws RemoteException;
}
