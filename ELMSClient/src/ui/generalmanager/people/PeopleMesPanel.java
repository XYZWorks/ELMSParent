package ui.generalmanager.people;

import org.dom4j.Element;

import ui.table.MyTablePanel;
 /** 
 * 
 * @author czq 
 * @version 2015年12月5日 上午9:24:16 
 */
@SuppressWarnings("serial")
public class PeopleMesPanel extends MyTablePanel{
	
	private static final int COLUMN_NUMS = 5;
	
	public PeopleMesPanel(Element config) {
		super(config);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = new String[5];
		columnNames[0] = "机构ID";
		columnNames[1] = "人员ID";
		
		
		
	}

	@Override
	protected void initTable() {
		// TODO Auto-generated method stub
		
	}

}
