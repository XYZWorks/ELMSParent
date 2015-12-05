package ui.saleman;

import org.dom4j.Element;
/**
 * @author JerryZhang
 * 营业厅业务员界面跳转控制器
 *
 */
import config.StaticMessage;
import ui.tools.MyPanel;
import ui.tools.MySideBarButton;
import ui.util.ButtonState;
import ui.util.CompomentType;
import ui.util.MySideBarListener;
import ui.util.PanelController;
 /** 
 * 
 * @author czq 
 * @version 2015年11月26日 下午3:40:59 
 */
public class SaleManController extends PanelController {
	private MyPanel saleManMainPanel;
	private MyPanel loadDocShowPanel;
	private MyPanel arriveYYDocShowPanel;
	private MyPanel sendGoodDocShowPanel;
	private MyPanel payDocShowPanel;
	private MyPanel driverInfoManagePanel;
	private MyPanel truckInfoManagePanel;


	private MySideBarButton loadDocButton;
	private MySideBarButton arriveYYDocButton;
	private MySideBarButton sendGoodDocButton;
	private MySideBarButton payDocButton;
	private MySideBarButton driverInfoManageButton;
	private MySideBarButton truckInfoManageButton;
	
	private static final String saleManMainStr = StaticMessage.MAIN_WINDOW;
	private static final String loadDocShowpanelStr = "loadDocShowpanel";
	private static final String arriveYYDocShowPanelStr = "arriveYYDocShowPanel";
	private static final String sendGoodDocShowPanelStr = "sendGoodDocShowPanel";
	private static final String payDocShowPanelStr = "payDocShowPanel";
	private static final String driverInfoManagePanelStr = "driverInfoManagePanel";
	private static final String truckInfoManagePanelStr = "truckInfoManagePanel";
	
	public SaleManController(MyPanel initialPanel, Element e) {
		super(initialPanel , e);
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
		saleManMainPanel = new SaleManMain(e.element(saleManMainStr));
		arriveYYDocShowPanel = new ArriveYYDocShowPanel(e.element(arriveYYDocShowPanelStr));
		driverInfoManagePanel = new DriverInfoManagePanel(e.element(driverInfoManagePanelStr));
		loadDocShowPanel = new LoadDocShowPanel(e.element(loadDocShowpanelStr));
		payDocShowPanel = new PayDocShowPanel(e.element(payDocShowPanelStr));
		sendGoodDocShowPanel = new SendGoodDocShowPanel(e.element(sendGoodDocShowPanelStr));
		truckInfoManagePanel = new TruckInfoManagePanel(e.element(truckInfoManagePanelStr));
		
	}

	@Override
	protected void initButtons(Element e) {
		arriveYYDocButton = new MySideBarButton(e.element("ArriveYYDoc"));
		driverInfoManageButton = new MySideBarButton(e.element("DriverInfoManage"));
		loadDocButton = new MySideBarButton(e.element("LoadDoc"));
		payDocButton = new MySideBarButton(e.element("PayDoc"));
		sendGoodDocButton = new MySideBarButton(e.element("SendGoodDoc"));
		truckInfoManageButton = new MySideBarButton(e.element("TruckInfoManage"));
				
		
	}

	@Override
	protected void addButtons() {
		mainPanel.add(arriveYYDocButton);
		mainPanel.add(driverInfoManageButton);
		mainPanel.add(loadDocButton);
		mainPanel.add(payDocButton);
		mainPanel.add(sendGoodDocButton);
		mainPanel.add(truckInfoManageButton);
		
	}

	@Override
	protected void addPanels() {
		changePanel.add(saleManMainStr, saleManMainPanel);
		changePanel.add(arriveYYDocShowPanelStr, arriveYYDocShowPanel);
		changePanel.add(driverInfoManagePanelStr, driverInfoManagePanel);
		changePanel.add(loadDocShowpanelStr, loadDocShowPanel);
		changePanel.add(payDocShowPanelStr, payDocShowPanel);
		changePanel.add(sendGoodDocShowPanelStr, sendGoodDocShowPanel);
		changePanel.add(truckInfoManagePanelStr, truckInfoManagePanel);
		
	}

	@Override
	protected void addListeners() {
		arriveYYDocButton.addMouseListener(new MySideBarListener(arriveYYDocButton, this, arriveYYDocShowPanelStr));
		driverInfoManageButton.addMouseListener(new MySideBarListener(driverInfoManageButton, this, driverInfoManagePanelStr));
		loadDocButton.addMouseListener(new MySideBarListener(loadDocButton, this, loadDocShowpanelStr));
		payDocButton.addMouseListener(new MySideBarListener(payDocButton, this, payDocShowPanelStr));
		sendGoodDocButton.addMouseListener(new MySideBarListener(sendGoodDocButton, this, sendGoodDocShowPanelStr));
		truckInfoManageButton.addMouseListener(new MySideBarListener(truckInfoManageButton, this, truckInfoManagePanelStr));
		
		
	}

	@Override
	public void setAllButtonUnClicked() {
		arriveYYDocButton.setMyIcon(ButtonState.NORMAL);
		driverInfoManageButton.setMyIcon(ButtonState.NORMAL);
		loadDocButton.setMyIcon(ButtonState.NORMAL);
		payDocButton.setMyIcon(ButtonState.NORMAL);
		sendGoodDocButton.setMyIcon(ButtonState.NORMAL);
		truckInfoManageButton.setMyIcon(ButtonState.NORMAL);
		
	}

	@Override
	public void setAllButtonVisable(boolean state) {
		arriveYYDocButton.setVisible(state);
		driverInfoManageButton.setVisible(state);
		loadDocButton.setVisible(state);
		payDocButton.setVisible(state);
		sendGoodDocButton.setVisible(state);
		truckInfoManageButton.setVisible(state);
		
		
	}

	@Override
	protected void addToMap() {
		buttonMap.put(arriveYYDocShowPanelStr, arriveYYDocButton);
		buttonMap.put(driverInfoManagePanelStr, driverInfoManageButton);
		buttonMap.put(loadDocShowpanelStr, loadDocButton);
		buttonMap.put(payDocShowPanelStr, payDocButton);
		buttonMap.put(sendGoodDocShowPanelStr, sendGoodDocButton);
		buttonMap.put(truckInfoManagePanelStr, truckInfoManageButton);
		
		
	}

	@Override
	protected void initialBL() {
		// TODO Auto-generated method stub
		
	}

	
}
