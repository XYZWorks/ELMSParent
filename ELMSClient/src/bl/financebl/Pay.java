package bl.financebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.finance.PayPO;
import test.java.other.VOPOchange;
import util.ResultMessage;
import vo.finance.PayVO;
import ds.financedataservice.FinanceDataService;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:47:03 
 *
 */
public class Pay {
	private FinanceDataService financeds;
	public Pay(FinanceDataService financeDataService) {
		this.financeds = financeDataService;
	}

	public ResultMessage create(PayVO vo) throws RemoteException {
		PayPO po = (PayPO) VOPOchange.VOtoPO(vo);
		
			return financeds.addPay(po);
	}

	public ArrayList<PayVO> showPays() throws RemoteException {
		ArrayList<PayPO> pos = null;
			pos = financeds.getPayPO();
		
		if(pos == null){
			return null;
		}
		
		ArrayList<PayVO> vos = new ArrayList<>(pos.size());
		
		for (PayPO payPO : pos) {
			vos.add((PayVO) VOPOchange.POtoVO(payPO));
		}
		return vos;
	}

}
