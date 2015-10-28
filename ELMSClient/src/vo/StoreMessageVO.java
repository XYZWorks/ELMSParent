package vo;

import java.util.ArrayList;

/**
 * 库存信息VO
 * @author ymc
 *
 */
public class StoreMessageVO {
	/**
	 * 所在城市
	 */
	public String location;
	/**
	 * 库存数量
	 */
	public int number;
	/**
	 * 入库单集合
	 */
	public ArrayList<InStoreDocVO> inStoreDocs;
	/**
	 * 出库单集合
	 */
	public ArrayList<OutStoreDocVO> OutStoreDocs;
	/**
	 * 
	 * @param location
	 * @param number
	 * @param inStoreDocs
	 * @param outStoreDocs
	 */
	public StoreMessageVO(String location, int number, ArrayList<InStoreDocVO> inStoreDocs,
			ArrayList<OutStoreDocVO> outStoreDocs) {
		super();
		this.location = location;
		this.number = number;
		this.inStoreDocs = inStoreDocs;
		OutStoreDocs = outStoreDocs;
	}

	
	
}
