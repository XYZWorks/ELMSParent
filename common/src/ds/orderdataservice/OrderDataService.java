package ds.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.DocPO;
import po.OrderPO;
import po.ReceivePO;
import util.MyDate;
import util.ResultMessage;

public interface OrderDataService extends Remote{
	/**
	 * 得到某日新增的所有订单
	 * 
	 * @param date
	 * @return ArrayList<orderPO>
	 */
	public ArrayList<OrderPO> getDayOrderPO(MyDate date) throws RemoteException;

	/**
	 * 增加订单
	 * 
	 * @param po
	 * @return
	 */
	public ResultMessage add(OrderPO po) throws RemoteException;

	/**
	 * 删除订单
	 * 
	 * @param orderBarCode
	 * @return
	 */
	public ResultMessage del(String orderBarCode) throws RemoteException;

	/**
	 * 将流转单中的所有订单的物流状态均更新
	 * 
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addDocToList(DocPO po) throws RemoteException;

	/**
	 * 获取单个订单的所有信息
	 * 
	 * @param orderBarCode
	 * @return
	 */
	public OrderPO getSingleOrderPO(String orderBarCode) throws RemoteException;

	/**
	 * 获取单个订单的流转情况
	 * 
	 * @param orderBarCode
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<DocPO> getSingleOrderDocs(String orderBarCode)
			throws RemoteException;

	/**
	 * 更新订单的收件信息状态
	 * 
	 * @param PO
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage receiveInfo(ReceivePO PO) throws RemoteException;

}
