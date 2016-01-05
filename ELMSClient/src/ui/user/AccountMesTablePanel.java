package ui.user;

import java.util.ArrayList;

import org.dom4j.Element;

import ui.config.GraphicsUtils;
import ui.table.MyTable;
import ui.table.MyTablePanel;
import util.AccountType;
import vo.account.AccountVO;
import blservice.accountblservice.Accountblservice;
 /** 
 * 
 * @author czq 
 * @version 2015年12月3日 下午4:29:56 
 */
@SuppressWarnings("serial")
public class AccountMesTablePanel extends MyTablePanel{
	
	private static final int COLUMN_NUM = 4;
	
	private Accountblservice bl;
	
	private ArrayList<AccountVO> vos;
	
	public AccountMesTablePanel(Element config , Accountblservice bl) {
		super(config);
		this.bl = bl;
		initialTitleAndColumn(config);
		initTable();
		initScrollerPane();
		this.add(rollpane);
		
		int[] columnLen = {40,40,100,100};
		setRowAndColumnLen(30, columnLen);
	}
	

	
	
	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = getColumnName(config.attributeValue("columnName"));
		
		vos = bl.show();
		data = new String[vos.size()][COLUMN_NUM];
		AccountVO vo;
		for (int i = 0; i < vos.size(); i++) {
			vo = vos.get(i);
			data[i][0] = vo.ID;
			data[i][1] =  vo.name;
			data[i][2] = vo.type.getName();
			data[i][3] = vo.password;
		}
		
	}

	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data);
		
		table.setFont(GraphicsUtils.getFont(null));
		
	}

	@Override
	public void updateTableMes() {
		vos = bl.show();
		if(vos == null){
			return;
		}
		
		removeAllRows();
		String[] temp = new String[4];
		AccountVO vo;
		for (int i = 0; i < vos.size(); i++) {
			vo = vos.get(i);
			temp[0] = vo.ID;
			temp[1] =  vo.name;
			temp[2] = vo.type.getName();
			temp[3] = vo.password;
			addOneRow(temp);
		}
		
	}

	
	
	


}
