package util;
 /**
  * 单据状态
  * @author czq
  *
  */
public enum DocState {
    /**
     * 未审批
     */
	wait("未审批"),
	/**
	 * 
	 * 审批通过
	 */
	pass("审批通过");
    //fail 暂时放弃
	
	private String name;
	
	private DocState(String name) {
		this.name = name;
	}
	
	public static String getName(DocState state){
		return state.name;
	}
}
