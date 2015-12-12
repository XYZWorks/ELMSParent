package ui.saleman.PayDoc;

import java.util.ArrayList;

import org.dom4j.Element;

import ui.table.MyTablePanel;
import vo.transport.PayDocVO;
import blservice.transportblservice.Transportblservice;
 /** 
 * 付款单信息表
 * @author czq 
 * @version 2015年12月8日 下午8:30:50 
 */
@SuppressWarnings("serial")
public class PayDocMesTable extends MyTablePanel{
	
	Transportblservice bl;
	
	ArrayList<PayDocVO> vos;
	
	String[] oneData = new String[COLUMN_NUM];
 	private static final int COLUMN_NUM = 5;
	
	public PayDocMesTable(Element config) {
		super(config);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateTableMes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initialTitleAndColumn(Element config) {
columnNames = MyTablePanel.getColumnName(config.attributeValue(columnStr));
		
//		vos = bl.get
		
		if(vos == null || vos.isEmpty()){
			return;
		}
		
		data = new String[vos.size()][COLUMN_NUM];
		PayDocVO vo;
		for (int i = 0; i < vos.size(); i++) {
			vo = vos.get(i);
			
//			data[i][0] = vo.ID;
//			data[i][1] = MyDate.toString(vo.date);
//			data[i][2] = vo.YYID;
//			data[i][3] = vo.loadDocID;
//			data[i][4] = vo.arriveCity.getName();
//			data[i][5] = vo.carID;
//			data[i][6] = vo.supervisor;
//			data[i][7] = vo.escort;
//			data[i][8] = String.valueOf(vo.orderBarCodes.size());
			
		}
		
	}

	@Override
	protected void initTable() {
		// TODO Auto-generated method stub
		
	}

}
