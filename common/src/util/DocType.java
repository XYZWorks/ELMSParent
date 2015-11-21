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
	order("order"),
	/**
	 * 装车单
	 */
	loadDoc("loadDoc"),
	/**
	 * 装车单（营业厅和中转中心流转）
	 */
	arriveZZDoc("arriveZZDoc"),
	/**
	 * 装车单
	 */
	transferDoc("transferDoc"),
	/**
	 * 装车单
	 */
	arriveYYDoc("arriveYYDoc"),
	/**
	 * 装车单
	 */
	sendGoodDoc("sendGoodDoc"),
	/**
	 * 入库单
	 */
	inStoreDoc("inStoreDoc"),
	/**
	 * 入库单
	 */
	outStoreDoc("outStoreDoc");
	
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
