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
	financeman("财务人员"),
	/**
	 * 营业厅业务员
	 */
	saleman("营业厅业务员"),
	/**
	 * 快递员
	 */
	courier("快递员"),
	/**
	 * 中转中心业务人员
	 */
	storeman("中转中心业务人员"),
	/**
	 * 中转中心管理员
	 */
	storemanager("中转中心管理员"),
	/**
	 * 司机
	 */
	driver("司机");

	private String stafftypeName;

	private StaffType(String name) {
		this.stafftypeName = name;
	}
	
	public final static StaffType getType(String chineseName){
		for (StaffType staffType : StaffType.values()) {
			if(staffType.stafftypeName.equals(chineseName)){
				return staffType;
			}
		}
		System.err.println("---------人员账户中英文不对应");
		return StaffType.courier;
		
	}
	
	
	public String getName() {
		return stafftypeName;
	}


}
