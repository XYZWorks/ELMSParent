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
			for (int i = 0; i < vos.size(); i++) {
				data[i][0] = vos.get(i).ID;
				data[i][1] = vos.get(i).type.name();
				data[i][2] = vos.get(i).location.name();
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
			table.setValueAt(vo.type.name(), i, 1);
			table.setValueAt(vo.location.name(), i, 2);

		}

	}

}
