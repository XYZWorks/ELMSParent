package ui.financeman.bulidStateForm;

import java.util.ArrayList;

import org.dom4j.Element;

import bl.BusinessLogicDataFactory;
import blservice.orderblservice.Orderblservice;
import blservice.statisticblservice.Statisticblservice;
import ui.table.MyTable;
import ui.table.MyTablePanel;
import util.MyDate;
import vo.finance.PayVO;

/**
 *
 * @author:xingcheng
 * @version 2015年12月31日
 */
@SuppressWarnings("serial")
public class DepositeSmallTable extends MyTablePanel {
	ArrayList<String> orderbarCodes = new ArrayList<>();
	String[] oneOrder = new String[3];
	ArrayList<PayVO> vos;
	private double moneyTotal = 0;

	public DepositeSmallTable(Element config) {
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
	
	double setMessage(ArrayList<PayVO> vos){
		if(vos == null){
			return 0;
		}
		double sum = 0;
		String[] oneData = new String[8];
		removeAllRows();
		
		for (PayVO vo : vos) {
			oneData[0] = vo.ID;
			oneData[1] = vo.account;
			oneData[2] = vo.person;
			oneData[3] = MyDate.toString(vo.time);
			oneData[4] = String.valueOf(vo.money);
			oneData[5] = String.valueOf(vo.rent);
			oneData[6] = String.valueOf(vo.freight);
			oneData[7] = String.valueOf(vo.salary);
			addOneRow(oneData);
			sum += vo.money;
		}
		
		return sum;
		
		
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
			readCost = orderblservice.getFullInfo(orderID).otherMes.getOrderCost();
		} catch (Exception e) {
			readCost = 10.0;
		}

		oneOrder[2] = String.valueOf(readCost);
		moneyTotal = moneyTotal + readCost;
		this.addOneRow(oneOrder);
	}

	public ArrayList<String> getOrderbarCodes() {

		return orderbarCodes;
	}

	public double getMoneyTotal() {
		return moneyTotal;
	}

	public void setMoneyTotal(double moneyTotal) {
		this.moneyTotal = moneyTotal;
	}
}
