package vo.finance;

import util.CostType;
import util.MyDate;

/**
 * 运费信息
 * @author ymc
 *
 */
public class FreightVO extends CostVO {
	public FreightVO() {
	}

	
	public FreightVO(String ID,MyDate startDate, MyDate endDate, int money, CostType costType) {
		super(ID, startDate, endDate, money, costType);
	}

}
