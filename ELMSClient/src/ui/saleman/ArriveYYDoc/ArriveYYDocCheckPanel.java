package ui.saleman.ArriveYYDoc;

import javax.swing.JPanel;

import org.dom4j.Element;

import blservice.transportblservice.Transportblservice;
import ui.saleman.LoadDoc.LoadDocMesTable;
import ui.tools.CheckDocPanel;
import ui.tools.MyDatePicker;
import ui.tools.MyPictureButton;
import ui.tools.MySearchBox;
/**
 * 接收单查看界面
 * @author czq
 *
 */
@SuppressWarnings("serial")
public class ArriveYYDocCheckPanel extends CheckDocPanel{

	Transportblservice bl;
	ArriveYYDocMesTable myTable;

	public ArriveYYDocCheckPanel(Element config, JPanel changePanel , String checkDocName , String addDocName, Transportblservice transportblservice) {
		super(config, changePanel , checkDocName , addDocName);
		this.bl = transportblservice;
		myTable = (ArriveYYDocMesTable) messageTable;
		myTable.bl = this.bl;
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
		
	}

	




	@Override
	protected void addDifferComp() {
		// TODO Auto-generated method stub
		
	}

}
