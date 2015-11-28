package vo.transport;

import java.util.ArrayList;

import util.City;
import util.DocState;
import util.DocType;
import util.GoodsState;
import util.MyDate;
import vo.DocVO;

/**
 * 到达单VO类
 * 
 * @author JerryZhang
 *
 */
public class ArriveZZDocVO extends DocVO {
	/**
	 * 中转中心编号
	 */
	public String zZID;
	// /**
	// * 到达日期
	// */
	// public Date arriveDate;
	// /**
	// * 中转单编号
	// */
	// public int TransferDocID;
	/**
	 * 出发地
	 */
	public City sendCity;
	/**
	 * 货物到达状态
	 */
	public GoodsState goodState;
	/**
	 * 订单号集合
	 */
	public ArrayList<String> orderBarCodes;
	
	public ArriveZZDocVO() {
		// TODO Auto-generated constructor stub
	}
	public ArriveZZDocVO(String iD, MyDate date, String zZID, City sendCity,
			GoodsState goodState,ArrayList<String> orderBarCodes) {
		super(iD, DocType.arriveZZDoc, date, DocState.wait);
		this.zZID = zZID;
		this.sendCity = sendCity;
		this.goodState = goodState;
		this.orderBarCodes = orderBarCodes;
	}

}
