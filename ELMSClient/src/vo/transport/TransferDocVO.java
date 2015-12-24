package vo.transport;

import java.util.ArrayList;

import util.City;
import util.DocState;
import util.DocType;
import util.MyDate;
import vo.DocVO;

/**
 * 中转单VO类
 * @author JerryZhang
 *
 */
public class TransferDocVO extends DocVO{
	

	
	/**
	 * 航班号/车次/车牌号
	 */
	public String transferWayID;
	/**
	 * 出发地
	 */
	public City sendCity;
	/**
	 * 货柜号
	 */
	public int containerNum;
	/**
	 * 监装员
	 */
	public String loadManName;
	/**
	 *所有托运单号
	 */
	public ArrayList<String> orderBarCode;
	public TransferDocVO() {
	}
	public TransferDocVO(String iD, DocType type, MyDate date, DocState state,
			String transferWayID, City sendCity, int containerNum,
			String loadManName, ArrayList<String> orderBarCode) {
		super(iD, type, date, state);
		this.transferWayID = transferWayID;
		this.sendCity = sendCity;
		this.containerNum = containerNum;
		this.loadManName = loadManName;
		this.orderBarCode = orderBarCode;
	}
	
	public TransferDocVO(String iD,  MyDate date,
			String transferWayID, City sendCity, int containerNum,
			String loadManName, ArrayList<String> orderBarCode) {
		super(iD, DocType.transferDoc, date, DocState.wait);
		this.transferWayID = transferWayID;
		this.sendCity = sendCity;
		this.containerNum = containerNum;
		this.loadManName = loadManName;
		this.orderBarCode = orderBarCode;
	}
	
	
	
}
