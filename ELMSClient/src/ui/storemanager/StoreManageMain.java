package ui.storemanager;

import org.dom4j.Element;

import ui.tools.MyDatePicker;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.CompomentType;
import ui.util.MyMainPanelButtonListener;
import ui.util.PanelController;

/**
*中转中心管理员 主界面
*@author:xingcheng
*@version 2015年11月26日
*/
public class StoreManageMain extends MyPanel{
	
	private MyPictureButton inStoreButton;
	private MyPictureButton outStoreButton;
	private MyPictureButton storeShowButton;
	private MyPictureButton storeCheckButton;
	private MyPictureButton alarmSetButton;
	private MyPictureButton alarmRecoverButton;
	
	private PanelController controller;
	
	private MyDatePicker date;
	
	public StoreManageMain(Element config,PanelController controller) {
		super(config);
		this.controller = controller;
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
		
		inStoreButton =  new MyPictureButton(e.element("inStore"));
		outStoreButton =  new MyPictureButton(e.element("outStore"));
		storeShowButton =  new MyPictureButton(e.element("storeShow"));
		storeCheckButton =  new MyPictureButton(e.element("storeCheck"));
		alarmSetButton =  new MyPictureButton(e.element("alarmSet"));
		alarmRecoverButton =  new MyPictureButton(e.element("alarmRecover"));

		
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
		this.add(inStoreButton);
		this.add(outStoreButton);
		this.add(alarmRecoverButton);
		this.add(alarmSetButton);
		this.add(storeCheckButton);
		this.add(storeShowButton);
		
		this.add(date);
	}

	@Override
	protected void addListener() {
		inStoreButton.addMouseListener(new MyMainPanelButtonListener(inStoreButton, "InStorePanel", controller));
		outStoreButton.addMouseListener(new MyMainPanelButtonListener(outStoreButton, "OutStorePanel", controller));
		storeShowButton.addMouseListener(new MyMainPanelButtonListener(storeShowButton, "StoreShowPanel", controller));
		storeCheckButton.addMouseListener(new MyMainPanelButtonListener(storeCheckButton, "StoreCheckPanel", controller));
		alarmSetButton.addMouseListener(new MyMainPanelButtonListener(alarmSetButton, "AlarmSetPanel", controller));
		alarmRecoverButton.addMouseListener(new MyMainPanelButtonListener(alarmRecoverButton, "AlarmRecoverPanel", controller));
		
	}

}
