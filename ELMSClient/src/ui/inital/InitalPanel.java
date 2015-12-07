 package ui.inital;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import org.dom4j.Element;

import ui.config.GraphicsUtils;
import ui.financeman.FinanceController;
import ui.generalmanager.GeneralManagerController;
import ui.tools.MyFrame;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.user.AdminstratorController;
import ui.util.ButtonState;
import ui.util.CompomentType;
import ui.util.PanelController;
import ui.util.TipsDialog;
import vo.account.AccountVO;

/**
 * 主面板界面，不动的界面
 * 
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class InitalPanel extends MyPanel {


//	private ShowCareer career;
	private MyPictureButton exit;
	private MyPictureButton min;
	private MyPictureButton home;
	private MyPictureButton rectangle;
	private MyLabel career;
	/**
	 * 控制器
	 */
	private PanelController controller;
	private MyFrame parent;
	private  AccountVO vo;


	public InitalPanel(Element e , MyFrame frame ,AccountVO vo) {
		super(e);
		this.parent = frame;
		
		TipsDialog.setFrame(frame);
		
		this.initButtons(e.element(CompomentType.BUTTONS.name()));
		this.initLables(e.element(CompomentType.LABELS.name()));
		this.initTextFields(e.element(CompomentType.TEXTFIELDS.name()));
		this.initOtherCompoment(e);
		this.addCompoment();
		this.addListener();
		//界面跳转方法
		this.addOtherPanel(e); 
		
		this.repaint();
		
		this.setVisible(true);
	}
	
	/**
	 * 根据账户类型跳转至不同的界面
	 * @param vo
	 */
	private void addOtherPanel(Element e) {
//		AccountType type = vo.type;
		
		//TODO 你直接在这里新建一个controller，把当前initialpanel 的指针穿件去就行了
		controller =  new GeneralManagerController(this, e.element("GeneralManager")) ;
//		controller = new FinanceController(this, e.element("Financeman"));
//		controller = new AdminstratorController(this, e.element("Adminstrator"));
//		switch (type) {
//		case Adminstrator:
//			
//			break;
//		case courier:
//
//			break;
//		case financeman:
//
//			break;
//		case manager:
////			new GeneralManagerController(this, )
//			break;
//		case saleman:
//
//			break;
//		case storeman:
//
//			break;
//		default:
//			break;
//		}

	}

	@Override
	 public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(GraphicsUtils.getImage("bg//bg"), 0, 0, null);
		//TODO 待修改，改成图片是预读进来的
		
		
	};                                                        

	@Override
	protected void initButtons(Element e) {

		min = new MyPictureButton(e.element("min"));
		home = new MyPictureButton(e.element("home"));
		exit = new MyPictureButton(e.element("exit"));
		rectangle = new MyPictureButton(e.element("drop"));
	}

	@Override
	protected void initTextFields(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initLables(Element e) {
//		career = new MyLabel(e.element("career") , vo.type.name() + "," + vo.name);

	}

	@Override
	protected void initOtherCompoment(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addCompoment() {
		this.add(exit);
		this.add(min);
		this.add(home);
		
		this.add(rectangle);
//		this.add(career);
	}

	@Override
	protected void addListener() {
		exit.addMouseListener(new ExitListener());
		min.addMouseListener(new MinListener());
		home.addMouseListener(new HomeListener());
		rectangle.addMouseListener(new RectangleListener());

	}
	
	class ExitListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			exit.setMyIcon(ButtonState.MOUSE_CLICKED);
			//弹出optionpane 确认退出 TODO
			
			System.exit(0);
			
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			exit.setMyIcon(ButtonState.MOUSE_ENTERED);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			exit.setMyIcon(ButtonState.NORMAL);
		}
	}
	
	class MinListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			min.setMyIcon(ButtonState.MOUSE_CLICKED);
			//最小化到任务栏
			parent.setExtendedState(JFrame.ICONIFIED);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			min.setMyIcon(ButtonState.MOUSE_ENTERED);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			min.setMyIcon(ButtonState.NORMAL);
		}
	}
	
	class HomeListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			home.setMyIcon(ButtonState.MOUSE_CLICKED);
			//切换到主页
			controller.jumpBackToMainWindow();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			home.setMyIcon(ButtonState.MOUSE_ENTERED);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			home.setMyIcon(ButtonState.NORMAL);
		}
	}
	
	class RectangleListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			rectangle.setMyIcon(ButtonState.MOUSE_CLICKED);
			//下拉窗口 选择“设置账户信息”“登出账户”
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			rectangle.setMyIcon(ButtonState.MOUSE_ENTERED);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			rectangle.setMyIcon(ButtonState.NORMAL);
		}
	}

	@Override
	protected void initWhitePanels(Element e) {
		// TODO Auto-generated method stub
		
	}
}
