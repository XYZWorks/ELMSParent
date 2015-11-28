package ui.tools;

import javax.swing.JLabel;

import org.dom4j.Element;
 /** 
 * 
 * @author czq 
 * @version 2015年11月16日 下午7:35:59 
 */
public class MyLabel extends JLabel{
	
	public MyLabel(Element config){
		this.setBounds(Integer.parseInt(config.attributeValue("x")) , Integer.parseInt(config.attributeValue("y")) , Integer.parseInt(config.attributeValue("width")) , Integer.parseInt(config.attributeValue("height")));
		this.setVisible(true);
	}

}
