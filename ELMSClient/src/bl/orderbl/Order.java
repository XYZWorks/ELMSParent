package bl.orderbl;

import java.util.ArrayList;
import java.util.Date;

import util.ResultMessage;
import vo.DocVO;
import vo.OrderVO;
import vo.ReceiveVO;
import blservice.strategyblservice.StrategyblService;
import ds.orderdataservice.OrderDataService;
import vo.o
/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:48:05 
 *
 */
public class Order {
	OrderDataService orderData;
	StrategyblService strategybl;
	public ResultMessage add(OrderVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage checkBarCode(String orderBarCode) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderVO> getOrderVO(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage del(String orderBarCode) {
		// TODO Auto-generated method stub
		return null;
	}

	public  ArrayList<OrderSimpleInfo> getSimpleInfo(String orderBarCode) {
		// TODO Auto-generated method stub
		return null;
	}

	public orderVO getFullInfo(String orderBarCode) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage receiveInfo(ArrayList<ReceiveVO> vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addDocToList(DocVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
