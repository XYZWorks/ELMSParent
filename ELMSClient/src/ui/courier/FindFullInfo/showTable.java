package ui.courier.FindFullInfo;

import java.util.ArrayList;

import org.dom4j.Element;

import ui.table.MyTable;
import ui.table.MyTablePanel;
import vo.order.OrderVO;
import vo.order.PreReceiveVO;
import blservice.orderblservice.Orderblservice;

@SuppressWarnings("serial")
public class showTable extends MyTablePanel {

	private Orderblservice bl;
	private ArrayList<OrderVO>pre;
	
 	private static final int COLUMN_NUM = 6;
 	
	public showTable(Element config,Orderblservice bl) {
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
		
		//需要新的接口  我传递进去 当天的日期 按时间顺序（最新的放在前面） 返回给我一堆ordervo
		pre =bl.getFullInfo(orderBarCode);

		
		
		if(pre == null || pre.isEmpty()){
			return;
		}
		
		data = new String[pre.size()][COLUMN_NUM];
		
		if (pre != null) {
			for (int i = 0; i < pre.size(); i++) {
				//订单号 收件人 收件地址 寄件人 寄件地址 运费
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

