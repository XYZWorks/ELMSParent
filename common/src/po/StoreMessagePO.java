package po;

import java.io.Serializable;
import java.util.ArrayList;
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
	private String location;
	/**
	 * 区位置
	 */
	private String storeLoc;
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
	private ArrayList<OutStoreDocPO> OutStoreDocs;
	
	public StoreMessagePO() {}
	
	/**
	 * 
	 * @param inStoreDocs
	 * @param outStoreDocs
	 */
	public StoreMessagePO(ArrayList<InStoreDocPO> inStoreDocs, ArrayList<OutStoreDocPO> outStoreDocs) {
		super();
		this.inStoreDocs = inStoreDocs;
		this.OutStoreDocs = outStoreDocs;
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
		return OutStoreDocs;
	}
	public void setOutStoreDocs(ArrayList<OutStoreDocPO> outStoreDocs) {
		OutStoreDocs = outStoreDocs;
	}

	public String getStoreLoc() {
		return storeLoc;
	}
	public void setStoreLoc(String storeLoc) {
		this.storeLoc = storeLoc;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
