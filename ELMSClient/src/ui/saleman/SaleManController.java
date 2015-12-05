package ui.saleman;

import java.awt.event.MouseEvent;

import org.dom4j.Element;

import config.StaticMessage;
import ui.tools.MyPanel;
import ui.tools.MySideBarButton;
import ui.util.ButtonState;
import ui.util.CompomentType;
import ui.util.MySideBarListener;
import ui.util.PanelController;
import ui.util.TipsDialog;
 /** 
 * 营业厅业务员界面跳转控制器
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
		this.setAllButtonVisable(true);
		changePanel.setVisible(true);
	}

	@Override
	protected void initPanel(Element e) {
		saleManMainPanel = new SaleManMain(e.element(saleManMainStr),this);
		arriveYYDocShowPanel = new ArriveYYDocShowPanel(e.element(arriveYYDocShowPanelStr));
		driverInfoManagePanel = new DriverInfoManagePanel(e.element(driverInfoManagePanelStr));
		loadDocShowPanel = new LoadDocShowPanel(e.element(loadDocShowpanelStr));
		payDocShowPanel = new PayDocShowPanel(e.element(payDocShowPanelStr));
		sendGoodDocShowPanel = new SendGoodDocShowPanel(e.element(sendGoodDocShowPanelStr));
		truckInfoManagePanel = new TruckInfoManagePanel(e.element(truckInfoManagePanelStr));
		
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

	
//	class MyTestListener extends MySideBarListener{
//
//		public MyTestListener(MySideBarButton button, PanelController controller, String itsPanel) {
//			super(button, controller, itsPanel);
//			// TODO Auto-generated constructor stub
//		}
//		
//		public void mouseClicked(MouseEvent e){
//			super.mouseClicked(e);
//			
//			new TipsDialog("hello world!");
//		}
//		
//	}
	
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
