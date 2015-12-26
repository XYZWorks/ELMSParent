package bl.financebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.finance.CostPO;
import po.finance.FreightPO;
import po.finance.RentPO;
import po.finance.SalaryPO;
import test.java.other.VOPOchange;
import util.CostType;
import util.ResultMessage;
import vo.finance.CostVO;
import vo.finance.FreightVO;
import vo.finance.RentVO;
import vo.finance.SalaryVO;
import blservice.personnelblservice.Personnelblservice;
import blservice.strategyblservice.StrategyblService;
import blservice.transportblservice.Transportblservice;
import ds.financedataservice.FinanceDataService;

/**
 * @author ymc
 * @version 创建时间：2015年10月27日 下午7:46:21
 *
 */
public class Cost {
	FinanceDataService financeData;
	StrategyblService strategybl;
	Transportblservice transportbl;
	Personnelblservice personnelbl;

	public Cost(FinanceDataService financeDataService) {
		this.financeData = financeDataService;
	}

	public ArrayList<? extends CostVO> showCosts(CostType type) {

		ArrayList<CostVO> vos = null;
		ArrayList<? extends CostPO> pos = null;
		try {
			switch (type) {
			case FREIGHT:

				pos = financeData.show(CostType.FREIGHT);

				FreightPO fpo;
				FreightVO fvo;
				if (pos != null) {
					vos = new ArrayList<CostVO>(pos.size());
					for (int i = 0; i < pos.size(); i++) {
						fpo = (FreightPO) pos.get(i);
						fvo = (FreightVO) VOPOchange.POtoVO(fpo);
						vos.add(fvo);
					}

				}

				break;
			case RENT:
				pos = financeData.show(CostType.RENT);
				RentPO rpo;
				RentVO rvo;
				if (pos != null) {
					vos = new ArrayList<CostVO>(pos.size());
					for (int i = 0; i < pos.size(); i++) {
						rpo = (RentPO) pos.get(i);
						rvo = (RentVO) VOPOchange.POtoVO(rpo);
						vos.add(rvo);
					}

				}
				break;
			case SALARY:
				pos = financeData.show(CostType.SALARY);
				SalaryPO spo = null;
				SalaryVO svo = null;
				if (pos != null) {
					vos = new ArrayList<CostVO>(pos.size());
					for (int i = 0; i < pos.size(); i++) {
						spo = (SalaryPO) pos.get(i);
						svo = (SalaryVO) VOPOchange.POtoVO(spo);
						System.err.println(svo.ID);
						vos.add(svo);
					}

				}
				break;
			default:
				return null;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vos;
	}

	public ResultMessage add(CostVO vo) {
		CostPO po = null;
		switch (vo.costType) {
		
		case FREIGHT:
			po = (FreightPO) VOPOchange.VOtoPO(vo);
			break;
		case RENT:
			po = (RentPO) VOPOchange.VOtoPO(vo);
			break;
		case SALARY:
			po = (SalaryPO) VOPOchange.VOtoPO(vo);
			break;
		default:
			return ResultMessage.FAIL;
		}
		ResultMessage result = null;
		try {
			result = financeData.add(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ResultMessage modify(CostVO vo) {
		CostPO po = (CostPO) VOPOchange.VOtoPO(vo);
		ResultMessage result = null;
		try {
			result = financeData.modify(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ResultMessage del(CostVO vo) {

		ResultMessage result = null;
		try {
			result = financeData.del(vo.ID, vo.costType);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

}
