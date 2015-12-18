package ui.financeman.bulidBill;

import org.dom4j.Element;

import blservice.statisticblservice.Statisticblservice;
import ui.table.MyTable;
import ui.table.MyTablePanel;
import vo.statistic.BillVO;
 /** 
 * 期初建账主界面信息表格
 * @author czq 
 * @version 2015年12月7日 下午9:07:47 
 */
@SuppressWarnings("serial")
public class MainTable extends MyTablePanel{
	
	private static final int COLUMN_NUMS = 5;
	
	private BulidBillPanel mainPanel;
	private Statisticblservice bl;
	private BillVO vo;
	
	public MainTable(Element config ,BulidBillPanel mainPanel) {
		super(config);
		this.mainPanel = mainPanel;
		this.bl = mainPanel.bl;
		initialTitleAndColumn(config);
		initTable();
		initScrollerPane();
		add(rollpane);
	}

	

	@Override
	public void updateTableMes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = MyTablePanel.getColumnName(config.attributeValue("column"));
		
		
		
		
		
		
	}

	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data);
	}

}
