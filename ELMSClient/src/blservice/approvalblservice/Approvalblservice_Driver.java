package blservice.approvalblservice;

import java.util.ArrayList;

import util.DocType;
import util.ResultMessage;
import vo.DocVO;
import vo.LoadDocVO;
 /** * @author czq @version 创建时间：2015年10月25日 下午3:29:34 * 简单说明 */
public class Approvalblservice_Driver {
	public void drive(Approvalblservice bl){
		ArrayList<DocVO> result;
		ResultMessage resultMes;
		
		
		System.out.println("获得单据");
		result = bl.getBills(DocType.order);
		System.out.println("获得" + DocType.getName(DocType.order) + "所有单据");
		
		System.out.println("审批单个单据");
		resultMes = bl.approveOne(new LoadDocVO(null, null, 0, 0, null, 0, null, null));
		if(resultMes == ResultMessage.SUCCESS){
			System.out.println("成功审批单据");
		}
		
		System.out.println("审批多个单据");
		result = new ArrayList<DocVO>();
		result.add(new LoadDocVO(null, null, 0, 0, null, 0, null, null));
		result.add(new LoadDocVO(null, null, 0, 0, null, 0, null, null));
		resultMes = bl.approveMany(result);
		if(resultMes == ResultMessage.SUCCESS){
			System.out.println("成功审批多个单据");
		}
		
		
		
		
		
		
	}
}
