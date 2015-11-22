package vo;

import java.util.Date;

import util.DocState;
import util.DocType;

/**
 * 中转单VO类
 * @author JerryZhang
 *
 */
public class TransferDocVO extends DocVO{
	
//	/**
//	 * 中转单ID
//	 */
//	public int TransferDocID;
	//继承
	/**
	 * 航班号/车次/车牌号
	 */
	public String transferWayID;
	/**
	 * 出发地
	 */
	public String sendCity;
	/**
	 * 货柜号
	 * 
	 */
	public int containerNum;
	/**
	 * 监装员
	 */
	public String loadManName;
	/**
	 *所有托运单号
	 */
	public String[] orderBarCode;
	
	
	public TransferDocVO(String iD, util.MyDate date,
			String transferWayID,
			String sendCity, int containerNum, String loadManName,
			String[] orderBarCode) {
		super(iD, DocType.transferDoc, date, DocState.wait);
		
		this.transferWayID = transferWayID;
		this.sendCity = sendCity;
		this.containerNum = containerNum;
		this.loadManName = loadManName;
		this.orderBarCode = orderBarCode;
	}

	
	
}
