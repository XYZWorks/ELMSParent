package ds.strategydataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ds.DataserviceParent;
import po.strategy.ConstPO;
import po.strategy.EstiDatePO;
import po.strategy.SalaryWayPO;
import util.ResultMessage;
import util.StaffType;

/**
 * 系统常量及薪水策略数据层接口
 * @author czq
 * @date 2015-10-22
 */
public interface StrategyDataService extends DataserviceParent{
	/**
	 * 获得所有常量
	 * @return
	 */
	public ConstPO getConst() throws RemoteException;
	/**
	 * 设置常量
	 * @param po
	 * @return
	 */
	public ResultMessage setConst(ConstPO po) throws RemoteException;
	/**
	 * 返回所有薪水策略
	 * @return
	 */
	public ArrayList<SalaryWayPO> getSalary() throws RemoteException;
	/**
	 * 设置单项薪水策略
	 * @param po
	 * @return
	 */
	public ResultMessage setSalaryWay(SalaryWayPO po) throws RemoteException;
	/**
	 * 获得某种职员的薪水策略
	 * @param type 职员类型
	 * @return
	 */
	public SalaryWayPO getOneSalary(StaffType type) throws RemoteException;
	/**
	 * 得到预计时间
	 * @return
	 */
	public EstiDatePO getEstiDatePO()  throws RemoteException ;
	/**
	 * 设置预计时间
	 * @return
	 */
	public ResultMessage setEstiDatePO(EstiDatePO po)  throws RemoteException ;
	
//	/**
//	 * 期初建账数据
//	 * @param po 账单PO类
//	 * @return
//	 */
//	public ResultMessage bulidBill(BillPO po) throws RemoteException;
//	/**
//	 * 获得所有的总账单
//	 * @return
//	 */
//	public ArrayList<BillPO> getBills() throws RemoteException;
	
}
