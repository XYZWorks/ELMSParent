package bl.orderbl;

import java.util.ArrayList;
import java.util.Date;

import util.DocState;
import util.DocType;
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

	public ArrayList<OrderSimpleInfoVO> getSimpleInfo(String orderBarCode) {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderVO getFullInfo(String orderBarCode) {
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

}
