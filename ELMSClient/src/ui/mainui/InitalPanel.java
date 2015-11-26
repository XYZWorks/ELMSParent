package ui.mainui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
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

	private MyButton exit;
	private MyButton min;

	public InitalPanel(Element e) {
		super(e);
		initButtons(e.element("buttons"));
		initLables(e.element("labels"));
		initTextFields(e.element("textfields"));
		initOtherCompoment(e);
		addCompoment();
		addListener();
		repaint();
	}

	

	@Override
	protected void initButtons(Element e) {
		exit = new MyButton(e);
		min = new MyButton(e);

	}

	@Override
	protected void initTextFields(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initLables(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initOtherCompoment(Element e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addCompoment() {
		this.add(exit);
		this.add(min);

	}

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub

	}
}
