package ui.inital;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JFrame;

import org.dom4j.Element;

import ui.config.GraphicsUtils;
import ui.tools.MyButton;
import ui.tools.MyFrame;

/*
 * 最小化按钮
 * 
 */
@SuppressWarnings("serial")
public class Min extends MyButton {
	
	private MyFrame parent;
//	private mainFrame mainframe;
	private Icon normal;
	private Icon clicked;
	private Icon entered;
	
	public Min(Element e , MyFrame parent) {
		super(e);
		this.parent = parent;
		this.addMouseListener(new MinListener());
		normal = GraphicsUtils.getIcon("");
		clicked = GraphicsUtils.getIcon("");
		entered = GraphicsUtils.getIcon("");
		setIcon(normal);
		this.setVisible(true);
	}

	// public boolean isMouseClicked(){
	// return mouseClicked;
	// }

//	@Override
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		Graphics2D g2d = (Graphics2D) g;
//		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//				RenderingHints.VALUE_ANTIALIAS_ON);
//		g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
//				RenderingHints.VALUE_RENDER_QUALITY);
//		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
//				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//
//		if (!mouseContained) {
//			g2d.drawImage(GraphicsUtils.getImage("minGrey"), 0, 0, null);
//		} else {
//			g2d.drawImage(GraphicsUtils.getImage("minGreen"), 0, 0, null);
//		}
//	}

	
	
	
	class MinListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			// mins
			setIcon(clicked);
			  parent.setExtendedState(JFrame.ICONIFIED);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
//			setIcon(GraphicsUtils.getIcon("minGreen"));
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
