package data.financedata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import po.finance.BankAccountPO;
import po.finance.CostPO;
import po.finance.DepositPO;
import po.finance.FreightPO;
import po.finance.PayPO;
import po.finance.RentPO;
import po.finance.SalaryPO;
import util.CostType;
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
	
	private static final String frieghtTable = "frieght";
	
	private static final String rentTable = "rent";
	
	private static final String salaryTable = "salarycost";
	
	private static final String bankAccountTable = "BankAccount";

	public FinanceDataImpl() throws RemoteException {}
	
	public void initial() throws RemoteException {
		initialFromSQL(payTable);
		initialFromSQL(depositTable);
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
			sql = "SELECT * FROM "  + payTable ;
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

	public ArrayList<CostPO> show(CostType type) throws RemoteException {
		ArrayList<CostPO> costs = new ArrayList<CostPO>(40);
		try {
			switch (type) {
			case FREIGHT:
				sql = "SELECT * FROM " + frieghtTable;

				preState = conn.prepareStatement(sql);
				result = preState.executeQuery();
				while (result.next()) {
					costs.add(new FreightPO(result.getString(1),
							MyDate.getDate(result.getString(2)), MyDate
									.getDate(result.getString(3)), Integer
									.parseInt(result.getString(4)), CostType
									.valueOf(result.getString(5))));
				}
				break;
			case RENT:
				sql = "SELECT * FROM " + rentTable;

				preState = conn.prepareStatement(sql);
				result = preState.executeQuery();
				while (result.next()) {
					costs.add(new RentPO(result.getString(1),MyDate.getDate(result.getString(2)),
							MyDate.getDate(result.getString(3)), Integer
									.parseInt(result.getString(4)), CostType
									.valueOf(result.getString(5))));
				}
				break;
			case SALARY:
				sql = "SELECT * FROM " + salaryTable;

				preState = conn.prepareStatement(sql);
				result = preState.executeQuery();
				while (result.next()) {
					costs.add(new SalaryPO(result.getString(1),MyDate.getDate(result.getString(2)),
							MyDate.getDate(result.getString(3)), Integer
									.parseInt(result.getString(4)), CostType
									.valueOf(result.getString(5)), result
									.getString(6)));
				}
				break;
			default:
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return costs.isEmpty() ? null : costs;

	}

	public ResultMessage add(CostPO po) throws RemoteException {
		switch (po.getCostType()) {
		case FREIGHT:
			FreightPO fpo = (FreightPO) po;
			return addToSQL(frieghtTable,fpo.getID(), MyDate.toString(fpo.getStartDate()),
					MyDate.toString(fpo.getEndDate()),
					String.valueOf(fpo.getMoney()), fpo.getCostType().name());
		case RENT:
			RentPO rpo = (RentPO) po;
			return addToSQL(rentTable,rpo.getID(), MyDate.toString(rpo.getStartDate()),
					MyDate.toString(rpo.getEndDate()),
					String.valueOf(rpo.getMoney()), rpo.getCostType().name());
		case SALARY:
			SalaryPO spo = (SalaryPO) po;
			return addToSQL(salaryTable,spo.getID(), MyDate.toString(spo.getStartDate()),
					MyDate.toString(spo.getEndDate()),
					String.valueOf(spo.getMoney()), spo.getCostType().name(),
					spo.getWorker());
		default:
			return ResultMessage.FAIL;
		}
	}
	
	
	public ResultMessage modify(CostPO po) throws RemoteException {
		switch (po.getCostType()) {
		case FREIGHT:
			FreightPO fpo = (FreightPO) po;
			return modifyFromSQL(frieghtTable,fpo.getID(), MyDate.toString(fpo.getStartDate()),
					MyDate.toString(fpo.getEndDate()),
					String.valueOf(fpo.getMoney()), fpo.getCostType().name());
		case RENT:
			RentPO rpo = (RentPO) po;
			return modifyFromSQL(rentTable, rpo.getID(),MyDate.toString(rpo.getStartDate()),
					MyDate.toString(rpo.getEndDate()),
					String.valueOf(rpo.getMoney()), rpo.getCostType().name());
		case SALARY:
			SalaryPO spo = (SalaryPO) po;
			return modifyFromSQL(salaryTable, spo.getID(),MyDate.toString(spo.getStartDate()),
					MyDate.toString(spo.getEndDate()),
					String.valueOf(spo.getMoney()), spo.getCostType().name(),
					spo.getWorker());
		default:
			return ResultMessage.FAIL;
		}
	}

	public ResultMessage del(String ID , CostType type) throws RemoteException {
		switch (type) {
		case FREIGHT:
			return delFromSQL(frieghtTable, ID);
			
		case RENT:
			return delFromSQL(rentTable, ID);
		case SALARY:
			return delFromSQL(salaryTable, ID);
		default:
			return ResultMessage.FAIL;
		}
	}

	@Override
	public ArrayList<BankAccountPO> getAccounts() throws RemoteException{
		ArrayList<BankAccountPO> pos = new ArrayList<>();
		
		sql = "SELECT * FROM " + bankAccountTable;

		
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				pos.add(new BankAccountPO(result.getString(1), result.getString(2), result.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pos.isEmpty()?null:pos;
	}

	@Override
	public ResultMessage modifyAccount(BankAccountPO vo) throws RemoteException{
		return modifyFromSQL(bankAccountTable, vo.getID() , vo.getPassword() , vo.getMoney());
	}

	@Override
	public ResultMessage deleteAccount(String ID) throws RemoteException{
		return delFromSQL(bankAccountTable, ID);
	}

	@Override
	public ResultMessage addAccount(BankAccountPO vo) throws RemoteException{
		return addToSQL(bankAccountTable, vo.getID() , vo.getPassword() , vo.getMoney());
	}

	

}
