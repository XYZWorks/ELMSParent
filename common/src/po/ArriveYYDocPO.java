package po;

import java.io.Serializable;

import util.MyDate;
import util.DocState;
import util.DocType;
import util.GoodsState;

/**
 * 接收单PO
 * 
 * @author JerryZhang
 *
 */
public class ArriveYYDocPO extends DocPO implements Serializable{

	
	public ArriveYYDocPO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 中转中心编号
	 */
	private String ZZID;
		
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
	private  String SendCity;
	/**
	 * 货物到达状态
	 */
	private  GoodsState goodState;

	/**
	 * 
	 * @param ZZID
	 * @param arriveDate
	 * @param TransferDocID
	 * @param SendCity
	 * @param GoodState
	 */
	public ArriveYYDocPO(String ZZID, MyDate arriveDate, String TransferDocID,
			String SendCity, GoodsState GoodState) {
		super(TransferDocID, DocType.arriveYYDoc, arriveDate, DocState.wait);
		this.goodState = GoodState;
		this.SendCity = SendCity;
		this.ZZID = ZZID;

	}
	
	
	
	
	public ArriveYYDocPO(String iD, DocType type, MyDate date, DocState state,
			String zZID, String sendCity, GoodsState goodState) {
		super(iD, type, date, state);
		ZZID = zZID;
		SendCity = sendCity;
		this.goodState = goodState;
	}




	public String getZZID() {
		return ZZID;
	}

	public void setZZID(String zZID) {
		ZZID = zZID;
	}

	public String getSendCity() {
		return SendCity;
	}

	public void setSendCity(String sendCity) {
		SendCity = sendCity;
	}

	public GoodsState getGoodState() {
		return goodState;
	}

	public void setGoodState(GoodsState goodState) {
		this.goodState = goodState;
	}

	
}
