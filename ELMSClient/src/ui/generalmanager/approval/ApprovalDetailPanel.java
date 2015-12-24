package ui.generalmanager.approval;

import java.awt.CardLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.saleman.ArriveYYDoc.ArriveYYDocAddPanel;
import ui.saleman.LoadDoc.LoadDocAddPanel;
import ui.saleman.SendGoodDoc.SendGoodDocAddPanel;
import ui.storeman.arrivezz.ArriveZZDocAdd;
import ui.storeman.arrivezz.ArriveZZPanel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
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
//	private Transfer
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
		addToChangePanel();
		addToMap();
		setPanelState();
	}
	
	private void myInit(Element e) {
//		back = new MyPictureButton(e.element("back"));
		
		arriveYYDocPanel = new ArriveYYDocAddPanel(e.element("arriveYYDocShowPanelAddPanel"), changePanel, ApprovalDocsPanel.approvalPanelStr, null);
		loadDocPanel = new LoadDocAddPanel(e.element("loadDocShowpanelAddPanel"), changePanel, ApprovalDocsPanel.approvalPanelStr, null);
		sendGoodDocPanel = new SendGoodDocAddPanel(e.element(""), changePanel, ApprovalDocsPanel.approvalPanelStr, null);
	}
	
	private void addToChangePanel(){
		changePanel.add(arriveYYDocPanel, DocType.arriveYYDoc.name());
		changePanel.add(loadDocPanel , DocType.loadDoc.name());
		changePanel.add(sendGoodDocPanel , DocType.sendGoodDoc.name());
	}
	private void addToMap(){
		docsPanels.put(DocType.arriveYYDoc, arriveYYDocPanel);
		docsPanels.put(DocType.loadDoc, loadDocPanel);
		docsPanels.put(DocType.sendGoodDoc, sendGoodDocPanel);
	}
	private void setPanelState(){
		arriveYYDocPanel.setAllCompUneditOrUnVisiable();
		arriveYYDocPanel.addBackButton(changePanel, ApprovalDocsPanel.approvalPanelStr);
		loadDocPanel.setAllCompUneditOrUnVisiable();
		loadDocPanel.addBackButton(changePanel, ApprovalDocsPanel.approvalPanelStr);
		sendGoodDocPanel.setAllCompUneditOrUnVisiable();
		sendGoodDocPanel.addBackButton(changePanel, ApprovalDocsPanel.approvalPanelStr);
	}
}
