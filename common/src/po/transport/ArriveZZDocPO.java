package po.transport;

import java.io.Serializable;

import po.DocPO;
import util.City;
import util.DocState;
import util.DocType;
import util.GoodsState;
import util.MyDate;

/**
 * 到达单PO
 * 
 * @author JerryZhang
 *
 */
public class ArriveZZDocPO extends DocPO implements Serializable{
	
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 中转中心编号
	 */
	private String zZID;
//	/**
//	 * 到达日期
//	 */
//	public Date arriveDate;
//	/**
//	 * 中转单编号
//	 */
//	public String TransferDocID;
	//继承
	
	/**
	 * 出发地
	 */
	private City sendCity;
	/**
	 * 货物到达状态
	 */
	private GoodsState goodState;
	
	public ArriveZZDocPO() {}
	
	public String getZZID() {
		return zZID;
	}

	public void setZZID(String zZID) {
		this.zZID = zZID;
	}

	public City getSendCity() {
		return sendCity;
	}

	public void setSendCity(City sendCity) {
		this.sendCity = sendCity;
	}

	public GoodsState getGoodState() {
		return goodState;
	}

	public void setGoodState(GoodsState goodState) {
		this.goodState = goodState;
	}

	public ArriveZZDocPO(String iD, MyDate date,
			String zZID, City sendCity, GoodsState goodState) {
		super(iD, DocType.arriveZZDoc, date, DocState.wait);
		this.zZID = zZID;
		this.sendCity = sendCity;
		this.goodState = goodState;
	}

	public ArriveZZDocPO(String iD, DocType type, MyDate date, DocState state,
			String zZID, City sendCity, GoodsState goodState) {
		super(iD, type, date, state);
		this.zZID = zZID;
		this.sendCity = sendCity;
		this.goodState = goodState;
	}

	
	
	
	
}