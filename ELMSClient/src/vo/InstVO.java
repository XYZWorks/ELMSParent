package vo;

import util.InstType;
/**
 * 机构VO类
 * @author czq
 *
 */
public class InstVO {
	/**
	 * 机构ID
	 */
	public String ID;
	/**
	 * 机构所在城市
	 */
	public String location;
	/**
	 * 机构类型  营业厅、中转中心、总部
	 */
	public InstType type;
	public InstVO(String iD, String location, InstType type) {
		super();
		ID = iD;
		this.location = location;
		this.type = type;
	}
	
	
}
