package test.transport;

import java.util.ArrayList;

import util.DocType;
import util.ResultMessage;
import vo.DocVO;
 /** 
 * 
 * @author czq 
 * @version 2015年11月15日 上午10:48:46 
 */
public class MockOrder{
	
	public ResultMessage addDocToList(DocVO vo) {	
		return ResultMessage.SUCCESS;
	}
	
	public ArrayList<DocVO> getDocLists(DocType type) {
		
		return null;
	}

	

}
