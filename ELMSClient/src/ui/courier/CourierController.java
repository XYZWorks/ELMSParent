package ui.courier;

import org.dom4j.Element;

import ui.courier.AddOrder.AddOrderPanel;
import ui.courier.FindFullInfo.FindFullOrderInfoPanel;
import ui.courier.FindFullInfo.showInfoPanel;
import ui.courier.inputInfoReceive.InputReceiveInfoPanel;
import ui.tools.MyPanel;
import ui.tools.MySideBarButton;
import ui.util.ButtonState;
import ui.util.CompomentType;
import ui.util.MySideBarListener;
import ui.util.PanelController;
import bl.BusinessLogicDataFactory;
import blservice.orderblservice.Orderblservice;
import blservice.strategyblservice.StrategyblService;
import config.StaticMessage;
 /** 
 * 
 * @author czq 
 * @version 2015年11月26日 下午3:43:30 
 */
public class CourierController extends PanelController{
	//初始化bl
	private Orderblservice orderblservice;
	private StrategyblService strategyblService;
	
	//初始化五个操作界面
	private CourierMainPanel courierMainPanel;
	private AddOrderPanel addOrderPanel;
	private FindFullOrderInfoPanel findFullInfoPanel;
	private InputReceiveInfoPanel inputReceiveInfoPanel;
	private showInfoPanel showInfoPanel;
	
	//左侧栏
	private MySideBarButton addOrderButton;
	private MySideBarButton findFullInfoButton;
	private MySideBarButton inputReceiveInfoButton;
	
	private final String courierMainPanelStr = StaticMessage.MAIN_WINDOW;
	private final String addOrderPanelStr = "addOrderPanel";
	private final String showInfoPanelStr="showInfoPanel";
	private final String inputReceiveInfoPanelStr="inputReceiveInfoPanel";
	private final String findFullInfoPanelStr="findFullInfoPanel";
	public CourierController(MyPanel initialPanel, Element e) {
		super(initialPanel,e);		
		initialBL();
		
		initButtons(e.element(CompomentType.BUTTONS.name()));
		initPanel(e);
		
		
		addButtons();
		addPanels();
		addListeners();	
		addToMap();
		//panelManager.show(changePanel, "courierMainPanel");
		this.setAllButtonVisable(false);
		changePanel.setVisible(true);
	
	
	}
	
	@Override
	protected void initPanel(Element e) {
		courierMainPanel=new CourierMainPanel(e.element(courierMainPanelStr),this);
		addOrderPanel=new AddOrderPanel(e.element(addOrderPanelStr),orderblservice,strategyblService);
		findFullInfoPanel=new FindFullOrderInfoPanel(e.element(findFullInfoPanelStr), orderblservice,this);
		showInfoPanel=new showInfoPanel(e.element(showInfoPanelStr),orderblservice,this,findFullInfoPanel);
		inputReceiveInfoPanel=new InputReceiveInfoPanel(e.element(inputReceiveInfoPanelStr),orderblservice);

	}

	@Override
	protected void initButtons(Element e) {
		addOrderButton=new MySideBarButton(e.element("addOrder"));
		findFullInfoButton=new MySideBarButton(e.element("findFullInfo"));
		inputReceiveInfoButton=new MySideBarButton(e.element("inputReceiveInfo"));
		
	}

	@Override
	protected void addButtons() {
		mainPanel.add(addOrderButton);
		mainPanel.add(findFullInfoButton);
		mainPanel.add(inputReceiveInfoButton);
		
	}

	@Override
	protected void addPanels() {
		changePanel.add(courierMainPanel , courierMainPanelStr);
		changePanel.add(addOrderPanel , addOrderPanelStr);
		changePanel.add(findFullInfoPanel , findFullInfoPanelStr);
		changePanel.add(showInfoPanel, showInfoPanelStr);
		changePanel.add(inputReceiveInfoPanel , inputReceiveInfoPanelStr);
	}

	@Override
	protected void addListeners() {
		addOrderButton.addMouseListener(new MySideBarListener(addOrderButton, this, addOrderPanelStr));
		//findFullInfoButton.addMouseListener(new MySideBarListener(findFullInfoButton, this, findFullInfoPanelStr));
		findFullInfoButton.addMouseListener(new MySideBarListener(findFullInfoButton, this, showInfoPanelStr));
		inputReceiveInfoButton.addMouseListener(new MySideBarListener(inputReceiveInfoButton, this, inputReceiveInfoPanelStr));
		
		
	}

	@Override
	public void setAllButtonUnClicked() {
		addOrderButton.setMyIcon(ButtonState.NORMAL);
		findFullInfoButton.setMyIcon(ButtonState.NORMAL);
		inputReceiveInfoButton.setMyIcon(ButtonState.NORMAL);
	}

	@Override
	public void setAllButtonVisable(boolean state) {
		addOrderButton.setVisible(state);
		findFullInfoButton.setVisible(state);
		inputReceiveInfoButton.setVisible(state);
	}

	@Override
	protected void addToMap() {
		buttonMap.put(addOrderPanelStr,addOrderButton);
		//buttonMap.put(findFullInfoPanelStr, findFullInfoButton);
		buttonMap.put(showInfoPanelStr, findFullInfoButton);
		buttonMap.put(inputReceiveInfoPanelStr, inputReceiveInfoButton);
		
	}

	@Override
	protected void initialBL() {
		orderblservice=BusinessLogicDataFactory.getFactory().getOrderBussinessLogic();
		strategyblService=BusinessLogicDataFactory.getFactory().getStrategyBusinessLogic();
		
	}
	
	
	

}
