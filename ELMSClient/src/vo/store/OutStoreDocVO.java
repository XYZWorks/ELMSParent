package vo.store;

import java.util.ArrayList;

import util.MyDate;
import vo.DocVO;
import vo.order.OrderVO;
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
	public ArrayList<OrderVO> orders;
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
	public OutStoreDocVO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param orderVOs
	 * @param loc
	 * @param time
	 * @param transferDoc
	 * @param shipWay
	 */
	public OutStoreDocVO(String ID,MyDate time, ArrayList<OrderVO> orderVOs, String loc, String transferDoc, String shipWay) {
		//
		super(ID, DocType.outStoreDoc, time, DocState.wait);
		
		
		this.orders = orderVOs;
		this.loc = loc;
		
		this.transferDoc = transferDoc;
		this.shipWay = shipWay;
	}
	
}
