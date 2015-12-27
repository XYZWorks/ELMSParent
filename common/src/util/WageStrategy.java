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
	byMonth("按月计费"),
	/**
	 * 按次数计工资
	 */
	byTimes("按次计费"),
	/**
	 * 按提成计工资
	 */
	baseAndMore("提成制");
	
	private String name;
	
	private WageStrategy(String name) {
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public final static WageStrategy getType(String chineseName) {
		for (WageStrategy wage : WageStrategy.values()) {
			if(wage.name.equals(chineseName)){
				return wage;
			}
		}
		System.err.println("非法工资策略输入");
		return byMonth;
	}

}
