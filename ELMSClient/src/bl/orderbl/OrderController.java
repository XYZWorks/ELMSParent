package bl.orderbl;

import java.util.ArrayList;

import net.RMIManage;
import ds.orderdataservice.OrderDataService;
import util.City;
import util.DataServiceType;
import util.DocState;
import util.DocType;
import util.MyDate;
import util.ResultMessage;
import vo.DocVO;
import vo.order.OrderSimpleInfoVO;
import vo.order.OrderVO;
import vo.order.PreReceiveVO;
import vo.order.ReceiveVO;
import bl.transportbl.TransportController;
import blservice.orderblservice.Orderblservice;
 /** 
 * 订单controller类
 * @author czq 
 * @version 2015年11月15日 上午9:22:18 
 */
public class OrderController implements Orderblservice{

	private TransportController transportController;
	private OrderDataService orderData;
	private Order order ;
	public OrderController() {
		orderData  = (OrderDataService) RMIManage.getDataService(DataServiceType.OrderDataService);
		order = new Order(orderData);
		transportController = new TransportController();
	}
	@Override
	public ResultMessage add(OrderVO vo) {
		return order.add(vo);
	}

	@Override
	public ResultMessage checkBarCode(String orderBarCode) {
		return order.checkBarCode(orderBarCode);
	}

	@Override
	public ArrayList<OrderVO> getOrderVO(MyDate date) {
		return order.getOrderVO(date);
	}

	@Override
	public ResultMessage del(String orderBarCode) {
		return order.del(orderBarCode);
	}

	@Override
	public ArrayList<OrderSimpleInfoVO> getSimpleInfo(String orderBarCode) {
		return order.getSimpleInfo(orderBarCode);
	}

	@Override
	public OrderVO getFullInfo(String orderBarCode) {
		return order.getFullInfo(orderBarCode);
	}

	@Override
	public ResultMessage receiveInfo(ReceiveVO vo) {
		return order.receiveInfo(vo);
	}

	@Override
	public ResultMessage addDocToList(DocVO vo,ArrayList<String> orderBarCodes) {
		return order.addDocToList(vo,orderBarCodes);
	}

	@Override
	public ArrayList<DocVO> getDocLists(DocType type) {
		
		return null;
	}

	@Override
	public ResultMessage changeDocsState(ArrayList<String> docsID, DocType type, DocState state) {
		return order.changeDocsState(docsID , type , state);
	}
	@Override
	public ResultMessage changeOneDocState(String docID, DocType type, DocState state) {
		return order.changeOneDocState(docID , type , state);
	}
	@Override
	public ArrayList<PreReceiveVO> getPreReceive() {
		return order.getPreReceive(transportController.getDaySendDocs(MyDate.getNowTime()));
	}
	@Override
	public DocVO getByID(String ID, DocType type) {
		return getFullInfo(ID);
	}
	@Override
	public double getEstiDate(City one,City two) {
		return order.getEstiDate(one,two);
	}
	@Override
	public ResultMessage setEstiDate(double day,City one,City two) {
		
		return order.setEstiDate(day,one,two);
	}

	@Override
	public int getDayDocCount(DocType type) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
