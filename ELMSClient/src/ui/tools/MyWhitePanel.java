package ui.tools;

import org.dom4j.Element;

import java.awt.Color;

import javax.swing.JPanel;

/**
*
*@author:xingcheng
*@version 2015年12月3日
*/
@SuppressWarnings("serial")
public class MyWhitePanel extends JPanel {
	public MyWhitePanel(Element config){
		this.setBounds(Integer.parseInt(config.attributeValue("x")) , Integer.parseInt(config.attributeValue("y")) , Integer.parseInt(config.attributeValue("width")) , Integer.parseInt(config.attributeValue("height")));
		this.setBackground(Color.WHITE);
	}
}
