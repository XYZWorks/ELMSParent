package ui.saleman.ArriveYYDoc;

import java.awt.Color;
import java.util.ArrayList;

import org.dom4j.Element;

import ui.table.MyTable;
import ui.table.MyTablePanel;
import ui.util.TipsDialog;
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
		
	}

	@Override
	public void updateTableMes() {

	}
	
	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = MyTablePanel.getColumnName(config.attributeValue(columnStr));
		
		vos = bl.getDayArriveYYDocs(MyDate.getNowTime());
		
		if(vos == null || vos.isEmpty()){
			vos = new ArrayList<>();
			return;
		}
		
		data = new String[vos.size()][COLUMN_NUM];
		ArriveYYDocVO vo;
		for (int i = 0; i < vos.size(); i++) {
			vo = vos.get(i);
			
			data[i][0] = vo.ID;
			data[i][1] = MyDate.getPartDay(vo.date);
			data[i][2] = vo.ZZID;
			data[i][3] = vo.sendFrom.getName();
			data[i][4] = vo.goodState.getName();
			if(vo.orderBarCodes!= null)
			data[i][5] = String.valueOf(vo.orderBarCodes.size());
		}

	}
	@Override
	public void addOneData(Object o , int type) {
		ArriveYYDocVO vo = (ArriveYYDocVO) o;
		if(type != 0){
			vos.add(vo);
		}
		String[] temp = new String[COLUMN_NUM];
		temp[0] = vo.ID;
		temp[1] = MyDate.getPartDay(vo.date);
		temp[2] = vo.ZZID;
		temp[3] = vo.sendFrom.getName();
		temp[4] = vo.goodState.getName();
		if(vo.orderBarCodes!= null)
		temp[5] = String.valueOf(vo.orderBarCodes.size());
		addOneRow(temp);
		
	}
	@Override
	public void searchID(String id) {
		removeAllRows();
		for (int i = 0; i < vos.size(); i++) {
			if(vos.get(i).ID.equals(id)){
				addOneData(vos.get(i) , 0);
				new TipsDialog("成功找到一条信息", Color.GREEN);
				return;
			}
		}
		new TipsDialog("未找到任何一条信息");
	}
	
	
	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data);
		
		int[] columnLen = {250, 100, 80,80,80,80};
		setRowAndColumnLen(40, columnLen);

	}
	@Override
	public void showAllMessages() {
		removeAllRows();
		for (int i = 0; i < vos.size(); i++) {
			addOneData(vos.get(i), 0);
		}
	}
}
