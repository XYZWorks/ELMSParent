package ui.saleman.ArriveYYDoc;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.tools.CheckDocPanel;
import ui.tools.MyLabel;
import blservice.transportblservice.Transportblservice;
/**
 * 接收单查看界面
 * @author czq
 *
 */
@SuppressWarnings("serial")
public class ArriveYYDocCheckPanel extends CheckDocPanel{
	
	private MyLabel title;
	
	Transportblservice bl;
	ArriveYYDocMesTable myTable;
	ArriveYYDocAddPanel addPanel;

	public ArriveYYDocCheckPanel(Element config, JPanel changePanel , String checkDocName , String addDocName, Transportblservice transportblservice) {
		super(config, changePanel , checkDocName , addDocName);
		this.bl = transportblservice;
		myTable = (ArriveYYDocMesTable) messageTable;
		myTable.bl = this.bl;
		addPanel = (ArriveYYDocAddPanel) addDocPanel;
		addPanel.bl = this.bl;
		initTableContent();
	}

	

	

	@Override
	protected void addListener() {
		super.addListener();
	}

	@Override
	protected void initialAddDocPanelAndTable(Element e) {
		messageTable = new ArriveYYDocMesTable(e.element(tableStr));
		addDocPanel = new ArriveYYDocAddPanel(e.element(addDocPanelStr), changePanel , checkDocPanelStr , messageTable);
		
	}

	@Override
	protected void initialDifferComp(Element e) {
		title = new MyLabel(e.element("title"));
	}

	




	@Override
	protected void addDifferComp() {
		add(title);
		
	}

}
