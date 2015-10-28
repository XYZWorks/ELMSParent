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
	private int YYID;
	/**
	 * 汽运编号
	 */
	private int LoadDocID;
	/**
	 * 到达地
	 */
	private String arriveCity;
	/**
	 * 车辆代号
	 */
	private int CarID;
	/**
	 * 监运员姓名
	 */
	private String Supervisor;
	/**
	 * 押送员代号
	 */
	private String Escort;

	public LoadDocPO(String iD, Date date, int yYID, int loadDocID,
			String arriveCity, int carID, String supervisor, String escort) {
		super(iD, DocType.loadDoc, date, DocState.wait);
		YYID = yYID;
		LoadDocID = loadDocID;
		this.arriveCity = arriveCity;
		CarID = carID;
		Supervisor = supervisor;
		Escort = escort;
	}

	public int getYYID() {
		return YYID;
	}

	public void setYYID(int yYID) {
		YYID = yYID;
	}

	public int getLoadDocID() {
		return LoadDocID;
	}

	public void setLoadDocID(int loadDocID) {
		LoadDocID = loadDocID;
	}

	public String getArriveCity() {
		return arriveCity;
	}

	public void setArriveCity(String arriveCity) {
		this.arriveCity = arriveCity;
	}

	public int getCarID() {
		return CarID;
	}

	public void setCarID(int carID) {
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
