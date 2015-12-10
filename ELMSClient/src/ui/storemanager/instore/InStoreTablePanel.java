package ui.storemanager.instore;

import java.util.ArrayList;

import org.dom4j.Element;

import bl.storebl.StoreController;
import ui.config.GraphicsUtils;
import ui.config.UserfulMethod;
import ui.table.MyTable;
import ui.table.MyTablePanel;
import util.DocType;
import util.MyDate;
import vo.store.InStoreDocVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月6日 下午2:20:45 
 *
 */
public class InStoreTablePanel extends MyTablePanel {

	private static final int COLUMN_NUM = 5;

	private StoreController bl;

	private ArrayList<InStoreDocVO> vos;

	public InStoreTablePanel(Element config, StoreController bl, MyDate date) {
		super(config);
		this.bl = bl;
		initialTitleAndColumn(config);
		initTable();
		initScrollerPane();
		this.add(rollpane);
		int[] columnLen = { 100, 180, 100, 100, 270 };
		this.setRowAndColumnLen(30, columnLen);
	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = getColumnName(config.attributeValue("columnName"));
		
		
		setDataValue();
		

	}
	

	private void setDataValue() {
		vos = bl.showInstoreDocs();
		
		if(vos==null){
			return;
		}
		data = new String[vos.size()][COLUMN_NUM];
		InStoreDocVO vo;
		for (int i = 0; i < vos.size(); i++) {
			vo = vos.get(i);
			data[i][0] = DocType.getName(vo.type);
			data[i][1] = vo.ID;
			data[i][2] = MyDate.toString(vo.date);
			data[i][3] = vo.loc.getName();
			data[i][4] = UserfulMethod.orderArrayToString(vo.orders);
			
		}
		
	}

	public InStoreDocVO getInStoreVO(int index) {
		return vos.get(index);
	}

	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data);
//		table.setBounds(0, 0, 500,700);
//		setRowAndColumnLen(rowLen, columnLen);
		table.setFont(GraphicsUtils.getFont(null));

	}

	@Override
	protected void initialTitleAndColumn(Element config,MyDate date) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTableMes() {
//		System.out.println("invoke inpanel table");
		
		setDataValue();
		//将增加table的行数
		Object[] tmp = {"","","","",""};
		
		for(int i = table.getRowCount();i<vos.size();i++)
			addOneRow(tmp);
		
		for(int i = 0;i<vos.size();i++){
			for(int j = 0;j<COLUMN_NUM;j++)
				table.setValueAt(data[i][j], i, j);
		}
		
	}

}
