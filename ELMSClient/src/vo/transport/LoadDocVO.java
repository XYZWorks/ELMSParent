package vo.transport;

import util.MyDate;
import vo.DocVO;
import ui.saleman.LoadDocShow;
import util.City;
import util.DocState;
import util.DocType;



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
	public String LoadDocID;
	/**
	 * 到达地
	 */
	public City arriveCity;
	/**
	 * 车辆代号
	 */
	public String CarID;
	/**
	 * 监运员姓名
	 */
	public String Supervisor;
	/**
	 * 押送员代号
	 */
	public String Escort;
	
	public LoadDocVO() {
		// TODO Auto-generated constructor stub
	}

	public LoadDocVO(String iD, MyDate date,
			String yYID, String loadDocID, City arriveCity, String carID,
			String supervisor, String escort) {
		super(iD, DocType.loadDoc, date, DocState.wait);
		YYID = yYID;
		LoadDocID = loadDocID;
		this.arriveCity = arriveCity;
		CarID = carID;
		Supervisor = supervisor;
		Escort = escort;
	}

	
}
