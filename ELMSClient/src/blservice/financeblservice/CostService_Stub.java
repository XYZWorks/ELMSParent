package blservice.financeblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ds.financedataservice.FinanceDataService;
import po.finance.CostPO;
import util.CostType;
import util.ResultMessage;
import vo.finance.CostVO;
/**
 * 成本信息管理接口
 * @author ymc
 *
 */
public class CostService_Stub implements CostService {
	FinanceDataService financeDS;
	
	public ArrayList<CostVO> showCosts() {
		ArrayList<CostVO> vos = null;
		try {
			ArrayList<CostPO> pos=(ArrayList<CostPO>) financeDS.show(null);
			vos = new ArrayList<CostVO>();
			if(pos!=null)
				for(CostPO po:pos){
					vos.add(getValue(po));
				}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vos;
	}

	@Override
	public ResultMessage add(CostVO vo) {
		
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modify(CostVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage del(CostVO vo) {
		return ResultMessage.SUCCESS;
	}
	private  CostVO getValue(CostPO po){
//		CostVO vo = new CostVO(null, null, null, po.getMoney(), po.getCostType());
		
		return null;
		
	}

	@Override
	public ArrayList<? extends CostVO> showCosts(CostType type) {
		// TODO Auto-generated method stub
		return null;
	} 

}
