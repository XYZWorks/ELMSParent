package ds.storedataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.InStoreDocPO;
import po.OutStoreDocPO;
import po.StoreCheckPO;
import po.StoreMessagePO;
import util.ResultMessage;
import ds.DataserviceParent;

/**
 * 
 * 库存数据的接口
 * @author ymc
 *
 */
public interface StoreDataService extends DataserviceParent{
	/**
	 * 得到库存信息PO
	 * @return
	 */
	public StoreMessagePO getStoreMessage() throws RemoteException;
	/**
	 * 增加入库单信息
	 * @param po
	 * @return
	 */
	public ResultMessage addIn(InStoreDocPO po) throws RemoteException;
	/**
	 * 增加出库单信息
	 * @param po
	 * @return
	 */
	public ResultMessage addOut(OutStoreDocPO po) throws RemoteException;
	/**
	 * 得到入库单PO
	 * @return
	 */
	public ArrayList<InStoreDocPO> getIn() throws RemoteException;
	/**
	 * 得到出库单PO
	 * @return
	 */
	public ArrayList<OutStoreDocPO> getOut()throws RemoteException;
	/**
	 * 更新库存PO
	 * @param po
	 * @return
	 */
	public ResultMessage update(StoreMessagePO po)throws RemoteException;
	/**
	 * 设置库存警戒值
	 * @return
	 */
	public boolean alarmValue(String value)throws RemoteException;
	/**
	 * 存储快照信息PO
	 * @param po
	 * @return
	 */
	public ResultMessage storeCheck(StoreCheckPO po)throws RemoteException;
	/**
	 * 得到快照PO
	 * @return
	 */
	public ArrayList<StoreCheckPO> getCheck()throws RemoteException;
}
