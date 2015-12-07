package ui.financeman.bankAccount;

import java.util.ArrayList;

import org.dom4j.Element;

import blservice.financeblservice.BankAccountBusinessService;
import ui.table.MyTablePanel;
import vo.finance.BankAccountVO;
 /** 
 * 银行账户列表
 * @author czq 
 * @version 2015年12月6日 下午8:18:48 
 */
@SuppressWarnings("serial")
public class BankAccountTable extends MyTablePanel{
	
	BankAccountBusinessService blService;
	
	ArrayList<BankAccountVO> vos;
	
	
	public BankAccountTable(Element config , BankAccountBusinessService blService) {
		super(config);
		this.blService = blService;
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
