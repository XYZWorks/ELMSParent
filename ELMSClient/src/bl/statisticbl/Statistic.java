package bl.statisticbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import po.finance.PayPO;
import po.statistic.BillPO;
import po.statistic.CostIncomePO;
import po.statistic.StateFormPO;
import po.transport.PayDocPO;
import util.MyDate;
import util.ResultMessage;
import vo.finance.PayVO;
import vo.statistic.BillVO;
import vo.statistic.CostIncomeVO;
import vo.statistic.StateFormVO;
import vo.transport.PayDocVO;
import ds.statisticdataservice.StatisticDataService;

/**
 * @author ymc
 * @version 创建时间：2015年10月27日 下午7:49:05
 *
 */
public class Statistic {
	private StatisticDataService statisticData;

	public Statistic(StatisticDataService statisticData) {
		this.statisticData = statisticData;
	}

	public ResultMessage bulidStateForm(StateFormVO vo) throws RemoteException {
		StateFormPO po = (StateFormPO) VOPOchange.VOtoPO(vo);
		return statisticData.bulidStateForm(po);
	}

	public ResultMessage bulidCostIncomeForm(CostIncomeVO vo)
			throws RemoteException {

		CostIncomePO po = (CostIncomePO) VOPOchange.VOtoPO(vo);

		return statisticData.CostIncomeForm(po);
	}

	public ArrayList<StateFormVO> getStateForm() throws RemoteException {

		ArrayList<StateFormPO> pos = new ArrayList<StateFormPO>();

		pos = statisticData.getStateForm();
		if (pos == null) {
			return null;
		}

		ArrayList<StateFormVO> vos = new ArrayList<StateFormVO>(pos.size());

		for (StateFormPO po : pos) {
			vos.add((StateFormVO) VOPOchange.POtoVO(po));
		}
		return vos;
	}

	public ArrayList<CostIncomeVO> getIncomeForm() throws RemoteException {

		ArrayList<CostIncomePO> pos = new ArrayList<CostIncomePO>();

		pos = statisticData.getCostIncomeForm();

		if (pos == null) {
			return null;
		}
		ArrayList<CostIncomeVO> vos = new ArrayList<CostIncomeVO>(pos.size());
		for (CostIncomePO po : pos) {
			vos.add((CostIncomeVO) VOPOchange.POtoVO(po));
		}
		return vos;
	}

	public ResultMessage bulidBill(BillVO vo) throws RemoteException {
		BillPO po = (BillPO) VOPOchange.VOtoPO(vo);

		return statisticData.bulidBill(po);
	}

	public ArrayList<BillVO> getBills() throws RemoteException {

		ArrayList<BillPO> pos = new ArrayList<BillPO>();

		pos = statisticData.getBills();

		if (pos == null) {
			return null;
		}
		ArrayList<BillVO> vos = new ArrayList<BillVO>(pos.size());
		for (BillPO po : pos) {
			vos.add((BillVO) VOPOchange.POtoVO(po));
		}
		return vos;
	}

	public ArrayList<PayDocVO> getDatePayDocs(MyDate start, MyDate end)
			throws RemoteException {

		ArrayList<PayDocPO> pos = null;
		pos = statisticData.getDatePayDocs(start, end);
		if (pos != null) {
			ArrayList<PayDocVO> vos = new ArrayList<>(pos.size());
			for (PayDocPO payDocPO : pos) {
				vos.add((PayDocVO) VOPOchange.POtoVO(payDocPO));
			}
			return vos.isEmpty() ? null : vos;
		}

		return null;
	}

	public ArrayList<PayVO> getDatePays(MyDate start, MyDate end)
			throws RemoteException {
		ArrayList<PayPO> pos = null;
		pos = statisticData.getDatePays(start, end);

		if (pos == null) {
			return null;
		}

		ArrayList<PayVO> vos = new ArrayList<>(pos.size());

		for (PayPO payPO : pos) {
			vos.add((PayVO) VOPOchange.POtoVO(payPO));
		}
		return vos;
	}

}
