package vo;

import util.Date;
import util.DocState;
import util.DocType;
import util.GoodsState;

/**
 * 到达单VO类
 * 
 * @author JerryZhang
 *
 */
public class ArriveZZDocVO extends DocVO {
	/**
	 * 中转中心编号
	 */
	public String ZZID;
	// /**
	// * 到达日期
	// */
	// public Date arriveDate;
	// /**
	// * 中转单编号
	// */
	// public int TransferDocID;
	/**
	 * 出发地
	 */
	public String SendCity;
	/**
	 * 货物到达状态
	 */
	public GoodsState goodState;

	public ArriveZZDocVO(String iD, Date date, String zZID, String sendCity,
			GoodsState goodState) {
		super(iD, DocType.arriveZZDoc, date, DocState.wait);
		ZZID = zZID;
		SendCity = sendCity;
		this.goodState = goodState;
	}

}
