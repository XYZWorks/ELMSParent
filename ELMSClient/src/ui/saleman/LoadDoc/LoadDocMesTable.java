package ui.saleman.LoadDoc;

import java.awt.Color;
import java.util.ArrayList;

import org.dom4j.Element;

import ui.table.MyTable;
import ui.table.MyTablePanel;
import ui.util.TipsDialog;
import util.MyDate;
import vo.transport.LoadDocVO;
import blservice.transportblservice.Transportblservice;
 /** 
 * 装车单信息表
 * @author czq 
 * @version 2015年12月8日 下午8:27:39 
 */
@SuppressWarnings("serial")
public class LoadDocMesTable extends MyTablePanel {
	Transportblservice bl;
	
	ArrayList<LoadDocVO> vos;
	
	String[] oneData = new String[COLUMN_NUM];
 	private static final int COLUMN_NUM = 9;
	public LoadDocMesTable(Element config , Transportblservice bl) {
		super(config);
		this.bl = bl;
	}

	@Override
	public void updateTableMes() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addOneData(Object o , int type) {
		LoadDocVO vo = (LoadDocVO) o;
		if(type != 0){
			vos.add(vo);
		}
		
		oneData[0] = vo.ID;
		oneData[1] = MyDate.toString(vo.date);
		oneData[2] = vo.YYID;
		oneData[3] = vo.loadDocID;
		oneData[4] = vo.arriveCity.getName();
		oneData[5] = vo.carID;
		oneData[6] = vo.supervisor;
		oneData[7] = vo.escort;
		oneData[8] = String.valueOf(vo.orderBarCodes.size());
		addOneRow(oneData);
	}
	
	
	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = MyTablePanel.getColumnName(config.attributeValue(columnStr));
		vos = bl.getDayLoadDocs(MyDate.getNowTime());
		
		if(vos == null || vos.isEmpty()){
			vos = new ArrayList<>(10);
			return;
		}
		
		data = new String[vos.size()][COLUMN_NUM];
		LoadDocVO vo;
		for (int i = 0; i < vos.size(); i++) {
			vo = vos.get(i);
			
			data[i][0] = vo.ID;
			data[i][1] = MyDate.toString(vo.date);
			data[i][2] = vo.YYID;
			data[i][3] = vo.loadDocID;
			data[i][4] = vo.arriveCity.getName();
			data[i][5] = vo.carID;
			data[i][6] = vo.supervisor;
			data[i][7] = vo.escort;
			data[i][8] = String.valueOf(vo.orderBarCodes.size());
			
		}
		
		
	}
	
	
	@Override
	protected void initTable() {
//		int[] columnLen = {};
		table = new MyTable(columnNames, data);
//		setRowAndColumnLen(rowLen, columnLen);
		
	}
	
	@Override
	public void searchID(String id) {
		super.searchID(id);
		removeAllRows();
		for (int i = 0; i < vos.size(); i++) {
			if(vos.get(i).ID.equals(id)){
				addOneData(vos.get(i) , 0);
				new TipsDialog("成功找到一条信息", Color.GREEN);
				break;
			}
			
		}
		new TipsDialog("未找到任何一条信息");
	}
	@Override
	public void showAllMessages() {
		removeAllRows();
		for (int i = 0; i < vos.size(); i++) {
			addOneData(vos.get(i), 0);
		}
	}
}
