package ui.storemanager;

import org.dom4j.Element;

import bl.storebl.StoreController;
import config.StaticMessage;
import ui.storemanager.alarm.AlarmRecoverPanel;
import ui.storemanager.alarm.AlarmSetPanel;
import ui.storemanager.alarm.AlarmSetSinglePanel;
import ui.storemanager.instore.AddInStorePanel;
import ui.storemanager.instore.FullInPanel;
import ui.storemanager.instore.InStorePanel;
import ui.storemanager.outstore.AddOutStorePanel;
import ui.storemanager.outstore.OutStorePanel;
import ui.storemanager.storecheck.StoreCheckInfoPanel;
import ui.storemanager.storecheck.StoreCheckPanel;
import ui.storemanager.storeshow.StoreShowPanel;
import ui.storemanager.storeshow.StoreSingleShowPanel;
import ui.tools.MyPanel;
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
	
	private AddInStorePanel addInStorePanel;
	private final String addInStorePanelStr = "AddInStorePanel";
	private FullInPanel fullInPanel;
	private final String fullInPanelStr = "FullInPanel";
	private AddOutStorePanel addOutStorePanel;
	private final String addOutStorePanelStr = "AddOutStorePanel";
	private StoreSingleShowPanel storeSingleShowPanel;
	private final String storeSingleShowPanelStr = "StoreSingleShowPanel";
	private StoreCheckInfoPanel storeCheckInfoPanel;
	private final String storeCheckInfoPanelStr = "StoreCheckInfoPanel";
	private AlarmSetSinglePanel alarmSetSinglePanel;
	private final String alarmSetSinglePanelStr = "AlarmSetSinglePanel";
	
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
		outStorePanel = new OutStorePanel(e.element(outStorePanelStr),bl,this);
		storeCheckPanel = new StoreCheckPanel(e.element(storeCheckPanelStr),bl,this);
		storeShowPanel = new StoreShowPanel(e.element(storeShowPanelStr),bl,this);
		alarmRecoverPanel = new AlarmRecoverPanel(e.element(alarmRecoverPanelStr));
		alarmSetPanel = new AlarmSetPanel(e.element(alarmSetPanelStr),bl,this);
		addInStorePanel = new AddInStorePanel(e.element(inStorePanelStr).element(addInStorePanelStr),bl,this);
		fullInPanel = new FullInPanel(e.element(inStorePanelStr).element(fullInPanelStr),bl,this);
		addOutStorePanel = new AddOutStorePanel(e.element(outStorePanelStr).element(addOutStorePanelStr), bl, this);
		storeSingleShowPanel = new StoreSingleShowPanel(e.element(storeShowPanelStr).element(storeSingleShowPanelStr),bl,this);
		storeCheckInfoPanel = new StoreCheckInfoPanel(e.element(storeCheckPanelStr).element(storeCheckInfoPanelStr), bl, this);
		alarmSetSinglePanel = new AlarmSetSinglePanel(e.element(alarmSetPanelStr).element(alarmSetSinglePanelStr),bl,this);
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
		changePanel.add(addOutStorePanel, addOutStorePanelStr);
		changePanel.add(storeSingleShowPanel,storeSingleShowPanelStr);
		changePanel.add(storeCheckInfoPanel,storeCheckInfoPanelStr);
		changePanel.add(alarmSetSinglePanel,alarmSetSinglePanelStr);
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
		
	
		panelMap.put(addInStorePanelStr, addInStorePanel);		
		panelMap.put(fullInPanelStr, fullInPanel);
		panelMap.put(inStorePanelStr, inStorePanel);
		panelMap.put(outStorePanelStr, outStorePanel);
		panelMap.put(storeSingleShowPanelStr, storeSingleShowPanel);
		panelMap.put(storeCheckInfoPanelStr, storeCheckInfoPanel);
		panelMap.put(alarmSetSinglePanelStr, alarmSetSinglePanel);
	}
	
	

	@Override
	protected void initialBL() {
		bl = new StoreController();
		
	}

	
	

}
