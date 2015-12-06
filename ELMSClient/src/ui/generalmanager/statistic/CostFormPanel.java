package ui.generalmanager.statistic;

import java.util.ArrayList;

import org.dom4j.Element;

import po.statistic.CostIncomePO;
import blservice.statisticblservice.Statisticblservice;
import ui.table.MyTablePanel;
import vo.statistic.CostIncomeVO;
 /** 
 * 成本收益表
 * @author czq 
 * @version 2015年12月6日 上午11:34:35 
 */
@SuppressWarnings("serial")
public class CostFormPanel extends MyTablePanel{
	
	private Statisticblservice bl;
	
	private ArrayList<CostIncomeVO> vos;
	
	public CostFormPanel(Element config , Statisticblservice bl) {
		super(config);
		this.bl = bl;
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
