package util;
/**
 * 账户种类
 * @author czq
 * @date 2015/10/20
 */
public enum AccountType {
	/**
	 * 总经理
	 */
	manager("manager"),
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
	storemanager("storemanager");
	
	private String name;
	
	private AccountType(String name) {
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	
	public static AccountType getType(String str){
		
		return Enum.valueOf(AccountType.class, str);
		
		
	}
}
