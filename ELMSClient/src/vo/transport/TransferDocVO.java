package vo.transport;

import java.util.Date;

import util.DocState;
import util.DocType;
import vo.DocVO;

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
	public String TransferWayID;
	/**
	 * 出发地
	 */
	public String SendCity;
	/**
	 * 货柜号
	 */
	public int containerNum;
	/**
	 * 监装员
	 */
	public String LoadManName;
	/**
	 *所有托运单号
	 */
	public String[] orderBarCode;
	public TransferDocVO() {
		// TODO Auto-generated constructor stub
	}
	
	public TransferDocVO(String iD, util.MyDate date,
			String transferWayID,
			String sendCity, int containerNum, String loadManName,
			String[] orderBarCode) {
		super(iD, DocType.transferDoc, date, DocState.wait);
		
		TransferWayID = transferWayID;
		SendCity = sendCity;
		this.containerNum = containerNum;
		LoadManName = loadManName;
		this.orderBarCode = orderBarCode;
	}

	
	
}