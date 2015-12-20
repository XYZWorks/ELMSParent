package ui.courier.FindFullInfo;

import org.dom4j.Element;

import blservice.orderblservice.Orderblservice;
import ui.courier.inputInfoReceive.inputReceiveTablePanel;
import ui.tools.MyPanel;
import ui.tools.MyPanelWithScroller;
import ui.util.CompomentType;

public class showInfoPanel extends MyPanelWithScroller{
	private Orderblservice bl;
	private showTable showTable;

	public showInfoPanel(Element config,Orderblservice orderblservice) {
		super(config);
		this.bl=bl;
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initLabels(config.element(CompomentType.LABELS.name()));
		addCompoment();
		addListener();
		setVisible(true);
	}

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initButtons(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initTextFields(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initLabels(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initOtherCompoment(Element e) {
		showTable=new showTable(e.element("showTable"), bl);
		
	}

	@Override
	protected void addCompoment() {
		this.add(showTable);
		
	}

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub
		
	}

}
