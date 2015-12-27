package ui.generalmanager.institution;

import java.util.ArrayList;

import org.dom4j.Element;

import ui.table.MyTable;
import ui.table.MyTablePanel;
import vo.personnel.InstVO;
import blservice.personnelblservice.Personnelblservice;

/**
 * 机构信息表格
 * 
 * @author czq
 * @version 2015年12月5日 下午4:59:44
 */
@SuppressWarnings("serial")
public class InstTablePanel extends MyTablePanel {

	private Personnelblservice bl;

	private ArrayList<InstVO> vos;

	public InstTablePanel(Element config, Personnelblservice bl) {
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

		vos = bl.getInst();
		
		if (vos != null) {
			data = new String[vos.size()][3];
			for (int i = 0; i < vos.size(); i++) {
				data[i][0] = vos.get(i).ID;
				data[i][1] = vos.get(i).type.getName();
				data[i][2] = vos.get(i).location.getName();
			}
		}

	}

	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data);
		int[] columnLen = { 100, 100, 100 };
		setRowAndColumnLen(30, columnLen);
	}
	@Override
	public void addOneData(Object o, int type) {
		InstVO vo = (InstVO) o;
		if(type == 1){
			vos.add(vo);
		}
		
		if(type == 1){
			String[] temp = new String[3];
			temp[0] = vo.ID;
			temp[1] = vo.type.getName();
			temp[2] = vo.location.name();
			addOneRow(temp);
		}else if(type == 2){
			int row = getSelectedRow();
			if(((String)table.getValueAt(row, 1)).equals(vo.ID)){
				table.setValueAt(vo.ID, row, 0);
				table.setValueAt(vo.type.getName(), row, 1);
				table.setValueAt(vo.location.getName(), row, 2);
			}
			
		}
		
		
		
	}
	@Override
	public void updateTableMes() {
		vos = bl.getInst();
		if (vos == null) {
			return;
		}
		
		table.getModel().setRowCount(vos.size());
		InstVO vo;
		for (int i = 0; i < vos.size(); i++) {
			vo = vos.get(i);
			table.setValueAt(vo.ID, i, 0);
			table.setValueAt(vo.type.getName(), i, 1);
			table.setValueAt(vo.location.getName(), i, 2);

		}

	}

}
