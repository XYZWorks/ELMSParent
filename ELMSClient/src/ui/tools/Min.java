package ui.tools;

import java.awt.BasicStroke;
	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.Image;
	import java.awt.RenderingHints;
	import java.awt.Toolkit;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;

	import javax.swing.ImageIcon;
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

class MinListener implements MouseListener{

	public void mouseClicked(MouseEvent e) {
		//mins
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		mouseContained=true;
		repaint();
		
	}

	public void mouseExited(MouseEvent e) {
		mouseContained=false;
		repaint();
	}
	
}
}
