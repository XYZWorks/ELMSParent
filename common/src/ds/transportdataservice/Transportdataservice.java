package ds.transportdataservice;

import java.rmi.RemoteException;

import po.ArriveYYDocPO;
import po.ArriveZZDocPO;
import po.LoadDocPO;
import po.SendGoodDocPO;
import po.TransferDocPO;
import util.ResultMessage;
import ds.DataserviceParent;

/**
 * 流转数据层接口
 * @author JerryZhang
 *
 */
public interface Transportdataservice  extends DataserviceParent{
	/**
	 * 获得一个装车单PO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public LoadDocPO getLoadDocPO(String id) throws RemoteException;
	/**
	 * 增加一个装车单PO
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addLoadDocPO(LoadDocPO po) throws RemoteException;
	
	/**
	 * 获得一个派送单PO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public SendGoodDocPO getSendGoodDocPO(String id) throws RemoteException;
	/**
	 * 增加一个派送单PO
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addSendGoodDocPO(SendGoodDocPO po) throws RemoteException;
	
	/**
	 * 获得一个中转单PO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public TransferDocPO getTransferDocPO(String id) throws RemoteException;
	/**
	 * 增加一个中转单PO
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addTransferDocPO(TransferDocPO po) throws RemoteException;
	
	/**
	 * 获得一个到达单PO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public ArriveZZDocPO getArriveZZDocPO(String id) throws RemoteException;
	/**
	 * 增加一个到达单PO
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addArriveZZDocPO(ArriveZZDocPO po) throws RemoteException;
	
	/**
	 * 获得一个接收单PO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public ArriveYYDocPO getArriveYYDocPO(String id) throws RemoteException;
	/**
	 * 增加一个接收单PO
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addArriveYYDocPO(ArriveYYDocPO po) throws RemoteException;
	
}
