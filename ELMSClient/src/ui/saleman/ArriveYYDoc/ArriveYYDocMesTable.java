package ui.saleman.ArriveYYDoc;

import java.util.ArrayList;

import org.dom4j.Element;

import ui.table.MyTable;
import ui.table.MyTablePanel;
import util.MyDate;
import vo.transport.ArriveYYDocVO;
import blservice.transportblservice.Transportblservice;
 /** 
 * 接收单表
 * @author czq 
 * @version 2015年12月8日 下午8:35:12 
 */
@SuppressWarnings("serial")
public class ArriveYYDocMesTable extends MyTablePanel {
	Transportblservice bl;
	
	ArrayList<ArriveYYDocVO> vos;
	
	String[] oneData = new String[COLUMN_NUM];
 	private static final int COLUMN_NUM = 6;
	public ArriveYYDocMesTable(Element config) {
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
		
		vos = bl.getDayArriveYYDocs(MyDate.getNowTime());
		
		if(vos == null || vos.isEmpty()){
			return;
		}
		
		data = new String[vos.size()][COLUMN_NUM];
		ArriveYYDocVO vo;
		for (int i = 0; i < vos.size(); i++) {
			vo = vos.get(i);
			
			data[i][0] = vo.ID;
			data[i][1] = MyDate.toString(vo.date);
			data[i][2] = vo.ZZID;
			data[i][3] = vo.sendCity.getName();
			data[i][4] = vo.goodState.getName();
			data[i][5] = String.valueOf(vo.orderBarCodes.size());
		}

	}

	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data);

	}

}
