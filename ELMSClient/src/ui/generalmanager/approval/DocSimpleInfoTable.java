package ui.generalmanager.approval;

import java.util.ArrayList;

import org.dom4j.Element;

import blservice.approvalblservice.Approvalblservice;
import ui.table.MyTable;
import ui.table.MyTableModel;
import ui.table.MyTablePanel;
import util.DocState;
import util.DocType;
import util.MyDate;
import util.ResultMessage;
import vo.DocVO;
 /** 
 * 单据简要信息表
 * @author czq 
 * @version 2015年12月6日 下午7:10:28 
 */
@SuppressWarnings("serial")
public class DocSimpleInfoTable extends MyTablePanel{
	
	private final static int COLUMN_NUMS = 5;
	
	private Approvalblservice bl;
	
	private ArrayList<? extends DocVO> vos;
	
	private DocType type;
	
	public DocSimpleInfoTable(Element config , Approvalblservice bl , DocType type) {
		super(config);
		this.bl = bl;
		this.type = type;
		initialTitleAndColumn(config);
		initTable();
		initScrollerPane();
		this.add(rollpane);
	}

	@Override
	public void updateTableMes() {
		
		
		
		
		
	}
	
	/**
	 * 审批多个单据，返回成功个数
	 * @return
	 */
	public int approveMany(){
		ArrayList<Integer> selectedNum = getSelectedNum();
		int successCount = 0;
		
		if(selectedNum == null){
			return 0;
		}else{
			for (Integer nowint : selectedNum) {
				if(bl.approveOne(new DocVO( (String) getValueAt(nowint, 1)  , type , null , DocState.pass) ) == ResultMessage.SUCCESS){
					//删除一行会出现行数-1的问题，所以要减去偏移值
					removeRow(nowint - successCount);
					successCount++;
				}
			}
		}
		return successCount;
	}
	
	public boolean approvaeOne(){
		try {
			int nowint = getSelectedNum().get(0);
			
			if(bl.approveOne(new DocVO( (String) getValueAt(nowint, 1) , type , null , DocState.pass) ) == ResultMessage.SUCCESS){
				removeRow(nowint);
				return true;
			}
		} catch (Exception e) {
		}
		
		return false;
	}
	
	private ArrayList<Integer> getSelectedNum() {
		ArrayList<Integer> temp = new ArrayList<>();
		for (int i = 0; i < table.getRowCount(); i++) {
			if( ((Boolean)table.getValueAt(i, 0)).booleanValue() == true ){
				temp.add(i);
			}
		}
		
		
		
		return temp.isEmpty()?null:temp;
	}

	/**
	 * 转换显示单据的类型
	 * @param type
	 */
	public void changeDocType(DocType type){
		initialMes();
		this.type = type;
		MyTableModel dtm = new MyTableModel(columnNames, data);
		//第一列可修改
		table.setModel(dtm);
		try {
			setColumnEdit(true, 0);
		} catch (NullPointerException e) {
		}
	}
	
	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = MyTablePanel.getColumnName(config.attributeValue("column"));
		//默认显示订单
		initialMes();
		
	}

	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data);
		//第一列可修改
		try {
			setColumnEdit(true, 0);
		} catch (NullPointerException e) {
		}
		
		
	}
	
	
	private void initialMes(){
		vos =  bl.getBills(type);
		
		if(vos==null){
			return;
		}
		
		data = new Object[vos.size()][COLUMN_NUMS];
			for (int i = 0; i < vos.size(); i++) {
				data[i][0] = new Boolean(false);
				data[i][1] = vos.get(i).ID;
				data[i][2] = DocType.getName(vos.get(i).type);
				data[i][3] = MyDate.toString(vos.get(i).date);
				data[i][4] = DocState.getName(vos.get(i).state);
			}
	}
}
