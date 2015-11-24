package data.statisticdata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import po.statistic.BillPO;
import po.statistic.CostIncomePO;
import po.statistic.StateFormPO;
import util.MyDate;
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
	
	private final String billTable = "bill";
	
	private final String stateFormTable = "StateForm";
	
	private final String costIncomeForm = "CostIncomeForm";

	public StatisticDataImpl() throws RemoteException {}
	
	public void initial() throws RemoteException {
		initialFromSQL(billTable);
		initialFromSQL(stateFormTable);
		initialFromSQL(costIncomeForm);
		
	}
	

	public ArrayList<StateFormPO> getStateForm() throws RemoteException {
		ArrayList<StateFormPO> pos = new ArrayList<StateFormPO>();
		try {
			sql = "SELECT * FROM " + stateFormTable;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while(result.next()){
				pos.add(new StateFormPO(MyDate.getDate(result.getString(1)), MyDate.getDate(result.getString(2)), helper.tranFromStringToArrayList(result.getString(3)), helper.tranFromStringToArrayList(result.getString(4))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (pos==null)?null:pos;
	}

	public ArrayList<CostIncomePO> getCostIncomeForm() throws RemoteException {
		ArrayList<CostIncomePO> pos = new ArrayList<CostIncomePO>();
		try {
			sql = "SELECT * FROM " + costIncomeForm;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while(result.next()){
				pos.add(new CostIncomePO(Integer.parseInt(result.getString(1)) , Integer.parseInt(result.getString(2)) , MyDate.getDate(result.getString(3)) , MyDate.getDate(result.getString(4))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (pos==null)?null:pos;
	}

	public ResultMessage bulidStateForm(StateFormPO po) throws RemoteException {
		
		return addToSQL(stateFormTable, MyDate.toString(po.getStartDate()) , MyDate.toString(po.getEndDate()) , helper.tranFromArrayToString(po.getDeposits()) , helper.tranFromArrayToString(po.getPays()));
	}

	public ResultMessage CostIncomeForm(CostIncomePO po) throws RemoteException {
		
		return  addToSQL(costIncomeForm	, String.valueOf(po.getIncome()) ,String.valueOf(po.getExpense()) , MyDate.toString(po.getStartDate()) , MyDate.toString(po.getEndDate()));
	}

	public ResultMessage bulidBill(BillPO po) throws RemoteException {
		
		return addToSQL(billTable, po.getFinaceman() , MyDate.toString(po.getDate()) , helper.tranFromArrayToString(po.getInstituations()) , helper.tranFromArrayToString(po.getPersons()) , helper.tranFromArrayToString(po.getCars()));
	}

	public ArrayList<BillPO> getBills() throws RemoteException {
		ArrayList<BillPO> pos = new ArrayList<BillPO>();
		try {
			sql = "SELECT * FROM " + billTable;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while(result.next()){
				pos.add(new BillPO(result.getString(1), MyDate.getDate(result.getString(2)), helper.tranFromStringToArrayList(result.getString(3)), helper.tranFromStringToArrayList(result.getString(4)), helper.tranFromStringToArrayList(result.getString(5))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(pos.size() == 0){
			return null;
		}else{
			return pos;
		}
	}

}
