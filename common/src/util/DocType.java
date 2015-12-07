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
	outStoreDoc("入库单");

	private final String name;

	private DocType(String name) {
		this.name = name;
	}

	
	 public static String getName(DocType type){
		 return type.name;
	 }

	public final static DocType getDocType(String chinese) {

		switch (chinese) {
		case "订单":
			return order;
		case "入库单":
			return inStoreDoc;
		case "出库单":
			return outStoreDoc;
		case "派送单":
			return sendGoodDoc;
		case "到达单":
			return arriveZZDoc;
		case "装车单":
			return loadDoc;
		case "接收单":
			return arriveYYDoc;
		case "中转单":

			return transferDoc;
		default:
			System.err.println("单据类型错误");
			return null;
		}

	}

}
