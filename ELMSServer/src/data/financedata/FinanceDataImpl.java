package data.financedata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CostPO;
import po.DepositPO;
import po.PayPO;
import util.ResultMessage;
import ds.financedataservice.FinanceDataService;
 /** 
 * 
 * @author czq 
 * @version 2015年11月5日 下午8:45:50 
 */
public class FinanceDataImpl implements FinanceDataService{

	public ArrayList<DepositPO> getDepositPO() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PayPO> getPayPO() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addDeposit(DepositPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addPay(PayPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<CostPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage add(CostPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage modify(CostPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage del(CostPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
