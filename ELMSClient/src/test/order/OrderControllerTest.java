package test.order;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import test.DataTool;
import util.DocState;
import util.DocType;
import util.ResultMessage;
import vo.DocVO;
import vo.OrderSimpleInfoVO;
import vo.OrderVO;
import bl.orderbl.OrderController;
import blservice.orderblservice.Orderblservice;
/** 
 * 
 * @author czq 
 * @version 2015年11月15日 下午2:39:01 
 */
public class OrderControllerTest {
	
	Orderblservice bl ;
	ResultMessage result;
	
	@Before
	public void setUp() throws Exception {
		bl  = new OrderController();
		
	}

	@Test
	public void testAdd() {
		result = bl.add((OrderVO)DataTool.getDocList(DocType.order).get(0));
		if(result == ResultMessage.FAIL)
		{
			fail("can not add a order");
		}
	}

	@Test
	public void testCheckBarCode() {
		result = bl.checkBarCode(DataTool.getDocList(DocType.order).get(0).ID);
		if(result == ResultMessage.FAIL)
		{
			fail("订单号查找失败");
		}
	}

	@Test
	public void testGetOrderVO() {
		OrderVO vo = bl.getFullInfo(DataTool.getDocList(DocType.order).get(0).ID);
		if(vo == null){
			fail("fail to get order vo");
		}
	}

	@Test
	public void testDel() {
		bl.add((OrderVO)DataTool.getDocList(DocType.order).get(0));
		result = bl.del(DataTool.getDocList(DocType.order).get(0).ID);
		
		if(result == ResultMessage.FAIL){
			fail("fail to del");
		}
		
		result = bl.del(DataTool.getDocList(DocType.order).get(0).ID);
		
		if(result == ResultMessage.FAIL){
			fail("allow to del one thing twice!");
		}
		
		
		
	}

	@Test
	public void testGetSimpleInfo() {
		OrderSimpleInfoVO vo = bl.getSimpleInfo(DataTool.getDocList(DocType.order).get(0).ID).get(0);
		if(vo == null){
			fail("fail to get simple info");
		}
	}

	@Test
	public void testGetFullInfo() {
		OrderVO vo = bl.getFullInfo(DataTool.getDocList(DocType.order).get(0).ID);
		if(vo == null){
			fail("fail to get full info");
		}
	}

	@Test
	public void testReceiveInfo() {
	}

	@Test
	public void testAddDocToList() {
		if(bl.addDocToList(DataTool.getDocList(DocType.arriveYYDoc).get(0)) == ResultMessage.SUCCESS){
			
		}else{
			fail(" fail  to AddDocToList");
		}
		
	
	}

	@Test
	public void testGetDocLists() {
		ArrayList<DocVO> vos = bl.getDocLists(DocType.order);
		if(vos == null){
			fail("fail to get doc lists");
		}
	}

	@Test
	public void testChangeDocsState() {
		ArrayList<DocVO> vos = bl.getDocLists(DocType.order);
		vos.get(0).state = DocState.pass;
		vos.get(1).state = DocState.pass;
		
		ArrayList<String > temp = new ArrayList<String>();
		temp.add(vos.get(0).ID);
		temp.add(vos.get(1).ID);
		
		result = bl.changeDocsState(temp);
		
		if(result == ResultMessage.SUCCESS){
			return;
		}
		fail("fail to ChangeDocsState");
		
	}

	@Test
	public void testChangeOneDocState() {
		ArrayList<DocVO> vos = bl.getDocLists(DocType.order);
		vos.get(0).state = DocState.pass;
		result = bl.changeOneDocState(vos.get(0).ID);
		if(result == ResultMessage.SUCCESS){
			return;
		}
		fail("fail to ChangeDocsState");
	}

}
