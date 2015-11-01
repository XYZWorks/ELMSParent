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

	public String getName() {
		return stafftypeName;
	}

	public static StaffType getType(String str) {

		return Enum.valueOf(StaffType.class, str);

	}

}
