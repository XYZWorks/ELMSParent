package ui.storemanager.instore;

import java.util.ArrayList;

import org.dom4j.Element;

import bl.storebl.StoreController;
import ui.table.MyTablePanel;
import vo.store.InStoreDocVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月8日 上午10:15:27 
 *
 */
public class AddLocTablePanel extends MyTablePanel {
	
	private static final int COLUMN_NUM = 5;


	private ArrayList<String> orders;
	
	private ArrayList<String> locs;
	
	public AddLocTablePanel(Element config) {
		super(config);
		initialTitleAndColumn(config);
		initTable();
		initScrollerPane();
		this.add(rollpane);
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
