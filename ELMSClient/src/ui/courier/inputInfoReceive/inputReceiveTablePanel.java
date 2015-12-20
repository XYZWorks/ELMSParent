package ui.courier.inputInfoReceive;

import java.util.ArrayList;

import org.dom4j.Element;

import bl.orderbl.Order;
import blservice.orderblservice.Orderblservice;
import ui.table.MyTable;
import ui.table.MyTablePanel;
import util.MyDate;
import vo.order.PreReceiveVO;
import vo.personnel.InstVO;
import vo.transport.ArriveYYDocVO;

/**
*
*@author:xingcheng
*@version 2015年12月8日
*/
@SuppressWarnings("serial")
public class inputReceiveTablePanel extends MyTablePanel{
	private Orderblservice bl;
	private ArrayList<PreReceiveVO>pre;
	
 	private static final int COLUMN_NUM = 5;
 	
	public inputReceiveTablePanel(Element config,Orderblservice bl) {
		super(config);
		this.bl = bl;
		initialTitleAndColumn(config);
		initTable();
		initScrollerPane();
		this.add(rollpane);
		
	}

	
	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = MyTablePanel.getColumnName(config
				.attributeValue("column"));
		pre = bl.getPreReceive();

		ArrayList<PreReceiveVO> pre=new ArrayList<PreReceiveVO>();
		PreReceiveVO one=new PreReceiveVO("1234567890", "南京大学2栋 axxx", "王二",null, null);
		PreReceiveVO two=new PreReceiveVO("1234567899", "复旦大学2栋 axxx", "凯二",null, null);
		pre.add(one);
		pre.add(two);
		
		
		if(pre == null || pre.isEmpty()){
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
		table = new MyTable(columnNames, data);
		int[] columnLen = { 100, 300, 100, 100,100};
		setRowAndColumnLen(40, columnLen);
		
	}

	@Override
	public void updateTableMes() {
		pre = bl.getPreReceive();
		if (pre == null) {
			return;
		}
		
		table.getModel().setRowCount(pre.size());
		PreReceiveVO vo;
		for (int i = 0; i < pre.size(); i++) {
			vo = pre.get(i);
			table.setValueAt(vo.realReceiver,i,3 );
			table.setValueAt(vo.receiveTime, i,4);
		}	
	}

}
