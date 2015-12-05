package ui.generalmanager.people;

import java.util.ArrayList;

import org.dom4j.Element;

import blservice.personnelblservice.Personnelblservice;
import po.personnel.PersonPO;
import ui.table.MyTable;
import ui.table.MyTablePanel;
import vo.personnel.PersonVO;
 /** 
 * 
 * @author czq 
 * @version 2015年12月5日 上午9:24:16 
 */
@SuppressWarnings("serial")
public class PeopleMesPanel extends MyTablePanel{
	
	private static final int COLUMN_NUMS = 5;
	
	private ArrayList<PersonVO> vos;
	
	private Personnelblservice bl;
	
	public PeopleMesPanel(Element config , Personnelblservice bl) {
		super(config);
		this.bl = bl;
		initialTitleAndColumn(config);
		initTable();
		initScrollerPane();
		this.add(rollpane);
		
		int[] columnLen = {100,100,100,100 , 200};
		setRowAndColumnLen(30, columnLen);
//		vos = bl.
	}
	
	
	
	
	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = new String[COLUMN_NUMS];
		columnNames[0] = "机构ID";
		columnNames[1] = "人员ID";
		columnNames[2] = "姓名";
		columnNames[3] = "职位";
		columnNames[4] = "手机号码";
		
		
		
	}
	
	
	
	
	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data);
		int[] columnLen = { 30 , 30,  30 , 30 };
		setRowAndColumnLen(30, columnLen);
	}

	
	
	
	@Override
	public void updateTableMes() {
		
		
		
		
	}

	

	

}
