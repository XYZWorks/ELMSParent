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
	
	
	
	
	
	
	@Override
	public void updateTableMes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = MyTablePanel.getColumnName(config.attributeValue(columnStr));
		
		vos = bl.getAllCars();
		
		if(vos == null){
			vos = new ArrayList<>();
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
	public void addOneData(Object o, int type) {
		CarVO vo = (CarVO) o;
		if(type != 0){
			vos.add(vo);
		}
		String[] temp = new String[4];
		temp[0] = vo.ID;
		temp[1] = vo.instID;
		temp[2] = vo.plateNum;
		temp[3] = String.valueOf(vo.useYear);
		addOneRow(temp);
		
	}
	@Override
	public void searchID(String id) {
		removeAllRows();
		for (int i = 0; i < vos.size(); i++) {
			if(vos.get(i).ID.equals(id)){
				addOneData(vos.get(i) , 0 );
				new TipsDialog("成功找到一条信息", Color.GREEN);
				return;
			}
		}
		new TipsDialog("未找到任何一条信息");
	}
	public void searchPlateNum(String PlateNum){
		removeAllRows();
		for (int i = 0; i < vos.size(); i++) {
			if(vos.get(i).plateNum.equals(PlateNum)){
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
	}

}
