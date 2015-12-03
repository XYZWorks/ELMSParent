package ui.tools;

import javax.swing.JLabel;

import org.dom4j.Element;

import ui.config.GraphicsUtils;
 /** 
 * 所有label的父类
 * @author czq 
 * @version 2015年11月16日 下午7:35:59 
 */
@SuppressWarnings("serial")
public class MyLabel extends JLabel{
	/**
	 * 
	 * @param config
	 */
	public MyLabel(Element config) {
		this.setBounds(Integer.parseInt(config.attributeValue("x")),
				Integer.parseInt(config.attributeValue("y")),
				Integer.parseInt(config.attributeValue("width")),
				Integer.parseInt(config.attributeValue("height")));
		this.setFont(GraphicsUtils.getFont(config));
		
		if(config.attributeValue("text")!= null){
			
			//System.out.println("enter"+config.attributeValue("text"));
			this.setText(config.attributeValue("text"));
		}
		if(config.attributeValue("fontName")!= null){
			this.setFont(GraphicsUtils.getFont(config));
		}
		
		
		this.setVisible(true);
	}
	
	public MyLabel(Element config , String text){
		this.setBounds(Integer.parseInt(config.attributeValue("x")),
				Integer.parseInt(config.attributeValue("y")),
				Integer.parseInt(config.attributeValue("width")),
				Integer.parseInt(config.attributeValue("height")));
		this.setFont(GraphicsUtils.getFont(config));
		this.setText(text);
		this.setVisible(true);
	}

}
