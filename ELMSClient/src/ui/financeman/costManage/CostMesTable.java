package ui.financeman.costManage;

import org.dom4j.Element;

import blservice.financeblservice.CostService;
import ui.table.MyTablePanel;
import util.CostType;
 /** 
 * 运费信息表格
 * @author czq 
 * @version 2015年12月18日 下午8:57:14 
 */
@SuppressWarnings("serial")
public class CostMesTable extends MyTablePanel {
	
	private CostService costService;
	
	
	

	public CostMesTable(Element config, CostType freight, CostService costService) {
		super(config);
		this.costService = costService;
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
	
	
	void setCostService(CostService costService) {
		this.costService = costService;
	}
}
