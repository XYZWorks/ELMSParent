package po.store;

import java.io.Serializable;
import java.util.ArrayList;

import util.City;
import util.TransferWay;
/**
 * 库存信息
 * @author ymc
 *
 */
public class StoreMessagePO implements Serializable{
	
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 所在城市
	 */
	private City location;
	/**
	 * 区位置
	 */
	private TransferWay storeLoc;
	/**
	 * 库存数量
	 */
	private int number;
	/**
	 * 入库单集合
	 */
	private ArrayList<InStoreDocPO> inStoreDocs;
	/**
	 * 出库单集合
	 */
	private ArrayList<OutStoreDocPO> outStoreDocs;
	
	public StoreMessagePO() {}
	
	
	public StoreMessagePO(City location, TransferWay storeLoc, int number,
			ArrayList<InStoreDocPO> inStoreDocs,
			ArrayList<OutStoreDocPO> outStoreDocs) {
		super();
		this.location = location;
		this.storeLoc = storeLoc;
		this.number = number;
		this.inStoreDocs = inStoreDocs;
		this.outStoreDocs = outStoreDocs;
	}


	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public ArrayList<InStoreDocPO> getInStoreDocs() {
		return inStoreDocs;
	}
	public void setInStoreDocs(ArrayList<InStoreDocPO> inStoreDocs) {
		this.inStoreDocs = inStoreDocs;
	}
	public ArrayList<OutStoreDocPO> getOutStoreDocs() {
		return outStoreDocs;
	}
	public void setOutStoreDocs(ArrayList<OutStoreDocPO> outStoreDocs) {
		this.outStoreDocs = outStoreDocs;
	}

	public TransferWay getStoreLoc() {
		return storeLoc;
	}
	public void setStoreLoc(TransferWay storeLoc) {
		this.storeLoc = storeLoc;
	}
	public City getLocation() {
		return location;
	}
	public void setLocation(City location) {
		this.location = location;
	}
	
}
