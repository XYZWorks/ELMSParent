package util;

/**
 * 职员种类,含司机不含总经理
 * 
 * @author czq
 *
 */
public enum StaffType {
	// /**
	// * 总经理
	// */
	// manager,
	/**
	 * 财务人员
	 */
	financeman("financeman"),
	/**
	 * 营业厅业务员
	 */
	saleman("saleman"),
	/**
	 * 快递员
	 */
	courier("courier"),
	/**
	 * 中转中心业务人员
	 */
	storeman("storeman"),
	/**
	 * 中转中心管理员
	 */
	storemanager("storemanager"),
	/**
	 * 司机
	 */
	driver("driver");

	private String stafftypeName;

	private StaffType(String name) {
		this.stafftypeName = name;
	}
	
	public final static StaffType getType(String chineseName){
		switch (chineseName) {
		case "快递员":

			return courier;
		case "司机":

			return driver;
		case "财务人员":

			return financeman;
		case "营业厅业务员":

			return saleman;
		case "中转中心业务人员":

			return storeman;
		case "中转中心管理员":

			return storemanager;

		default:
			return null;
		}
		
		
	}
	
	
	public final static String getName(StaffType type) {
		
		
		switch (type) {
		case courier:

			return "快递员";
		case driver:

			return "司机";
		case financeman:

			return "财务人员";
		case saleman:

			return "营业厅业务员";
		case storeman:

			return "中转中心业务员";
		case storemanager:

			return "中转中心管理人员";

		default:
			System.err.println("--------------非法人员输入");
			return "";
		}

	}


}
