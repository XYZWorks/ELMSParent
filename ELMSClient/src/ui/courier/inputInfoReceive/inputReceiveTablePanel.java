package ui.courier.inputInfoReceive;

import java.awt.Color;
import java.util.ArrayList;

import org.dom4j.Element;

import ui.table.MyTable;
import ui.table.MyTablePanel;
import ui.util.TipsDialog;
import util.MyDate;
import vo.order.PreReceiveVO;
import blservice.orderblservice.Orderblservice;

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
				try {
					data[i][4] = MyDate.getPartDay(pre.get(i).receiveTime);
				} catch (Exception e) {
					data[i][4]=null;
				}
				
			}
		}

	}

	@Override
	protected void initTable() {
		
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
			new TipsDialog("成功找到一条信息", Color.green);
			return;
		}
		new TipsDialog("未找到任何信息");
	}

	@Override
	public void updateTableMes() {
		 pre = bl.getPreReceive();
		//重新读取表格的数据
		if (pre == null) {
			return;
		}

		removeAllRows();
		String[] temp = new String[5];
		for (PreReceiveVO vo : pre) {
			temp[0] = vo.barCode;
			temp[1] = vo.address;
			temp[2] = vo.name;
			temp[3] = vo.realReceiver;
			try {
				temp[4] = MyDate.getPartDay(vo.receiveTime);
			} catch (Exception e) {
				temp[4]=null;
			}
			addOneRow(temp);
		}
		
		
	}
	

	// public ArrayList<PreReceiveVO> getPreReceive(){
	// return after;
	// }

	public String[][] getData() {
		return (String[][]) data;
	}


	
}
