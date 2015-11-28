package ui.generalmanager;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.dom4j.Element;

import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.ButtonState;
import ui.util.CompomentType;

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
		
		public void mouseMoved(MouseEvent e){
			
			
			
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
		salaryStrategySetButton.setMyIcon(ButtonState.NORMAL);
	}
	}

class peopleManageListener extends MouseAdapter{
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	
}
}
