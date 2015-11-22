package po;

import java.io.Serializable;
import java.util.ArrayList;

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
	private ArrayList<String> orderPOs;
	/**
	 * 目的地
	 */
	private String loc;
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

	public InStoreDocPO(String iD, MyDate date, ArrayList<String> orderPOs,
			String loc, ArrayList<String> location) {

		super(iD, DocType.inStoreDoc, date, DocState.wait);
		this.orderPOs = orderPOs;
		this.loc = loc;
		this.location = location;
	}
	
	
	
	
	public InStoreDocPO(String iD, DocType type, MyDate date, DocState state,
			ArrayList<String> orderPOs, String loc, ArrayList<String> location) {
		super(iD, type, date, state);
		this.orderPOs = orderPOs;
		this.loc = loc;
		this.location = location;
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

	public ArrayList<String> getLocation() {
		return location;
	}

	public void setLocation(ArrayList<String> location) {
		this.location = location;
	}
}
