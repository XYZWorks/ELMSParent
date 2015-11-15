package vo;

import java.util.ArrayList;

import util.Date;
import util.DocState;
import util.DocType;

/**
 * 出库单
 * @author ymc
 *
 */
public class OutStoreDocVO extends DocVO{
	/**
	 * 订单
	 */
	public ArrayList<OrderVO> orderVOs;
	/**
	 * 目的地
	 */
	public String loc;
	/**
	 * 时间
	 */
	//继承 edited by czq
//	public String time;
	
	/**
	 * 对应中转单编号
	 */
	public String transferDoc;
	/**
	 * 装运方式
	 */
	public String shipWay;
	/**
	 * 
	 * @param orderVOs
	 * @param loc
	 * @param time
	 * @param transferDoc
	 * @param shipWay
	 */
	public OutStoreDocVO(String ID,Date time, ArrayList<OrderVO> orderVOs, String loc, String transferDoc, String shipWay) {
		//
		super(ID, DocType.outStoreDoc, time, DocState.wait);
		
		
		this.orderVOs = orderVOs;
		this.loc = loc;
		
		this.transferDoc = transferDoc;
		this.shipWay = shipWay;
	}
	
}
