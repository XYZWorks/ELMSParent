package ds.orderdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.DocPO;
import po.order.OrderPO;
import po.order.ReceivePO;
import util.MyDate;
import util.ResultMessage;
import ds.DataserviceParent;

public interface OrderDataService extends DataserviceParent{
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
	 * 增加订单号列表                 ---- edit by czq
	 * @param po
	 * @param orderBarCodes 要修改的订单号列表
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addDocToList(DocPO po ,ArrayList<String> orderBarCodes) throws RemoteException;

	/**
	 * 获取单个订单的所有信息
	 * 
	 * @param orderBarCode
	 * @return
	 */
	public OrderPO getSingleOrderPO(String orderBarCode) throws RemoteException;

	/**
	 * 获取单个订单的流转情况
	 * 将DocPO改为String       ---edit by czq 
	 * @param orderBarCode
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<String> getSingleOrderDocs(String orderBarCode)
			throws RemoteException;

	/**
	 * 更新订单的收件信息状态
	 * 增加参数订单号                       ---edit by czq
	 * @param PO
	 * @return  notExist:表示修改的订单不存在  Fail:失败
	 * @throws RemoteException
	 */
	public ResultMessage receiveInfo(ReceivePO PO , String orderBarCode) throws RemoteException;

}
