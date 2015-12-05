package ui.storeman;

import org.dom4j.Element;

import blservice.transportblservice.Transportblservice;
import blservice.transportblservice.transportblservice_Driver;
import config.StaticMessage;
import ui.tools.MyAddListener;
import ui.tools.MyJumpListener;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.CompomentType;
import ui.util.PanelController;

/**
 *   到达单
 * @author xingcheng
 *
 */
public class ArriveZZDocAdd extends MyPanel{
	
	private MyPictureButton confirmButton;
	private MyPictureButton returnButton;
	
	PanelController controller;
	Transportblservice bl;
	public ArriveZZDocAdd(Element config,Transportblservice bl,PanelController controller) {
		super(config);
		this.bl = bl;
		this.controller = controller;
		initLables(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));

		initOtherCompoment(config);
		addCompoment();
		addListener();
	}

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initButtons(Element e) {
		confirmButton = new MyPictureButton(e.element("confirm"));
		returnButton = new MyPictureButton(e.element("return"));
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addCompoment() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addListener() {
		confirmButton.addMouseListener(new MyAddListener(confirmButton, bl));
		returnButton.addMouseListener(new MyJumpListener(returnButton, "ArriveZZPanel", controller));
		
	}

}
