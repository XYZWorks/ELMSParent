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
	private String ZZID;
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
	private String SendCity;
	/**
	 * 货物到达状态
	 */
	private GoodsState goodState;
	
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

	public ArriveZZDocPO(String iD, MyDate date,
			String zZID, String sendCity, GoodsState goodState) {
		super(iD, DocType.arriveZZDoc, date, DocState.wait);
		ZZID = zZID;
		SendCity = sendCity;
		this.goodState = goodState;
	}

	
	
	
	
}