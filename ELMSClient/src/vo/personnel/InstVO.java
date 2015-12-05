package vo.personnel;

import util.City;
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
	public City location;
	/**
	 * 机构类型  营业厅、中转中心、总部
	 */
	public InstType type;
	public InstVO() {
		// TODO Auto-generated constructor stub
	}
	public InstVO(String iD, City location, InstType type) {
		super();
		ID = iD;
		this.location = location;
		this.type = type;
	}
	
	
}
