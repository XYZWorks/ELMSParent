package ui.generalmanager;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.dom4j.Element;

import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.ButtonState;
import ui.util.CompomentType;
import ui.util.MyPictureButtonListener;

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
	

	public GeneralManagerMain(Element config) {
		super(config);
		initButtons(config.element(CompomentType.BUTTONS.name()));
		initTextFields(config.element(CompomentType.TEXTFIELDS.name()));
		initOtherCompoment(config);
		initLables(config.element(CompomentType.LABLES.name()));
		addCompoment();
		setVisible(true);
	}

	@Override
	protected void initButtons(Element e) {
		constsetButton = new MyPictureButton(e.element("ConstSet"));
		instManageButton = new MyPictureButton(e.element("InstManage"));
		approvalButton = new MyPictureButton(e.element("GMApproval"));
		statisticButton = new MyPictureButton(e.element("Statistic"));
		salaryStrategySetButton = new MyPictureButton(
				e.element("SalaryStrategySet"));
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
	}

	@Override
	protected void addCompoment() {
		this.add(constsetButton);
		this.add(instManageButton);
		this.add(approvalButton);
		this.add(statisticButton);
		this.add(salaryStrategySetButton);
		this.add(peopleManageButton);

	}

	@Override
	protected void addListener() {
		constsetButton.addMouseListener(new constsetListener(constsetButton));
		instManageButton.addMouseListener(new instManageListener(instManageButton));
		approvalButton.addMouseListener(new approvalListener(approvalButton));
		statisticButton.addMouseListener(new statisticListener(statisticButton));
		salaryStrategySetButton.addMouseListener(new salaryStrategyListener(salaryStrategySetButton));
		peopleManageButton.addMouseListener(new peopleManageListener(peopleManageButton));
	}

	class constsetListener extends MyPictureButtonListener {
		public constsetListener(MyPictureButton button) {
			super(button);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
		}
	
	}
	class approvalListener extends MyPictureButtonListener{
		public approvalListener(MyPictureButton button) {
			super(button);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
		}
	}
	class statisticListener extends MyPictureButtonListener{
		public statisticListener(MyPictureButton button) {
			super(button);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
		}
	}
	
	class instManageListener extends MyPictureButtonListener{
		public instManageListener(MyPictureButton button) {
			super(button);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
		}
		
	}
	
class salaryStrategyListener extends MyPictureButtonListener{
	public salaryStrategyListener(MyPictureButton button) {
		super(button);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
	}
	}

class peopleManageListener extends MyPictureButtonListener{
	
	public peopleManageListener(MyPictureButton button) {
		super(button);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
	}
	
}
}
