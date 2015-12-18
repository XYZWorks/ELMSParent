package ui.generalmanager.salary;

import java.util.ArrayList;

import org.dom4j.Element;

import ui.table.MyTable;
import ui.table.MyTablePanel;
import vo.strategy.SalaryWayVO;
 /** 
 * 薪水策略信息显示面板
 * @author czq 
 * @version 2015年12月4日 下午4:51:52 
 */
@SuppressWarnings("serial")
public class SalaryStrategyMesTablePanel extends MyTablePanel{
	
	private static final int COLUMN_NUM = 4;
	
	private static final String[] columnName = { "职员类型" , "计费策略" , "基础工资" ,"提成" };
 	
	private ArrayList<SalaryWayVO> vos;
	
	public SalaryStrategyMesTablePanel(Element config,ArrayList<SalaryWayVO> vos) {
		super(config);
		this.vos = vos;
		initialTitleAndColumn(config);
		initTable();
		initScrollerPane();
		this.add(rollpane);
	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		
		columnNames = columnName;
		
		
		
		if(vos != null){
			
			data = new String[vos.size()][COLUMN_NUM];
			SalaryWayVO vo;
			for (int i = 0; i < vos.size(); i++) {
				vo = vos.get(i);
				data[i][0] = vo.type.name();
				data[i][1] =  vo.way.name();
				data[i][2] = String.valueOf(vo.basicSalary);
				data[i][3] = String.valueOf(vo.moreMoney);
			}
			
			
			
		}
		
		
	}

	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data);
		int columnLen[] = { 200 , 100 , 100 , 100 };
		setRowAndColumnLen(40, columnLen);
	}

	@Override
	public void updateTableMes() {
		
		
	}

}
