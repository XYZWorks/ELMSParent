package ui.storeman.storeshow;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import org.dom4j.Element;

import bl.storebl.StoreController;
import config.StaticMessage;
import ui.storeman.StoreManController;
import ui.storemanager.StoreManagerController;
import ui.tools.MyComboBox;
import ui.tools.MyJumpListener;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MyWhitePanel;
import ui.util.CompomentType;
import ui.util.PanelController;

@SuppressWarnings("serial")
public class StoreManShowPanel extends MyPanel {
	
	StoreController bl;
	
	protected MyPictureButton confirmButton;
	protected MyPictureButton returnButton;
	
	
	protected MyLabel centerL;
	protected MyLabel storeNum;
	
	protected MyWhitePanel whitePanel;
	
	protected MyComboBox cityC;
	protected MyComboBox storeC;
	
	protected StoreManController controller;

	public StoreManShowPanel(Element config, StoreController bl, StoreManController controller) {
		super(config);
		this.bl = bl;
		this.controller = controller;
		
		initLabels(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));

		initOtherCompoment(config);
		initWhitePanels(config.element(CompomentType.WHITEPANELS.name()));
		addCompoment();
		addListener();
	}

	@Override
	protected void initWhitePanels(Element e) {
		whitePanel=new MyWhitePanel(100,150,600,220);
		//whitePanel=new MyWhitePanel(e.element("whitePanel"));
		
	}
	@Override
	protected void initButtons(Element e) {
		confirmButton = new MyPictureButton(e.element("confirm"));
		returnButton = new MyPictureButton(e.element("return"));
			
	}

	@Override
	protected void initTextFields(Element e) {
		

	}

	@Override
	protected void initLabels(Element e) {
		centerL = new MyLabel(e.element("center"));
		storeNum = new MyLabel(e.element("store"));
	}

	@Override
	protected void initOtherCompoment(Element e) {
		cityC = new MyComboBox(e.element("city"));
		storeC = new MyComboBox(e.element("store"));
		whitePanel=new MyWhitePanel(new Rectangle(65,90,500,480));

	}

	@Override
	protected void addCompoment() {
		
		whitePanel.add(centerL);
		whitePanel.add(cityC);
		whitePanel.add(storeC);
		whitePanel.add(storeNum);
		
		add(whitePanel);
		
		add(confirmButton);
		add(returnButton);
	}
	
	
	
	@Override
	protected void addListener() {
		confirmButton.addMouseListener(new SingleShowListener(confirmButton, "StoreManSingleShowPanel", controller));
		returnButton.addMouseListener(new MyJumpListener(returnButton, StaticMessage.MAIN_WINDOW, controller,false));


	}
	

	class SingleShowListener extends MyJumpListener {

		public SingleShowListener(MyPictureButton button, String toPanel,
				PanelController controller) {
			super(button, toPanel, controller, false);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			StoreManSingleShowPanel tmp = (StoreManSingleShowPanel) controller
					.getPanelMap().get("StoreManSingleShowPanel");
			tmp.getInfo(cityC.getSelectedItem().toString(), storeC
					.getSelectedItem().toString());
		}
	}

}
