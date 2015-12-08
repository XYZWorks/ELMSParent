package ui.courier;

import org.dom4j.Element;

import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.CompomentType;
import ui.util.MyMainPanelButtonListener;
import ui.util.PanelController;

/**
 * 快递员主界面
 * 
 * @author:xingcheng
 * @version 2015年11月26日
 */
@SuppressWarnings("serial")
public class CourierMainPanel extends MyPanel {

	private MyPictureButton addOrderButton;
	private MyPictureButton findFullInfoButton;
	private MyPictureButton inputReceiveButton;
	private PanelController controller;
	
	public CourierMainPanel(Element config,PanelController controller) {
		super(config);
		this.controller=controller;
		
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initLabels(config.element(CompomentType.LABELS.name()));
		addCompoment();
		addListener();
		setVisible(true);
	
	}

	@Override
	protected void initButtons(Element e) {
		addOrderButton = new MyPictureButton(e.element("AddOrder"));
		findFullInfoButton = new MyPictureButton(e.element("CheckOrder"));
		inputReceiveButton = new MyPictureButton(e.element("InputReceive"));
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
		// TODO Auto-generated method stub

	}

	@Override
	protected void addCompoment() {
		this.add(addOrderButton);
		this.add(findFullInfoButton);
		this.add(inputReceiveButton);
	

	}

	@Override
	protected void addListener() {
		addOrderButton.addMouseListener(new MyMainPanelButtonListener(addOrderButton, "addOrderPanel",controller));
		findFullInfoButton.addMouseListener(new MyMainPanelButtonListener(findFullInfoButton, "findFullInfoPanel",controller));
		inputReceiveButton.addMouseListener(new MyMainPanelButtonListener(inputReceiveButton, "inputReceiveInfoPanel",controller));
		
	}

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub
		
	}

	
}
