package ui.generalmanager.statistic;

import java.util.ArrayList;

import org.dom4j.Element;

import ui.table.MyTablePanel;
import vo.finance.DepositVO;
import vo.finance.PayVO;
 /** 
 * 经营状况表详细信息,包括 所有的收款付款信息
 * @author czq 
 * @version 2015年12月6日 下午12:02:30 
 */
@SuppressWarnings("serial")
public class StateFormDetailPanel extends MyTablePanel {
	
	private ArrayList<PayVO> payVOs;
	
	private ArrayList<DepositVO> depositVOs;
	
	public StateFormDetailPanel(Element config) {
		super(config);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateTableMes() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initTable() {
		// TODO Auto-generated method stub

	}

}
