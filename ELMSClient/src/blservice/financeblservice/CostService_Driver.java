package blservice.financeblservice;

import java.util.ArrayList;

import util.CostType;
import vo.finance.CostVO;

/** 
* @author ymc 
* @version 创建时间：2015年10月26日 下午7:20:29 
*/
public class CostService_Driver {
	public void drive(CostService cost) {

		ArrayList<? extends CostVO> vos;
		System.out.println("显示信息");
		vos=cost.showCosts(CostType.FREIGHT);
		if(vos!=null){
			for(CostVO vo:vos){
				System.out.println(vo.money+" ");
			}
		}

		


	}
}
