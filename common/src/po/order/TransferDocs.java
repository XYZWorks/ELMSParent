package po.order;

import java.io.Serializable;
import java.util.ArrayList;

/** 
 * 订单流转过程中的单据信息
 * @author czq 
 * @version 2015年11月22日 下午12:27:00 
 */
public class TransferDocs implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 装车单
	 */
	private String loadDoc;
	private String arriveZZDoc;
	
	/**
	 * 货物发出地的中转中心：入库 出库
	 */
	private String inStoreOneDoc;
	private String outStoreOneDoc;
	
	private String transferDoc;
	
	/**
	 * 货物接收地的中转中心：入库 出库
	 */
	private String instoreTwoDoc;
	private String outStoreTwoDoc;
	
	private String arriveYYDoc;
	private String sendGoodDoc;
	
	/**
	 * 流转的所有编号
	 */
	private ArrayList<String> allDocs;

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

	public String getInStoreOneDoc() {
		return inStoreOneDoc;
	}

	public void setInStoreOneDoc(String inStoreOneDoc) {
		this.inStoreOneDoc = inStoreOneDoc;
	}

	public String getOutStoreOneDoc() {
		return outStoreOneDoc;
	}

	public void setOutStoreOneDoc(String outStoreOneDoc) {
		this.outStoreOneDoc = outStoreOneDoc;
	}

	public String getTransferDoc() {
		return transferDoc;
	}

	public void setTransferDoc(String transferDoc) {
		this.transferDoc = transferDoc;
	}

	public String getInstoreTwoDoc() {
		return instoreTwoDoc;
	}

	public void setInstoreTwoDoc(String instoreTwoDoc) {
		this.instoreTwoDoc = instoreTwoDoc;
	}

	public String getOutStoreTwoDoc() {
		return outStoreTwoDoc;
	}

	public void setOutStoreTwoDoc(String outStoreTwoDoc) {
		this.outStoreTwoDoc = outStoreTwoDoc;
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

	public ArrayList<String> getAllDocs() {
		return allDocs;
	}

	public void setAllDocs(ArrayList<String> allDocs) {
		this.allDocs = allDocs;
	}

	public TransferDocs(String loadDoc, String arriveZZDoc, String inStoreOneDoc, String outStoreOneDoc,
			String transferDoc, String instoreTwoDoc, String outStoreTwoDoc, String arriveYYDoc, String sendGoodDoc,
			ArrayList<String> allDocs) {
		super();
		this.loadDoc = loadDoc;
		this.arriveZZDoc = arriveZZDoc;
		this.inStoreOneDoc = inStoreOneDoc;
		this.outStoreOneDoc = outStoreOneDoc;
		this.transferDoc = transferDoc;
		this.instoreTwoDoc = instoreTwoDoc;
		this.outStoreTwoDoc = outStoreTwoDoc;
		this.arriveYYDoc = arriveYYDoc;
		this.sendGoodDoc = sendGoodDoc;
		this.allDocs = allDocs;
	}
	
	
	
	
}	
	
	