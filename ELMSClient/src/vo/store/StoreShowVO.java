package vo.store;

import java.util.ArrayList;

import bl.orderbl.orderbl_stub;
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
	
}
