package ui.table;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
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
		r.setHorizontalAlignment(SwingConstants.CENTER);   
		setDefaultRenderer(String.class,   r);
		
		
		
		//不允许修改列宽
		getTableHeader().setResizingAllowed(false);
		getTableHeader().setReorderingAllowed(false);

		
		
	}
	public MyTable(MyTableModel model ) {
		this.model = model;
		this.setModel(model);
		
		
		
	}
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
//	public void setColEditable(boolean flag ,int column){
//		model.setCellInColumEdit(flag, column);
//		revalidate();
//	}
//	public void setRowEditable(boolean flag ,int row){
//		model.setCellInRowEdit(flag, row);
//		revalidate();
//	}
	
	
	@Override
	public MyTableModel getModel() {
		return model;
	}
	
}



