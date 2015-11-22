package po;

import java.io.Serializable;

import util.MyDate;
import util.DocState;
import util.DocType;
import util.GoodsState;

/**
 * 到达单PO
 * 
 * @author JerryZhang
 *
 */
public class ArriveZZDocPO extends DocPO implements Serializable{
	public ArriveZZDocPO() {
		// TODO Auto-generated constructor stub
	}
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
	private String sendCity;
	/**
	 * 货物到达状态
	 */
	private GoodsState goodState;
	
	public String getZZID() {
		return zZID;
	}

	public void setZZID(String zZID) {
		zZID = zZID;
	}

	public String getSendCity() {
		return sendCity;
	}

	public void setSendCity(String sendCity) {
		this.sendCity = sendCity;
	}

	public GoodsState getGoodState() {
		return goodState;
	}

	public void setGoodState(GoodsState goodState) {
		this.goodState = goodState;
	}

	public ArriveZZDocPO(String iD, MyDate date,
			String zZID, String sendCity, GoodsState goodState) {
		super(iD, DocType.arriveZZDoc, date, DocState.wait);
		this.zZID = zZID;
		this.sendCity = sendCity;
		this.goodState = goodState;
	}

	public ArriveZZDocPO(String iD, DocType type, MyDate date, DocState state,
			String zZID, String sendCity, GoodsState goodState) {
		super(iD, type, date, state);
		zZID = zZID;
		this.sendCity = sendCity;
		this.goodState = goodState;
	}

	
	
	
	
}