package ui.saleman.PayDoc;

import javax.swing.JPanel;

import org.dom4j.Element;

import blservice.transportblservice.Transportblservice;
import ui.tools.CheckDocPanel;
import ui.tools.MyLabel;
 /** 
 * 付款单查看界面
 * @author czq 
 * @version 2015年12月8日 下午8:29:59 
 */
@SuppressWarnings("serial")
public class PayDocCheckPanel extends CheckDocPanel{
	
	private MyLabel title;
	
	PayDocMesTable myTable;
	PayDocAddPanel addPanel;
	Transportblservice bl;
	public PayDocCheckPanel(Element config, JPanel changePanel , String checkDocName , String addDocName, Transportblservice transportblservice) {
		super(config, changePanel , checkDocName , addDocName);
		this.bl = transportblservice;
		myTable = (PayDocMesTable) messageTable;
		myTable.bl = this.bl;
		addPanel = (PayDocAddPanel) addDocPanel;
		addPanel.bl = this.bl;
		initTableContent();
		
	}

	@Override
	protected void initialAddDocPanelAndTable(Element e) {
		messageTable = new PayDocMesTable(e.element(tableStr));
		addDocPanel = new PayDocAddPanel(e.element(addDocPanelStr), changePanel , checkDocPanelStr, messageTable);
		
		
	}

	@Override
	protected void initialDifferComp(Element e) {
		title = new MyLabel(e.element("title"));
		
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
