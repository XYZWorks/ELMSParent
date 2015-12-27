package ui.tools;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
 /** 
 * 所有表格的实现父类
 * @author czq 
 * @version 2015年11月22日 下午11:25:15 
 */
@SuppressWarnings("serial")
public class MyTable extends JTable {
	/**
	 * 
	 */
	DefaultTableModel tm = new DefaultTableModel();
	
	
	
	
	
	
	
	
	/**
	 * 不允许修改表格内容
	 */
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
}
