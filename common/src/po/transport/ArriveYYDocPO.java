package po.transport;

import java.io.Serializable;

import po.DocPO;
import util.DocState;
import util.DocType;
import util.GoodsState;
import util.MyDate;

/**
 * 接收单PO
 * 
 * @author JerryZhang
 *
 */
public class ArriveYYDocPO extends DocPO implements Serializable{

	
	
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
	//继承

	
//	/**
//	 * 中转单编号
//	 */
//	public int TransferDocID;
	
	
	/**
	 * 出发地
	 */
	private  String sendCity;
	/**
	 * 货物到达状态
	 */
	private  GoodsState goodState;
	
	
	public ArriveYYDocPO() {}
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
		this.sendCity = SendCity;
		this.zZID = ZZID;

	}
	
	
	
	
	public ArriveYYDocPO(String iD, DocType type, MyDate date, DocState state,
			String zZID, String sendCity, GoodsState goodState) {
		super(iD, type, date, state);
		this.zZID = zZID;
		this.sendCity = sendCity;
		this.goodState = goodState;
	}




	public String getZZID() {
		return zZID;
	}

	public void setZZID(String zZID) {
		this.zZID = zZID;
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

	
}
