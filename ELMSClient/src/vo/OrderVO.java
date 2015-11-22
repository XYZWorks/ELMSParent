package vo;

import java.util.ArrayList;

import util.DocState;
import util.DocType;

/**
 * 订单VO类
 * 
 * @author xc
 * @date 2015/10/22
 */

public class OrderVO extends DocVO{
	/**
	 * 生成订单所属的营业厅
	 */
	public String orderYYT;

//
//	/**
//	 * 订单日期
//	 */
//	private Date orderDate;
	//已继承

	/**
	 * 寄件人姓名
	 */
	public String senderName;

	/**
	 * 寄件人手机
	 */
	public String senderPhone;

	/**
	 * 寄件人单位
	 */
	public String senderCompany;

	/**
	 * 收件人地址
	 */
	public String senderAddress;

	/**
	 * 收件人姓名
	 */
	public String receiverName;

	/**
	 * 收件人手机
	 */
	public String receiverPhone;

	/**
	 * 收件人单位
	 */
	public String receiverCompany;

	/**
	 * 收件人地址
	 */
	public String receiverAddress;

	/**
	 * 货物件数
	 */
	public int goodNum;

	/**
	 * 货物名称
	 */
	public String goodName;

	/**
	 * 货物重量
	 */
	public int goodWeight;

	/**
	 * 货物体积
	 */
	public int goodLong;
	public int goodWidth;
	public int goodHeight;

	/**
	 * 订单的包装形式（木箱、纸箱、快递袋、其他）
	 */
	public String goodPack;

	/**
	 * 订单的快递形式（经济快递、标准快递、特快快递）
	 */
	public String orderForm;

	/**
	 * 预计订单于几天内送达
	 */
	public int orderEestiTime;

	/**
	 * 订单费用总计
	 */
	public int orderCost;
	
	//2015.11.1 新增
	/**
	 * 经手的快递员
	 */
     
	/**
	 * 按照时间顺序存储整个订单流转的各种单据
	 */
	public ArrayList<DocVO> docList;

	public OrderVO() {
		// TODO Auto-generated constructor stub
	}
	public OrderVO(String iD, util.MyDate date,
			String orderYYT,  String senderName,
			String senderPhone, String senderCompany, String senderAddress,
			String receiverName, String receiverPhone, String receiverCompany,
			String receiverAddress, int goodNum, String goodName,
			int goodWeight, int goodLong, int goodWidth, int goodHeight,
			String goodPack, String orderForm, int orderEestiTime,
			int orderCost, ArrayList<DocVO> docList) {
		super(iD, DocType.order, date, DocState.wait);
		this.orderYYT = orderYYT;
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
		this.docList = docList;
	}

	public String getOrderYYT() {
		return orderYYT;
	}

	public void setOrderYYT(String orderYYT) {
		this.orderYYT = orderYYT;
	}

	
//	public Date getOrderDate() {
//		return orderDate;
//	}
//
//	public void setOrderDate(Date orderDate) {
//		this.orderDate = orderDate;
//	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderPhone() {
		return senderPhone;
	}

	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}

	public String getSenderCompany() {
		return senderCompany;
	}

	public void setSenderCompany(String senderCompany) {
		this.senderCompany = senderCompany;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getReceiverCompany() {
		return receiverCompany;
	}

	public void setReceiverCompany(String receiverCompany) {
		this.receiverCompany = receiverCompany;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public int getGoodNum() {
		return goodNum;
	}

	public void setGoodNum(int goodNum) {
		this.goodNum = goodNum;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public int getGoodWeight() {
		return goodWeight;
	}

	public void setGoodWeight(int goodWeight) {
		this.goodWeight = goodWeight;
	}

	public int getGoodLong() {
		return goodLong;
	}

	public void setGoodLong(int goodLong) {
		this.goodLong = goodLong;
	}

	public int getGoodWidth() {
		return goodWidth;
	}

	public void setGoodWidth(int goodWidth) {
		this.goodWidth = goodWidth;
	}

	public int getGoodHeight() {
		return goodHeight;
	}

	public void setGoodHeight(int goodHeight) {
		this.goodHeight = goodHeight;
	}

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

	public int getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(int orderCost) {
		this.orderCost = orderCost;
	}

	public ArrayList<DocVO> getDocList() {
		return docList;
	}

	public void setDocList(ArrayList<DocVO> docList) {
		this.docList = docList;
	}

}