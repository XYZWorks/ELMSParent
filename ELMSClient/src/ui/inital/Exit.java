package ui.inital;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;

import org.dom4j.Element;

import ui.config.GraphicsUtils;
import ui.tools.MyButton;
import ui.tools.MyFrame;


/*
 * 退出按钮
 * 
 */
@SuppressWarnings("serial")
public class Exit extends MyButton{

	private MyFrame parent;
	
	private Icon normal;
	private Icon clicked;
	private Icon entered;
	
	public Exit(Element e , MyFrame parent){
		super(e);
		this.parent = parent;
		this.addMouseListener(new ExitListener());
		normal = GraphicsUtils.getIcon("close-normal");
		clicked = GraphicsUtils.getIcon("close-exit");
		entered = GraphicsUtils.getIcon("close-enter");
		
		this.setIcon(normal);
		this.setVisible(true);

	}


	
	class ExitListener extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent e) {
//			new MyOptionPane(parent, "请问您要离开吗？", JOptionPane.YES_NO_OPTION);
			setIcon(clicked);
			parent.dispose();
			System.exit(0);
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
