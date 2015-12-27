package blservice.statisticblservice;

import java.util.ArrayList;

import util.ResultMessage;
import vo.statistic.BillVO;
import vo.statistic.CostIncomeVO;
import vo.statistic.StateFormVO;
 /** * @author czq @version 创建时间：2015年10月26日 上午12:15:19 * 简单说明 */
public class StatisticblService_Driver {
	public void drive(Statisticblservice bl){
		ResultMessage result;
		ArrayList<StateFormVO> temp1;
		ArrayList<CostIncomeVO> temp2;
		
		System.out.println("增加经营状况表");
		result = bl.bulidStateForm(new StateFormVO(null, null, null, null));
		if(result ==  ResultMessage.SUCCESS){
			System.out.println("增加成功");
		}
		
		System.out.println("增加成本收益表");
		result = bl.bulidCostIncomeForm(new CostIncomeVO(3000, 2000, null, null));
		if(result ==  ResultMessage.SUCCESS){
			System.out.println("增加成功");
		}
		
		System.out.println("获得经营状况表");
		temp1 = bl.getStateForm();
		System.out.println("成功获得" + temp1.size() + "张经营状况表");
		
		System.out.println("获得成本收益表");
		temp2 = bl.getIncomeForm();
		System.out.println("成功获得" + temp2.size() + "张收益表");
		
		System.out.println("新建账单");
		result = bl.bulidBill(new BillVO());
		if(result ==  ResultMessage.SUCCESS){
			System.out.println("增加成功");
		}
		
		System.out.println("获得账单");
		ArrayList<BillVO> temp3 = bl.getBills();
		System.out.println("成功获得" + temp3.size() + "张账单");
		
		
	}
}
