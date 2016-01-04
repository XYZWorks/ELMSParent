package DTManage;

import java.util.ArrayList;
import java.util.Date;

import util.DocType;
import util.ResultMessage;
import vo.DocVO;
import vo.order.OrderVO;
import bl.DataTool;
import bl.orderbl.OrderController;

/** 
 * @author ymc 
 * @version 创建时间：2015年11月10日 上午9:38:13 
 *
 */
public class MockOrder extends OrderController {
	
	public ArrayList<OrderVO> getOrderVO(Date date) {
		ArrayList<OrderVO> temp = new ArrayList<OrderVO>();
		int size = DataTool.getDocList(DocType.order).size();
		for (int i = 0; i < size; i++) {
			temp.add((OrderVO)DataTool.getDocList(DocType.order).get(i));
			
		}
		return temp;
	}

	
	public ResultMessage addDocToList(DocVO vo) {
		return ResultMessage.SUCCESS;
	}

	
}
