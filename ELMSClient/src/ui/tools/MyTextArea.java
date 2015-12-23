package ui.tools;

import java.awt.Font;

import javax.swing.JTextArea;

import org.dom4j.Element;

/**
*
*@author:xingcheng
*@version 2015年12月22日
*/
@SuppressWarnings("serial")
public class MyTextArea extends JTextArea {

	public MyTextArea(Element config){
		this.setBounds(Integer.parseInt(config.attributeValue("x")),
				Integer.parseInt(config.attributeValue("y")),
				Integer.parseInt(config.attributeValue("width")),
				Integer.parseInt(config.attributeValue("height")));
		this.setEditable(true);
		//设置透明
		this.setOpaque(false);
		this.setFont(new Font("华文细黑", Font.PLAIN, 16));
		this.setWrapStyleWord(true);
		this.setVisible(true);
	}
}
