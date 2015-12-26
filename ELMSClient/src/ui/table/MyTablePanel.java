package ui.table;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.dom4j.Element;

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

	protected JScrollPane rollpane;
	
	private Element config;
	
	protected final static String columnStr = "column";

	public MyTablePanel(Element config) {
		this.config = config;
		this.setLayout(null);
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
		rollpane = new JScrollPane(table);
		rollpane.setBounds(0, 0, getWidth(), getHeight());
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

	/**
	 * 通过ID查找信息
	 * @param id
	 */
	public void searchID(String id){
		
	}
	/**
	 * 表格增加一行信息
	 * @param type 0表示查找时使用的方法，不向vos中增加数据，非0时则是addPanel增加数据一条，向vo中增加
	 */
	public void addOneData(Object o , int type){
		
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
	}
	
	/**
	 * 增加一行数据
	 * @param data
	 */
	public void addOneRow(Object[] data) {
		table.getModel().addRow(data);
		
	}
	
	/**
	 * 删除某一行数据、其中ID必须位于第一列
	 * @param ID
	 */
	public void deleteRow(String ID){
		int row = -1;
		for (int i = 0; i < table.getRowCount(); i++) {
			if(  ( (String)table.getValueAt(i, 0)).equals(ID)){
				row = i;
				break;
			}
		}
		if(row >= 0){
			removeRow(row);
		}
	}
	
	public void removeAllRows() {
		while(table.getRowCount() > 0){
			table.getModel().removeRow(0);
		}
	}
	
	/**
	 * 若不在构造器中初始化列、表数据，想要推迟初始化可以调用此方法
	 */
	public void myInit() {
		initialTitleAndColumn(config);
		initTable();
		initScrollerPane();
		add(rollpane);
	}
	
	public void showAllMessages(){
		
	}
}
