package ui.storemanager.outstore;

import java.util.ArrayList;

import org.dom4j.Element;

import ui.config.GraphicsUtils;
import ui.config.UserfulMethod;
import ui.table.MyTable;
import ui.table.MyTablePanel;
import util.DocType;
import util.MyDate;
import util.TransferWay;
import vo.store.OutStoreDocVO;
import bl.storebl.StoreController;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月9日 下午7:57:29 
 *
 */
@SuppressWarnings("serial")
public class OutStoreTablePanel extends MyTablePanel {

	private static final int COLUMN_NUM = 7;

	private StoreController bl;

	private ArrayList<OutStoreDocVO> vos;

	public OutStoreTablePanel(Element config, StoreController bl, MyDate date) {
		super(config);
		this.bl = bl;
		initialTitleAndColumn(config);
		initTable();
		initScrollerPane();
		this.add(rollpane);
		int[] columnLen = { 80, 190, 100, 40, 180,60,250 };
		this.setRowAndColumnLen(30, columnLen);
	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = getColumnName(config.attributeValue("columnName"));
		
		
		setDataValue();
		

	}
	
	/**
	 * 重新得到数据层的数据
	 */
	public void setDataValue() {
		vos = bl.showOutStoreDocs();
		
		if(vos==null){
			return;
		}
		data = new String[vos.size()][COLUMN_NUM];
		OutStoreDocVO vo;
		for (int i = 0; i < vos.size(); i++) {
			vo = vos.get(i);
			data[i][0] = DocType.getName(vo.type);
			data[i][1] = vo.ID;
			data[i][2] = MyDate.toString(vo.date);
			data[i][3] = vo.loc.getName();
			data[i][4] = vo.transferDoc;
			data[i][5] = TransferWay.getTransferWay(vo.shipWay.name());
			data[i][6] = UserfulMethod.orderArrayToString(vo.orders);
			
		}
		
	}

	public OutStoreDocVO getOutStoreVO(int index) {
		return vos.get(index);
	}

	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
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
		
		Object[] tmp = {"","","","","","",""};
		
		for(int i = table.getRowCount();i<vos.size();i++)
			addOneRow(tmp);
		
		for(int i = 0;i<vos.size();i++){
			for(int j = 0;j<COLUMN_NUM;j++)
				table.setValueAt(data[i][j], i, j);
		}
		
	}
	
	/**
	 * 根据传入的vosout重设table的值
	 * @param vosout
	 */
	public void resetValue(ArrayList<OutStoreDocVO> vosout) {
		vos = vosout;
		if(vos==null){
			return;
		}
		data = new String[vos.size()][COLUMN_NUM];
		OutStoreDocVO vo;
		for (int i = 0; i < vos.size(); i++) {
			vo = vos.get(i);
			data[i][0] = DocType.getName(vo.type);
			data[i][1] = vo.ID;
			data[i][2] = MyDate.toString(vo.date);
			data[i][3] = vo.loc.getName();
			data[i][4] = vo.transferDoc;
			data[i][5] = TransferWay.getTransferWay(vo.shipWay.name());
			data[i][6] = UserfulMethod.orderArrayToString(vo.orders);
			
		}
		removeAllRows();
		Object[] tmp = {"","","","","","",""};
		
		for(int i = table.getRowCount();i<vos.size();i++)
			addOneRow(tmp);
		
		for(int i = 0;i<vos.size();i++){
			for(int j = 0;j<COLUMN_NUM;j++)
				table.setValueAt(data[i][j], i, j);
		}
	}
	
	
}
