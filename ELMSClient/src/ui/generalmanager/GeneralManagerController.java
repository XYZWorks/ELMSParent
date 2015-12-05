package ui.generalmanager;

import org.dom4j.Element;

import bl.BusinessLogicDataFactory;
import blservice.approvalblservice.Approvalblservice;
import blservice.personnelblservice.Personnelblservice;
import blservice.statisticblservice.Statisticblservice;
import blservice.strategyblservice.StrategyblService;
import ui.generalmanager.institution.InstManagePanel;
import ui.generalmanager.people.PeopleManagePanel;
import ui.tools.MyPanel;
import ui.tools.MySideBarButton;
import ui.util.ButtonState;
import ui.util.CompomentType;
import ui.util.MySideBarListener;
import ui.util.PanelController;
import config.StaticMessage;

/**
 * 总经理界面跳转控制器
 * 
 * @author czq
 * @version 2015年11月26日 下午3:41:24
 */
public class GeneralManagerController extends PanelController {

	private MyPanel GMmainpanel;
	private MyPanel constSetPanel;
	private MyPanel approvalPanel;
	private MyPanel instManagePanel;
	private MyPanel peopleManagePanel;
	private MyPanel statisticPanel;
	private MyPanel salaryStrategySetPanel;

	private MySideBarButton constsetButton;
	private MySideBarButton approvalButton;
	private MySideBarButton instManageButton;
	private MySideBarButton peopleManageButton;
	private MySideBarButton statisticButton;
	private MySideBarButton salaryStrategySetButton;
	
	private static final String GMmainpanelStr = StaticMessage.MAIN_WINDOW;
	private static final String constSetPanelStr = "ConstSetPanel";
	private static final String approvalPanelStr = "ApprovalPanel";
	private static final String instManagePanelStr = "InstManagePanel";
	private static final String peopleManagePanelStr = "PeopleManagePanel";
	private static final String statisticPanelStr = "StatisticPanel";
	private static final String salaryStrategySetStr = "SalaryStrategySetPanel";
	
	private Approvalblservice approvalBL;
	private StrategyblService strategyblService;
	private Statisticblservice statisticblservice;
	private Personnelblservice personnelblservice;
	

	public GeneralManagerController(MyPanel initialPanel, Element e) {
		super(initialPanel, e);
		initialBL();
		initButtons(e.element(CompomentType.BUTTONS.name()));
		initPanel(e);
		addButtons();
		addPanels();
		addListeners();
		addToMap();
		this.setAllButtonVisable(false);
		panelManager.show(changePanel, GMmainpanelStr);
		changePanel.setVisible(true);
	}
	
	@Override
	protected void initialBL() {
		approvalBL = BusinessLogicDataFactory.getFactory().getApprovalBusinessLogic();
		strategyblService = BusinessLogicDataFactory.getFactory().getStrategyBusinessLogic();
		statisticblservice = BusinessLogicDataFactory.getFactory().getStatisticBusinessLogic();
		personnelblservice = BusinessLogicDataFactory.getFactory().getPersonnelBusinessLogic();
	}
	
	@Override
	protected void initButtons(Element e) {
		constsetButton = new MySideBarButton(e.element("ConstSet"));
		instManageButton = new MySideBarButton(e.element("InstManage"));
		approvalButton = new MySideBarButton(e.element("GMApproval"));
		statisticButton = new MySideBarButton(e.element("Statistic"));
		salaryStrategySetButton = new MySideBarButton(
				e.element("SalaryStrategySet"));
		peopleManageButton = new MySideBarButton(e.element("PeopleManage"));

	}

	@Override
	protected void addButtons() {

		mainPanel.add(constsetButton);
		mainPanel.add(instManageButton);
		mainPanel.add(approvalButton);
		mainPanel.add(statisticButton);
		mainPanel.add(salaryStrategySetButton);
		mainPanel.add(peopleManageButton);

	}

	@Override
	protected void initPanel(Element e) {
		GMmainpanel = new GeneralManagerMain(e.element(GMmainpanelStr) , this);
		approvalPanel = new ApprovalDocsPanel(e.element(approvalPanelStr) , approvalBL);
		constSetPanel = new ConstSetPanel(e.element(constSetPanelStr) , strategyblService);
		statisticPanel = new StatisticPanel(e.element(statisticPanelStr) , statisticblservice);
		instManagePanel = new InstManagePanel(e.element(instManagePanelStr), changePanel , personnelblservice);
		peopleManagePanel = new PeopleManagePanel(
				e.element(peopleManagePanelStr) , panelManager , personnelblservice);
		salaryStrategySetPanel = new SalaryStrategySetPanel(e.element(salaryStrategySetStr), strategyblService);
	}

	@Override
	protected void addPanels() {
		changePanel.add(GMmainpanel, GMmainpanelStr);
		changePanel.add(approvalPanel, approvalPanelStr);
		changePanel.add(constSetPanel, constSetPanelStr);
		changePanel.add(statisticPanel, statisticPanelStr);
		changePanel.add(instManagePanel, instManagePanelStr);
		changePanel.add(peopleManagePanel, peopleManagePanelStr);
		changePanel.add(salaryStrategySetPanel , salaryStrategySetStr);
	}

	@Override
	protected void addListeners() {
		constsetButton.addMouseListener(new MySideBarListener(constsetButton, this, constSetPanelStr));
		instManageButton.addMouseListener(new MySideBarListener(instManageButton, this , instManagePanelStr));
		approvalButton.addMouseListener(new MySideBarListener(approvalButton, this , approvalPanelStr));
		statisticButton.addMouseListener(new MySideBarListener(statisticButton, this , statisticPanelStr));
		salaryStrategySetButton.addMouseListener(new MySideBarListener(salaryStrategySetButton, this , salaryStrategySetStr));
		peopleManageButton.addMouseListener(new MySideBarListener(peopleManageButton, this , peopleManagePanelStr));

	}


	@Override
	public void setAllButtonUnClicked() {
		constsetButton.setMyIcon(ButtonState.NORMAL);
		instManageButton.setMyIcon(ButtonState.NORMAL);
		approvalButton.setMyIcon(ButtonState.NORMAL);
		statisticButton.setMyIcon(ButtonState.NORMAL);
		salaryStrategySetButton.setMyIcon(ButtonState.NORMAL);
		peopleManageButton.setMyIcon(ButtonState.NORMAL);		
	}

	@Override
	public void setAllButtonVisable(boolean state) {
		constsetButton.setVisible(state);
		instManageButton.setVisible(state);
		approvalButton.setVisible(state);
		statisticButton.setVisible(state);
		salaryStrategySetButton.setVisible(state);
		peopleManageButton.setVisible(state);
	}

	@Override
	protected void addToMap() {
		buttonMap.put(approvalPanelStr, approvalButton);
		buttonMap.put(constSetPanelStr, constsetButton);
		buttonMap.put(instManagePanelStr, instManageButton);
		buttonMap.put(salaryStrategySetStr, salaryStrategySetButton);
		buttonMap.put(peopleManagePanelStr, peopleManageButton);
		buttonMap.put(statisticPanelStr, statisticButton);
		
	}

	

}
