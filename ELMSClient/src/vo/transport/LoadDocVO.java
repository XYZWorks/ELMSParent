package vo.transport;

import java.util.ArrayList;

import util.City;
import util.DocState;
import util.DocType;
import util.MyDate;
import vo.DocVO;



/**
 * 装车单VO类
 * @author JerryZhang
 *
 */
public class LoadDocVO extends DocVO{
	/**
	 * 本营业厅编号
	 */
	public String YYID;
	/**
	 * 汽运编号
	 */
	public String loadDocID;
	/**
	 * 到达地
	 */
	public City arriveCity;
	/**
	 * 车辆代号
	 */
	public String carID;
	/**
	 * 监运员姓名
	 */
	public String supervisor;
	/**
	 * 押送员代号
	 */
	public String escort; 
	/**
	 * 订单号集合
	 */
	public ArrayList<String> orderBarCodes;
	
	public LoadDocVO() {
	}

	public LoadDocVO(String iD, MyDate date,
			String yYID, String loadDocID, City arriveCity, String carID,
			String supervisor, String escort,ArrayList<String> orderBarCodes) {
		super(iD, DocType.loadDoc, date, DocState.wait);
		YYID = yYID;
		this.loadDocID = loadDocID;
		this.arriveCity = arriveCity;
		this.carID = carID;
		this.supervisor = supervisor;
		this.escort = escort;
		this.orderBarCodes = orderBarCodes;
	}

	
}
