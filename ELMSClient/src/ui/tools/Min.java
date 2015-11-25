package ui.tools;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import ui.config.GraphicsUtils;

	/*
	 * 最小化按钮
	 * 
	 */
public class Min extends JLabel{
	Boolean mouseContained = false;
	Boolean mouseClicked = false;
	
public Min(){
	
	this.setBounds(1020,0 , 30, 30);
	this.addMouseListener(new MinListener());
}

//public boolean isMouseClicked(){
//	return mouseClicked;
//}

@Override
public void paintComponent(Graphics g) {

	Graphics2D g2d = (Graphics2D)g;
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
	
	if(!mouseContained){
		g2d.drawImage(GraphicsUtils.getImage("minGrey"),1020,0,null);
	}
	else {
		g2d.drawImage(GraphicsUtils.getImage("minGreen"),1020,0,null);
	}
}

class MinListener extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent e) {
		//mins
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		mouseContained=true;
		repaint();
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		mouseContained=false;
		repaint();
	}
	
}
}
