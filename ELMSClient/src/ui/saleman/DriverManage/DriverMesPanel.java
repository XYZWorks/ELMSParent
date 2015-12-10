package ui.saleman.DriverManage;

import java.util.ArrayList;

import org.dom4j.Element;

import blservice.DTManageblservice.DTManageblservice;
import ui.table.MyTable;
import ui.table.MyTablePanel;
import ui.tools.MyLabel;
import ui.tools.MyTextField;
import util.MyDate;
import vo.DTManage.CarVO;
import vo.DTManage.DriverVO;
 /** 
 * 
 * @author czq 
 * @version 2015年12月8日 下午8:25:55 
 */
@SuppressWarnings("serial")
public class DriverMesPanel extends MyTablePanel {
	
	DTManageblservice bl;
	
	ArrayList<DriverVO> vos;
	
	public DriverMesPanel(Element config) {
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
		
		vos = bl.getAllDrivers();
		
		if(vos == null){
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
	protected void initTable() {
		table = new MyTable(columnNames, data);
//		setRowAndColumnLen(rowLen, columnLen);

	}

}
