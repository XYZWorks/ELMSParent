package po.order;

import java.io.Serializable;

import po.DocPO;
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
	 * 寄件人信息
	 */
	private PeopleMes sender;

	/**
	 * 收件人信息
	 */
	private PeopleMes receiver;
	/**
	 * 货物信息
	 */
	private GoodMes goodMes;
	/**
	 * 订单其余信息，包括包装、快递形式、预计送达时间、费用、真实收件人信息、真实收件时间
	 */
	private OtherOrderMes otherMes;
	/**
	 * 单据运输的过程的各种单据的ID
	 */
	private TransferDocs transferDocs;

	
	
	public OrderPO() {}



	public OrderPO(String iD, DocType type, MyDate date, DocState state,
			PeopleMes sender, PeopleMes receiver, GoodMes goodMes,
			OtherOrderMes otherMes, TransferDocs transferDocs) {
		super(iD, type, date, state);
		this.sender = sender;
		this.receiver = receiver;
		this.goodMes = goodMes;
		this.otherMes = otherMes;
		this.transferDocs = transferDocs;
	}



	public PeopleMes getSender() {
		return sender;
	}



	public PeopleMes getReceiver() {
		return receiver;
	}



	public GoodMes getGoodMes() {
		return goodMes;
	}



	public OtherOrderMes getOtherMes() {
		return otherMes;
	}



	public TransferDocs getTransferDocs() {
		return transferDocs;
	}


	//只有两个set方法
	public void setOtherMes(OtherOrderMes otherMes) {
		this.otherMes = otherMes;
	}



	public void setTransferDocs(TransferDocs transferDocs) {
		this.transferDocs = transferDocs;
	}

	

}
