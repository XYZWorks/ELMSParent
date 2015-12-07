package vo.order;

import po.order.GoodMes;
import po.order.OtherOrderMes;
import po.order.PeopleMes;
import po.order.TransferDocs;
import util.DocState;
import util.DocType;
import util.MyDate;
import vo.DocVO;

/**
 * 订单VO类
 * 
 * @author xc
 * @date 2015/10/22
 */

public class OrderVO extends DocVO{


	/**
	 * 寄件人信息
	 */
	public PeopleMes sender;

	/**
	 * 收件人信息
	 */
	public PeopleMes receiver;
	/**
	 * 货物信息
	 */
	public GoodMes goodMes;
	/**
	 * 订单其余信息，包括包装、快递形式、预计送达时间、费用、真实收件人信息、真实收件时间
	 */
	public OtherOrderMes otherMes;
	/**
	 * 单据运输的过程的各种单据的ID
	 */
	public TransferDocs transferDocs;

	
	
	public OrderVO() {}



	public OrderVO(String iD, DocType type, MyDate date, DocState state,
			PeopleMes sender, PeopleMes receiver, GoodMes goodMes,
			OtherOrderMes otherMes, TransferDocs transferDocs) {
		super(iD, type, date, state);
		this.sender = sender;
		this.receiver = receiver;
		this.goodMes = goodMes;
		this.otherMes = otherMes;
		this.transferDocs = transferDocs;
	}


}