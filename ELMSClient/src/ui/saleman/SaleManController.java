package ui.saleman;

import org.dom4j.Element;

import bl.BusinessLogicDataFactory;
import blservice.DTManageblservice.DTManageblservice;
import blservice.DTManageblservice.DTManageblservice_Stub;
import blservice.transportblservice.Transportblservice;
import ui.saleman.ArriveYYDoc.ArriveYYDocCheckPanel;
import ui.saleman.CarManage.CarManageCheckPanel;
import ui.saleman.DriverManage.DriverManageCheckPanel;
import ui.saleman.LoadDoc.LoadDocCheckPanel;
import ui.saleman.PayDoc.PayDocCheckPanel;
import ui.saleman.SendGoodDoc.SendGoodDocCheckPanel;
import ui.tools.CheckDocPanel;
import ui.tools.MyPanel;
import ui.tools.MySideBarButton;
import ui.util.ButtonState;
import ui.util.CompomentType;
import ui.util.MySideBarListener;
import ui.util.PanelController;
import config.StaticMessage;
 /** 
 * 营业厅业务员界面跳转控制器
 * @author czq 
 * @version 2015年11月26日 下午3:40:59 
 */
public class SaleManController extends PanelController {
	private MyPanel saleManMainPanel;
	private CheckDocPanel loadDocShowPanel;
	private CheckDocPanel arriveYYDocShowPanel;
	private CheckDocPanel sendGoodDocShowPanel;
	private CheckDocPanel payDocShowPanel;
	private CheckDocPanel driverInfoManagePanel;
	private CheckDocPanel truckInfoManagePanel;


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
	
	private static final String postStr = "AddPanel";
	
	private Transportblservice transportblservice;
	private DTManageblservice dtManageblservice;
	
	public SaleManController(MyPanel initialPanel, Element e) {
		super(initialPanel , e);
		initialBL();
		initButtons(e.element(CompomentType.BUTTONS.name()));
		initPanel(e);
		addButtons();
		addPanels();
		addListeners();
		addToMap();
		this.setAllButtonVisable(false);
		panelManager.show(changePanel, saleManMainStr);
		changePanel.setVisible(true);
	}
	
	@Override
	protected void initialBL() {
		transportblservice = BusinessLogicDataFactory.getFactory().getTransportblservice();
		dtManageblservice = BusinessLogicDataFactory.getFactory().getDTManageBusinessLogic();
//		dtManageblservice = new DTManageblservice_Stub();
	}
	
	
	@Override
	protected void initPanel(Element e) {
		saleManMainPanel = new SaleManMain(e.element(saleManMainStr),this);
		arriveYYDocShowPanel = new ArriveYYDocCheckPanel(e.element(arriveYYDocShowPanelStr) , changePanel , arriveYYDocShowPanelStr , arriveYYDocShowPanelStr + postStr , transportblservice);
		driverInfoManagePanel = new DriverManageCheckPanel(e.element(driverInfoManagePanelStr), changePanel , driverInfoManagePanelStr , driverInfoManagePanelStr + postStr , dtManageblservice);
		loadDocShowPanel = new LoadDocCheckPanel(e.element(loadDocShowpanelStr), changePanel , loadDocShowpanelStr , loadDocShowpanelStr + postStr , transportblservice);
		payDocShowPanel = new PayDocCheckPanel(e.element(payDocShowPanelStr), changePanel , payDocShowPanelStr , payDocShowPanelStr +postStr  , transportblservice);
		sendGoodDocShowPanel = new SendGoodDocCheckPanel(e.element(sendGoodDocShowPanelStr), changePanel , sendGoodDocShowPanelStr , sendGoodDocShowPanelStr + postStr , transportblservice);
		truckInfoManagePanel = new CarManageCheckPanel(e.element(truckInfoManagePanelStr), changePanel , truckInfoManagePanelStr , truckInfoManagePanelStr + postStr ,dtManageblservice);
		
	}

	@Override
	protected void initButtons(Element e) {
		arriveYYDocButton = new MySideBarButton(e.element("arriveYYDoc"));
		driverInfoManageButton = new MySideBarButton(e.element("driverInfoManage"));
		loadDocButton = new MySideBarButton(e.element("loadDoc"));
		payDocButton = new MySideBarButton(e.element("payDoc"));
		sendGoodDocButton = new MySideBarButton(e.element("sendGoodDoc"));
		truckInfoManageButton = new MySideBarButton(e.element("truckInfoManage"));
				
		
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
		changePanel.add(saleManMainPanel,saleManMainStr);
		changePanel.add(arriveYYDocShowPanel,arriveYYDocShowPanelStr);
		changePanel.add(driverInfoManagePanel,driverInfoManagePanelStr);
		changePanel.add(loadDocShowPanel,loadDocShowpanelStr);
		changePanel.add(payDocShowPanel,payDocShowPanelStr);
		changePanel.add(sendGoodDocShowPanel,sendGoodDocShowPanelStr);
		changePanel.add(truckInfoManagePanel,truckInfoManagePanelStr);
		
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

	

	
}
