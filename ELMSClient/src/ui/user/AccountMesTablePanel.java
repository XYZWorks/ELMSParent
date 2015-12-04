package ui.user;

import java.util.ArrayList;

import org.dom4j.Element;

import blservice.accountblservice.Accountblservice;
import ui.config.UserfulMethod;
import ui.table.MyTable;
import ui.table.MyTablePanel;
import vo.account.AccountVO;
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
			data[i][2] = vo.type.name();
			data[i][3] = vo.password;
		}
	}

	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data);
	}

	


}