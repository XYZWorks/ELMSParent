package data.transportdata;

import java.rmi.RemoteException;

import po.ArriveYYDocPO;
import po.ArriveZZDocPO;
import po.LoadDocPO;
import po.SendGoodDocPO;
import po.TransferDocPO;
import util.ResultMessage;
import dataSuper.DataSuperClass;
import ds.transportdataservice.Transportdataservice;
 /** 
 * 
 * @author czq 
 * @version 2015年11月5日 下午10:04:10 
 */
public class TransportDataImpl extends DataSuperClass implements Transportdataservice {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TransportDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoadDocPO getLoadDocPO(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addLoadDocPO(LoadDocPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public SendGoodDocPO getSendGoodDocPO(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addSendGoodDocPO(SendGoodDocPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public TransferDocPO getTransferDocPO(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addTransferDocPO(TransferDocPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArriveZZDocPO getArriveZZDocPO(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addArriveZZDocPO(ArriveZZDocPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArriveYYDocPO getArriveYYDocPO(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addArriveYYDocPO(ArriveYYDocPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
