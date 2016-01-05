package ui.saleman.PayDoc;

import java.awt.Color;
import java.util.ArrayList;

import org.dom4j.Element;

import ui.table.MyTable;
import ui.table.MyTablePanel;
import ui.util.TipsDialog;
import util.DocState;
import util.MyDate;
import vo.transport.PayDocVO;
import blservice.transportblservice.Transportblservice;
 /** 
 * 付款单信息表
 * @author czq 
 * @version 2015年12月8日 下午8:30:50 
 */
@SuppressWarnings("serial")
public class PayDocMesTable extends MyTablePanel{
	
	public Transportblservice bl;
	
	ArrayList<PayDocVO> vos;
	
	public boolean isApproval = false;
	String[] oneData = new String[COLUMN_NUM];
 	private static final int COLUMN_NUM = 6;
	
	public PayDocMesTable(Element config) {
		super(config);
	}

	@Override
	public void updateTableMes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = MyTablePanel.getColumnName(config.attributeValue(columnStr));
		
		vos = bl.getPays();
		
		if(vos == null || vos.isEmpty()){
			vos = new ArrayList<>();
			return;
		}
		
		
		data = new String[vos.size()][COLUMN_NUM];
		PayDocVO vo;
		for (int i = 0; i < vos.size(); i++) {
			vo = vos.get(i);
			if(isApproval){
				if(vo.state == DocState.pass){
					continue;
				}
			}
			data[i][0] = vo.ID;
			data[i][1] = MyDate.getPartDay(vo.date);
			data[i][2] = vo.YYID;
			data[i][3] = String.valueOf(vo.money);
			data[i][4] = vo.courierName;
			data[i][5] = String.valueOf(vo.orders.size());
			
		}
		
	}
	@Override
	public void addOneData(Object o, int type) {
		PayDocVO vo = (PayDocVO) o;
		if(type != 0){
			vos.add(vo);
		}
		String[] temp = new String[COLUMN_NUM];
		vos.add(vo);
		temp[0] = vo.ID;
		temp[1] = MyDate.getPartDay(vo.date);
		temp[2] = vo.YYID;
		temp[3] = String.valueOf(vo.money);
		temp[4] = vo.courierName;
		temp[5] = String.valueOf(vo.orders.size());
		addOneRow(temp);
	}
	@Override
	public void searchID(String id) {
		removeAllRows();
		for (int i = 0; i < vos.size(); i++) {
			if(vos.get(i).ID.equals(id)){
				addOneData(vos.get(i) , 0);
				new TipsDialog("成功找到一条信息", Color.GREEN);
				return;
			}
		}
		new TipsDialog("未找到任何一条信息");
	}
	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data);
		
	}
	
	public Object getARowMes(int row){
		String id = (String) getValueAt(row, 0);
		for (PayDocVO vo : vos) {
			if(vo.ID.equals(id)){
				return vo;
			}
		}
		return null;
	}
	@Override
	public void showAllMessages() {
		removeAllRows();
		for (int i = 0; i < vos.size(); i++) {
			addOneData(vos.get(i), 0);
		}
	}
	
}
