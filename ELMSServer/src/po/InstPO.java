package po;

import util.InstType;

/**
 * 机构PO类
 * @author czq
 * 
 */
public class InstPO {
	/**
	 * 机构ID
	 */
	private String ID;
	/**
	 * 机构所在城市
	 */
	private String location;
	/**
	 * 机构类型  营业厅、中转中心、总部
	 */
	private InstType type;
	public InstPO(String iD, String location, InstType type) {
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public InstType getType() {
		return type;
	}
	public void setType(InstType type) {
		this.type = type;
	}
	
	
	
	
}
