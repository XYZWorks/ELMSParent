package ui.saleman.PayDoc;

import javax.swing.JPanel;

import org.dom4j.Element;

import ui.tools.CheckDocPanel;
 /** 
 * 
 * @author czq 
 * @version 2015年12月8日 下午8:29:59 
 */
@SuppressWarnings("serial")
public class PayDocCheckPanel extends CheckDocPanel{

	public PayDocCheckPanel(Element config, JPanel changePanel , String checkDocName , String addDocName) {
		super(config, changePanel , checkDocName , addDocName);

		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initialAddDocPanelAndTable(Element e) {
		addDocPanel = new PayDocAddPanel(e.element(addDocPanelStr), changePanel , checkDocPanelStr);
		messageTable = new PayDocMesTable(e.element(tableStr));
		
	}

	@Override
	protected void initialDifferComp(Element e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void addListener() {
		super.addListener();		
	}

	@Override
	protected void addDifferComp() {
		// TODO Auto-generated method stub
		
	}

}
