package po.finance;

import java.io.Serializable;

import util.CostType;
import util.MyDate;

/**
 *租金成本信息
 *@author ymc
 *
 */
public class RentPO extends CostPO implements Serializable{
	
	
	
	/**
	 * 序列化UID
	 */
	private static final long serialVersionUID = 1L;
	
	public RentPO() {}
	
	public RentPO(MyDate startDate, MyDate endDate, int money, CostType costType) {
		super(startDate, endDate, money,costType);
	}

}
