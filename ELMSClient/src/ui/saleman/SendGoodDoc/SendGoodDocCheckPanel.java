package ui.saleman.SendGoodDoc;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.tools.CheckDocPanel;
import ui.tools.MyLabel;
import blservice.transportblservice.Transportblservice;
 /** 
 * 派送单查看界面
 * @author czq 
 * @version 2015年12月8日 下午8:33:08 
 */
@SuppressWarnings("serial")
public class SendGoodDocCheckPanel extends CheckDocPanel {
	
	private MyLabel title;
	
	Transportblservice bl;
	SendGoodMesTable myTable;
	
	SendGoodDocAddPanel myAddPanel;
	
	public SendGoodDocCheckPanel(Element config, JPanel changePanel , String checkDocName , String addDocName, Transportblservice transportblservice) {
		super(config, changePanel , checkDocName , addDocName);
		this.bl = transportblservice;
		myTable = (SendGoodMesTable) messageTable;
		myTable.bl = this.bl;
		myAddPanel = (SendGoodDocAddPanel) addDocPanel;
		myAddPanel.bl = this.bl;
		myAddPanel.myInit();
		initTableContent();
	}

	@Override
	protected void initialAddDocPanelAndTable(Element e) {
		messageTable = new SendGoodMesTable(e.element(tableStr));
		addDocPanel = new SendGoodDocAddPanel(e.element(addDocPanelStr), changePanel , checkDocPanelStr, messageTable , bl);
		
	}

	@Override
	protected void initialDifferComp(Element e) {
		title = new MyLabel(e.element("title"));// TODO Auto-generated method stub

	}



	@Override
	protected void addListener() {
		super.addListener();
	}

	@Override
	protected void addDifferComp() {
		add(title);
		
	}

}
