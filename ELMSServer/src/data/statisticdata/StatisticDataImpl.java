package data.statisticdata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import po.BillPO;
import po.CostIncomePO;
import po.StateFormPO;
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
	
	private final String billTable = "Bill";
	
	private final String stateFormTable = "StateForm";
	
	private final String costIncomeForm = "CostIncomeForm";

	public StatisticDataImpl() throws RemoteException {}
	
	public void initial() throws RemoteException {
		initialFromSQL(billTable);
		initialFromSQL(stateFormTable);
		initialFromSQL(costIncomeForm);
		
	}

	public ArrayList<StateFormPO> getStateForm() throws RemoteException {
//		ArrayList<StateFormPO> pos = 
//		sql = "SELECT * FROM " + stateFormTable;
//		preState = conn.prepareStatement(sql);
//		result = preState.executeQuery();
//		while(result.next()){
			
//		}
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(pos.size() == 0){
			return null;
		}else{
			return pos;
		}
	}

}
