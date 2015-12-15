package ui.storeman.storeshow;

import java.awt.event.MouseEvent;

import org.dom4j.Element;

import bl.storebl.StoreController;
import config.StaticMessage;
import ui.storeman.StoreManController;
import ui.storemanager.storeshow.StoreSingleShowPanel;
import ui.tools.MyComboBox;
import ui.tools.MyJumpListener;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.CompomentType;
import ui.util.PanelController;

public class StoreManShowPanel extends MyPanel{
	
	
StoreController bl;
	
	private MyPictureButton confirmButton;
	private MyPictureButton returnButton;
	
	
	private MyLabel centerL;
	private MyLabel storeNum;
	
	MyComboBox cityC;
	MyComboBox storeC;
	
	StoreManController controller;

	public StoreManShowPanel(Element config, StoreController bl, StoreManController controller) {
		super(config);
		this.bl = bl;
		this.controller = controller;
		initLabels(config.element(CompomentType.LABELS.name()));
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));

		initOtherCompoment(config);
		addCompoment();
		addListener();
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

	}

	@Override
	protected void addCompoment() {
		add(centerL);
		add(cityC);
		add(confirmButton);
		add(returnButton);
		add(storeC);
		add(storeNum);
		

	}
	
	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void addListener() {
		confirmButton.addMouseListener(new SingleShowListener(confirmButton, "StoreManSingleShowPanel", controller));
		returnButton.addMouseListener(new MyJumpListener(returnButton, StaticMessage.MAIN_WINDOW, controller,false));


	}
	
	class SingleShowListener extends MyJumpListener{

		public SingleShowListener(MyPictureButton button, String toPanel, PanelController controller) {
			super(button, toPanel, controller,false);
			// TODO Auto-generated constructor stub
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			StoreManSingleShowPanel tmp  = (StoreManSingleShowPanel) controller.getPanelMap().get("StoreManSingleShowPanel");
			tmp.getInfo(cityC.getSelectedItem().toString(),storeC.getSelectedItem().toString());
		}
	}


}