package data.strategydata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BillPO;
import po.ConstPO;
import po.SalaryWayPO;
import util.ResultMessage;
import util.StaffType;
import dataSuper.DataSuperClass;
import ds.strategydataservice.StrategyDataService;
 /** 
 * 
 * @author czq 
 * @version 2015年11月5日 下午10:03:11 
 */
public class StrategyDataImpl extends DataSuperClass implements StrategyDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 工资计算方式表 表名
	 */
	private final String salaryTable = "salary";

	public StrategyDataImpl() throws RemoteException {
		super();
	}

	public ConstPO getConst() throws RemoteException {
		return (ConstPO)helper.readFromSerFile("const");
	}

	public ResultMessage setConst(ConstPO po) throws RemoteException {
		if(helper.writeToSerFile(po, "const")){
			return ResultMessage.SUCCESS;
		}else{
			return ResultMessage.FAIL;
		}
	}

	public ArrayList<SalaryWayPO> getSalary() throws RemoteException {
		ArrayList<SalaryWayPO> pos = new ArrayList<SalaryWayPO>();
		sql = "SELECT * from " + salaryTable;
		preState = conn.prepareStatement(sql);
		
		
		
		return null;
	}

	public ResultMessage setSalaryWay(SalaryWayPO po) throws RemoteException {
		
		return null;
	}

	public SalaryWayPO getOneSalary(StaffType type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage bulidBill(BillPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<BillPO> getBills() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
