package data.strategydata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BillPO;
import po.ConstPO;
import po.SalaryWayPO;
import util.ResultMessage;
import util.StaffType;
import ds.strategydataservice.StrategyDataService;
 /** 
 * 
 * @author czq 
 * @version 2015年11月5日 下午10:03:11 
 */
public class StrategyDataImpl  implements StrategyDataService{

	public ConstPO getConst() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage setConst(ConstPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<SalaryWayPO> getSalary() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage setSalaryWay(SalaryWayPO po) throws RemoteException {
		// TODO Auto-generated method stub
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
