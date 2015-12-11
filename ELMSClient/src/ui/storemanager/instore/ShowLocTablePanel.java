package ui.storemanager.instore;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JScrollPane;

import org.dom4j.Element;

import ui.config.UserfulMethod;
import ui.table.MyTable;
import ui.table.MyTablePanel;
import ui.tools.MyButton;
import ui.tools.MyLabel;
import util.MyDate;
import vo.store.InStoreDocVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月8日 上午11:12:09 
 *
 */
public class ShowLocTablePanel extends MyTablePanel {
	
	private static final int COLUMN_NUM = 5;

//	private static final int ROW_NUM = 15;
	
	ArrayList<String> orders;
	
	ArrayList<String> locs;
	
	public ShowLocTablePanel(Element config) {
		
		super(config);
		initialTitleAndColumn(config);
		initTable();
		initScrollerPane();
		this.add(rollpane);
		int[] columnLen = { 330, 100, 100, 100, 100 };
		this.setRowAndColumnLen(30, columnLen);
	
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
		// TODO Auto-generated method stub
		table = new MyTable(columnNames, data);

	}

	public void reset() {
		//清空table
		for(int i = 0;i<table.getRowCount();i++){
			for(int j = 0;j<COLUMN_NUM ; j++)
				table.setValueAt("", i, j);
		}
		
		//将增加table的行数
		Object[] tmp = {"","","","",""};	
		for(int i = table.getRowCount();i<orders.size();i++)
			addOneRow(tmp);
		
		data = new String[orders.size()][COLUMN_NUM];
		for(int i = 0;i<orders.size();i++){
			data[i][0] = orders.get(i);
			String[] sp1 = locs.get(i).split("区");
			data[i][1] = sp1[0]+"区";
			String[] sp2 = sp1[1].split("排");
			data[i][2] = sp2[0]+"排";
			String[] sp3 = sp2[1].split("架");	
			data[i][3] = sp3[0]+"架";
			data[i][4] = sp3[1];
		}
		for(int i = 0;i<orders.size();i++){
			for(int j = 0;j<COLUMN_NUM ; j++)
				table.setValueAt(data[i][j], i, j);
		}
		
	}

}
