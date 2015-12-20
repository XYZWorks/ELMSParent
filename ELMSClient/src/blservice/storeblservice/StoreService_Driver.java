package blservice.storeblservice;

import java.util.ArrayList;

import util.ResultMessage;
import vo.store.StoreMessageVO;

public class StoreService_Driver {
	public void drive(StoreblService store){
		ResultMessage result = null;
		System.out.println("更新库存信息");
		if(result==ResultMessage.SUCCESS)
			System.out.println("更新库存信息成功");
		else
			System.out.println("更新库存信息失败");
		
		System.out.println("设置库存报警");
		//result=store.setAlarmValue("90","sd");
		if(result==ResultMessage.SUCCESS)
			System.out.println("设置库存报警成功");
		else
			System.out.println("设置库存报警失败");
		
		System.out.println("导出excel");
		result=store.exportExcel("/graph/01");
		if(result==ResultMessage.SUCCESS)
			System.out.println("设置库存报警成功");
		else
			System.out.println("设置库存报警失败");
		
		System.out.println("显示库存信息");
		ArrayList<StoreMessageVO> vos=store.show();
		for(StoreMessageVO vo:vos){
			System.out.println(vo.location+" "+vo.number+" "+vo.inStoreDocs+" "+vo.outStoreDocs);
		}
		

	}
}
