package ui.tools;

import org.dom4j.Element;

import ui.config.GraphicsUtils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

/**
*
*@author:xingcheng
*@version 2015年12月3日
*/
@SuppressWarnings("serial")
public class MyWhitePanel extends JPanel {
	private Color color;
	private double alpha;
	
	public MyWhitePanel(Rectangle rectangle) {
		this.setBounds(rectangle);
		this.setLayout(null);
	}
	public MyWhitePanel(Element config ){
		this.setBounds(Integer.parseInt(config.attributeValue("x")) , Integer.parseInt(config.attributeValue("y")) , Integer.parseInt(config.attributeValue("width")) , Integer.parseInt(config.attributeValue("height")));
		
		if(config.attributeValue("alpha")!= null){
			alpha = Double.parseDouble(config.attributeValue("alpha"));
		}
		
		this.setLayout(null);
		
    //	this.setBackground(Color.WHITE);
	}
	@Override
	public void paintComponent(Graphics g){
		GraphicsUtils.setAlpha(g, 0.75);
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		
	}
	
	
}
