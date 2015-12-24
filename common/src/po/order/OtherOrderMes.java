package po.order;

import util.MyDate;
 /** 
 * 订单其他信息封装类
 * @author czq 
 * @version 2015年11月22日 下午12:14:08 
 */
public class OtherOrderMes {
	/**
	 * 订单的包装形式（木箱、纸箱、快递袋、其他）
	 */
	private String goodPack;

	/**
	 * 订单的快递形式（经济快递、标准快递、特快快递）
	 */
	private String orderForm;
	/**
	 * 起始时间
	 */
	private MyDate orderStartDate;
	/**
	 * 预计订单于几天内送达
	 */
	private int orderEestiTime;

	/**
	 * 订单费用总计
	 */
	private double orderCost;
	
	/**
	 * 订单货物真实的收件人
	 */
	private String realReceiver;

	/**
	 * 订单被接收的真实时间
	 */
	private MyDate orderReceiveDate;

	public String getGoodPack() {
		return goodPack;
	}

	public void setGoodPack(String goodPack) {
		this.goodPack = goodPack;
	}

	public String getOrderForm() {
		return orderForm;
	}

	public void setOrderForm(String orderForm) {
		this.orderForm = orderForm;
	}

	public int getOrderEestiTime() {
		return orderEestiTime;
	}

	public void setOrderEestiTime(int orderEestiTime) {
		this.orderEestiTime = orderEestiTime;
	}

	public double getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(int orderCost) {
		this.orderCost = orderCost;
	}

	public String getRealReceiver() {
		return realReceiver;
	}

	public void setRealReceiver(String realReceiver) {
		this.realReceiver = realReceiver;
	}

	public MyDate getOrderReceiveDate() {
		return orderReceiveDate;
	}

	public void setOrderReceiveDate(MyDate orderReceiveDate) {
		this.orderReceiveDate = orderReceiveDate;
	}

	public OtherOrderMes(String goodPack, String orderForm, int orderEestiTime,
			double total, String realReceiver, MyDate orderStartDate, MyDate orderReceiveDate) {
		super();
		this.goodPack = goodPack;
		this.orderForm = orderForm;
		this.orderEestiTime = orderEestiTime;
		this.orderCost = total;
		this.realReceiver = realReceiver;
		this.orderReceiveDate = orderReceiveDate;
		this.orderStartDate = orderStartDate;
	}
	
	
}
