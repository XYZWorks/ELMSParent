package ui.storeman.transport;

import java.util.ArrayList;

import org.dom4j.Element;

import ui.table.MyTable;
import ui.table.MyTablePanel;

/** * @author zr 
* @date 创建时间：2015年12月30日 下午4:24:14 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
@SuppressWarnings("serial")
public class TransportOrders extends MyTablePanel{
public TransportOrders(Element config) {
		super(config);
		myInit();
	}

ArrayList<String> orderbarCodes = new ArrayList<>();
	
	String[] oneOrder = new String[2];
	
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
	public void clearOrders(){
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
	public void addAOrder(String orderID){
		orderbarCodes.add(orderID);
		oneOrder[0] = String.valueOf(orderbarCodes.size()); 
		oneOrder[1] = orderID;
		this.addOneRow(oneOrder);
	}

	public ArrayList<String> getOrderbarCodes() {
		
		return orderbarCodes;
	}
}
