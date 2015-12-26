package vo.store;

import java.util.ArrayList;

import util.City;
import util.TransferWay;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月23日 下午8:51:57 
 *
 */
public class StoreShowVO {
	/**
	 * 所在城市
	 */
	public City location;
	/**
	 * 区位置
	 */
	public TransferWay storeLoc;

	/**
	 * 库存数量
	 */
	public int number;
	/**
	 * 库存总容量
	 */
	public int totalNum;
	/**
	 * 入库单集合
	 */
	public ArrayList<String> inStoreDocs;
	
	/**
	 * 出库单集合
	 */
	public ArrayList<String> outStoreDocs;
	/**
	 * 
	 */
	public ArrayList<String> orders;
	/**
	 * 
	 */
	public ArrayList<String> locs;
	/**
	 * 
	 */
	public StoreShowVO() {
		inStoreDocs = new ArrayList<>();
		outStoreDocs = new ArrayList<>();
		orders = new ArrayList<>();
		locs = new ArrayList<>();
	}
	public StoreShowVO(City location, TransferWay storeLoc, int number, int totalNum, ArrayList<String> inStoreDocs,
			ArrayList<String> outStoreDocs, ArrayList<String> orders, ArrayList<String> locs) {
		super();
		this.location = location;
		this.storeLoc = storeLoc;
		this.number = number;
		this.totalNum = totalNum;
		this.inStoreDocs = inStoreDocs;
		this.outStoreDocs = outStoreDocs;
		this.orders = orders;
		this.locs = locs;
	}
	public static StoreShowVO getStoreShow(StoreMessageVO vo){
		StoreShowVO storevo = new StoreShowVO();
		
		storevo.location = vo.location;
		storevo.number = vo.number;
		storevo.totalNum = vo.totalNum;
		storevo.storeLoc = vo.storeLoc;
		for (int i = 0; i < vo.inStoreDocs.size(); i++) {
			storevo.inStoreDocs.add(vo.inStoreDocs.get(i).ID);
		}
		for (int i = 0; i < vo.outStoreDocs.size(); i++) {
			storevo.outStoreDocs.add(vo.outStoreDocs.get(i).ID);
		}
		getOrders(vo.inStoreDocs, vo.outStoreDocs, storevo);
		
		
		return storevo;
	}
	
	private static boolean hasOut(String ord,ArrayList<String> ordertmp) {
		
		for(String tmp : ordertmp){
			if(ord.equals(tmp)){
				return true;
			}
		}
			
		return false;
	}
	
	public static void getOrders(ArrayList<InStoreDocVO> ins,ArrayList<OutStoreDocVO> outs,StoreShowVO storevo){
		ArrayList<String> ordertmp = new ArrayList<>();
		//得到出库单中的订单号
		for(OutStoreDocVO out : outs){
			for(String order : out.orders)
				ordertmp.add(order);
		}
		
		//将已经出库的订单从订单列表删除
		for(InStoreDocVO in : ins){
			for(int i =0;i<in.orders.size();i++){
				if(hasOut(in.orders.get(i),ordertmp)){
					continue;
				}
				
				storevo.orders.add(in.orders.get(i));
				storevo.locs.add(in.location.get(i));
				
			}
		}
	}
}
