package po;

import java.io.Serializable;

import util.Date;
import util.DocState;
import util.DocType;

/**
 * 装车单PO
 * 
 * @author JerryZhang
 *
 */
public class LoadDocPO extends DocPO implements Serializable{
	
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 本营业厅编号
	 */
	private String YYID;
	/**
	 * 汽运编号
	 */
	private String LoadDocID;
	/**
	 * 到达地
	 */
	private String arriveCity;
	/**
	 * 车辆代号
	 */
	private String CarID;
	/**
	 * 监运员姓名
	 */
	private String Supervisor;
	/**
	 * 押送员代号
	 */
	private String Escort;

	public LoadDocPO(String iD, Date date, String yYID, String loadDocID,
			String arriveCity, String carID, String supervisor, String escort) {
		super(iD, DocType.loadDoc, date, DocState.wait);
		YYID = yYID;
		LoadDocID = loadDocID;
		this.arriveCity = arriveCity;
		CarID = carID;
		Supervisor = supervisor;
		Escort = escort;
	}

	public String getYYID() {
		return YYID;
	}

	public void setYYID(String yYID) {
		YYID = yYID;
	}

	public String getLoadDocID() {
		return LoadDocID;
	}

	public void setLoadDocID(String loadDocID) {
		LoadDocID = loadDocID;
	}

	public String getArriveCity() {
		return arriveCity;
	}

	public void setArriveCity(String arriveCity) {
		this.arriveCity = arriveCity;
	}

	public String getCarID() {
		return CarID;
	}

	public void setCarID(String carID) {
		CarID = carID;
	}

	public String getSupervisor() {
		return Supervisor;
	}

	public void setSupervisor(String supervisor) {
		Supervisor = supervisor;
	}

	public String getEscort() {
		return Escort;
	}

	public void setEscort(String escort) {
		Escort = escort;
	}

}
