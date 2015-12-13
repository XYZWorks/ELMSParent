package bl.orderbl;

import java.util.ArrayList;

import blservice.orderblservice.Orderblservice;
import util.DocState;
import util.DocType;
import util.ResultMessage;
import vo.DocVO;
import vo.order.OrderSimpleInfoVO;
import vo.order.OrderVO;
import vo.order.PreReceiveVO;
import vo.order.ReceiveVO;

/**
*
*@author:xingcheng
*@version 2015年12月13日
*/
public class orderbl_stub implements Orderblservice{

	@Override
	public ArrayList<? extends DocVO> getDocLists(DocType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage changeDocsState(ArrayList<String> docsID, DocType type, DocState state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage changeOneDocState(String docID, DocType type, DocState state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocVO getByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage add(OrderVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage checkBarCode(String orderBarCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage del(String orderBarCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderSimpleInfoVO> getSimpleInfo(String orderBarCode) {
		ArrayList<OrderSimpleInfoVO> info=new ArrayList<>();
		OrderSimpleInfoVO one=new OrderSimpleInfoVO("1","南京","2015-10-9-11-23-12",DocType.loadDoc);
		info.add(one);
		return info;
	}

	@Override
	public OrderVO getFullInfo(String orderBarCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage receiveInfo(ReceiveVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addDocToList(DocVO vo, ArrayList<String> orderBarCodes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PreReceiveVO> getPreReceive() {
		// TODO Auto-generated method stub
		return null;
	}

}
