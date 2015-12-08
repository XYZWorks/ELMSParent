package ui.storemanager.instore;

import java.util.ArrayList;

import org.dom4j.Element;

import ui.table.MyTable;
import ui.table.MyTablePanel;

/**
 * @author ymc
 * @version 创建时间：2015年12月8日 上午10:15:27
 *
 */
public class AddLocTablePanel extends MyTablePanel {

	private static final int COLUMN_NUM = 5;

	private static final int ROW_NUM = 15;

	private ArrayList<String> orders;

	private ArrayList<String> locs;

	public AddLocTablePanel(Element config) {
		super(config);
		initialTitleAndColumn(config);
		initTable();
		initScrollerPane();
		this.add(rollpane);
		initOther();

	}

	private void initOther() {

		int[] columnLen = { 330, 100, 100, 100, 100 };
		this.setRowAndColumnLen(30, columnLen);

		for (int i = 0; i < ROW_NUM; i++){
			this.setRowEdit(true, i);
		}
		
		for (int i = 0; i < COLUMN_NUM; i++) {
			this.setColumnEdit(true, i);
		}
	}

	@Override
	public void updateTableMes() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = getColumnName(config.attributeValue("columnName"));

	}

	@Override
	protected void initTable() {
		data = new String[ROW_NUM][COLUMN_NUM];
		for (int i = 0; i < ROW_NUM; i++) {
			for (int j = 0; j < COLUMN_NUM; j++) {
				data[i][j] = "";
			}
		}
		

		table = new MyTable(columnNames, data);

	}
	
	public void resetData() {
		for (int i = 0; i < ROW_NUM; i++) {
			for (int j = 0; j < COLUMN_NUM; j++) {
				table.setValueAt("", i, j);
			}
		}
		
	}

	public ArrayList<String> getOrders() {
		ArrayList<String> orders = new ArrayList<>();
		int i = 0;
		String tmp="";
		while ((tmp = (String)getValueAt(i, 0)).length()>0){
			orders.add(tmp);
			i++;
			
		}
		return orders;
	}

	public ArrayList<String> getLocations() {
		ArrayList<String> locations = new ArrayList<>();
		int i = 0;
		String tmp="";
		while ((tmp = (String)getValueAt(i, 1)).length()>0){

			locations.add(tmp+"区"+(String)getValueAt(i, 2)+"排"+(String)getValueAt(i, 3)+"架"+(String)getValueAt(i, 4)+"位");
			i++;
		}
		
		return locations;
	}
}
