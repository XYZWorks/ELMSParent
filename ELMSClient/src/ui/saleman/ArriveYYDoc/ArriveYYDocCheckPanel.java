package ui.saleman.ArriveYYDoc;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.tools.CheckDocPanel;
import ui.tools.MyDatePicker;
import ui.tools.MyPictureButton;
import ui.tools.MySerachBox;
/**
 * 接收单查看界面
 * @author czq
 *
 */
@SuppressWarnings("serial")
public class ArriveYYDocCheckPanel extends CheckDocPanel{

	

	public ArriveYYDocCheckPanel(Element config, JPanel changePanel , String checkDocName , String addDocName) {
		super(config, changePanel , checkDocName , addDocName);
		// TODO Auto-generated constructor stub
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
