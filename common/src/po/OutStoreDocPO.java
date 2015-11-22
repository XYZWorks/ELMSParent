package po;

import java.io.Serializable;
import java.util.ArrayList;

import util.MyDate;
import util.DocState;
import util.DocType;
/**
 * 出库单
 * @author ymc
 *
 */
public class OutStoreDocPO extends DocPO implements Serializable{
	
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 订单
	 */
	private ArrayList<String> orderPOs;
	/**
	 * 目的地
	 */
	private String loc;
//	/**
//	 * 时间
//	 */
//	private String time;
	//继承
	/**
	 * 对应中转单编号
	 */
	private String transferDoc;
	/**
	 * 装运方式
	 */
	private String shipWay;
	
	
	
	public OutStoreDocPO() {}
	
	public OutStoreDocPO(String iD, MyDate date,
			ArrayList<String> orderPOs, String loc, String transferDoc,
			String shipWay) {
		super(iD, DocType.outStoreDoc, date,DocState.wait);
		this.orderPOs = orderPOs;
		this.loc = loc;
		this.transferDoc = transferDoc;
		this.shipWay = shipWay;
	}
	
	
	
	
	public OutStoreDocPO(String iD, DocType type, MyDate date, DocState state,
			ArrayList<String> orderPOs, String loc, String transferDoc,
			String shipWay) {
		super(iD, type, date, state);
		this.orderPOs = orderPOs;
		this.loc = loc;
		this.transferDoc = transferDoc;
		this.shipWay = shipWay;
	}

	public ArrayList<String> getOrderPOs() {
		return orderPOs;
	}
	public void setOrderPOs(ArrayList<String> orderPOs) {
		this.orderPOs = orderPOs;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getTransferDoc() {
		return transferDoc;
	}
	public void setTransferDoc(String transferDoc) {
		this.transferDoc = transferDoc;
	}
	public String getShipWay() {
		return shipWay;
	}
	public void setShipWay(String shipWay) {
		this.shipWay = shipWay;
	}
}
