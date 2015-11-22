package po.order;
 /** 
 * 订单流转过程中的单据信息
 * @author czq 
 * @version 2015年11月22日 下午12:27:00 
 */
public class TransferDocs {
	/**
	 * 装车单
	 */
	String loadDoc;
	String arriveZZDoc;
	String transferDoc;
	String arriveYYDoc;
	String sendGoodDoc;
	public TransferDocs(String loadDoc, String arriveZZDoc, String transferDoc,
			String arriveYYDoc, String sendGoodDoc) {
		super();
		this.loadDoc = loadDoc;
		this.arriveZZDoc = arriveZZDoc;
		this.transferDoc = transferDoc;
		this.arriveYYDoc = arriveYYDoc;
		this.sendGoodDoc = sendGoodDoc;
	}
	
	
	
}
