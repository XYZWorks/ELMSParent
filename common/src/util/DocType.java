package util;


/**
 * 单据类型
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
	 * 装车单（营业厅和中转中心流转）
	 */
	arriveZZDoc("装车单"),
	/**
	 * 装车单
	 */
	transferDoc("装车单"),
	/**
	 * 装车单
	 */
	arriveYYDoc("装车单"),
	/**
	 * 装车单
	 */
	sendGoodDoc("装车单"),
	/**
	 * 入库单
	 */
	inStoreDoc("入库单"),
	/**
	 * 入库单
	 */
	outStoreDoc("出库单");
	
	private final String name;
	
	private DocType(String name){
		this.name = name;
	}
	
	public static String getName(DocType type){
		return type.name;
	}
	
	
	
//	public DocVO getVOInstance(DocType type){
//		switch (type) {
//		case order: return new OrderVO(iD, date, orderYYT, orderBarCode, senderName, senderPhone, senderCompany, senderAddress, receiverName, receiverPhone, receiverCompany, receiverAddress, goodNum, goodName, goodWeight, goodLong, goodWidth, goodHeight, goodPack, orderForm, orderEestiTime, orderCost, docList)
//			
//			break;
//
//		default:
//			break;
//		}
//		
//	}
	
	
}
