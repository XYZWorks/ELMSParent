package data.statisticdata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.text.Position;

import po.DTManage.CarPO;
import po.finance.DepositPO;
import po.personnel.InstPO;
import po.personnel.PersonPO;
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
	
	private final String depositFormForStateForm = "DepositForForm";
	
	private final String payFormForStateForm = "PayFormForForm";
	
	private final String billInstForm = "BillInst";
	
	private final String billPeopleForm = "BillPeople";
	
	private final String billCarForm = "BillCar";
	
	public StatisticDataImpl() throws RemoteException {}
	
	public void initial() throws RemoteException {
		initialFromSQL(billTable);
		initialFromSQL(stateFormTable);
		initialFromSQL(costIncomeForm);
		
	}
	

	public ArrayList<StateFormPO> getStateForm() throws RemoteException {
		ArrayList<StateFormPO> pos = new ArrayList<StateFormPO>();
		try {
			sql = "SELECT * FROM "+ stateFormTable;
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
		
		return addToSQL(stateFormTable, MyDate.toString(po.getStartDate()) , MyDate.toString(po.getEndDate()) , changeToStringArray() , helper.tranFromArrayToString(po.getPays()));
	}

	public ResultMessage CostIncomeForm(CostIncomePO po) throws RemoteException {
		
		return  addToSQL(costIncomeForm	, String.valueOf(po.getIncome()) ,String.valueOf(po.getExpense()) , MyDate.toString(po.getStartDate()) , MyDate.toString(po.getEndDate()));
	}

	public ResultMessage bulidBill(BillPO po) throws RemoteException {
		return addToSQL(billTable, po.getFinaceman() , MyDate.toString(po.getDate()) , saveInstsToSQL(po.getInstituations()) , savePersonsToSQL(po.getPersons()) , saveCarsToSQL(po.getCars()));
	}

	public ArrayList<BillPO> getBills() throws RemoteException {
		ArrayList<BillPO> pos = new ArrayList<BillPO>();
		try {
			sql = "SELECT * FROM "+ billTable;
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
	
	private ArrayList<InstPO> readInstFromSQL(String text) {
		ArrayList<String> ids = helper.tranFromStringToArrayList(text);
		
		
		
	}
	
	
	private String saveInstsToSQL(ArrayList<InstPO> pos ){
		if (pos == null || pos.isEmpty()) {
			return null;
		}
		ResultMessage resultMessage;
		String[] ids = new String[pos.size()];
		for (int i = 0; i < ids.length; i++) {
			ids[i] = pos.get(i).getID();
			resultMessage =addToSQL(billInstForm, pos.get(i).getID() , pos.get(i).getLocation() , pos.get(i).getType().name() );
			if(resultMessage != ResultMessage.SUCCESS){
				System.err.println("ERROR! 无法存储Inst消息");
			}
		}
		return helper.tranFromArrayToString(ids);
		
	}
	
	private String savePersonsToSQL(ArrayList<PersonPO> pos ){
		if (pos == null || pos.isEmpty()) {
			return null;
		}
		ResultMessage resultMessage;
		String[] ids = new String[pos.size()];
		for (int i = 0; i < ids.length; i++) {
			ids[i] = pos.get(i).getID();
			resultMessage =addToSQL(billInstForm, pos.get(i).getID() , pos.get(i).getInstID() , pos.get(i).getName(), pos.get(i).getType().name() ,pos.get(i).getPhoneNum() );
			if(resultMessage != ResultMessage.SUCCESS){
				System.err.println("ERROR! 无法存储PersonPO消息");
			}
		}
		return helper.tranFromArrayToString(ids);
		
	}
	
	private String saveCarsToSQL(ArrayList<CarPO> pos ){
		if (pos == null || pos.isEmpty()) {
			return null;
		}
		ResultMessage resultMessage;
		String[] ids = new String[pos.size()];
		for (int i = 0; i < ids.length; i++) {
			ids[i] = pos.get(i).getID();
			resultMessage =addToSQL(billInstForm, pos.get(i).getID() , pos.get(i).getPlateNum(), String.valueOf(pos.get(i).getUseYear()) );
			if(resultMessage != ResultMessage.SUCCESS){
				System.err.println("ERROR! 无法存储PersonPO消息");
			}
		}
		return helper.tranFromArrayToString(ids);
		
	}
	
	/**
	 * 
	 * @return
	 */
	private String saveDepositsToSQL(ArrayList<DepositPO> pos) {
		if (pos == null || pos.isEmpty()) {
			return null;
		}
		StringBuffer buffer = new StringBuffer(pos.size()*5);
		ResultMessage result;
		for (DepositPO depositPO : pos) {
			result = addToSQL(depositFormForStateForm, MyDate.toString(depositPO.getTime()) ,String.valueOf( depositPO.getMoney()));
			if(result != ResultMessage.SUCCESS){
				System.err.println("存储depositPO出现问题");
				return null;
			}
		}
		
		
	}
	
	private ArrayList<String> changeToStringArray(){
		return null;
	}
	
}
