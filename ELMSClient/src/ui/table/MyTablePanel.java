package ui.table;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.tools.MyScrollerPane;
import util.MyDate;

/**
 * 
 * @author czq
 * @version 2015年12月3日 下午3:35:58
 */
@SuppressWarnings("serial")
public abstract class MyTablePanel extends JPanel {

	protected String[] columnNames;

	protected Object[][] data;

	protected MyTableModel dtm;

	protected MyTable table;

	protected MyScrollerPane rollpane;

	public MyTablePanel(Element config) {

		this.setBounds(Integer.parseInt(config.attributeValue("x")),
				Integer.parseInt(config.attributeValue("y")),
				Integer.parseInt(config.attributeValue("width")),
				Integer.parseInt(config.attributeValue("height")));
	}

	/**
	 * 更新表格信息
	 */
	public abstract void updateTableMes();

	/**
	 * 初始化列标题、 内容信息,注意，一定要检查从逻辑层读出的数据是否为空指针,避免空指针异常
	 * 
	 * @param config
	 */
	protected abstract void initialTitleAndColumn(Element config);

	/**
	 * 初始化表格
	 */
	protected abstract void initTable();

	/**
	 * 设置行宽,列宽
	 */
	protected void setRowAndColumnLen(int rowLen, int[] columnLen) {
		table.setRowHeight(rowLen);
		try {
			for (int i = 0; i < columnLen.length; i++) {
				table.getColumnModel().getColumn(i)
						.setPreferredWidth(columnLen[i]);
			}
		} catch (Exception e) {
			System.err.println("输入的表宽有误");
		}

	}

	protected void initScrollerPane() {
		dtm = table.getModel();
		rollpane = new MyScrollerPane(table);
		// this.add(table);
	}

	/**
	 * 注意！列数从0计
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	public Object getValueAt(int row, int col) {
		return table.getValueAt(row, col);
	}

	/**
	 * 获得选中的行，如果没有，返回-1
	 * 
	 * @return
	 */
	public int getSelectedRow() {
		return table.getSelectedRow();
	}

	/**
	 * 移除某一行，若无效，直接返回
	 * 
	 * @param row
	 */
	public void removeRow(int row) {
		try {
			dtm.removeRow(row);
		} catch (ArrayIndexOutOfBoundsException e) {
		}
	}

	public void setRowEdit(boolean flag, int row) {
		table.setRowEditable(flag, row);
	}

	/**
	 * 设置某一列可修改
	 * 
	 * @param flag
	 * @param column
	 */
	public void setColumnEdit(boolean flag, int column) {
		table.setColEditable(flag, column);
	}

	public MyTableModel getDtm() {
		return dtm;
	}

	public MyTable getTable() {
		return table;
	}

	public final static String[] getColumnName(String text) {
		return text.split(" ");
	}

	protected void initialTitleAndColumn(Element config, MyDate date) {
		// TODO Auto-generated method stub
		
	}

	

}
