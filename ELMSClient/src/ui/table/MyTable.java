package ui.table;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.dom4j.Element;

import ui.user.MyTableModel;
 /** 
 * 表格类
 * @author czq 
 * @version 2015年12月2日 下午11:11:18 
 */
@SuppressWarnings("serial")
public class MyTable extends JTable{
	
	
	/**
	 * 表格模型
	 */
	MyTableModel model;
	
	public MyTable(String[] columnNames ,Object[][] data) {
		this.model = new MyTableModel(columnNames, data);
		
		this.setModel(model);
		DefaultTableCellRenderer   r   =   new   DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		setDefaultRenderer(Object.class,   r);
//		setPreferredScrollableViewportSize(new Dimension(400, 200));//TODO
		
		
	}
	public MyTable(MyTableModel model ) {
		this.model = model;
		this.setModel(model);
		
		
		
	}
	
	
	public void setColEditable(boolean flag ,int column){
		model.setCellInColumEdit(flag, column);
		revalidate();
	}
	public void setRowEditable(boolean flag ,int row){
		model.setCellInRowEdit(flag, row);
		revalidate();
	}
	
	
	public MyTableModel getModel() {
		return model;
	}
	
}



