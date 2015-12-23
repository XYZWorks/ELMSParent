package bl.financebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.orderblservice.Orderblservice;
import ds.financedataservice.FinanceDataService;
import po.finance.DepositPO;
import test.java.other.VOPOchange;
import util.ResultMessage;
import vo.finance.DepositVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年10月27日 下午7:46:46 
 *
 */
public class Deposit {
	FinanceDataService financeData;
	Orderblservice orderbl;
	public Deposit(FinanceDataService financeDataService) {
		this.financeData = financeDataService;
	}

	public ResultMessage create(DepositVO vo) {
		DepositPO po = (DepositPO) VOPOchange.VOtoPO(vo);
		try {
			return financeData.addDeposit(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	} 

	public ArrayList<DepositVO> show() {
		ArrayList<DepositPO> pos = new ArrayList<>();
		ArrayList<DepositVO> vos = null;
		try {
			pos = financeData.getDepositPO();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(pos!=null){
			vos = new ArrayList<>(pos.size());
			for(DepositPO po: pos){
				vos.add((DepositVO)VOPOchange.POtoVO(po));
			}
		}
		return vos;
	}

}
