package bl.strategybl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import net.RMIManage;
import util.DataServiceType;
import util.ResultMessage;
import util.StaffType;
import vo.strategy.ConstVO;
import vo.strategy.EstiDateVO;
import vo.strategy.SalaryWayVO;
import bl.BusinessController;
import blservice.strategyblservice.StrategyblService;
import ds.strategydataservice.StrategyDataService;
import exception.ExceptionHandler;

/**
 * 
 * @author czq
 * @version 2015年11月15日 上午9:26:46
 */
public class StrategyController extends BusinessController implements
		StrategyblService {

	private Strategy strategy;
	private StrategyDataService strategyData;

	public StrategyController() {
		strategyData = (StrategyDataService) RMIManage
				.getDataService(DataServiceType.StrategyDataService);
		strategy = new Strategy(strategyData);
	}

	@Override
	public ConstVO getConst() {

		try {
			return strategy.getConst();
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return getConst();
			}
		}
		return null;
	}

	@Override
	public ResultMessage setConst(ConstVO vo) {
		try {
			return strategy.setConst(vo);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return setConst(vo);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<SalaryWayVO> getsalary() {
		try {
			return strategy.getsalary();
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return getsalary();
			}
		}
		return null;
	}

	@Override
	public SalaryWayVO getOneSalary(StaffType type) {
		try {
			return strategy.getOneSalary(type);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return getOneSalary(type);
			}
		}
		return null;
	}

	@Override
	public ResultMessage setSalary(SalaryWayVO way) {
		try {
			return strategy.setSalary(way);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return setSalary(way);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public EstiDateVO getEstiDateVO() {
		try {
			return strategy.getEstiDateVO();
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return getEstiDateVO();
			}
		}
		return null;
	}

	@Override
	public ResultMessage setEstiDateVO(EstiDateVO vo) {
		try {
			return strategy.setEstiDateVO(vo);
		} catch (RemoteException e) {
			if (ExceptionHandler.myExceptionHandler(myType, this)) {
				return setEstiDateVO(vo);
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public void reinitDataService(Remote dataService) {
		strategyData = (StrategyDataService) dataService;
		strategy = new Strategy(strategyData);
	}

}
