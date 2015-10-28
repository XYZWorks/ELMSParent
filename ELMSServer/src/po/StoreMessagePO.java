package po;

import java.util.ArrayList;

public class StoreMessagePO {
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
	
}
