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
	private String arriveZZOneDoc;
	private String arriveZZTwoDoc;
	
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

	public TransferDocs(String loadDoc, String arriveZZOneDoc, String arriveZZTwoDoc, String inStoreOneDoc,
			String outStoreOneDoc, String transferDoc, String instoreTwoDoc, String outStoreTwoDoc, String arriveYYDoc,
			String sendGoodDoc, ArrayList<String> allDocs) {
		super();
		this.loadDoc = loadDoc;
		this.arriveZZOneDoc = arriveZZOneDoc;
		this.arriveZZTwoDoc = arriveZZTwoDoc;
		this.inStoreOneDoc = inStoreOneDoc;
		this.outStoreOneDoc = outStoreOneDoc;
		this.transferDoc = transferDoc;
		this.instoreTwoDoc = instoreTwoDoc;
		this.outStoreTwoDoc = outStoreTwoDoc;
		this.arriveYYDoc = arriveYYDoc;
		this.sendGoodDoc = sendGoodDoc;
		this.allDocs = allDocs;
	}



	public String getLoadDoc() {
		return loadDoc;
	}

	public String getArriveZZOneDoc() {
		return arriveZZOneDoc;
	}

	public String getArriveZZTwoDoc() {
		return arriveZZTwoDoc;
	}

	public String getInStoreOneDoc() {
		return inStoreOneDoc;
	}

	public String getOutStoreOneDoc() {
		return outStoreOneDoc;
	}

	public String getTransferDoc() {
		return transferDoc;
	}

	public String getInstoreTwoDoc() {
		return instoreTwoDoc;
	}

	public String getOutStoreTwoDoc() {
		return outStoreTwoDoc;
	}

	public String getArriveYYDoc() {
		return arriveYYDoc;
	}

	public String getSendGoodDoc() {
		return sendGoodDoc;
	}

	public ArrayList<String> getAllDocs() {
		return allDocs;
	}


	
	
	
	
}	
	
	