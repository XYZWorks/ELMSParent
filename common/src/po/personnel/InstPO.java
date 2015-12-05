package po.personnel;

import java.io.Serializable;

import util.City;
import util.InstType;

/**
 * 机构PO类
 * @author czq
 * 
 */
public class InstPO implements Serializable{
	
	
	public InstPO() {}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 机构ID
	 */
	private String ID;
	/**
	 * 机构所在城市
	 */
	private City location;
	/**
	 * 机构类型  营业厅、中转中心、总部
	 */
	private InstType type;
	
	
	
	
	public InstPO(String iD, City location, InstType type) {
		super();
		ID = iD;
		this.location = location;
		this.type = type;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public City getLocation() {
		return location;
	}
	public void setLocation(City location) {
		this.location = location;
	}
	public InstType getType() {
		return type;
	}
	public void setType(InstType type) {
		this.type = type;
	}
	
	
	
	
}
