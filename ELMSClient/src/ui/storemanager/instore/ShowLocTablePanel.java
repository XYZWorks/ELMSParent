package ui.storemanager.instore;

import java.util.ArrayList;

import org.dom4j.Element;

import ui.config.UserfulMethod;
import ui.table.MyTable;
import ui.table.MyTablePanel;
import ui.tools.MyButton;
import ui.tools.MyLabel;
import util.MyDate;
import vo.store.InStoreDocVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月8日 上午11:12:09 
 *
 */
public class ShowLocTablePanel extends MyTablePanel {
	
	private static final int COLUMN_NUM = 5;

	private static final int ROW_NUM = 15;
	
	
	
	public ShowLocTablePanel(Element config) {
		
		super(config);
		initialTitleAndColumn(config);
		initTable();
		initScrollerPane();
		this.add(rollpane);
		int[] columnLen = { 330, 100, 100, 100, 100 };
		this.setRowAndColumnLen(30, columnLen);
	}

	@Override
	public void updateTableMes() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = getColumnName(config.attributeValue("columnName"));
		
//		vos = bl.showInstoreDocs();
		
//		if(vos==null){
//			return;
//		}
//		
//		data = new String[vos.size()][COLUMN_NUM];
//		InStoreDocVO vo;
//		for (int i = 0; i < vos.size(); i++) {
//			vo = vos.get(i);
//			data[i][0] = vo.type.name();
//			data[i][1] = vo.ID;
//			data[i][2] = MyDate.toString(vo.date);
//			data[i][3] = vo.loc.name();
//			data[i][4] = UserfulMethod.orderArrayToString(vo.orders);
//		}

	}

	@Override
	protected void initTable() {
		// TODO Auto-generated method stub
		table = new MyTable(columnNames, data);

	}

}
