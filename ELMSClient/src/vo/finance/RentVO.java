package vo.finance;

import util.CostType;
import util.MyDate;

/**
 * 租金信息
 * @author ymc
 *
 */
public class RentVO extends CostVO {
	public RentVO() {
		// TODO Auto-generated constructor stub
	}

	
	public RentVO(String ID,MyDate startDate, MyDate endDate, int money, CostType costType) {
		super(ID, startDate, endDate, money,costType);
	}

}
