package po;

import java.io.Serializable;
import java.util.Date;

import util.DocState;
import util.DocType;

/**
 * 中转单PO
 * 
 * @author JerryZhang
 *
 */
public class TransferDocPO extends DocPO implements Serializable{
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;
	
//	/**
//	 * 中转单ID
//	 */
//	private  int TransferDocID;
	/**
	 * 航班号/车次/车牌号
	 */
	private  String TransferWayID;
	/**
	 * 出发地
	 */
	private  String SendCity;
	/**
	 * 货柜号
	 */
	private  int containerNum;
	/**
	 * 监装员
	 */
	private  String LoadManName;
	/**
	 * 所有托运单号
	 */
	private  String[] orderBarCode;



	public TransferDocPO(String iD, util.Date date,
			 String transferWayID,
			String sendCity, int containerNum, String loadManName,
			String[] orderBarCode) {
		super(iD,DocType.transferDoc, date, DocState.wait);
		TransferWayID = transferWayID;
		SendCity = sendCity;
		this.containerNum = containerNum;
		LoadManName = loadManName;
		this.orderBarCode = orderBarCode;
	}

	

//	public int getTransferDocID() {
//		return TransferDocID;
//	}
//
//	public void setTransferDocID(int transferDocID) {
//		TransferDocID = transferDocID;
//	}

	public String getTransferWayID() {
		return TransferWayID;
	}

	public void setTransferWayID(String transferWayID) {
		TransferWayID = transferWayID;
	}

	public String getSendCity() {
		return SendCity;
	}

	public void setSendCity(String sendCity) {
		SendCity = sendCity;
	}

	public int getContainerNum() {
		return containerNum;
	}

	public void setContainerNum(int containerNum) {
		this.containerNum = containerNum;
	}

	public String getLoadManName() {
		return LoadManName;
	}

	public void setLoadManName(String loadManName) {
		LoadManName = loadManName;
	}

	public String[] getOrderBarCode() {
		return orderBarCode;
	}

	public void setOrderBarCode(String[] orderBarCode) {
		this.orderBarCode = orderBarCode;
	}

}
