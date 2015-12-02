package ui.generalmanager;

import org.dom4j.Element;

import ui.tools.DateChooser;
import ui.tools.MyDatePicker;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.CompomentType;
import ui.util.MyMainPanelButtonListener;
import ui.util.PanelController;

/**
 * 总经理主界面
 *
 * @author:xingcheng
 * @version 2015年11月26日
 */
@SuppressWarnings("serial")
public class GeneralManagerMain extends MyPanel {

	private MyPictureButton constsetButton;
	private MyPictureButton approvalButton;
	private MyPictureButton instManageButton;
	private MyPictureButton peopleManageButton;
	private MyPictureButton statisticButton;
	private MyPictureButton salaryStrategySetButton;
	
	private PanelController controller;
	
	private MyDatePicker date;
	
	
	public GeneralManagerMain(Element config , PanelController controller) {
		super(config);
		this.controller = controller;
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initLables(config.element(CompomentType.LABLES.name()));
		addCompoment();
		addListener();
		repaint();
		setVisible(true);
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
	protected void initTextFields(Element e) {
	}

	@Override
	protected void initLables(Element e) {
	}

	@Override
	protected void initOtherCompoment(Element e) {
		date = new MyDatePicker(e.element("DatePicker"));
	}

	@Override
	protected void addCompoment() {
		this.add(constsetButton);
		this.add(instManageButton);
		this.add(approvalButton);
		this.add(statisticButton);
		this.add(salaryStrategySetButton);
		this.add(peopleManageButton);
		
		this.add(date);
//		date.setLocation(500, 300);
		date.setVisible(true);
	}

	@Override
	protected void addListener() {
		constsetButton.addMouseListener(new MyMainPanelButtonListener(constsetButton, "ConstSetPanel", controller));
		instManageButton.addMouseListener(new MyMainPanelButtonListener(instManageButton, "InstManagePanel", controller));
		approvalButton.addMouseListener(new MyMainPanelButtonListener(approvalButton, "ApprovalPanel", controller));
		statisticButton.addMouseListener(new MyMainPanelButtonListener(statisticButton, "StatisticPanel", controller));
		salaryStrategySetButton.addMouseListener(new MyMainPanelButtonListener(salaryStrategySetButton, "SalaryStrategySetPanel", controller));
		peopleManageButton.addMouseListener(new MyMainPanelButtonListener(peopleManageButton, "PeopleManagePanel", controller));
	}

	
}
