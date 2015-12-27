package bl.financebl;

import vo.finance.ProfitVO;
import ds.financedataservice.FinanceDataService;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:47:28 
 *
 */
public class Profit {
	FinanceDataService financeDate;
	public Profit(FinanceDataService financeDataService) {
		this.financeDate = financeDataService;
	}
	public ProfitVO getMessage() {
		return null;
	}

}
