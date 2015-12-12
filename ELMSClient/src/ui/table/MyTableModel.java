package ui.table;

import javax.swing.table.DefaultTableModel;
import javax.xml.transform.Templates;

@SuppressWarnings("serial")
public class MyTableModel extends DefaultTableModel {

	/**
	 * 标题
	 */
	String[] headers;
	/**
	 * 表格值
	 */
	Object[][] values;

	boolean[][] isCellEditable; // TODO 動態的改變表格時會出現越界異常，待處理

	public MyTableModel(Object[] headers, Object[][] data) {
		super(data, headers);

		if(data == null||data.length==0){
			return;
		}
//		System.out.println(data.length);
		isCellEditable = new boolean[data.length][data[0].length];
		for (int i = 0; i < isCellEditable.length; i++) {
			for (int j = 0; j < isCellEditable[0].length; j++) {
				isCellEditable[i][j] = false;
			}

		}

	}

	public Class<?> getColumnClass(int c) {
		Class<?> temp = null; 
		
		try{
			temp =  getValueAt(0, c).getClass();
		}
		catch(Exception e){
			return String.class;
		}
		return temp;
	}

	/**
	 * 设置某一列可否编辑
	 * 
	 * @param flag
	 * @param column
	 */
	public void setCellInColumEdit(boolean flag, int column) {
		for (int i = 0; i < isCellEditable.length; i++) {
			isCellEditable[i][column] = flag;
		}

	}

	public void setCellInRowEdit(boolean flag, int row) {
		for (int i = 0; i < isCellEditable[0].length; i++) {
			isCellEditable[row][i] = flag;
		}

	}
	
	public void setCellEdit(boolean flag ,int row , int col){
		isCellEditable[row][col] = flag;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return isCellEditable[rowIndex][columnIndex];
	}

}
