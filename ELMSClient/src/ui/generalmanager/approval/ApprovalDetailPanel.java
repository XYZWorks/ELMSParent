package ui.generalmanager.approval;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.courier.AddOrder.AddOrderPanel;
import ui.saleman.ArriveYYDoc.ArriveYYDocAddPanel;
import ui.saleman.LoadDoc.LoadDocAddPanel;
import ui.saleman.SendGoodDoc.SendGoodDocAddPanel;
import ui.storeman.arrivezz.ArriveZZDocAdd;
import ui.storeman.transport.AddTransportPanel;
import ui.storemanager.instore.AddInStorePanel;
import ui.storemanager.outstore.AddOutStorePanel;
import ui.tools.MyCardLayOut;
import ui.util.DocPanelForApproval;
import util.DocType;


 /** 
 * 单据审批的详细界面，含有各个单据界面的引用~
 * @author czq 
 * @version 2015年12月24日 上午10:43:21 
 */
public class ApprovalDetailPanel{
	
	private JPanel changePanel;
	private MyCardLayOut panelManager;
	
	private ArriveYYDocAddPanel arriveYYDocPanel;
	private LoadDocAddPanel loadDocPanel;
	private ArriveZZDocAdd arriveZZPanel;
	private SendGoodDocAddPanel sendGoodDocPanel;
	private AddInStorePanel inStorePanel;
	private AddOutStorePanel outStorePanel;
	private AddTransportPanel transportPanel;
	private AddOrderPanel orderPanel;
	private Map<DocType, DocPanelForApproval> docsPanels = new HashMap<>(12);
	
	
	
	public ApprovalDetailPanel(Element config , JPanel changePanel ) {
		
		this.changePanel = changePanel;
		this.panelManager = (MyCardLayOut) changePanel.getLayout();
		
		myInit(config);
		addToMap();
		setPanelState();
	}
	
	private void myInit(Element e) {
		
		arriveYYDocPanel = new ArriveYYDocAddPanel(e.element("arriveYYDocShowPanelAddPanel"), changePanel, ApprovalDocsPanel.approvalPanelStr, null);
		loadDocPanel = new LoadDocAddPanel(e.element("loadDocShowpanelAddPanel"), changePanel, ApprovalDocsPanel.approvalPanelStr, null);
		sendGoodDocPanel = new SendGoodDocAddPanel(e.element("sendGoodDocShowPanelAddPanel"), changePanel, ApprovalDocsPanel.approvalPanelStr, null);
		arriveZZPanel = new ArriveZZDocAdd(e.element("AddArriveZZPanel"), null, null);
		inStorePanel = new AddInStorePanel(e.element("AddInStorePanel"), null, null);
		outStorePanel = new AddOutStorePanel(e.element("AddOutStorePanel"), null, null);
//		orderPanel = new AddOrderPanel(e.element(""), null, null);
		transportPanel = new AddTransportPanel(e.element("AddTransportPanel"), null, null);
	}
	
	/**
	 * 跳转至单据详细信息界面
	 * @param message 作为信息传入单据界面
	 * @param type
	 */
	void jumpToDocPanel(Object message , DocType type){
		System.out.println(type);
		docsPanels.get(type).setMessage(message);
		
		panelManager.show(changePanel, type.name());
	}
	
	
	private void addToMap(){
		docsPanels.put(DocType.arriveYYDoc, arriveYYDocPanel);
		docsPanels.put(DocType.loadDoc, loadDocPanel);
		docsPanels.put(DocType.sendGoodDoc, sendGoodDocPanel);
		docsPanels.put(DocType.arriveZZDoc, arriveZZPanel);
		docsPanels.put(DocType.inStoreDoc, inStorePanel);
		docsPanels.put(DocType.outStoreDoc, outStorePanel);
//		docsPanels.put(DocType.order, orderPanel);
		docsPanels.put(DocType.transferDoc, transportPanel);
	}
	/**
	 * 将所有panel的无关组件设置为不可见或不可修改
	 */
	private void setPanelState(){
		for (Entry<DocType, DocPanelForApproval> docPanel : docsPanels.entrySet()) {
			docPanel.getValue().setAllCompUneditOrUnVisiable();
			docPanel.getValue().addBackButton(changePanel, ApprovalDocsPanel.approvalPanelStr);
			changePanel.add((Component) docPanel.getValue(), docPanel.getKey().name());
		}
	}
}
