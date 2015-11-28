package ui.generalmanager;

import org.dom4j.Element;

import ui.tools.MyButton;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.CompomentType;
import ui.util.PanelController;
 /** 
 * 总经理界面跳转控制器
 * @author czq 
 * @version 2015年11月26日 下午3:41:24 
 */
public class GeneralManagerController extends PanelController{
	
	private GeneralManagerMain GMmainpanel;
	private ConstSetPanel constSetPanel;
	private ApprovalDocsPanel approvalPanel;
	private InstManagePanel instManagePanel;
	private PeopleManagePanel peopleManagePanel;
	private StatisticPanel statisticPanel;
	
	private MyPictureButton constsetButton;
	private MyPictureButton approvalButton;
	private MyPictureButton instManageButton;
	private MyPictureButton peopleManageButton;
	private MyPictureButton statisticButton;
	private MyPictureButton salaryStrategySetButton;
	
	
	public GeneralManagerController(MyPanel initialPanel , Element e) {
		super(initialPanel , e);
		initButtons(e.element(CompomentType.BUTTONS.name()));
		initPanel(e);
		addButtons();
		addPanels();
		addListeners();
	}
	
	@Override
	protected void initButtons(Element e) {
//		constsetButton = new MyPictureButton(e.element("ConstSet"));
//		instManageButton = new MyPictureButton(e.element("InstManage"));
//		approvalButton = new MyPictureButton(e.element("GMApproval"));
//		statisticButton = new MyPictureButton(e.element("Statistic"));
//		salaryStrategySetButton = new MyPictureButton(e.element("SalaryStrategySet"));
//		peopleManageButton = new MyPictureButton(e.element("PeopleManage"));
		
	}
	
	@Override
	protected void addButtons() {

//		
//		mainPanel.add(constsetButton);
//		mainPanel.add(instManageButton);
//		mainPanel.add(approvalButton);
//		mainPanel.add(statisticButton);
//		mainPanel.add(salaryStrategySetButton);
//		mainPanel.add(peopleManageButton);
		
	}
	
	@Override
	protected void initPanel(Element e) {
		GMmainpanel = new GeneralManagerMain(e.element("GMmainpanel"));
		
	}
	
	
	@Override
	protected void addPanels() {
		changePanel.add(GMmainpanel, "GMmainpanel");
//		changePanel.add(approvalPanel, e.attributeValue("approval"));
		
	}

	@Override
	protected void addListeners() {
		// TODO Auto-generated method stub
		
	}

	

	

}
