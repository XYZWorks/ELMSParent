package po;

import java.io.Serializable;
import util.MyDate;

import util.DocState;
import util.DocType;

/**
 * 订单PO类
 * 
 * @author xc
 * @date 2015/10/22
 */

public class OrderPO extends DocPO implements Serializable{
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 订单条形码
	 */
	private String orderBarCode;

	/**
	 * 订单日期
	 */
	// Date orderDate;
	// 已继承

	/**
	 * 寄件人姓名
	 */
	private String senderName;

	/**
	 * 寄件人手机
	 */
	private String senderPhone;

	/**
	 * 寄件人单位
	 */
	private String senderCompany;

	/**
	 * 收件人地址
	 */
	private String senderAddress;

	/**
	 * 收件人姓名
	 */
	private String receiverName;

	/**
	 * 收件人手机
	 */
	private String receiverPhone;

	/**
	 * 收件人单位
	 */
	private String receiverCompany;

	/**
	 * 收件人地址
	 */
	private String receiverAddress;

	/**
	 * 货物件数
	 */
	private int goodNum;

	/**
	 * 货物名称
	 */
	private String goodName;

	/**
	 * 货物重量
	 */
	private int goodWeight;

	/**
	 * 货物体积
	 */
	private int goodLong;
	private int goodWidth;
	private int goodHeight;

	/**
	 * 订单的包装形式（木箱、纸箱、快递袋、其他）
	 */
	private String goodPack;

	/**
	 * 订单的快递形式（经济快递、标准快递、特快快递）
	 */
	private String orderForm;

	/**
	 * 预计订单于几天内送达
	 */
	private int orderEestiTime;

	/**
	 * 订单费用总计
	 */
	private int orderCost;

	/**
	 * 装车单
	 */
	private String loadDoc;

	/**
	 * 中转中心到达单
	 */
	private String arriveZZDoc;

	/**
	 * 中转单
	 */
	private String transferDoc;

	/**
	 * 接收单（到达营业厅）
	 */
	private String arriveYYDoc;

	/**
	 * 派送单
	 */
	private String sendGoodDoc;

	/**
	 * 订单货物真实的收件人
	 */
	private String realReceiver;

	/**
	 * 订单被接收的真实时间
	 */
	private MyDate orderReceiveDate;

	public OrderPO(String orderBarCode, util.MyDate date,  String senderName,
			String senderPhone, String senderCompany, String senderAddress,
			String receiverName, String receiverPhone, String receiverCompany,
			String receiverAddress, int goodNum, String goodName,
			int goodWeight, int goodLong, int goodWidth, int goodHeight,
			String goodPack, String orderForm, int orderEestiTime,
			int orderCost, String loadDoc, String arriveZZDoc,
			String transferDoc, String arriveYYDoc, String sendGoodDoc,
			String realReceiver, util.MyDate orderReceiveDate) {

		// 将条形码号付给订单的父类ID edit by czq
		super(orderBarCode, DocType.order, date, DocState.wait);
		this.orderBarCode = orderBarCode;
		this.senderName = senderName;
		this.senderPhone = senderPhone;
		this.senderCompany = senderCompany;
		this.senderAddress = senderAddress;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.receiverCompany = receiverCompany;
		this.receiverAddress = receiverAddress;
		this.goodNum = goodNum;
		this.goodName = goodName;
		this.goodWeight = goodWeight;
		this.goodLong = goodLong;
		this.goodWidth = goodWidth;
		this.goodHeight = goodHeight;
		this.goodPack = goodPack;
		this.orderForm = orderForm;
		this.orderEestiTime = orderEestiTime;
		this.orderCost = orderCost;
		this.loadDoc = loadDoc;
		this.arriveZZDoc = arriveZZDoc;
		this.transferDoc = transferDoc;
		this.arriveYYDoc = arriveYYDoc;
		this.sendGoodDoc = sendGoodDoc;
		this.realReceiver = realReceiver;
		this.orderReceiveDate = orderReceiveDate;
	}

	public String getOrderBarCode() {
		return orderBarCode;
	}

	public String getSenderName() {
		return senderName;
	}

	public String getSenderPhone() {
		return senderPhone;
	}

	public String getSenderCompany() {
		return senderCompany;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public String getReceiverCompany() {
		return receiverCompany;
	}

	// public String getReceiverAddress() {
	// return receiverAddress;
	// }

	public int getGoodNum() {
		return goodNum;
	}

	public String getGoodName() {
		return goodName;
	}

	public int getGoodWeight() {
		return goodWeight;
	}

	public int getGoodLong() {
		return goodLong;
	}

	public int getGoodWidth() {
		return goodWidth;
	}

	public int getGoodHeight() {
		return goodHeight;
	}

	public String getGoodPack() {
		return goodPack;
	}

	public String getOrderForm() {
		return orderForm;
	}

	public int getOrderEestiTime() {
		return orderEestiTime;
	}

	public int getOrderCost() {
		return orderCost;
	}

	public String getLoadDoc() {
		return loadDoc;
	}

	public String getArriveZZDoc() {
		return arriveZZDoc;
	}

	public String getTransferDoc() {
		return transferDoc;
	}

	public String getArriveYYDoc() {
		return arriveYYDoc;
	}

	public String getSendGoodDoc() {
		return sendGoodDoc;
	}

	public void setLoadDoc(String loadDoc) {
		this.loadDoc = loadDoc;
	}

	public void setArriveZZDoc(String arriveZZDoc) {
		this.arriveZZDoc = arriveZZDoc;
	}

	public void setTransferDoc(String transferDoc) {
		this.transferDoc = transferDoc;
	}

	public void setArriveYYDoc(String arriveYYDoc) {
		this.arriveYYDoc = arriveYYDoc;
	}

	public void setSendGoodDoc(String sendGoodDoc) {
		this.sendGoodDoc = sendGoodDoc;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
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

	public void setOrderBarCode(String orderBarCode) {
		this.orderBarCode = orderBarCode;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}

	public void setSenderCompany(String senderCompany) {
		this.senderCompany = senderCompany;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public void setReceiverCompany(String receiverCompany) {
		this.receiverCompany = receiverCompany;
	}

	public void setGoodNum(int goodNum) {
		this.goodNum = goodNum;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public void setGoodWeight(int goodWeight) {
		this.goodWeight = goodWeight;
	}

	public void setGoodLong(int goodLong) {
		this.goodLong = goodLong;
	}

	public void setGoodWidth(int goodWidth) {
		this.goodWidth = goodWidth;
	}

	public void setGoodHeight(int goodHeight) {
		this.goodHeight = goodHeight;
	}

	public void setGoodPack(String goodPack) {
		this.goodPack = goodPack;
	}

	public void setOrderForm(String orderForm) {
		this.orderForm = orderForm;
	}

	public void setOrderEestiTime(int orderEestiTime) {
		this.orderEestiTime = orderEestiTime;
	}

	public void setOrderCost(int orderCost) {
		this.orderCost = orderCost;
	}

}
