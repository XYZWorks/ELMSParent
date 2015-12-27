package bl.financebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import blservice.orderblservice.Orderblservice;
import ds.financedataservice.FinanceDataService;
import po.finance.DepositPO;
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

	public ResultMessage create(DepositVO vo) throws RemoteException {
		DepositPO po = (DepositPO) VOPOchange.VOtoPO(vo);
			return financeData.addDeposit(po);
	} 

	public ArrayList<DepositVO> show() throws RemoteException {
		ArrayList<DepositPO> pos = new ArrayList<>();
		ArrayList<DepositVO> vos = null;
			pos = financeData.getDepositPO();
		
		if(pos!=null){
			vos = new ArrayList<>(pos.size());
			for(DepositPO po: pos){
				vos.add((DepositVO)VOPOchange.POtoVO(po));
			}
		}
		return vos;
	}

}
