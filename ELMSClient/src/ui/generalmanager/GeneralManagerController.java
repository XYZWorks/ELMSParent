package ui.generalmanager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.dom4j.Element;

import ui.tools.MyButton;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.ButtonState;
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
		constsetButton = new MyPictureButton(e.element("ConstSet"));
		instManageButton = new MyPictureButton(e.element("InstManage"));
		approvalButton = new MyPictureButton(e.element("GMApproval"));
		statisticButton = new MyPictureButton(e.element("Statistic"));
		salaryStrategySetButton = new MyPictureButton(e.element("SalaryStrategySet"));
		peopleManageButton = new MyPictureButton(e.element("PeopleManage"));
		
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
		GMmainpanel = new GeneralManagerMain(e.element("GMmainpanel"));
		approvalPanel = new ApprovalDocsPanel(e.element("Approval"));
		constSetPanel = new ConstSetPanel(e.element("ConstSetPanel"));
		statisticPanel = new StatisticPanel(e.element("Statistic"));
		instManagePanel = new InstManagePanel(e.element("InstManage"));
		peopleManagePanel = new PeopleManagePanel(e.element("PeopleManage"));
	}
	
	
	@Override
	protected void addPanels() {
		changePanel.add(GMmainpanel, "GMmainpanel");
		changePanel.add(approvalPanel,"Approval");
		changePanel.add(constSetPanel, "ConstSet");
		changePanel.add(statisticPanel , "Statistic");
		changePanel.add(instManagePanel , "InstManage");
		changePanel.add(peopleManagePanel , "PeopleManage");
		
	}

	@Override
	protected void addListeners() {
		constsetButton.addMouseListener(new constsetListener());
		instManageButton.addMouseListener(new instManageListener());
		approvalButton.addMouseListener(new approvalListener());
		statisticButton.addMouseListener(new statisticListener());
		salaryStrategySetButton.addMouseListener(new salaryStrategyListener());
		peopleManageButton.addMouseListener(new peopleManageListener());
		
	}


	class constsetListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			constsetButton.setMyIcon(ButtonState.MOUSE_CLICKED);
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			constsetButton.setMyIcon(ButtonState.MOUSE_ENTERED);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			constsetButton.setMyIcon(ButtonState.NORMAL);
		}
	}
	class approvalListener extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			approvalButton.setMyIcon(ButtonState.MOUSE_CLICKED);
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			approvalButton.setMyIcon(ButtonState.MOUSE_ENTERED);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			approvalButton.setMyIcon(ButtonState.MOUSE_ENTERED);
		}
	}
	class statisticListener extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			statisticButton.setMyIcon(ButtonState.MOUSE_CLICKED);
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			statisticButton.setMyIcon(ButtonState.MOUSE_ENTERED);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			statisticButton.setMyIcon(ButtonState.MOUSE_ENTERED);
		}
		
	}
	
	class instManageListener extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			instManageButton.setMyIcon(ButtonState.MOUSE_CLICKED);
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			instManageButton.setMyIcon(ButtonState.MOUSE_ENTERED);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			instManageButton.setMyIcon(ButtonState.MOUSE_ENTERED);
		}
		
	}
	
class salaryStrategyListener extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent e) {
		salaryStrategySetButton.setMyIcon(ButtonState.MOUSE_CLICKED);
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		salaryStrategySetButton.setMyIcon(ButtonState.MOUSE_ENTERED);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		salaryStrategySetButton.setMyIcon(ButtonState.MOUSE_ENTERED);
	}
	}

class peopleManageListener extends MouseAdapter{
	
	@Override
	public void mouseClicked(MouseEvent e) {
		peopleManageButton.setMyIcon(ButtonState.MOUSE_CLICKED);
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		peopleManageButton.setMyIcon(ButtonState.MOUSE_ENTERED);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		peopleManageButton.setMyIcon(ButtonState.MOUSE_ENTERED);
	}
	
}

	

}
