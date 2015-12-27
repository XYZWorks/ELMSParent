package ui.saleman.LoadDoc;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.tools.CheckDocPanel;
import ui.tools.MyLabel;
import blservice.transportblservice.Transportblservice;
 /** 
 * 装车单信息查看表
 * @author czq 
 * @version 2015年12月8日 下午8:27:08 
 */
@SuppressWarnings("serial")
public class LoadDocCheckPanel extends CheckDocPanel{
	
	Transportblservice bl;
	LoadDocMesTable myTable;
	LoadDocAddPanel myAddPanel;
	private MyLabel title;
	
	public LoadDocCheckPanel(Element config, JPanel changePanel , String checkDocName , String addDocName, Transportblservice transportblservice) {
		super(config, changePanel , checkDocName , addDocName);
		this.bl = transportblservice;
		myTable = (LoadDocMesTable) messageTable;
		myTable.bl = this.bl;
		myAddPanel = (LoadDocAddPanel) addDocPanel;
		myAddPanel.bl = this.bl;
		myAddPanel.reinit();
		initTableContent();
	}

	@Override
	protected void initialAddDocPanelAndTable(Element e) {
		messageTable = new LoadDocMesTable(e.element(tableStr), bl);
		addDocPanel = new LoadDocAddPanel(e.element(addDocPanelStr), changePanel , checkDocPanelStr, messageTable);
		
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
		// TODO Auto-generated method stub
		
	}
	
		
//		protected void initLabels(Element e) {
//}

}
