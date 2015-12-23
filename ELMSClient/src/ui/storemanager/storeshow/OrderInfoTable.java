package ui.storemanager.storeshow;

import java.util.ArrayList;

import org.dom4j.Element;

import po.order.OrderSimpleInfoPO;
import ui.storemanager.instore.ShowLocTablePanel;
import vo.store.InStoreDocVO;
import vo.store.OutStoreDocVO;

/** 
 * @author ymc 
 * @version 创建时间：2015年12月12日 下午2:06:22 
 *
 */
public class OrderInfoTable extends ShowLocTablePanel {
	
	ArrayList<String> ordertmp;
	
	public OrderInfoTable(Element config) {
		super(config);
	}

	public void resetValue(ArrayList<InStoreDocVO> ins, ArrayList<OutStoreDocVO> outs) {
		
		ordertmp = new ArrayList<>();
		orders = new ArrayList<>();
		locs = new ArrayList<>();
		
		//得到出库单中的订单号
		for(OutStoreDocVO out : outs){
			for(String order : out.orders)
				ordertmp.add(order);
		}
		
		//将已经出库的订单从订单列表删除
		for(InStoreDocVO in : ins){
			for(int i =0;i<in.orders.size();i++){
				if(hasOut(in.orders.get(i))){
					continue;
				}
				
				orders.add(in.orders.get(i));
				locs.add(in.location.get(i));
				
			}
		}
			
		reset();
		
	}

	private boolean hasOut(String ord) {
		
		for(String tmp : ordertmp){
			if(ord.equals(tmp)){
				return true;
			}
		}
			
		return false;
	}


}
