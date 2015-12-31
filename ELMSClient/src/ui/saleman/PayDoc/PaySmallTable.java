package ui.saleman.PayDoc;

import java.util.ArrayList;

import org.dom4j.Element;

import ui.table.MyTable;
import ui.table.MyTablePanel;
import bl.BusinessLogicDataFactory;
import blservice.orderblservice.Orderblservice;

/**
 *
 * @author:xingcheng
 * @version 2015年12月27日
 */
@SuppressWarnings("serial")
public class PaySmallTable extends MyTablePanel {

	ArrayList<String> orderbarCodes = new ArrayList<>();

	String[] oneOrder = new String[3];

	private double moneyTotal = 0;

	public PaySmallTable(Element config) {
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
	public void clearOrders() {
		while (table.getRowCount() > 0) {
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
	 * 
	 * @param orderID
	 */
	public void addAOrder(String orderID) {
		orderbarCodes.add(orderID);
		oneOrder[0] = String.valueOf(orderbarCodes.size());
		oneOrder[1] = orderID;
		Orderblservice orderblservice = BusinessLogicDataFactory.getFactory().getOrderBussinessLogic();
		double readCost;
		try {
			readCost=orderblservice.getFullInfo(orderID).otherMes.getOrderCost();
		} catch (Exception e) {
			readCost = 10.0;
		}
		
		oneOrder[2] = String.valueOf(readCost);
		moneyTotal=moneyTotal+readCost;
		this.addOneRow(oneOrder);
	}

	public ArrayList<String> getOrderbarCodes() {

		return orderbarCodes;
	}

	public double getMoneyTotal() {
		return moneyTotal;
	}
}
