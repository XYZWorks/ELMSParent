package po.transport;

import java.io.Serializable;
import java.util.ArrayList;

import po.DocPO;
import util.DocState;
import util.DocType;
import util.GoodsState;
import util.InstType;
import util.InstType;
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
	private String ZZID;
		
	/**
	 * 出发地
	 */
	private  InstType sendFrom;
	/**
	 * 货物到达状态
	 */
	private  GoodsState goodState;
	/**
	 * 订单号集合
	 */
	private ArrayList<String> orderBarCodes;
	
	public ArriveYYDocPO() {}
//	/**
//	 * 
//	 * @param ZZID
//	 * @param arriveDate
//	 * @param TransferDocID
//	 * @param SendCity
//	 * @param GoodState
//	 */
//	public ArriveYYDocPO(String ZZID, MyDate arriveDate, String TransferDocID,
//			City SendCity, GoodsState GoodState,ArrayList<String> orderBarCodes) {
//		super(TransferDocID, DocType.arriveYYDoc, arriveDate, DocState.wait);
//		this.goodState = GoodState;
//		this.sendCity = SendCity;
//		this.ZZID = ZZID;
//		this.orderBarCodes = orderBarCodes;
//	}
	
	
	
	
	public ArriveYYDocPO(String iD, DocType type, MyDate date, DocState state,
			String zZID, InstType sendFrom, GoodsState goodState,ArrayList<String> orderBarCodes) {
		super(iD, type, date, state);
		this.ZZID = zZID;
		this.sendFrom = sendFrom;
		this.goodState = goodState;
		this.orderBarCodes = orderBarCodes;
	}




	public String getZZID() {
		return ZZID;
	}

	public void setZZID(String zZID) {
		this.ZZID = zZID;
	}

	public InstType getInstType() {
		return sendFrom;
	}

	public void setSendCity(InstType sendCity) {
		this.sendFrom = sendCity;
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
