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
	
	
	
	public MyButton(Element config){
		this.setBounds(Integer.parseInt(config.attributeValue("x")),
				Integer.parseInt(config.attributeValue("y")),
				Integer.parseInt(config.attributeValue("width")),
				Integer.parseInt(config.attributeValue("height")));
		
		this.setText(config.attributeValue("text"));
		
		this.setVisible(true);
		//		this.setText(config.attributeValue("text"));
	//	this.setForeground(Color.red);
//		this.setOpaque(false);
		
	}
	
	
}
