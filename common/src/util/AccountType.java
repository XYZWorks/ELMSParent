package util;

/**
 * 账户种类
 * 
 * @author czq
 * @date 2015/10/20
 */
public enum AccountType {

	/**
	 * 管理员
	 */
	Adminstrator("管理员"),
	/**
	 * 总经理
	 */
	manager("总经理"),
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
	storemanager("中转中心管理员");

	private String name;

	private AccountType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static AccountType getType(String str) {
		for (AccountType type : AccountType.values()) {
			if(type.name.equals(str)){
				return type;
			}
		}
		System.err.println("-----------------账户类型输入错误");
		return AccountType.Adminstrator;
	}
}
