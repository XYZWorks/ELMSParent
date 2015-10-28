package blservice.orderblservice;

import java.util.ArrayList;
import java.util.Date;

import po.DocPO;
import util.ResultMessage;
import vo.DocVO;
import vo.OrderVO;
import vo.ReceiveVO;

/**
 * 订单增、删、查，收件信息录入
 * 
 * @author xingcheng
 */
public interface Orderblservice {

	/**
	 * 增加订单
	 * @param vo
	 * @return
	 */
	public ResultMessage add(OrderVO vo);
	
	/**
	 * 确认订单号是否在数据库中已存在
	 * @param orderBarCode
	 * @return
	 */
	public ResultMessage checkBarCode(String orderBarCode);
	
	/**
	 * 得到某日新增的所有订单
	 * @param date
	 * @return ArrayList<orderVO> 
	 */
	public  ArrayList< OrderVO > getOrderVO(Date date);


	/**
	 * 删除订单
	 * @param orderBarCode
	 * @return
	 */
	public ResultMessage del(String  orderBarCode);
	
	/**
	 * 让寄件人查询订单的简单信息 只显示订单的流转状态（流转地＋到达时间）
	 * @param orderBarCode
	 * @return
	 */
	public ResultMessage getSimpleInfo(String orderBarCode);
	
	/**
	 * 让快递员查询订单的详细信息 显示订单的所有信息
	 * @param orderBarCode
	 * @return
	 */
	public ResultMessage getFullInfo(String	orderBarCode);

	/**
	 * 收件信息录入 
	 * @param ArrayList ReceiveVO  vo
	 * @return 
	 */
	public ResultMessage receiveInfo(ArrayList<ReceiveVO> vo);

	/**
	 * 将流转单中的所有订单的物流状态均更新
	 * @param vo
	 * @return
	 */
	public ResultMessage addDocToList (DocVO vo);
	
}
