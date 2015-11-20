package data.strategydata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import po.BillPO;
import po.ConstPO;
import po.SalaryWayPO;
import util.ResultMessage;
import util.StaffType;
import util.WageStrategy;
import dataSuper.DataSuperClass;
import ds.strategydataservice.StrategyDataService;
 /** 
 * 
 * @author czq 
 * @version 2015年11月5日 下午10:03:11 
 */
public class StrategyDataImpl extends DataSuperClass implements StrategyDataService{

	private static final long serialVersionUID = 1L;
	/**
	 * 工资计算方式表 表名
	 */
	private final String salaryTable = "salary";

	public StrategyDataImpl() throws RemoteException {}
	
	//const 暂时用序列化实现
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
		
		try {
			sql = "SELECT * from " + salaryTable;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	public ResultMessage setSalaryWay(SalaryWayPO po) throws RemoteException {
		
		return modifyFromSQL(salaryTable, po.getType().getName() , String.valueOf(po.getBasicSalary()) , String.valueOf(po.getMoreMoney()) , po.getWay().name());
	}

	public SalaryWayPO getOneSalary(StaffType type) throws RemoteException {
		findMes = findFromSQL(salaryTable, type.getName());
		if(findMes == null){
			return null;
		}else{
			return new SalaryWayPO(type, Integer.parseInt(findMes.get(1)), Integer.parseInt(findMes.get(2)), WageStrategy.valueOf(findMes.get(3)));
		}
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
