package ui.saleman.SendGoodDoc;

import java.util.ArrayList;

import org.dom4j.Element;

import bl.BusinessLogicDataFactory;
import blservice.orderblservice.Orderblservice;
import po.order.PeopleMes;
import ui.table.MyTable;
import ui.table.MyTablePanel;

/**
*
*@author:xingcheng
*@version 2015年12月29日
*/
@SuppressWarnings("serial")
public class SendSmallTable extends MyTablePanel {

		ArrayList<String> orderbarCodes = new ArrayList<>();

		String[] oneOrder = new String[4];

		public SendSmallTable(Element config) {
			super(config);
			myInit();
			allowHorizen();
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
			
			int[] columnLen = {50, 150, 80, 200};
			setRowAndColumnLen(40, columnLen);

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
			PeopleMes receiver=orderblservice.getFullInfo(orderID).receiver;
			oneOrder[2] =receiver.getName();
			oneOrder[3] =receiver.getAddress();
			this.addOneRow(oneOrder);
		}

		public ArrayList<String> getOrderbarCodes() {

			return orderbarCodes;
		}

	}


