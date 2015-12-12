package ui.saleman.SendGoodDoc;

import java.util.ArrayList;

import org.dom4j.Element;

import blservice.transportblservice.Transportblservice;
import ui.table.MyTable;
import ui.table.MyTablePanel;
import util.MyDate;
import vo.transport.LoadDocVO;
import vo.transport.SendGoodDocVO;
 /** 
 * 
 * @author czq 
 * @version 2015年12月8日 下午8:34:24 
 */
@SuppressWarnings("serial")
public class SendGoodMesTable extends MyTablePanel {
	Transportblservice bl;
	
	ArrayList<SendGoodDocVO> vos;
	
	String[] oneData = new String[COLUMN_NUM];
 	private static final int COLUMN_NUM = 5;
	
	public SendGoodMesTable(Element config) {
		super(config);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateTableMes() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = MyTablePanel.getColumnName(config.attributeValue(columnStr));
		
		vos = bl.getDaySendDocs(MyDate.getNowTime());
		
		if(vos == null || vos.isEmpty()){
			return;
		}
		
		data = new String[vos.size()][COLUMN_NUM];
		SendGoodDocVO vo;
		for (int i = 0; i < vos.size(); i++) {
			vo = vos.get(i);
			
			data[i][0] = vo.ID;
			data[i][1] = MyDate.toString(vo.date);
			data[i][2] = vo.sendMan;
			data[i][3] = vo.orderBarCode;
			data[i][4] = vo.sendCity.getName();
			
		}

	}

	@Override
	protected void initTable() {
	table = new MyTable(columnNames, data);

	}

}
