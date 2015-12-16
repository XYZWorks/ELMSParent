package util;
/**
 * 机构类型
 * @author czq
 *
 */
public enum InstType {
	/**
	 * 营业厅
	 */
	businessHall("营业厅"),
	/**
	 * 中转中心
	 */
	transportCenter("中转中心"),
	/**
	 * 总部
	 */
	headOffice("总部");
	
	private String name;
	
	private InstType(String name) {
		this.name = name;
	}
	
	public static InstType toInst(String name){
		switch (name) {
		case "营业厅":
			
			return InstType.businessHall;
		case "中转中心":
			return InstType.transportCenter;
			case "总部":
				return headOffice;
		default:
			System.err.println("机构中文名称错误");
			return null;
		}
	}
	
	public String getName() {
		return name;
	}
}
