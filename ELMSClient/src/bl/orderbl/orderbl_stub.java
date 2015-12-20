package bl.orderbl;

import java.util.ArrayList;

import blservice.orderblservice.Orderblservice;
import util.DocState;
import util.DocType;
import util.MyDate;
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
		
		if(orderBarCode.equals("1234567890")){
		ArrayList<OrderSimpleInfoVO> info=new ArrayList<>();
		OrderSimpleInfoVO one=new OrderSimpleInfoVO("1234567890","南京","2015-10-9-11-23-12",DocType.loadDoc);
		OrderSimpleInfoVO two=new OrderSimpleInfoVO("1234567890","南京","2015-10-9-11-23-12",DocType.arriveZZDoc);
		OrderSimpleInfoVO three=new OrderSimpleInfoVO("1234567890","南京","2015-10-9-11-23-12",DocType.inStoreDoc);
		OrderSimpleInfoVO four=new OrderSimpleInfoVO("1234567890","南京","2015-10-9-11-23-12",DocType.outStoreDoc);
		OrderSimpleInfoVO five=new OrderSimpleInfoVO("1234567890","南京","2015-10-9-11-23-12",DocType.arriveYYDoc);
		OrderSimpleInfoVO six=new OrderSimpleInfoVO("1234567890","王伟","2015-10-9-11-23-12",DocType.sendGoodDoc);
		
		info.add(one);

		info.add(two);
		info.add(three);
		info.add(four);
		info.add(five);
		info.add(six);
	
		return info;
		}
		else{
				ArrayList<OrderSimpleInfoVO> info=new ArrayList<>();
				OrderSimpleInfoVO one=new OrderSimpleInfoVO("1234567899","上海","2015-10-9-11-23-12",DocType.loadDoc);
				OrderSimpleInfoVO two=new OrderSimpleInfoVO("1234567899","上海","2015-10-9-11-23-12",DocType.arriveZZDoc);
				OrderSimpleInfoVO three=new OrderSimpleInfoVO("1234567899","上海","2015-10-9-11-23-12",DocType.inStoreDoc);
				OrderSimpleInfoVO four=new OrderSimpleInfoVO("1234567899","上海","2015-10-9-11-23-12",DocType.outStoreDoc);
				OrderSimpleInfoVO five=new OrderSimpleInfoVO("1234567899","上海","2015-10-9-11-23-12",DocType.arriveYYDoc);
				OrderSimpleInfoVO six=new OrderSimpleInfoVO("1234567899","王伟","2015-10-9-11-23-12",DocType.sendGoodDoc);
				
				info.add(one);
				info.add(two);
				info.add(three);
				info.add(four);
				info.add(five);
				info.add(six);
			
				return info;
		}
	

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
		ArrayList<PreReceiveVO> list=new ArrayList<PreReceiveVO>();
		PreReceiveVO one=new PreReceiveVO("1234567890", "南京大学2栋 axxx", "王二",null, null);
		PreReceiveVO two=new PreReceiveVO("1234567899", "复旦大学2栋 axxx", "凯二",null, null);
		list.add(one);
		list.add(two);
		return list;
	}

	@Override
	public DocVO getByID(String ID, DocType type) {
		// TODO Auto-generated method stub
		return null;
	}

}
