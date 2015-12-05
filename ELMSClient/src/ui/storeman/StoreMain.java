package ui.storeman;

import org.dom4j.Element;

import ui.tools.MyDatePicker;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.CompomentType;
import ui.util.MyMainPanelButtonListener;
import ui.util.PanelController;

/**
*中转中心业务员 主界面
*@author:xingcheng
*@version 2015年11月26日
*/
public class StoreMain extends MyPanel{
	

	
	public StoreMain(Element config , PanelController panelController) {
		super(config);
		controller = panelController;
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initLables(config.element(CompomentType.LABELS.name()));
		addCompoment();
		addListener();
		repaint();
		setVisible(true);
	}



	@Override
	protected void initButtons(Element e) {
		transportButton = new MyPictureButton(e.element("transport"));
		arriveZZButton = new MyPictureButton(e.element("arriveZZ"));
		storeButton = new MyPictureButton(e.element("store"));
		
	}


	@Override
	protected void initTextFields(Element e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void initLables(Element e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void initOtherCompoment(Element e) {
		date = new MyDatePicker(e.element("DatePicker"));
		
	}


	@Override
	protected void addCompoment() {
		this.add(transportButton);
		this.add(arriveZZButton);
		this.add(storeButton);
		
		this.add(date);
	}


	@Override
	protected void addListener() {
		transportButton.addMouseListener(new MyMainPanelButtonListener(transportButton, "TransportPanel", controller));
		arriveZZButton.addMouseListener(new MyMainPanelButtonListener(arriveZZButton, "ArriveZZPanel", controller));
		storeButton.addMouseListener(new MyMainPanelButtonListener(storeButton, "StorePanel", controller));
		
	}
	
	private MyPictureButton transportButton;
	private MyPictureButton arriveZZButton;
	private MyPictureButton storeButton;
	
	private PanelController controller;
	private MyDatePicker date;
	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
