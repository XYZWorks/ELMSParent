package ui.courier.inputInfoReceive;

import java.util.ArrayList;

import org.dom4j.Element;

import blservice.orderblservice.Orderblservice;
import ui.table.MyTable;
import ui.table.MyTablePanel;
import vo.order.PreReceiveVO;

/**
 *
 * @author:xingcheng
 * @version 2015年12月8日
 */
@SuppressWarnings("serial")
public class inputReceiveTablePanel extends MyTablePanel {
	private Orderblservice bl;
	private InputReceiveInfoPanel inputReceiveInfoPanel;
	public ArrayList<PreReceiveVO> pre;
	public ArrayList<PreReceiveVO> after;
	private Element config;
	private static final int COLUMN_NUM = 5;

	public inputReceiveTablePanel(Element config, Orderblservice bl, InputReceiveInfoPanel inputReceiveInfoPanel) {
		super(config);
		this.bl = bl;
		this.config=config;
		this.inputReceiveInfoPanel = inputReceiveInfoPanel;

		initialTitleAndColumn(config);
		initTable();
		initScrollerPane();
		this.add(rollpane);

	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		System.out.println("initaltitle");
		columnNames = MyTablePanel.getColumnName(config.attributeValue("column"));
		pre = bl.getPreReceive();
		after = pre;

		if (pre == null || pre.isEmpty()) {
			return;
		}

		data = new String[pre.size()][COLUMN_NUM];

		if (pre != null) {
			for (int i = 0; i < pre.size(); i++) {
				data[i][0] = pre.get(i).barCode;
				data[i][1] = pre.get(i).address;
				data[i][2] = pre.get(i).name;
				data[i][3] = pre.get(i).realReceiver;
				data[i][4] = pre.get(i).receiveTime;
			}
		}

		System.out.println("pre.length"+pre.size());
	}

	@Override
	protected void initTable() {
		System.out.println("inittable");
		
		removeAll();
		table = new MyTable(columnNames, data) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if ((column >= 0) && (column <= 2)) {
					return false;
				}
				return true;
			}
		};
		
		
		
		int[] columnLen = { 100, 300, 100, 100, 100 };
		setRowAndColumnLen(40, columnLen);

	}

	public void updateTableMes(ArrayList<PreReceiveVO> x) {
		// pre = bl.getPreReceive();
		if (x == null) {
			return;
		}

		table.getModel().setRowCount(x.size());
		PreReceiveVO vo;
		for (int i = 0; i < x.size(); i++) {
			vo = x.get(i);
			table.setValueAt(vo.realReceiver, i, 3);
			table.setValueAt(vo.receiveTime, i, 4);
		}
	}

	@Override
	public void updateTableMes() {
		 //pre = bl.getPreReceive();
//		//重新读取表格的数据
//		if (pre == null) {
//			return;
//		}
//
//		table.getModel().setRowCount(pre.size());
//		PreReceiveVO vo;
//		for (int i = 0; i < pre.size(); i++) {
//			vo = pre.get(i);
//			table.setValueAt(vo.realReceiver, i, 3);
//			table.setValueAt(vo.receiveTime, i, 4);
//		}
		
	}
	

	// public ArrayList<PreReceiveVO> getPreReceive(){
	// return after;
	// }

	public String[][] getData() {
		return (String[][]) data;
	}


	
}
