package ui.inital;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;

import org.dom4j.Element;

import ui.config.GraphicsUtils;
import ui.tools.MyButton;
import ui.tools.MyFrame;

/**
 *
 * @author:xingcheng
 * @version 2015年11月26日
 */
@SuppressWarnings("serial")
public class Home extends MyButton {
	private MyFrame parent;
	// private mainFrame mainframe;
	private Icon normal;
	private Icon clicked;
	private Icon entered;

	public Home(Element config ) {
		super(config);
		this.addMouseListener(new HomeListener());
		normal = GraphicsUtils.getIcon("");
		clicked = GraphicsUtils.getIcon("");
		entered = GraphicsUtils.getIcon("");
		setIcon(normal);
		
		
		
		this.setVisible(true);
	}

	class HomeListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			setIcon(clicked);
			// 进入主页面
			// 根据人来选择

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			setIcon(entered);
			repaint();

		}

		@Override
		public void mouseExited(MouseEvent e) {
			setIcon(normal);
			repaint();
		}

	}
}
