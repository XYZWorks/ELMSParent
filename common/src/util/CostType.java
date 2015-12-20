package util;

/**
 * cost单据类型枚举
 * 
 * @author czq
 * @version 2015年11月23日 下午10:57:28
 */
public enum CostType {
	FREIGHT("运费"), RENT("租金"), SALARY("薪水");

	private String name;

	private CostType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static CostType toCostType(String name) {
		switch (name) {
		case "运费":

			return CostType.FREIGHT;
		case "租金":

			return CostType.RENT;
		case "薪水":
			return SALARY;

		default:
			System.err.println("成本信息输入有误");

			return SALARY;

		}

	}

}
