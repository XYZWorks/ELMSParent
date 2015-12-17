package ds.storedataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.store.InStoreDocPO;
import po.store.OutStoreDocPO;
import po.store.StoreCheckPO;
import po.store.StoreMessagePO;
import util.City;
import util.ResultMessage;
import ds.DocApprovalDataService;

/**
 * 
 * 库存数据的接口
 * @author ymc
 *
 */
public interface StoreDataService extends DocApprovalDataService{
	/**
	 * 得到库存信息PO,返回4個城市共12個區的StoreMessagePO
	 * @return
	 */
	public ArrayList<StoreMessagePO> getStoreMessages() throws RemoteException;
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
	 * 获得某个城市的库存警戒值
	 */
	public String getAlarmValue(City city) throws RemoteException;
	/**
	 * 设置某个城市的库存警戒值
	 * @return
	 */
	public ResultMessage setAlarmValue(String value , City city)throws RemoteException;
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
	/**
	 * 获得单个入库单
	 * @param ID
	 * @return
	 * @throws RemoteException
	 */
	public InStoreDocPO getOneInstoreDoc(String ID) throws RemoteException;
	/**
	 * 获得单个出库单
	 * @param ID
	 * @return
	 * @throws RemoteException
	 */
	public OutStoreDocPO getOneOutStoreDoc(String ID) throws RemoteException;
	
}
