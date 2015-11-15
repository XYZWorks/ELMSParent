package test.approval;

import java.util.ArrayList;

import util.DocType;
import util.ResultMessage;
import vo.DocVO;
import blservice.DocApprovalService;

/**
 * 
 * @author czq
 * @version 2015年11月15日 上午10:15:25
 */
public class MockDocs implements DocApprovalService {

	public ArrayList<DocVO> getDocLists(DocType type) {
		switch (type) {
		case arriveYYDoc:

			break;
		case arriveZZDoc:

			break;
		case inStoreDoc:

			break;
		case loadDoc:

			break;
		case order:

			break;
		case outStoreDoc:

			break;
		case sendGoodDoc:

			break;
		case transferDoc:

			break;

		default:
			break;
		}
		return null;
	}

	public ResultMessage changeDocsState(ArrayList<String> docsID) {
		
		return ResultMessage.SUCCESS;
	}

	public ResultMessage changeOneDocState(String docID) {
		return ResultMessage.SUCCESS;
	}

}
