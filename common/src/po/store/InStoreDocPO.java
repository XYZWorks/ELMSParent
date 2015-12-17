package po.store;

import java.io.Serializable;
import java.util.ArrayList;

import po.DocPO;
import util.City;
import util.MyDate;
import util.DocState;
import util.DocType;

/**
 * 入库单
 * 
 * @author ymc
 *
 */
public class InStoreDocPO extends DocPO implements Serializable{
	
	
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
	// /**
	// * 时间
	// */
	// 继承
	// private String time;
	/**
	 * 位置信息
	 */
	private ArrayList<String> location;
	
	public InStoreDocPO() {}

//	public InStoreDocPO(String iD, MyDate date, ArrayList<String> orderPOs,
//			City loc, ArrayList<String> location) {
//
//		super(iD, DocType.inStoreDoc, date, DocState.wait);
//		this.orders = orderPOs;
//		this.loc = loc;
//		this.location = location;
//	}
	
	
	
	
	public InStoreDocPO(String iD, DocType type, MyDate date, DocState state,
			ArrayList<String> orderPOs, City loc, ArrayList<String> location) {
		super(iD, type, date, state);
		this.orders = orderPOs;
		this.loc = loc;
		this.location = location;
	}




	public ArrayList<String> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<String> orderPOs) {
		this.orders = orderPOs;
	}

	public City getLoc() {
		return loc;
	}

	public void setLoc(City loc) {
		this.loc = loc;
	}

	public ArrayList<String> getLocation() {
		return location;
	}

	public void setLocation(ArrayList<String> location) {
		this.location = location;
	}
}
