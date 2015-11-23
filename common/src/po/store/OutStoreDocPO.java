package po.store;

import java.io.Serializable;
import java.util.ArrayList;

import po.DocPO;
import util.City;
import util.DocState;
import util.DocType;
import util.MyDate;
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
	private ArrayList<String> orders;
	/**
	 * 目的地
	 */
	private City loc;
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
	
	
	
	
	
	public OutStoreDocPO(String iD, DocType type, MyDate date, DocState state,
			ArrayList<String> orderPOs, City loc, String transferDoc,
			String shipWay) {
		super(iD, type, date, state);
		this.orders = orderPOs;
		this.loc = loc;
		this.transferDoc = transferDoc;
		this.shipWay = shipWay;
	}

	public ArrayList<String> getOrderPOs() {
		return orders;
	}
	public void setOrderPOs(ArrayList<String> orderPOs) {
		this.orders = orderPOs;
	}
	public City getLoc() {
		return loc;
	}
	public void setLoc(City loc) {
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
