package test.java.store;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import test.java.other.DataTool;
import util.DocState;
import util.DocType;
import util.ResultMessage;
import vo.DocVO;
import vo.store.InStoreDocVO;
import vo.store.OutStoreDocVO;
import vo.store.StoreCheckVO;
import vo.store.StoreMessageVO;
import bl.storebl.StoreController;
import blservice.storeblservice.InStoreDocService;
import blservice.storeblservice.OutStoreDocService;
import blservice.storeblservice.StoreblService;
/** 
 * 
 * @author czq 
 * @version 2015年11月15日 下午2:39:34 
 */
public class StoreControllerTest {
	
	StoreblService bl ;
	InStoreDocService in;
	OutStoreDocService out;

	ResultMessage result;
	
	
	@Before
	public void setUp() throws Exception {
		bl = new StoreController();
	}

	@Test
	public void testShow() {
		ArrayList<StoreMessageVO> vos = bl.show();
		
		if(vos==null)
			fail("fail to show");
	}

	@Test
	public void testShowCheck() {
		ArrayList<StoreCheckVO> vos = bl.showCheck();
		
		if(vos==null)
			fail("fail to show");
	}

	@Test
	public void testExportExcel() {
		result=bl.exportExcel("D:\\exportForm");
		if(result!=ResultMessage.SUCCESS)
			fail("fail to export");
	}

	@Test
	public void testUpdate() {
		if(result!=ResultMessage.SUCCESS)
			fail("fail to update");
	}

	@Test
	public void testSetAlarmValue() {
		result = bl.setAlarmValue("90%");
		if(result!=ResultMessage.SUCCESS)
			fail("fail to set alarm value");

	}

	@Test
	public void testGetDocLists() {
		ArrayList<InStoreDocVO> vos = (ArrayList<InStoreDocVO>) in.getDocLists(DocType.inStoreDoc);
		if(vos==null)
			fail("Not yet implemented");
	}


	@Test
	public void testChangeDocsState() {
		ArrayList<InStoreDocVO> vos = (ArrayList<InStoreDocVO>) in.getDocLists(DocType.inStoreDoc);
		ArrayList<String> ids=null;
		for(DocVO vo:vos)
			ids.add(vo.ID);
		result = in.changeDocsState(ids, DocType.inStoreDoc, DocState.pass);
		if(result!=ResultMessage.SUCCESS)
			fail("Not change states");	
	}

	@Test
	public void testChangeOneDocState() {
		
		ArrayList<InStoreDocVO> vos = (ArrayList<InStoreDocVO>) in.getDocLists(DocType.inStoreDoc);
		
		String id=vos.get(0).ID;
		
		result = in.changeOneDocState(id, DocType.inStoreDoc, DocState.pass);
		
		if(result!=ResultMessage.SUCCESS)
			fail("Not change states");		}

	@Test
	public void testGenerateOutStoreDocVO() {
		
		ArrayList<OutStoreDocVO> vos = (ArrayList<OutStoreDocVO>) DataTool.getDocList(DocType.outStoreDoc);
		
		result=out.generate(vos.get(0));
		
		if(result!=ResultMessage.SUCCESS)
			fail("Not generate");		

				
	}

	@Test
	public void testGenerateInStoreDocVO() {
		ArrayList<InStoreDocVO> vos = (ArrayList<InStoreDocVO>) DataTool.getDocList(DocType.inStoreDoc);
		
		result=in.generate(vos.get(0));
		
		if(result!=ResultMessage.SUCCESS)
			fail("Not generate");		
	}

	@Test
	public void testShowOutStoreDocs() {
		ArrayList<OutStoreDocVO> vos =out.showOutStoreDocs();
		if(vos==null)
			fail("Not yet implemented");
	}

	@Test
	public void testShowInstoreDocs() {
		ArrayList<InStoreDocVO> vos =in.showInstoreDocs();
		if(vos==null)
			fail("Not yet implemented");
	}

}
