package ui.inital;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.dom4j.Element;

import ui.config.GraphicsUtils;
import ui.inital.Min.MinListener;
import ui.tools.MyButton;

/**
*
*@author:xingcheng
*@version 2015年11月26日
*/
@SuppressWarnings("serial")
public class Home extends MyButton{
	private boolean  mouseContained = false;
	//private boolean mouseClicked = false;

	public Home(Element config) {
		super(config);
		this.addMouseListener(new HomeListener());
		this.setIcon(GraphicsUtils.getIcon("minGrey"));
		this.setVisible(true);
	}

class HomeListener extends MouseAdapter {
	@Override
	public void mouseClicked(MouseEvent e) {
	//进入主页面
		//根据人来选择

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		mouseContained  = true;
		setIcon(GraphicsUtils.getIcon("minGreen"));
		repaint();

	}

	@Override
	public void mouseExited(MouseEvent e) {
		mouseContained = false;
		setIcon(GraphicsUtils.getIcon("minGreen"));
		repaint();
	}

}
}
