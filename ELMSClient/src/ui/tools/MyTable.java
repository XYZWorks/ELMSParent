package ui.tools;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import org.dom4j.Element;
 /** 
 * 表格类
 * @author czq 
 * @version 2015年12月2日 下午11:11:18 
 */
@SuppressWarnings("serial")
public class MyTable extends JTable{
	/**
	 * 标题
	 */
	Object[] headers;
	/**
	 * 表格值
	 */
	Object[][] values;
	
	/**
	 * 表格模型
	 */
	MyTableModel model;
	
	public MyTable(Element e) {
		headers = e.attributeValue("headers").split(" ");
		
		
		
		
	}
	
	
}



@SuppressWarnings("serial")
class MyTableModel extends AbstractTableModel{
	
	public MyTableModel() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	

	public String getColumnName(int col) {
//		return n[col];
		return null;
	}

	

	public Class<?> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	
	
	
	
	
}
