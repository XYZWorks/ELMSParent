package ui.storemanager;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.dom4j.Element;

import bl.storebl.StoreController;
import blservice.storeblservice.StoreblService;
import config.StaticMessage;
import ui.storeman.StoreMain;
import ui.storeman.arrivezz.ArriveZZPanel;
import ui.storeman.storeshow.StoreShowPanel;
import ui.storeman.transport.TransportPanel;
import ui.storemanager.alarm.AlarmRecoverPanel;
import ui.storemanager.alarm.AlarmSetPanel;
import ui.storemanager.instore.AddInStorePanel;
import ui.storemanager.instore.FullInPanel;
import ui.storemanager.instore.InStorePanel;
import ui.storemanager.outstore.OutStorePanel;
import ui.storemanager.storecheck.StoreCheckPanel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.tools.MySideBarButton;
import ui.util.ButtonState;
import ui.util.CompomentType;
import ui.util.MySideBarListener;
import ui.util.PanelController;
 /** 
 * 仓库管理人员控制器
 * @author czq 
 * @version 2015年11月26日 下午3:39:40 
 */
public class StoreManagerController extends PanelController {
	
	StoreController bl;
	
	private MyPanel SMmainpanel;
	private MyPanel inStorePanel;
	private MyPanel outStorePanel;
	private MyPanel storeShowPanel;
	private MyPanel storeCheckPanel;
	private MyPanel alarmSetPanel;
	private MyPanel alarmRecoverPanel;
	

	private MySideBarButton inStoreButton;
	private MySideBarButton outStoreButton;
	private MySideBarButton storeShowButton;
	private MySideBarButton storeCheckButton;
	private MySideBarButton alarmSetButton;
	private MySideBarButton alarmRecoverButton;
	
	private final String SMmainpanelStr = StaticMessage.MAIN_WINDOW;
	private final String inStorePanelStr = "InStorePanel";
	private final String outStorePanelStr = "OutStorePanel";
	private final String storeShowPanelStr = "StoreShowPanel";
	private final String storeCheckPanelStr = "StoreCheckPanel";
	private final String alarmSetPanelStr = "AlarmSetPanel";
	private final String alarmRecoverPanelStr = "AlarmRecoverPanel";
	
	private MyPanel addInStorePanel;
	private final String addInStorePanelStr = "AddInStorePanel";
	private MyPanel fullInPanel;
	private final String fullInPanelStr = "FullInPanel";
	
	public StoreManagerController(MyPanel initialPanel, Element e) {
		super(initialPanel , e);
		initialBL();
		initButtons(e.element(CompomentType.BUTTONS.name()));
		initPanel(e);
		addButtons();
		addPanels();
		addListeners();
		addToMap();
		this.setAllButtonVisable(false);
		changePanel.setVisible(true);
	}

	@Override
	protected void initPanel(Element e) {
		SMmainpanel = new StoreManageMain(e.element(SMmainpanelStr) , this);
		inStorePanel = new InStorePanel(e.element(inStorePanelStr),bl,this);
		outStorePanel = new OutStorePanel(e.element(outStorePanelStr));
		storeCheckPanel = new StoreCheckPanel(e.element(storeCheckPanelStr));
		storeShowPanel = new StoreShowPanel(e.element(storeShowPanelStr));
		alarmRecoverPanel = new AlarmRecoverPanel(e.element(alarmRecoverPanelStr));
		alarmSetPanel = new AlarmSetPanel(e.element(alarmSetPanelStr));
		addInStorePanel = new AddInStorePanel(e.element(inStorePanelStr).element(addInStorePanelStr),bl,this);
		fullInPanel = new FullInPanel(e.element(inStorePanelStr).element(fullInPanelStr),bl,this);
		
	}

	@Override
	protected void initButtons(Element e) {
		inStoreButton = new MySideBarButton(e.element("inStore"));
		outStoreButton = new MySideBarButton(e.element("outStore"));
		storeCheckButton = new MySideBarButton(e.element("storeCheck"));
		storeShowButton = new MySideBarButton(e.element("storeShow"));
		alarmRecoverButton = new MySideBarButton(e.element("alarmRecover"));
		alarmSetButton = new MySideBarButton(e.element("alarmSet"));

		
	}

	@Override
	protected void addButtons() {
		mainPanel.add(inStoreButton);
		mainPanel.add(outStoreButton);
		mainPanel.add(storeCheckButton);
		mainPanel.add(storeShowButton);
		mainPanel.add(alarmRecoverButton);
		mainPanel.add(alarmSetButton);
		
	}

	@Override
	protected void addPanels() {
		changePanel.add(SMmainpanel,SMmainpanelStr);
		changePanel.add(inStorePanel, inStorePanelStr);
		changePanel.add(outStorePanel, outStorePanelStr);
		changePanel.add(storeShowPanel, storeShowPanelStr);
		changePanel.add(storeCheckPanel, storeCheckPanelStr);
		changePanel.add(alarmRecoverPanel, alarmRecoverPanelStr);
		changePanel.add(alarmSetPanel, alarmSetPanelStr);
		changePanel.add(addInStorePanel, addInStorePanelStr);
		changePanel.add(fullInPanel, fullInPanelStr);
		
	}

	@Override
	protected void addListeners() {
		inStoreButton.addMouseListener(new MySideBarListener(inStoreButton, this, inStorePanelStr));
		outStoreButton.addMouseListener(new MySideBarListener(outStoreButton, this , outStorePanelStr));
		storeCheckButton.addMouseListener(new MySideBarListener(storeCheckButton, this , storeCheckPanelStr));
		storeShowButton.addMouseListener(new MySideBarListener(storeShowButton, this , storeShowPanelStr));
		alarmRecoverButton.addMouseListener(new MySideBarListener(alarmRecoverButton, this , alarmRecoverPanelStr));
		alarmSetButton.addMouseListener(new MySideBarListener(alarmSetButton, this , alarmSetPanelStr));
		
	}

	@Override
	public void setAllButtonUnClicked() {
		inStoreButton.setMyIcon(ButtonState.NORMAL);
		outStoreButton.setMyIcon(ButtonState.NORMAL);
		storeShowButton.setMyIcon(ButtonState.NORMAL);
		storeCheckButton.setMyIcon(ButtonState.NORMAL);
		alarmRecoverButton.setMyIcon(ButtonState.NORMAL);
		alarmSetButton.setMyIcon(ButtonState.NORMAL);

		
	}

	@Override
	public void setAllButtonVisable(boolean state) {
		inStoreButton.setVisible(state);
		outStoreButton.setVisible(state);
		storeCheckButton.setVisible(state);
		storeShowButton.setVisible(state);
		alarmRecoverButton.setVisible(state);
		alarmSetButton.setVisible(state);

		
	}

	@Override
	protected void addToMap() {
		buttonMap.put(inStorePanelStr, inStoreButton);
		buttonMap.put(outStorePanelStr, outStoreButton);
		buttonMap.put(storeCheckPanelStr, storeCheckButton);
		buttonMap.put(storeShowPanelStr, storeShowButton);
		buttonMap.put(alarmRecoverPanelStr, alarmRecoverButton);
		buttonMap.put(alarmSetPanelStr, alarmSetButton);
		
		
	}

	@Override
	protected void initialBL() {
//		bl = new StoreController();
		
	}

	
	

}
