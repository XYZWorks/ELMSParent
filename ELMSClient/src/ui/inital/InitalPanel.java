package ui.inital;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.dom4j.Element;

import ui.config.GraphicsUtils;
import ui.tools.MyFrame;
import ui.tools.MyLabel;
import ui.tools.MyPanel;
import ui.tools.MyPictureButton;
import ui.util.ButtonState;
import util.AccountType;
import vo.account.AccountVO;

/**
 * 主面板界面，不动的界面
 * 
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class InitalPanel extends MyPanel {

	private MyPictureButton exit;
	private MyPictureButton min;
	private MyPictureButton home;
	private MyPictureButton rectangle;
	private MyLabel career;
	private MyFrame parent;

	public InitalPanel(Element e, MyFrame frame, AccountVO vo) {
		super(e);
		this.parent = frame;
		initButtons(e.element("buttons"));
		initLables(e.element("labels"));
		initTextFields(e.element("textfields"));
		initOtherCompoment(e);
		addCompoment();
		addListener();
		// 界面跳转方法
		addOtherPanel(vo);

		repaint();
		this.setVisible(true);
	}

	/**
	 * 根据账户类型跳转至不同的界面
	 * 
	 * @param vo
	 */
	private void addOtherPanel(AccountVO vo) {
		AccountType type = vo.type;
		switch (type) {
		case Adminstrator:

			break;
		case courier:

			break;
		case financeman:

			break;
		case manager:
			// new GeneralManagerController(this, )
			break;
		case saleman:

			break;
		case storeman:

			break;
		default:
			break;
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(GraphicsUtils.getImage("workingBackground"), 0, 0, null);

	};

	@Override
	protected void initButtons(Element e) {
		exit = new MyPictureButton(e.element("exit"));
		min = new MyPictureButton(e.element("min"));
		home = new MyPictureButton(e.element("home"));
		rectangle = new MyPictureButton(e.element("rectangle"));
		career = new MyLabel(e.element("Career"));

		// hello = new JLabel("asdasdasdsa");
		// hello.setBounds(300 , 400 , 50 , 50);
		// sd = new JLabel("aaaaaaaaa");
		// sd.setBounds(200, 200, 30, 30);
		// sd.setVisible(true);
		// this.add(sd);

	}

	@Override
	protected void initTextFields(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initLables(Element e) {

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
		this.add(career);
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
			//弹出optionpane 确认退出
			
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


	
}
