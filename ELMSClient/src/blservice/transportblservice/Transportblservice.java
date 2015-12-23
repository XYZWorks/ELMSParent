package blservice.transportblservice;

import java.util.ArrayList;

import util.DocType;
import util.MyDate;
import util.ResultMessage;
import vo.DocVO;
import vo.store.OutStoreDocVO;
import vo.transport.ArriveYYDocVO;
import vo.transport.ArriveZZDocVO;
import vo.transport.LoadDocVO;
import vo.transport.PayDocVO;
import vo.transport.SendGoodDocVO;
import vo.transport.TransferDocVO;
import blservice.DocApprovalService;

/**
 * 流转单管理接口类
 * @author JerryZhang
 *
 */
public interface Transportblservice extends DocApprovalService{
	/**
	 * 增加一个付款单
	 * @param vo
	 * @return
	 */
	public ResultMessage addOnePay(PayDocVO vo);
	/**
	 * 获得当日所有付款单
	 * @return
	 */
	public ArrayList<PayDocVO> getPays();
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
	public ArrayList<LoadDocVO> getDayLoadDocs(MyDate date);
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
	public ArrayList<SendGoodDocVO> getDaySendDocs(MyDate date);
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
	public ArrayList<ArriveYYDocVO> getDayArriveYYDocs(MyDate date);
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
	public ArrayList<ArriveZZDocVO> getDayArriveZZDocs(MyDate date);
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
	public ArrayList<TransferDocVO> getDayTransferDocs(MyDate date);
	/**
	 * 从货物流转包中获得该单据
	 * @param type
	 * @return
	 */
	public ArrayList<DocVO> getDoc(DocType type);
	/**
	 * 得到该单据的运费成本信息
	 * @param arriveVO,transferVO
	 * @return
	 */
	public double getExpense(OutStoreDocVO arriveVO, TransferDocVO transferVO);
}
