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
