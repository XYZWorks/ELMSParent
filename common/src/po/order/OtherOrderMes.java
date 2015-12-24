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

	public OtherOrderMes(String goodPack, String orderForm,
			MyDate orderStartDate, int orderEestiTime, double orderCost,
			String realReceiver, MyDate orderReceiveDate) {
		super();
		this.goodPack = goodPack;
		this.orderForm = orderForm;
		this.orderStartDate = orderStartDate;
		this.orderEestiTime = orderEestiTime;
		this.orderCost = orderCost;
		this.realReceiver = realReceiver;
		this.orderReceiveDate = orderReceiveDate;
	}

	public String getGoodPack() {
		return goodPack;
	}

	public String getOrderForm() {
		return orderForm;
	}

	public MyDate getOrderStartDate() {
		return orderStartDate;
	}

	public int getOrderEestiTime() {
		return orderEestiTime;
	}

	public double getOrderCost() {
		return orderCost;
	}

	public String getRealReceiver() {
		return realReceiver;
	}

	public MyDate getOrderReceiveDate() {
		return orderReceiveDate;
	}

	
	
	
}
