package ui.generalmanager.statistic;

import java.util.ArrayList;

import org.dom4j.Element;

import ui.table.MyTable;
import ui.table.MyTablePanel;
import util.MyDate;
import vo.statistic.CostIncomeVO;
import blservice.statisticblservice.Statisticblservice;
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
		initialTitleAndColumn(config);
		initTable();
		initScrollerPane();
		this.add(rollpane);
	}

	@Override
	public void updateTableMes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = config.attributeValue("column").split(" ");
		
		vos = bl.getIncomeForm();
		if(vos != null){
			
			for (int i = 0; i < vos.size(); i++) {
				
				data[i][0] = MyDate.toString(vos.get(i).startDate);
				data[i][1] = MyDate.toString(vos.get(i).endDate);
				data[i][2] = String.valueOf(vos.get(i).income);
				data[i][3] = String.valueOf(vos.get(i).expense);
			}
			
			
		}
		
		
		
	}

	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data);
		
	}

}
