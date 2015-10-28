package po;

import java.io.Serializable;
import java.util.ArrayList;

import util.Date;
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
	private ArrayList<OrderPO> orderPOs;
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

	public InStoreDocPO(String iD, Date date, ArrayList<OrderPO> orderPOs,
			String loc, ArrayList<String> location) {

		super(iD, DocType.inStoreDoc, date, DocState.wait);
		this.orderPOs = orderPOs;
		this.loc = loc;
		this.location = location;
	}

	public ArrayList<OrderPO> getOrderPOs() {
		return orderPOs;
	}

	public void setOrderPOs(ArrayList<OrderPO> orderPOs) {
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
