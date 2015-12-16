package ui.saleman.LoadDoc;

import java.util.ArrayList;

import org.dom4j.Element;

import ui.table.MyTable;
import ui.table.MyTablePanel;
 /** 
 * 装车单界面中订单号表
 * @author czq 
 * @version 2015年12月11日 上午8:59:16 
 */
@SuppressWarnings("serial")
public class LoadDocOrders extends MyTablePanel{
	
	ArrayList<String> orderbarCodes = new ArrayList<>();
	
	String[] oneOrder = new String[2];
	
	public LoadDocOrders(Element config) {
		super(config);
		myInit();
	}

	@Override
	public void updateTableMes() {
		
	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = MyTablePanel.getColumnName(config.attributeValue(columnStr));
		data = null;
	}
	/**
	 * 清空表内所有信息
	 */
	void clearOrders(){
		while(table.getRowCount() > 0){
			table.getModel().removeRow(0);
		}
		orderbarCodes.clear();
	}
	
	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data);
		
	}
	/**
	 * 增加一条订单信息
	 * @param orderID
	 */
	void addAOrder(String orderID){
		orderbarCodes.add(orderID);
		oneOrder[0] = String.valueOf(orderbarCodes.size()); 
		oneOrder[1] = orderID;
		this.addOneRow(oneOrder);
	}
	
}
