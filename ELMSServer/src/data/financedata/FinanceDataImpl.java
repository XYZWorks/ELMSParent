package data.financedata;

import java.rmi.RemoteException;
import java.sql.SQLException;
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
	
	private static final String depositTable = "deposit";
	
	private static final String payTable = "pay";

	public FinanceDataImpl() throws RemoteException {}
	
	public void initial() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<DepositPO> getDepositPO() throws RemoteException {
		ArrayList<DepositPO> pos = new ArrayList<DepositPO>();
		try {
			sql = "SELECT * FROM " + depositTable;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while(result.next()){
				pos.add(new DepositPO(MyDate.getDate(result.getString(2)), Integer.parseInt(result.getString(3))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (pos==null)?null:pos;
	}

	public ArrayList<PayPO> getPayPO() throws RemoteException {
		ArrayList<PayPO> pos = new ArrayList<PayPO>();
		try {
			sql = "SELECT * FROM " + payTable;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while(result.next()){
				pos.add(new PayPO(MyDate.getDate(result.getString(2)), Integer.parseInt(result.getString(3)), result.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (pos==null)?null:pos;
	}

	public ResultMessage addDeposit(DepositPO po) throws RemoteException {
		return addToSQL(depositTable, "0" , MyDate.toString(po.getTime()) , String.valueOf(po.getMoney()));
	}

	public ResultMessage addPay(PayPO po) throws RemoteException {
		return addToSQL(payTable, "0" , MyDate.toString(po.getTime()) , String.valueOf(po.getMoney()) , po.getType());
	}

	public ArrayList<CostPO> show() throws RemoteException {
		
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
