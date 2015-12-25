package ui.storeman.transport;

import java.util.ArrayList;

import org.dom4j.Element;

import ui.config.GraphicsUtils;
import ui.config.UserfulMethod;
import ui.table.MyTable;
import ui.table.MyTablePanel;
import util.DocType;
import util.MyDate;
import vo.transport.TransferDocVO;
import blservice.transportblservice.Transportblservice;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月5日 下午4:48:31 
 *
 */
@SuppressWarnings("serial")
public class TransportTablePanel extends MyTablePanel {

	private static final int COLUMN_NUM = 8;

	private Transportblservice bl;

	private ArrayList<TransferDocVO> vos;

	public TransportTablePanel(Element config, Transportblservice bl, MyDate date) {
		super(config);
		this.bl = bl;
		initialTitleAndColumn(config, date);
		initTable();
		initScrollerPane();
		this.add(rollpane);
		int[] columnLen = { 60, 140, 60, 130, 50,50,50,260};
		this.setRowAndColumnLen(30, columnLen);
	}

	@Override
	protected void initialTitleAndColumn(Element config,MyDate date) {
		columnNames = getColumnName(config.attributeValue("columnName"));
		setDataValue(date);
		

	}

	

	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data);
		table.setBounds(0, 0, 500,700);
//		setRowAndColumnLen(rowLen, columnLen);
		table.setFont(GraphicsUtils.getFont(null));

	}

	@Override
	public void updateTableMes() {
		setDataValue(MyDate.getNowTime());
		Object[] tmp = {"","","","","","","",""};
		
		for(int i = table.getRowCount();i<vos.size();i++)
			addOneRow(tmp);
		
		for(int i = 0;i<vos.size();i++){
			for(int j = 0;j<COLUMN_NUM;j++)
				table.setValueAt(data[i][j], i, j);
		}
	}

	private void setDataValue(MyDate date) {
		vos = bl.getDayTransferDocs(date);
		if(vos==null)
			return;
		data = new String[vos.size()][COLUMN_NUM];
		TransferDocVO vo;
		for (int i = 0; i < vos.size(); i++) {
			vo = vos.get(i);
			data[i][0] = DocType.getName(vo.type);
			data[i][1] = vo.ID;
			data[i][2] = MyDate.toString(vo.date);
			data[i][3] = vo.transferWayID;
			data[i][4] = vo.sendCity.getName();
			data[i][5] = String.valueOf(vo.containerNum);
			data[i][6] = vo.loadManName;
			data[i][7] = UserfulMethod.orderArrayToString(vo.orderBarCode);
		}
		
	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		// TODO Auto-generated method stub
		
	}

}
