package ui.saleman;

import java.awt.Color;

import org.dom4j.Element;

import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.CompomentType;
import ui.util.MyMainPanelButtonListener;
import ui.util.PanelController;

/**
*营业厅业务员 主界面
*@author:xingcheng
*@version 2015年11月26日
*/
@SuppressWarnings("serial")
public class SaleManMain extends MyPanel{
	
	private MyPictureButton arriveYYDocButton;
	private MyPictureButton driverInfoManageButton;
	private MyPictureButton loadDocButton;
	private MyPictureButton payDocButton;
	private MyPictureButton sendGoodDocButton;
	private MyPictureButton truckInfoManageButton;
	
	private PanelController controller;
	

	public SaleManMain(Element config,PanelController controller) {
		super(config);
		this.controller = controller;
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initLabels(config.element(CompomentType.LABELS.name()));
		addCompoment();
		addListener();
		repaint();
		setBackground(new Color(241, 241, 241));
		setVisible(true);
		
	}

	@Override
	protected void initWhitePanels(Element e) {
		
		
		
	}

	@Override
	protected void initButtons(Element e) {
		arriveYYDocButton = new MyPictureButton(e.element("arriveYYDoc"));
		driverInfoManageButton = new MyPictureButton(e.element("driverInfoManage"));
		loadDocButton = new MyPictureButton(e.element("loadDoc"));
		payDocButton = new MyPictureButton(e.element("payDoc"));
		sendGoodDocButton = new MyPictureButton(e.element("sendGoodDoc"));
		truckInfoManageButton = new MyPictureButton(e.element("truckInfoManage"));
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
		
		
	}

	@Override
	protected void addCompoment() {
		this.add(arriveYYDocButton);
		this.add(loadDocButton);
		this.add(driverInfoManageButton);
		this.add(payDocButton);
		this.add(sendGoodDocButton);
		this.add(truckInfoManageButton);
		
		
	}

	@Override
	protected void addListener() {
		arriveYYDocButton.addMouseListener(new MyMainPanelButtonListener(arriveYYDocButton, "arriveYYDocShowPanel", controller));
		driverInfoManageButton.addMouseListener(new MyMainPanelButtonListener(driverInfoManageButton, "driverInfoManagePanel", controller));
		loadDocButton.addMouseListener(new MyMainPanelButtonListener(loadDocButton, "loadDocShowpanel", controller));
		payDocButton.addMouseListener(new MyMainPanelButtonListener(payDocButton, "payDocShowPanel", controller));
		sendGoodDocButton.addMouseListener(new MyMainPanelButtonListener(sendGoodDocButton, "sendGoodDocShowPanel", controller));
		truckInfoManageButton.addMouseListener(new MyMainPanelButtonListener(truckInfoManageButton, "truckInfoManagePanel", controller));
	}

}
