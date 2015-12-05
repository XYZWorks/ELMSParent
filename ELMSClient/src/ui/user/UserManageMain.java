package ui.user;

import org.dom4j.Element;

import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.CompomentType;
import ui.util.MyMainPanelButtonListener;
import ui.util.PanelController;

/**
 * 管理员主界面
 * @author czq
 *
 */
@SuppressWarnings("serial")
public class UserManageMain extends MyPanel{
	
	private MyPictureButton addAccountButton;
	private MyPictureButton modifyAccountButton;
	
	private PanelController controller;
	
	
	
	public UserManageMain(Element config , PanelController controller) {
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
		addAccountButton = new MyPictureButton(e.element("AddAccount"));
		modifyAccountButton = new MyPictureButton(e.element("ModifyAccount"));
	}

	@Override
	protected void initTextFields(Element e) {
	}

	@Override
	protected void initLables(Element e) {
	}

	@Override
	protected void initOtherCompoment(Element e) {
	}

	@Override
	protected void addCompoment() {
		this.add(addAccountButton);
		this.add(modifyAccountButton);
	}

	@Override
	protected void addListener() {
		addAccountButton.addMouseListener(new MyMainPanelButtonListener(addAccountButton, "AddAccountPanel", controller));
		modifyAccountButton.addMouseListener(new MyMainPanelButtonListener(modifyAccountButton, "ModifyAccountPanel", controller));
	}



	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub
		
	}

}
