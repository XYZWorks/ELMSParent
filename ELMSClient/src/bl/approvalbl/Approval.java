package bl.approvalbl;

import java.util.ArrayList;

import util.DocState;
import util.DocType;
import util.ResultMessage;
import vo.DocVO;
import blservice.orderblservice.Orderblservice;
import blservice.storeblservice.InStoreDocService;
import blservice.storeblservice.OutStoreDocService;
import blservice.transportblservice.Transportblservice;

/**
 * @author ymc
 * @version 创建时间：2015年10月27日 下午7:45:13
 *
 */
public class Approval {
	private Transportblservice transportbl;
	private Orderblservice orderbl;
	private InStoreDocService instorebl;
	private OutStoreDocService outStorebl;

	public Approval(Transportblservice transportbl, Orderblservice orderbl,
			InStoreDocService instorebl, OutStoreDocService outStorebl) {
		this.orderbl = orderbl;
		this.instorebl = instorebl;
		this.outStorebl = outStorebl;
		this.transportbl = transportbl;
	}

	public ArrayList<? extends DocVO> getBills(DocType type) {
		switch (type) {
		case arriveYYDoc:
		case arriveZZDoc:
		case sendGoodDoc:
		case loadDoc:
		case transferDoc:
			return transportbl.getDocLists(type);
		case order:
			return orderbl.getDocLists(type);
		case inStoreDoc:
			return instorebl.getDocLists(type);
		case outStoreDoc:
			return outStorebl.getDocLists(type);

		default:
			break;
		}
		return null;
	}

	public ResultMessage approveOne(DocVO vo) {
		switch (vo.type) {
		case arriveYYDoc:
		case arriveZZDoc:
		case sendGoodDoc:
		case loadDoc:
		case transferDoc:
			return transportbl.changeOneDocState(vo.ID, vo.type, DocState.pass);
		case order:
			return orderbl.changeOneDocState(vo.ID, vo.type, DocState.pass);
		case inStoreDoc:
			return instorebl.changeOneDocState(vo.ID, vo.type, DocState.pass);
		case outStoreDoc:
			return outStorebl.changeOneDocState(vo.ID, vo.type, DocState.pass);
		default:
			break;
		}
		return null;
	}

	public ResultMessage approveMany(ArrayList<? extends DocVO> vos) {
		if(vos == null){
			return null;
		}
		
		ArrayList<String> ids = new ArrayList<>(vos.size());
		for (int i = 0 ; i < vos.size() ; i ++) {
			ids.add(vos.get(i).ID);
		}
		
		DocType type = vos.get(0).type;
		switch (type) {
		case arriveYYDoc:
		case arriveZZDoc:
		case sendGoodDoc:
		case loadDoc:
		case transferDoc:
			return transportbl.changeDocsState(ids, type, DocState.pass);
		case order:
			return orderbl.changeDocsState(ids, type, DocState.pass);
		case inStoreDoc:
			return instorebl.changeDocsState(ids, type, DocState.pass);
		case outStoreDoc:
			return outStorebl.changeDocsState(ids, type, DocState.pass);
		default:
			break;
		}
		return null;
	}

}
