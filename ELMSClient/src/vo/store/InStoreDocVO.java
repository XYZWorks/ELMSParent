package vo.store;

import java.util.ArrayList;

import util.MyDate;
import vo.DocVO;
import vo.order.OrderVO;
import util.City;
import util.DocState;
import util.DocType;

/**
 * 入库单
 * @author ymc
 *
 */
public class InStoreDocVO extends DocVO {
	

	/**
	 * 订单
	 */
	public ArrayList<String> orders;
	/**
	 * 目的地
	 */
	public City loc;
	
	/**
	 * 位置信息
	 */
	public ArrayList<String> location;
	
	
	public InStoreDocVO() {
		// TODO Auto-generated constructor stub
	}
	public InStoreDocVO(String iD,  MyDate date,
			ArrayList<String> orderVOs, City loc, ArrayList<String> location) {
		
		//初始建单状态
		super(iD,DocType.inStoreDoc, date, DocState.wait);
		this.orders = orderVOs;
		this.loc = loc;
		this.location = location;
	}

	
	
	
	
}
