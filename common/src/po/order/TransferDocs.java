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
	private String loadDoc;
	private String arriveZZDoc;
	private String transferDoc;
	private String arriveYYDoc;
	private String sendGoodDoc;
	public TransferDocs(String loadDoc, String arriveZZDoc, String transferDoc,
			String arriveYYDoc, String sendGoodDoc) {
		super();
		this.loadDoc = loadDoc;
		this.arriveZZDoc = arriveZZDoc;
		this.transferDoc = transferDoc;
		this.arriveYYDoc = arriveYYDoc;
		this.sendGoodDoc = sendGoodDoc;
	}
	public String getLoadDoc() {
		return loadDoc;
	}
	public void setLoadDoc(String loadDoc) {
		this.loadDoc = loadDoc;
	}
	public String getArriveZZDoc() {
		return arriveZZDoc;
	}
	public void setArriveZZDoc(String arriveZZDoc) {
		this.arriveZZDoc = arriveZZDoc;
	}
	public String getTransferDoc() {
		return transferDoc;
	}
	public void setTransferDoc(String transferDoc) {
		this.transferDoc = transferDoc;
	}
	public String getArriveYYDoc() {
		return arriveYYDoc;
	}
	public void setArriveYYDoc(String arriveYYDoc) {
		this.arriveYYDoc = arriveYYDoc;
	}
	public String getSendGoodDoc() {
		return sendGoodDoc;
	}
	public void setSendGoodDoc(String sendGoodDoc) {
		this.sendGoodDoc = sendGoodDoc;
	}
	
	
	
}
