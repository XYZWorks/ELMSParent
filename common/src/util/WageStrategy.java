package util;

/**
 * 工资计算方式
 * 
 * @author czq
 * @date 2015-10-22
 */
public enum WageStrategy {
	/**
	 * 按月计工资
	 */
	byMonth,
	/**
	 * 按次数计工资
	 */
	byTimes,
	/**
	 * 按提成计工资
	 */
	baseAndMore;

	public final static WageStrategy getType(String chineseName) {
		switch (chineseName) {
		case "按月计费":

			return byMonth;
		case "按次计费":

			return byTimes;
		case "提成制":

			return baseAndMore;
		default:
			System.err.println("非法工资策略输入");
			return byMonth;
		}

	}

}
