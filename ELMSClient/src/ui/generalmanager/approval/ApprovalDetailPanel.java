package ui.generalmanager.approval;

import java.awt.CardLayout;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.saleman.ArriveYYDoc.ArriveYYDocAddPanel;
import ui.saleman.LoadDoc.LoadDocAddPanel;
import ui.saleman.SendGoodDoc.SendGoodDocAddPanel;
import ui.storeman.arrivezz.ArriveZZDocAdd;
import ui.storemanager.instore.AddInStorePanel;
import ui.storemanager.outstore.AddOutStorePanel;
import ui.util.DocPanelForApproval;
import util.DocType;


 /** 
 * 单据审批的详细界面，含有各个单据界面的引用~
 * @author czq 
 * @version 2015年12月24日 上午10:43:21 
 */
public class ApprovalDetailPanel{
	
	private JPanel changePanel;
	private CardLayout panelManager;
	private ApprovalDocsPanel approvalDocsPanel;
	
	private DocType type;
	
	private ArriveYYDocAddPanel arriveYYDocPanel;
	private LoadDocAddPanel loadDocPanel;
	private ArriveZZDocAdd arriveZZPanel;
	private SendGoodDocAddPanel sendGoodDocPanel;
	private AddInStorePanel inStorePanel;
	private AddOutStorePanel outStorePanel;
//	private TransferD
	private Map<DocType, DocPanelForApproval> docsPanels = new HashMap<>(15);
	
	
	void jumpToDocPanel(Object message , DocType type){
		System.out.println(type);
		docsPanels.get(type).setMessage(message);
		
		panelManager.show(changePanel, type.name());
	}
	
	public ApprovalDetailPanel(Element config , JPanel changePanel , ApprovalDocsPanel approvalDocsPanel) {
		
		this.approvalDocsPanel = approvalDocsPanel;
		this.changePanel = changePanel;
		this.panelManager = (CardLayout) changePanel.getLayout();
		
		myInit(config);
		addToMap();
		setPanelState();
	}
	
	private void myInit(Element e) {
//		back = new MyPictureButton(e.element("back"));
		
		arriveYYDocPanel = new ArriveYYDocAddPanel(e.element("arriveYYDocShowPanelAddPanel"), changePanel, ApprovalDocsPanel.approvalPanelStr, null);
		loadDocPanel = new LoadDocAddPanel(e.element("loadDocShowpanelAddPanel"), changePanel, ApprovalDocsPanel.approvalPanelStr, null);
		sendGoodDocPanel = new SendGoodDocAddPanel(e.element("sendGoodDocShowPanelAddPanel"), changePanel, ApprovalDocsPanel.approvalPanelStr, null);
		arriveZZPanel = new ArriveZZDocAdd(e.element("AddArriveZZPanel"), null, null);
		inStorePanel = new AddInStorePanel(e.element("AddInStorePanel"), null, null);
		outStorePanel = new AddOutStorePanel(e.element("AddOutStorePanel"), null, null);
	
	}
	
	private void addToMap(){
		docsPanels.put(DocType.arriveYYDoc, arriveYYDocPanel);
		docsPanels.put(DocType.loadDoc, loadDocPanel);
		docsPanels.put(DocType.sendGoodDoc, sendGoodDocPanel);
		docsPanels.put(DocType.arriveZZDoc, arriveZZPanel);
		docsPanels.put(DocType.inStoreDoc, inStorePanel);
		docsPanels.put(DocType.outStoreDoc, outStorePanel);
	}
	private void setPanelState(){
		for (Entry<DocType, DocPanelForApproval> docPanel : docsPanels.entrySet()) {
			docPanel.getValue().setAllCompUneditOrUnVisiable();
			docPanel.getValue().addBackButton(changePanel, ApprovalDocsPanel.approvalPanelStr);
			changePanel.add((Component) docPanel.getValue(), docPanel.getKey().name());
		}
	}
}
