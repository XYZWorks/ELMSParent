package data.financedata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CostPO;
import po.DepositPO;
import po.PayPO;
import util.MyDate;
import util.ResultMessage;
import dataSuper.DataSuperClass;
import ds.financedataservice.FinanceDataService;
 /** 
 * 
 * @author czq 
 * @version 2015年11月5日 下午8:45:50 
 */
public class FinanceDataImpl extends DataSuperClass implements FinanceDataService{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String depositTable = "deposit";
	
	private final String payTable = "pay";

	public FinanceDataImpl() throws RemoteException {}

	public ArrayList<DepositPO> getDepositPO() throws RemoteException {
		
		return null;
	}

	public ArrayList<PayPO> getPayPO() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addDeposit(DepositPO po) throws RemoteException {
		return addToSQL(depositTable, "0" , MyDate.toString(po.getTime()) , String.valueOf(po.getMoney()));
	}

	public ResultMessage addPay(PayPO po) throws RemoteException {
		return addToSQL(payTable, "0" , MyDate.toString(po.getTime()) , String.valueOf(po.getMoney()) , po.getType());
	}

	public ArrayList<CostPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage add(CostPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 *  TODO  怎么修改，改什么？？？？
	 */
	public ResultMessage modify(CostPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage del(CostPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
