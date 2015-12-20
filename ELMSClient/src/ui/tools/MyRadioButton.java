package ui.tools;

import java.awt.Color;

import javax.swing.JRadioButton;

import org.dom4j.Element;

/**
*单选框
*@author:xingcheng
*@version 2015年12月2日
*/
@SuppressWarnings("serial")
public class MyRadioButton extends JRadioButton{
	public MyRadioButton(int x1, int x2, int y1,  int y2){
		super();
		this.setBounds(x1 , y1 , x2 - x1 , y2 - y1);
		this.setVisible(true);
	}
	public MyRadioButton(Element config) {
		this.setBounds(Integer.parseInt(config.attributeValue("x")) , Integer.parseInt(config.attributeValue("y")) , Integer.parseInt(config.attributeValue("width")) , Integer.parseInt(config.attributeValue("height")));
		this.setText(config.attributeValue("text"));
		this.setVisible(true);
		this.setBackground(Color.WHITE );
	}
}
