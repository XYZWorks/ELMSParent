package bl.statisticbl;

import java.rmi.Remote;
import java.util.ArrayList;

import net.RMIManage;
import util.DataServiceType;
import util.ResultMessage;
import vo.statistic.BillVO;
import vo.statistic.CostIncomeVO;
import vo.statistic.StateFormVO;
import bl.BusinessController;
import blservice.statisticblservice.Statisticblservice;
import ds.statisticdataservice.StatisticDataService;
import exception.ExceptionHandler;
 /** 
 * 经营状况表、成本收益表、期初建账控制器
 * @author czq 
 * @version 2015年11月15日 上午9:24:59 
 */
public class StatisticController extends BusinessController implements Statisticblservice{
	
	private Statistic statistic;
	private StatisticDataService statisticData;
	public StatisticController(){
		myType = DataServiceType.StatisticDataService;
		statisticData = (StatisticDataService) RMIManage.getDataService(DataServiceType.StatisticDataService);
		statistic = new Statistic(statisticData);
	}
	@Override
	public ResultMessage bulidStateForm(StateFormVO vo) {
		try {
			return statistic.bulidStateForm(vo);
		} catch (Exception e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				try {
					return statistic.bulidStateForm(vo);
				} catch (Exception e1) {}
			}
		}return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage bulidCostIncomeForm(CostIncomeVO vo) {
		try {
			return statistic.bulidCostIncomeForm(vo);
		} catch (Exception e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				try {
					return statistic.bulidCostIncomeForm(vo);
				} catch (Exception e1) {}
			}
		}return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<StateFormVO> getStateForm() {
		try {
			return statistic.getStateForm();
		} catch (Exception e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				try {
					return statistic.getStateForm();
				} catch (Exception e1) {}
			}
		}return null;
	}

	@Override
	public ArrayList<CostIncomeVO> getIncomeForm() {
		try {
			return statistic.getIncomeForm();
		} catch (Exception e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				try {
					return statistic.getIncomeForm();
				} catch (Exception e1) {}
			}
		}return null;
	}

	@Override
	public ResultMessage bulidBill(BillVO vo) {
		try {
			return statistic.bulidBill(vo);
		} catch (Exception e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				try {
					return statistic.bulidBill(vo);
				} catch (Exception e1) {}
			}
		}return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<BillVO> getBills() {
		try {
			return statistic.getBills();
		} catch (Exception e) {
			if(ExceptionHandler.myExceptionHandler(myType, this)){
				try {
					return statistic.getBills();
				} catch (Exception e1) {}
			}
		}return null;
	}
	@Override
	public void reinitDataService(Remote dataService) {
		statisticData = (StatisticDataService) dataService;
		statistic = new Statistic(statisticData);
		
	}

}
