package bl.financebl;

import vo.finance.ProfitVO;
import ds.financedataservice.FinanceDataService;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:47:28 
 *
 */
public class Profit {
	FinanceDataService financebl;
	public Profit(FinanceDataService financeDataService) {
		this.financebl = financeDataService;
	}
	public ProfitVO getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
