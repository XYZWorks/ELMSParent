package ui.financeman.bankAccount;

import java.util.ArrayList;

import org.dom4j.Element;

import blservice.financeblservice.BankAccountBusinessService;
import ui.table.MyTable;
import ui.table.MyTablePanel;
import vo.account.AccountVO;
import vo.finance.BankAccountVO;
 /** 
 * 银行账户列表
 * @author czq 
 * @version 2015年12月6日 下午8:18:48 
 */
@SuppressWarnings("serial")
public class BankAccountTable extends MyTablePanel{
	
	private BankAccountBusinessService blService;
	
	private ArrayList<BankAccountVO> vos;
	
	private final static int COLUMN_NUMS = 3;
	
	
	public BankAccountTable(Element config , BankAccountBusinessService blService) {
		super(config);
		this.blService = blService;
		this.initialTitleAndColumn(config);
		this.initTable();
		this.initScrollerPane();
		this.add(rollpane);
	}

	@Override
	public void updateTableMes() {
		vos = blService.getAccounts();
		if(vos == null){
			return;
		}
		
		
		table.getModel().setRowCount(vos.size());
		
		BankAccountVO vo;
		for (int i = 0; i < vos.size(); i++) {
			vo = vos.get(i);
			table.setValueAt(vo.ID, i, 0);
			table.setValueAt(vo.password, i, 1);
			table.setValueAt(vo.money, i, 2);
		}
		
	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = MyTablePanel.getColumnName(config.attributeValue("column"));
		
		vos = blService.getAccounts();
		
		if(vos == null){
			return;
		}
		data = new Object[vos.size()][COLUMN_NUMS];
		BankAccountVO vo;
		for (int i = 0; i < vos.size(); i++) {
			vo = vos.get(i);
			data[i][0] = vo.ID;
			data[i][1] = vo.password;
			data[i][2] = vo.money;
		}
		
		
	}

	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data);
	}

}
