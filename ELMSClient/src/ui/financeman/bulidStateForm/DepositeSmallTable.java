package ui.financeman.bulidStateForm;

import java.util.ArrayList;

import org.dom4j.Element;

import ui.table.MyTable;
import ui.table.MyTablePanel;
import util.MyDate;
import vo.finance.PayVO;

/**
 *
 * @author:xingcheng
 * @version 2015年12月31日
 */
@SuppressWarnings("serial")
public class DepositeSmallTable extends MyTablePanel {

	public DepositeSmallTable(Element config) {
		super(config);
		myInit();

	}

	@Override
	public void updateTableMes() {

	}

	@Override
	protected void initialTitleAndColumn(Element config) {
		columnNames = MyTablePanel.getColumnName(config.attributeValue(columnStr));
		
		data = null;
		
		
	}


	@Override
	protected void initTable() {
		table = new MyTable(columnNames, data);

	}
	
	double setMessage(ArrayList<PayVO> vos){
		if(vos == null){
			return 0;
		}
		double sum = 0;
		String[] oneData = new String[8];
		removeAllRows();
		
		for (PayVO vo : vos) {
			oneData[0] = vo.ID;
			oneData[1] = vo.account;
			oneData[2] = vo.person;
			oneData[3] = MyDate.toString(vo.time);
			oneData[4] = String.valueOf(vo.money);
			oneData[5] = String.valueOf(vo.rent);
			oneData[6] = String.valueOf(vo.freight);
			oneData[7] = String.valueOf(vo.salary);
			addOneRow(oneData);
			sum += vo.money;
		}
		
		return sum;
		
		
	}
	
}
