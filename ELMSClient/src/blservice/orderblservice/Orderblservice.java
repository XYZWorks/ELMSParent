package blservice.orderblservice;

import java.util.ArrayList;

import util.City;
import util.MyDate;
import util.ResultMessage;
import vo.DocVO;
import vo.order.OrderSimpleInfoVO;
import vo.order.OrderVO;
import vo.order.PreReceiveVO;
import vo.order.ReceiveVO;
import blservice.DocApprovalService;

/**
 * 订单增、删、查，收件信息录入
 * 
 * @author xingcheng
 */
public interface Orderblservice extends DocApprovalService{

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
	public ArrayList<OrderSimpleInfoVO> getSimpleInfo(String orderBarCode);
	
	/**
	 * 让快递员查询订单的详细信息 显示订单的所有信息
	 * @param orderBarCode
	 * @return
	 */
	public OrderVO getFullInfo(String	orderBarCode);

	/**
	 * 收件信息录入 
	 * @param ArrayList ReceiveVO  vo
	 * @return 
	 */
	public ResultMessage receiveInfo(ReceiveVO vo);

	/**
	 * 将流转单中的所有订单的物流状态均更新
	 * @param vo
	 * @return
	 */
	public ResultMessage addDocToList (DocVO vo,ArrayList<String> orderBarCodes);
	/**
	 * 得到接受准备信息
	 * @return
	 */
	public ArrayList<PreReceiveVO> getPreReceive() ;
		
	/**
	 * 输入对应的日期 返回当天所有生成的ordervo
	 * 
	 */
	public ArrayList<OrderVO> getOrderVO(MyDate date);
	/**
	 * 得到预计时间
	 * @return
	 */
	public double getEstiDate(City one,City two);
	/**
	 * 设置预计时间
	 * @return
	 */
	public ResultMessage setEstiDate(double day,City one,City two);
	
}
