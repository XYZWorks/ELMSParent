package ui.storemanager.storeshow;

import java.util.ArrayList;

import org.dom4j.Element;

import po.order.OrderSimpleInfoPO;
import ui.storemanager.instore.ShowLocTablePanel;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月12日 下午2:06:22 
 *
 */
public class OrderInfoTable extends ShowLocTablePanel {

	public OrderInfoTable(Element config) {
		super(config);
		// TODO Auto-generated constructor stub
	}

	public void resetValue(ArrayList<String> orderBars, ArrayList<String> locs) {
		orders = orderBars;
		this.locs = locs;
		reset();
		
	}


}
