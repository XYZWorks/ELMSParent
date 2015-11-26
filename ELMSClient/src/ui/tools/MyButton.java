package ui.tools;


import java.awt.Color;

import javax.swing.JLabel;

import org.dom4j.Element;

/**
 * Button父类
 * @author czq
 * @version 2015年11月16日 下午7:35:33
 */
@SuppressWarnings("serial")
public class MyButton extends JLabel {
	
//	public MyButton() {
//		
//		this.setOpaque(true);
//		this.setVisible(true);
//	}
//	
//	public MyButton(String text) {
//		super.setText(text);
//		this.setOpaque(true);
//		this.setVisible(true);
//	}
//	
//	public MyButton(int x1 , int y1 , int x2 , int y2){
//		this.setBounds(x1, y1, x2 - x1, y2 - y1);
//		this.setOpaque(false);
//		this.setVisible(true);
//	}
	
	public MyButton(Element config){
		this.setBounds(Integer.parseInt(config.attributeValue("x")) , Integer.parseInt(config.attributeValue("y")) , Integer.parseInt(config.attributeValue("width")) , Integer.parseInt(config.attributeValue("height")));
//		this.setText(config.attributeValue("text"));
	//	this.setForeground(Color.red);
//		this.setOpaque(false);
		this.setVisible(true);
	}
	
	
}
