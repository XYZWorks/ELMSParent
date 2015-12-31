package util;

/**
 * 单据类型
 * 
 * @author czq
 *
 */
public enum DocType {

	/**
	 * 订单
	 */
	order("订单"),
	/**
	 * 装车单
	 */
	loadDoc("装车单"),
	/**
	 * 到达单（营业厅和中转中心流转）
	 */
	arriveZZDoc("到达单"),
	/**
	 * 中转单
	 */
	transferDoc("中转单"),
	/**
	 * 接收单
	 */
	arriveYYDoc("接收单"),
	/**
	 * 派送单
	 */
	sendGoodDoc("派送单"),
	/**
	 * 入库单
	 */
	inStoreDoc("入库单"),
	/**
	 * 入库单
	 */
	outStoreDoc("出库单"),
	
	/**
	 * 付款单
	 */
	payDoc("付款单");
	
	private final String name;

	private DocType(String name) {
		this.name = name;
	}

	
	 public static String getName(DocType type){
		 return type.name;
	 }

	public final static DocType getDocType(String chinese) {
		for (DocType type : DocType.values()) {
			if(type.name.equals(chinese)){
				return type;
			}
		}
		System.err.println("单据类型错误");
		return null;
		
		

	}

}
