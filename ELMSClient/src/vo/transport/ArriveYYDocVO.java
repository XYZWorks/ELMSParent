package vo.transport;

import util.MyDate;
import vo.DocVO;

import java.util.ArrayList;

import javax.print.Doc;

import util.City;
import util.DocState;
import util.DocType;
import util.GoodsState;
import util.InstType;

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
	public  InstType sendFrom;
	/**
	 * 货物到达状态
	 */
	public  GoodsState goodState;
	/**
	 * 订单号集合
	 */
	public ArrayList<String> orderBarCodes;
	public ArriveYYDocVO() {
	}
	public ArriveYYDocVO(String iD, DocType type, MyDate date, DocState state, String zZID, InstType sendFrom,
			GoodsState goodState, ArrayList<String> orderBarCodes) {
		super(iD, type, date, state);
		ZZID = zZID;
		this.sendFrom = sendFrom;
		this.goodState = goodState;
		this.orderBarCodes = orderBarCodes;
	}
	public ArriveYYDocVO(String iD, MyDate myDate, String zZID, InstType sendFrom, GoodsState goodState,
			ArrayList<String> orderBarCodes) {
		super(iD, DocType.arriveYYDoc, myDate, DocState.wait);
		ZZID = zZID;
		this.sendFrom = sendFrom;
		this.goodState = goodState;
		this.orderBarCodes = orderBarCodes;
	}
	
	
	
}
