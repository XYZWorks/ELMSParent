package ui.saleman.PayDoc;

import java.util.ArrayList;

import org.dom4j.Element;

import blservice.transportblservice.Transportblservice;
import ui.table.MyTablePanel;
import vo.transport.LoadDocVO;
import vo.transport.PayDocVO;
 /** 
 * 
 * @author czq 
 * @version 2015年12月8日 下午8:30:50 
 */
@SuppressWarnings("serial")
public class PayDocMesTable extends MyTablePanel{
	
	Transportblservice bl;
	
	ArrayList<PayDocVO> vos;
	
	String[] oneData = new String[COLUMN_NUM];
 	private static final int COLUMN_NUM = 9;
	
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
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initTable() {
		// TODO Auto-generated method stub
		
	}

}
