package blservice.transportblservice;

import java.util.ArrayList;
import java.util.Date;

import util.DocType;
import util.ResultMessage;
import vo.ArriveYYDocVO;
import vo.ArriveZZDocVO;
import vo.DocVO;
import vo.LoadDocVO;
import vo.SendGoodDocVO;
import vo.TransferDocVO;

/**
 * 流转单管理接口类
 * @author JerryZhang
 *
 */
public interface Transportblservice {
	/**
	 * 增加装车单
	 * @param vo
	 * @return
	 */
	public ResultMessage add(LoadDocVO vo);
	/**
	 * 显示当日所有装车单
	 * @param date
	 * @return
	 */
	public ArrayList<LoadDocVO> getDayLoadDocs(Date date);
	/**
	 * 增加派件单
	 * @param vo
	 * @return
	 */
	public ResultMessage add(SendGoodDocVO vo);
	/**
	 * 显示当日所有派件单
	 * @param date
	 * @return
	 */
	public ArrayList<SendGoodDocVO> getDaySendDocs(Date date);
	/**
	 * 增加接收单
	 * @param vo
	 * @return
	 */
	public ResultMessage add(ArriveYYDocVO vo);
	/**
	 * 显示当日所有接收单
	 * @param date
	 * @return
	 */
	public ArrayList<ArriveZZDocVO> getDayArriveYYDocs(Date date);
	/**
	 * 增加到达单
	 * @param vo
	 * @return
	 */
	public ResultMessage add(ArriveZZDocVO vo);
	/**
	 * 显示当日所有到达单
	 * @param date
	 * @return
	 */
	public ArrayList<ArriveZZDocVO> getDayArriveZZDocs(Date date);
	/**
	 * 增加中转单
	 * @param vo
	 * @return
	 */
	public ResultMessage add(TransferDocVO vo);
	/**
	 * 显示当日所有中转单
	 * @param date
	 * @return
	 */
	public ArrayList<TransferDocVO> getDayTransferDocs(Date date);
	/**
	 * 从货物流转包中获得该单据
	 * @param type
	 * @return
	 */
	public ArrayList<DocVO> getDoc(DocType type);
	/**
	 * 得到该单据的运费成本信息
	 * @param type
	 * @return
	 */
	public double getExpense(DocType type);
}
