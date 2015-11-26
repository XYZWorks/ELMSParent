package ui.inital;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.dom4j.Element;

import ui.config.GraphicsUtils;
import ui.tools.MyButton;
import ui.tools.MyPanel;

/**
 * 主面板界面，不动的界面
 * 
 * @author xingcheng
 *
 */
@SuppressWarnings("serial")
public class InitalPanel extends MyPanel {
	// private Exit exit=new Exit();
	// private Min min=new Min();

	private Exit exit;
	private Min min;
	private Home home;
	private Rectangle rectangle;
	private ShowCareer career;
	
//	private JLabel hello;
//	private JLabel sd;

	public InitalPanel(Element e) {
		super(e);
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
		exit = new Exit(e.element("exit"));
		min = new Min(e.element("min"));
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
		
//		this.add(hello);
		

	}

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub

	}
}
