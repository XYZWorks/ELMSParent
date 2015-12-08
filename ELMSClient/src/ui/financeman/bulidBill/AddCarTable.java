package ui.financeman.bulidBill;

import org.dom4j.Element;

import ui.table.MyTable;
import ui.table.MyTablePanel;
import vo.DTManage.CarVO;
 /** 
 * 增加车辆信息表格
 * @author czq 
 * @version 2015年12月7日 下午9:07:29 
 */
@SuppressWarnings("serial")
public class AddCarTable extends MyTablePanel{
	private static final int COLUMN_NUMS = 3;

	public AddCarTable(Element config) {
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
	
	void addCar(CarVO vo){
		if(vo!=null){
			Object[] temp = new Object[COLUMN_NUMS];
			
			temp[0] = vo.ID;
			temp[1] = vo.plateNum;
			temp[2] = String.valueOf(vo.useYear);
			
			
			table.getModel().addRow(temp);
		}
		
		
		
	}
	
}
