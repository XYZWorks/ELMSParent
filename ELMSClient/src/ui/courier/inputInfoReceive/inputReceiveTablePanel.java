package ui.courier.inputInfoReceive;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.text.TabExpander;

import org.dom4j.Element;

import blservice.orderblservice.Orderblservice;
import ui.table.MyTable;
import ui.table.MyTablePanel;
import vo.order.PreReceiveVO;
import vo.order.ReceiveVO;

/**
 *
 * @author:xingcheng
 * @version 2015年12月8日
 */
@SuppressWarnings("serial")
public class inputReceiveTablePanel extends MyTablePanel {
	private Orderblservice bl;
	private InputReceiveInfoPanel inputReceiveInfoPanel;
	public  ArrayList<PreReceiveVO> pre;
	public ArrayList<PreReceiveVO>after;

	private static final int COLUMN_NUM = 5;

	public inputReceiveTablePanel(Element config, Orderblservice bl,InputReceiveInfoPanel inputReceiveInfoPanel) {
		super(config);
		this.bl = bl;
		this.inputReceiveInfoPanel=inputReceiveInfoPanel;
		
		initialTitleAndColumn(config);
		initTable();
		initScrollerPane();
		this.add(rollpane);

	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = MyTablePanel.getColumnName(config.attributeValue("column"));
		 pre = bl.getPreReceive();
		 after=pre;
		 
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

	}

	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data){
		@Override
		public boolean isCellEditable(int row, int column) {
			if((column>=0)&&(column<=2)){
				return false;
			}
			return true;
		}
		};
		
		int[] columnLen = { 100, 300, 100, 100,100};
		setRowAndColumnLen(40, columnLen);

		
	}

	
	public void updateTableMes(ArrayList<PreReceiveVO>pre) {
		//pre = bl.getPreReceive();
		if (pre == null) {
			return;
		}

		table.getModel().setRowCount(pre.size());
		PreReceiveVO vo;
		for (int i = 0; i < pre.size(); i++) {
			vo = pre.get(i);
			table.setValueAt(vo.realReceiver, i, 3);
			table.setValueAt(vo.receiveTime, i, 4);
		}
	}

	@Override
	public void updateTableMes() {
		// TODO Auto-generated method stub
		
	}

//	public ArrayList<PreReceiveVO> getPreReceive(){
//		return after;
//	}
	
	public String[][] getData(){
		return (String[][]) data;
	}
}
