package ui.table;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
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
	 * 表格模型
	 */
	MyTableModel model;
	
	public MyTable(String[] columnNames ,Object[][] data) {
		this.model = new MyTableModel(columnNames, data);
		
		this.setModel(model);
		DefaultTableCellRenderer   r   =   new   DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		setDefaultRenderer(Object.class,   r);
		setPreferredScrollableViewportSize(new Dimension(400, 200));//TODO
		
		
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



@SuppressWarnings("serial")
class MyTableModel extends DefaultTableModel{
	
	/**
	 * 标题
	 */
	String[] headers;
	/**
	 * 表格值
	 */
	Object[][] values;
	
	boolean[][] isCellEditable;
	
	public MyTableModel(Object[] headers , Object[][] data) {
		super(data, headers);
		
		
		
		
		isCellEditable = new boolean[data.length][data[0].length];
		for (int i = 0; i < isCellEditable.length; i++) {
			for (int j = 0; j < isCellEditable[0].length; j++) {
				isCellEditable[i][j] = false;
			}
			
		}
		
	}
	
	
	

	

	public Class<?> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	
	/**
	 * 设置某一列可否编辑
	 * @param flag
	 * @param column
	 */
	public void setCellInColumEdit(boolean flag , int column){
		for (int i = 0; i < isCellEditable.length; i++) {
			isCellEditable[i][column] = flag;
		}
		
	}
	public void setCellInRowEdit(boolean flag , int row){
		for (int i = 0; i < isCellEditable[0].length; i++) {
			isCellEditable[row][i] = flag;
		}
		
	}
	
	
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
	      return isCellEditable[rowIndex][columnIndex];
	}
	
	
}
