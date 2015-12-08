package ui.financeman.bulidBill;

import org.dom4j.Element;

import ui.table.MyTable;
import ui.table.MyTablePanel;
import vo.personnel.PersonVO;
 /** 
 * 人员信息面板
 * @author czq 
 * @version 2015年12月7日 下午9:07:07 
 */
@SuppressWarnings("serial")
public class AddPeopleTable extends MyTablePanel{
	
	private static final int COLUMN_NUMS = 5;
	
	
	public AddPeopleTable(Element config) {
		super(config);
		initialTitleAndColumn(config);
		initTable();
		initScrollerPane();
		add(rollpane);
	}

	@Override
	public void updateTableMes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = MyTablePanel.getColumnName(config.attributeValue("column"));
		
	}

	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data);
		
	}
	
	void addAPeople(PersonVO vo){
		if(vo!= null){
			Object[] temp = new Object[COLUMN_NUMS];
			temp[0] = vo.ID;
			temp[1] =vo.instID;
			temp[2] = vo.name;
			temp[3] = vo.type.name();
			temp[4] = vo.phoneNum;
			table.getModel().addRow(temp);
		}
		
		
		
	}
	
}
