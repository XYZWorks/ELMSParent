package vo.transport;

import util.MyDate;
import vo.DocVO;

import java.util.ArrayList;

import util.City;
import util.DocState;
import util.DocType;
import util.GoodsState;

/**
 * 接收单VO类
 * @author JerryZhang
 *
 */
public class ArriveYYDocVO extends DocVO{
	/**
	 * 中转中心编号
	 */
	public String ZZID;
		
//	/**
//	 * 到达日期
//	 */
//	public Date arriveDate;
	//继承

	
//	/**
//	 * 中转单编号
//	 */
//	public int TransferDocID;
	
	
	/**
	 * 出发地
	 */
	public  City sendCity;
	/**
	 * 货物到达状态
	 */
	public  GoodsState goodState;
	/**
	 * 订单号集合
	 */
	public ArrayList<String> orderBarCodes;
	public ArriveYYDocVO() {
		// TODO Auto-generated constructor stub
	}
	public ArriveYYDocVO(String iD, MyDate date,
			String zZID, City sendCity, GoodsState goodState,ArrayList<String> orderBarCodes) {
		super(iD, DocType.arriveYYDoc, date, DocState.wait);
		this.ZZID = zZID;
		this.sendCity = sendCity;
		this.goodState = goodState;
		this.orderBarCodes = orderBarCodes;
	}
	
	
	
}
