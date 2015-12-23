package ui.saleman.DriverManage;

import java.awt.Color;
import java.util.ArrayList;

import org.dom4j.Element;

import ui.table.MyTable;
import ui.table.MyTablePanel;
import ui.util.TipsDialog;
import util.MyDate;
import vo.DTManage.DriverVO;
import blservice.DTManageblservice.DTManageblservice;
 /** 
 * 司机信息表
 * @author czq 
 * @version 2015年12月8日 下午8:25:55 
 */
@SuppressWarnings("serial")
public class DriverMesPanel extends MyTablePanel {
	
	DTManageblservice bl;
	
	ArrayList<DriverVO> vos;
	
	public DriverMesPanel(Element config) {
		super(config);
	}

	@Override
	public void updateTableMes() {

	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = MyTablePanel.getColumnName(config.attributeValue(columnStr));
		
		vos = bl.getAllDrivers();
		
		if(vos == null){
			vos = new ArrayList<>();
			return;
		}
		
		data = new String[vos.size()][8];
		DriverVO vo;
		for (int i = 0; i < vos.size(); i++) {
			vo = vos.get(i);
			data[i][0] = vo.ID;
			data[i][1] = vo.name;
			data[i][2] = vo.InstID;
			data[i][3] = MyDate.toString(vo.birthDay);
			data[i][4] = vo.IDcard;
			data[i][5] = vo.phoneNum;
			data[i][6] = vo.isman?"男":"女";
			data[i][7] = String.valueOf(vo.licenseYear);
		}

	}
	@Override
	public void addOneData(Object o , int type) {
		DriverVO vo = (DriverVO) o;
		if(type != 0){
			vos.add(vo);
		}
		String[] temp  = new String[8];
		temp[0] = vo.ID;
		temp[1] = vo.name;
		temp[2] = vo.InstID;
		temp[3] = MyDate.toString(vo.birthDay);
		temp[4] = vo.IDcard;
		temp[5] = vo.phoneNum;
		temp[6] = vo.isman?"男":"女";
		temp[7] = String.valueOf(vo.licenseYear);
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
	public void searchInstID(String instid){
		removeAllRows();
		int count = 0;
		for (int i = 0; i < vos.size(); i++) {
			if(vos.get(i).InstID.equals(instid)){
				addOneData(vos.get(i) , 0);
				count++;
			}
		}
		if(count > 0){
			new TipsDialog("成功找到" + count + "条信息", Color.GREEN);
		}else{
			new TipsDialog("未找到任何一条信息");
		}
	}
	public void searchName(String  name) {
		removeAllRows();
		ArrayList<DriverVO> vos = bl.checkDriverByName(name);
		int count = 0;
		for (DriverVO driverVO : vos) {
			addOneData(driverVO , 0);
			count++;
			
		}
		if(count > 0){
			new TipsDialog("成功找到" + count + "条信息", Color.GREEN);
		}else{
			new TipsDialog("未找到任何一条信息");
		}
		
		
	}
	
	
	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data);
//		setRowAndColumnLen(rowLen, columnLen);

	}

}
