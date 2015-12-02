package ui.user;

import org.dom4j.Element;

import config.StaticMessage;
import ui.tools.MyPanel;
import ui.tools.MySideBarButton;
import ui.util.ButtonState;
import ui.util.CompomentType;
import ui.util.MySideBarListener;
import ui.util.PanelController;
 /** 
 * 管理员界面控制器
 * @author czq 
 * @version 2015年11月26日 下午3:07:45 
 */
public class AdminstratorController extends PanelController{
	
	private MySideBarButton addAccountButton;
	private MySideBarButton modifyAccountButton;
	
	private MyPanel AdminMainPanel;
	private MyPanel addAccountPanel;
	private MyPanel modifyAccountPanel;
	
	private final static String adminPanelStr = StaticMessage.MAIN_WINDOW;
	private final static String addAccountPanelStr = "AddAccountPanel";
	private final static String modifyAccountPanelStr = "ModifyAccountPanel";
	
	public AdminstratorController(MyPanel initialPanel, Element e) {
		super(initialPanel , e);
		initButtons(e.element(CompomentType.BUTTONS.name()));
		initPanel(e);
		addButtons();
		addPanels();
		addListeners();
	}

	@Override
	protected void initPanel(Element e) {
		AdminMainPanel = new UserManageMain(e.element(adminPanelStr), this);
		addAccountPanel = new AddAccountPanel(e.element(addAccountPanelStr));
		modifyAccountPanel = new ModifyAccountPanel(e.element(modifyAccountPanelStr));
		
	}

	@Override
	protected void initButtons(Element e) {
		addAccountButton = new MySideBarButton(e.element("AddAccount"));
		modifyAccountButton = new MySideBarButton(e.element("ModifyAccount"));
	}

	@Override
	protected void addButtons() {
		mainPanel.add(addAccountButton);
		mainPanel.add(modifyAccountButton);
		
	}

	@Override
	protected void addPanels() {
		changePanel.add(addAccountPanel, addAccountPanelStr);
		changePanel.add(modifyAccountPanel, modifyAccountPanelStr);
		changePanel.add(AdminMainPanel,adminPanelStr);
	}

	@Override
	protected void addListeners() {
		addAccountButton.addMouseListener(new MySideBarListener(addAccountButton, this, addAccountPanelStr));
		modifyAccountButton.addMouseListener(new MySideBarListener(modifyAccountButton, this, modifyAccountPanelStr));
	}

	@Override
	public void setAllButtonUnClicked() {
		addAccountButton.setMyIcon(ButtonState.NORMAL);
		modifyAccountButton.setMyIcon(ButtonState.NORMAL);
		
	}

	@Override
	public void setAllButtonVisable(boolean state) {
		addAccountButton.setVisible(state);
		modifyAccountButton.setVisible(state);
	}

	@Override
	protected void addToMap() {
		buttonMap.put(addAccountPanelStr, addAccountButton);
		buttonMap.put(modifyAccountPanelStr, modifyAccountButton);
		
	}

	

}
