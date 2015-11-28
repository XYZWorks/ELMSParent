package bl.orderbl;

import java.util.ArrayList;
import java.util.Date;

import util.DocState;
import util.DocType;
import util.MyDate;
import util.ResultMessage;
import vo.DocVO;
import vo.order.OrderSimpleInfoVO;
import vo.order.OrderVO;
import vo.order.ReceiveVO;
import blservice.orderblservice.Orderblservice;
 /** 
 * 订单controller类
 * @author czq 
 * @version 2015年11月15日 上午9:22:18 
 */
public class OrderController implements Orderblservice{

	Order order ;
	public OrderController() {
		order = new Order();
	}
	public ResultMessage add(OrderVO vo) {
		return order.add(vo);
	}

	public ResultMessage checkBarCode(String orderBarCode) {
		return order.checkBarCode(orderBarCode);
	}

	public ArrayList<OrderVO> getOrderVO(MyDate date) {
		return order.getOrderVO(date);
	}

	public ResultMessage del(String orderBarCode) {
		return order.del(orderBarCode);
	}

	public ArrayList<OrderSimpleInfoVO> getSimpleInfo(String orderBarCode) {
		return order.getSimpleInfo(orderBarCode);
	}

	public OrderVO getFullInfo(String orderBarCode) {
		return order.getFullInfo(orderBarCode);
	}

	public ResultMessage receiveInfo(ReceiveVO vo) {
		return order.receiveInfo(vo);
	}

	public ResultMessage addDocToList(DocVO vo,ArrayList<String> orderBarCodes) {
		return order.addDocToList(vo,orderBarCodes);
	}

	public ArrayList<DocVO> getDocLists(DocType type) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage changeDocsState(ArrayList<String> docsID, DocType type, DocState state) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage changeOneDocState(String docID, DocType type, DocState state) {
		// TODO Auto-generated method stub
		return null;
	}
	public DocVO getByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
