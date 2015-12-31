package bl.orderbl;

import java.util.ArrayList;

import blservice.orderblservice.Orderblservice;
import po.order.GoodMes;
import po.order.OtherOrderMes;
import po.order.PeopleMes;
import po.order.TransferDocs;
import util.City;
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
		PeopleMes sender1=new PeopleMes("王二","13390949086","复旦大学", "上海市杨浦区23花园230xxxxxxxxxxxxxxxxxxxxfsdfsdfsxxxxxxxxxx");
		PeopleMes receiver1=new PeopleMes("李四","13049030987","南京大学", "南京市鼓楼区34花园394");
        GoodMes goodMes1=new GoodMes(1, "服装", 0.2, 20, 20, 20);
        OtherOrderMes otherMes1=new OtherOrderMes("快递袋", "普通快递", null, 2, 10,null, null);
        ArrayList<String> bar=new ArrayList<String>();
        bar.add("A1");
        bar.add("A2");
        bar.add("A1");
        bar.add("A2");
        bar.add("A1");
        bar.add("A2");
        TransferDocs transferDocs1=new TransferDocs(null, null, null, null, null, null, null, null, null,orderBarCode, bar);
		OrderVO one=new OrderVO("1234567890",DocType.order,new MyDate(2015, 12, 21),DocState.wait,sender1,receiver1,goodMes1,otherMes1,transferDocs1);
		return one;
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

	@Override
	public ArrayList<OrderVO> getOrderVO(MyDate date) {
		System.out.println("enter!!");
		
		
		ArrayList<OrderVO> order =new ArrayList<OrderVO>();
		PeopleMes sender1=new PeopleMes("王二","13390949086","复旦大学", "上海市杨浦区23花园230");
		PeopleMes receiver1=new PeopleMes("李四","13049030987","南京大学", "南京市鼓楼区34花园394");
        GoodMes goodMes1=new GoodMes(1, "服装", 0.2, 20, 20, 20);
        OtherOrderMes otherMes1=new OtherOrderMes("快递袋", "普通快递", date, 2, 10,null, null);
        
        ArrayList<String> bar=new ArrayList<String>();
        bar.add("A1");
        bar.add("A2");
        bar.add("A1");
        bar.add("A2");
        bar.add("A1");
        bar.add("A2");
        
        
        TransferDocs transferDocs1=new TransferDocs(null, null, null, null, null, null, null, null, null, null, bar);
		OrderVO one=new OrderVO("1234567890",DocType.order,new MyDate(2015, 12, 21),DocState.wait,sender1,receiver1,goodMes1,otherMes1,transferDocs1);
		
		
		
		PeopleMes sender=new PeopleMes("王二","13390949086","复旦大学", "上海市杨浦区23花园230");
		PeopleMes receiver=new PeopleMes("李四","13049030987","南京大学", "南京市鼓楼区34花园394");
        GoodMes goodMes=new GoodMes(1, "服装", 0.2, 20, 20, 20);
        OtherOrderMes otherMes=new OtherOrderMes("快递袋", "普通快递", date, 2, 10,null, null);
        ArrayList<String> bar2=new ArrayList<String>();
        bar.add("A1");
        bar.add("A2");
        bar.add("A1");
        bar.add("A2");
        bar.add("A1");
        bar.add("A2");
        TransferDocs transferDocs=new TransferDocs(null, null, null, null, null, null, null, null, null,null, bar2);
		OrderVO two=new OrderVO("1234567899",DocType.order,new MyDate(2015, 12, 23),DocState.wait,sender,receiver,goodMes,otherMes,transferDocs);
	
		order.add(one);
		order.add(two);
		return order;
	}

	@Override
	public double getEstiDate(City one, City two) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultMessage setEstiDate(double day, City one, City two) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	@Override
	public int getDayDocCount(DocType type) {
		// TODO Auto-generated method stub
		return 0;
	}

}
