package ui.inital;

import java.awt.Graphics;

import org.dom4j.Element;

import ui.config.GraphicsUtils;
import ui.tools.MyFrame;
import ui.tools.MyPanel;

/**
 * 主面板界面，不动的界面
 * 
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class InitalPanel extends MyPanel {


	private Exit exit;
	private Min min;
	private Home home;
	private Rectangle rectangle;
	private ShowCareer career;
	private MyFrame parent;


	public InitalPanel(Element e , MyFrame frame) {
		super(e);
		this.parent = frame;
		initButtons(e.element("buttons"));
		initLables(e.element("labels"));
		initTextFields(e.element("textfields"));
		initOtherCompoment(e);
		addCompoment();
		addListener();
		repaint();
		this.setVisible(true);
	}

	@Override
	 public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(GraphicsUtils.getImage("workingBackground"), 0, 0, null);
		
		
	};

	@Override
	protected void initButtons(Element e) {
		exit = new Exit(e.element("exit"),parent);
		min = new Min(e.element("min"),parent);
		home=new Home(e.element("home"));
		rectangle=new Rectangle(e.element("rectangle"));
		career=new ShowCareer(e.element("showCareer"));
		
//		hello = new JLabel("asdasdasdsa");
//		hello.setBounds(300 , 400 , 50 , 50);
//		sd = new JLabel("aaaaaaaaa");
//		sd.setBounds(200, 200, 30, 30);
//		sd.setVisible(true);
//		this.add(sd);

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
		

	}
}
