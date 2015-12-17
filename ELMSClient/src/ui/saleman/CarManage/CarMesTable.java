package ui.saleman.CarManage;

import java.awt.Color;
import java.util.ArrayList;

import org.dom4j.Element;

import ui.table.MyTable;
import ui.table.MyTablePanel;
import ui.util.TipsDialog;
import vo.DTManage.CarVO;
import blservice.DTManageblservice.DTManageblservice;
 /** 
 * 车辆信息表格
 * @author czq 
 * @version 2015年12月8日 下午8:26:14 
 */
@SuppressWarnings("serial")
public class CarMesTable extends MyTablePanel{
	
	DTManageblservice bl;
	
	ArrayList<CarVO> vos;
	
	public CarMesTable(Element config , DTManageblservice bl) {
		super(config);
		this.bl = bl;
	}
	/**
	 * 根据车派号 ID查找车辆信息
	 * @param identifier
	 * @param type
	 */
	void checkByIDOrPlate(String identifier , int type){
		String[][] result = new String[1][4];
		boolean find = false;
		for (int i = 0; i < table.getRowCount(); i++) {
			if( ((String)table.getValueAt(i, type)).equals(identifier)){
				result[0][0] = (String) table.getValueAt(i, 0);
				result[0][1] = (String) table.getValueAt(i, 1);
				result[0][2] = (String) table.getValueAt(i, 2);
				result[0][3] = (String) table.getValueAt(i, 3);
				find = true;
				break;
			}
		}
		
		if(find){
			table.getModel().setDataVector( result, columnNames);
		}else{
			if(type == 0){
				new TipsDialog("没有找到该ID对应的车辆", Color.red);
			}else{
				new TipsDialog("没有找到该车牌号对应的车辆", Color.red);
			}
			
		}
	}
	
	
	
	
	
	@Override
	public void updateTableMes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = MyTablePanel.getColumnName(config.attributeValue(columnStr));
		
		vos = bl.getAllCars();
		
		if(vos == null){
			return;
		}
		
		data = new String[vos.size()][4];
		CarVO vo;
		for (int i = 0; i < vos.size(); i++) {
			vo = vos.get(i);
			data[i][0] = vo.ID;
			data[i][1] = vo.instID;
			data[i][2] = vo.plateNum;
			data[i][3] = String.valueOf(vo.useYear);
		}
		
		
		
	}

	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data);
	}

}
