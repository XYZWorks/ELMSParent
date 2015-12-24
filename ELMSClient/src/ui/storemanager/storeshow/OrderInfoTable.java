package ui.storemanager.storeshow;

import java.util.ArrayList;

import org.dom4j.Element;

import po.order.OrderSimpleInfoPO;
import ui.storemanager.instore.ShowLocTablePanel;
import vo.store.InStoreDocVO;
import vo.store.OutStoreDocVO;
import vo.store.StoreShowVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月12日 下午2:06:22 
 *
 */
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
