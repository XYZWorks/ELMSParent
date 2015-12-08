package ui.tools;

import java.awt.Window.Type;

import javax.swing.JComboBox;

import org.dom4j.Element;
 /** 
 * 下拉框类
 * @author czq 
 * @version 2015年11月30日 下午7:03:15 
 */
@SuppressWarnings("serial")
public class MyComboBox extends JComboBox<String> {
	
	
	public MyComboBox(Element config) {
		this.setBounds(Integer.parseInt(config.attributeValue("x")),
				Integer.parseInt(config.attributeValue("y")),
				Integer.parseInt(config.attributeValue("width")),
				Integer.parseInt(config.attributeValue("height")));
		String[] strs = config.attributeValue("strings").split(" ");
		for (String string : strs) {
			this.addItem(string);
		}
		this.setSelectedIndex(0);
		
	}
	
	public MyComboBox(Element config,String city){
		this.setBounds(Integer.parseInt(config.attributeValue("x")),
				Integer.parseInt(config.attributeValue("y")),
				Integer.parseInt(config.attributeValue("width")),
				Integer.parseInt(config.attributeValue("height")));
		
		
		
		String[] strs = config.attributeValue("string"+city).split(" ");
		for (String string : strs) {
			this.addItem(string);
		}
		this.setSelectedIndex(0);
		//this.setVisible(true);
	
		
	}
}
