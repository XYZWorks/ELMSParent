package ui.storemanager.storeshow;

import org.dom4j.Element;

import ui.storemanager.instore.ShowLocTablePanel;
import vo.store.StoreShowVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月12日 下午2:06:22 
 *
 */
@SuppressWarnings("serial")
public class OrderInfoTable extends ShowLocTablePanel {
	
	
	
	public OrderInfoTable(Element config) {
		super(config);
	}

	public void resetValue(StoreShowVO show) {
		orders = show.orders;
		locs = show.locs;

		reset();
		
	}



}
