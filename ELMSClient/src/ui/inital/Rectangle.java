package ui.inital;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.dom4j.Element;

import ui.config.GraphicsUtils;
import ui.inital.Min.MinListener;
import ui.tools.MyButton;

/**
*账户旁边的三角显示
*@author:xingcheng
*@version 2015年11月26日
*/
@SuppressWarnings("serial")
public class Rectangle extends MyButton{
	private	boolean mouseContained = false;
//	private	boolean mouseClicked = false;
	
	public Rectangle(Element config) {
		super(config);
		this.addMouseListener(new RectangleListener());
		this.setIcon(GraphicsUtils.getIcon("minGrey"));
		this.setVisible(true);
		
		}
	
	
	class RectangleListener extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			//下拉菜单的panel
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			mouseContained=true;
			setIcon(GraphicsUtils.getIcon("closeGreen"));
			repaint();
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			mouseContained=false;
			setIcon(GraphicsUtils.getIcon("closeGrey"));
			repaint();
		}

	}
}
