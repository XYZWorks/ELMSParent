package po.transport;

import java.io.Serializable;
import java.util.ArrayList;

import po.DocPO;
import util.City;
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
	private  City sendCity;
	/**
	 * 货物到达状态
	 */
	private  GoodsState goodState;
	/**
	 * 订单号集合
	 */
	private ArrayList<String> orderBarCodes;
	
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
			City SendCity, GoodsState GoodState,ArrayList<String> orderBarCodes) {
		super(TransferDocID, DocType.arriveYYDoc, arriveDate, DocState.wait);
		this.goodState = GoodState;
		this.sendCity = SendCity;
		this.zZID = ZZID;
		this.orderBarCodes = orderBarCodes;
	}
	
	
	
	
	public ArriveYYDocPO(String iD, DocType type, MyDate date, DocState state,
			String zZID, City sendCity, GoodsState goodState,ArrayList<String> orderBarCodes) {
		super(iD, type, date, state);
		this.zZID = zZID;
		this.sendCity = sendCity;
		this.goodState = goodState;
		this.orderBarCodes = orderBarCodes;
	}




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
	public ArrayList<String> getOrderBarCodes() {
		return orderBarCodes;
	}
	public void setOrderBarCodes(ArrayList<String> orderBarCodes) {
		this.orderBarCodes = orderBarCodes;
	}

	
}
